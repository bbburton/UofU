/*
 * I pledge that the work done here was my own and that I have learned how to write
 *         this program (such that I could throw it out and restart and finish it in a timely
 *         manner).  I am not turning in any work that I cannot understand, describe, or
 *         recreate.  Any sources (e.g., web sites) other than the lecture that I used to
 *         help write the code are cited in my work.  When working with a partner, I have
 *         contributed an equal share and understand all the submitted work.  Further, I have
 *         helped write all the code assigned as pair-programming and reviewed all code that
 *         was written separately.
 *                      -- Brian Burton, Lisa Richardson
 */

/*
 * My name: Brian Burton
 * Partner name: Lisa Richardson
 */

package cs2420;

import static cs2420.Bit_Operations.*;
import static cs2420.Utility.*;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Original Huffman code by Erin Parker, April 2007 Adapted by H. James
 *         de St. Germain to words as symbols 2008 Heavily Updated by H. James
 *         de St. Germain 2017
 * 
 *         Implements file compression and decompression using Huffman's
 *         algorithm.
 * 
 *         Instead of compressing on just characters, we treat words as symbols
 *         as well. To see what the best levels of compression are, we choose
 *         the "N" most frequent words (modified by their length) and use these
 *         along with characters as symbols for compression.
 * 
 */
public class HuffmanTreeUsingWords {
	/**
	 * allows us to tag the end of a file with a special character
	 * 
	 * otherwise it's not clear how to end the bit stream output of compression
	 * (i.e., bit stream needs to print a full byte at end, but we may only have
	 * a partial byte)
	 */
	final static String EOF = "EOF";

	/**
	 * For encoding, how many words to treat as symbols
	 */
	int WORD_COUNT;

	/**
	 * For a verbose account of what is going on, set these to true.
	 */
	static final boolean VERBOSE_ENCODING_TREE = true;
	static final boolean VERBOSE_FILE_SIZE = true;
	static final boolean VERBOSE_PRINT_SYMBOL_BITS = true;
	static final boolean VERBOSE_PRINT_TREE = true;

	/**
	 * The root of the Huffman tree
	 */
	private Node root;

	/**
	 * Constructor for an empty tree
	 * 
	 * @param words_as_symbols_count
	 *            - take the top N words and use as symbols
	 *
	 */
	public HuffmanTreeUsingWords(int words_as_symbols_count) {
		
		this.WORD_COUNT = words_as_symbols_count;

		this.root = null;
	}

	/**
	 * Generates a compressed version of the input file.
	 * 
	 * 1) read the file, counting all the symbols 2) create the huffman tree
	 * based on frequency counts 3) compress the data into a binary file
	 * 
	 * @param infile
	 *            - input file of (uncompressed) data
	 * @param outfile
	 *            - output file of compressed data
	 */
	public void compress_file(File infile, File outfile) {
		
		List<String> ordered_list_of_symbols = new ArrayList<>();

		Hashtable<String, Node> top_words;
		Hashtable<String, Node> all_symbols;

		ArrayList<Character> buffer = read_file(infile);

		top_words = compute_most_common_word_symbols(buffer, this.WORD_COUNT);
		all_symbols = compute_remaining_single_character_symbols(buffer, top_words, ordered_list_of_symbols);

		create_tree(all_symbols.values());
		
		compress_data(outfile, all_symbols, ordered_list_of_symbols);
	}

	/**
	 * Generates a decompressed version of the input file.
	 * 
	 * 1) Read the encoding information (how to reconstruct the tree) from the
	 * front of the file. 2) Build the Huffman tree (exactly as it was for
	 * compression) 3) read the bits from the compressed file one by one until a
	 * bit sequence finds a leaf in the huffman tree. report the symbol in the
	 * leaf and start again.
	 * 
	 * @param infile
	 *            - Path to input file (of compressed data)
	 * @param outfile
	 *            - output file of decompressed data
	 */
	public void decompress_file(Path path, File outfile) { 
		
		try {
			// have to read the file as bytes and then process bits inside of
			// those bytes
			
			byte[] bytes = Files.readAllBytes(path);
			ByteBuffer byte_buffer = ByteBuffer.wrap(bytes);

			Hashtable<String, Node> symbols = new Hashtable<>();
			
			//builds symbol frequency table
			symbols = read_file_header_with_symbol_frequencies(byte_buffer);

			if (VERBOSE_FILE_SIZE) {
				System.out.println("");
				System.out.printf("\tHeader Size in Bytes:   %10d\n", byte_buffer.position());
				System.out.printf("\tBody Size in Bytes:     %10d\n", byte_buffer.remaining());
				System.out.printf("\tTotal Size in Bytes:    %10d\n", bytes.length);
			}

			this.root = create_tree(symbols.values());

			decompress_data(this.root, byte_buffer, outfile);
			
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	/**
	 * Write the compressed file, including the encoding information and the
	 * compressed data.
	 * 
	 * @param file
	 *            - the file to write the data to
	 * @param ordered_list_of_symbols
	 *            - the symbols created by parsing the input file
	 * 
	 * @throws IOException
	 *             - if something goes wrong...
	 */
	private static void compress_data(File file, Hashtable<String, Node> symbols, List<String> ordered_list_of_symbols) {
		
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
			byte[] file_header = build_file_header(symbols.values());
			byte[] symbol_bit_stream = build_compressed_bit_stream(ordered_list_of_symbols, symbols);

			out.write(file_header);
			out.write(symbol_bit_stream);

			if (VERBOSE_FILE_SIZE) {
				System.out.printf("Header Size:   %10d bytes\n", file_header.length);
				System.out.printf("Encoding Size: %10d bytes\n", symbol_bit_stream.length);
				System.out.printf("Total Size:    %10d bytes\n", (file_header.length + symbol_bit_stream.length));
			}

		} catch (IOException e) {
			throw new RuntimeException("Error: could not read file");
		}
	}

	/**
	 * Read the compressed data bit stream, translating it into characters, and
	 * writing the uncompressed values into "out"
	 * 
	 * @param bits
	 *            - the compressed bit stream that needs to be turned back into
	 *            real characters and words
	 * @param outfile
	 *            - the file to put this data into
	 * @throws IOException
	 *             - if something goes wrong
	 */
	private static void decompress_data(Node huffman_root, ByteBuffer bits, File outfile) throws IOException {
		
		List<String> symbol_list = convert_bitstream_to_original_symbols(bits, huffman_root);

		write_data(outfile, symbol_list);
	}

	/**
	 * The compressed file has two parts: a) the HEADER - symbol frequency count
	 * b) the DATA - compressed symbol bit stream
	 * 
	 * Here we read the HEADER and build the list of symbols (and counts)
	 * 
	 * 1) read four bytes (representing the number of characters in the symbol
	 * 2) read that many groups of bytes (each is a character in the symbol) 3)
	 * read four bytes (representing the symbol's frequency)
	 * 
	 * repeat from 1, unless we read a zero, then the encoding table is complete
	 * 
	 * 
	 * @param file_bytes
	 *            - the bytes from the compressed file (which start with the
	 *            header information)
	 * @return the hashtable containing all the symbol nodes
	 */
	private static Hashtable<String, Node> read_file_header_with_symbol_frequencies(ByteBuffer file_bytes) {

		Hashtable<String, Node> table = new Hashtable<>();
		
		if (VERBOSE_ENCODING_TREE) {
			System.out.println("\n---------------- Reading encoding tree information  -----------------");
		}
		
		int length = 0;
		char character = 0;
		int freq = 0;
		
		//update length the first time so it won't be zero
		length = file_bytes.getInt();
		
		while(length > 0) {
			
			String word = "";
			
			for(int iter = 0; iter < length; iter++){
				character = (char) file_bytes.get();
				word += character;
			}
			
			freq = file_bytes.getInt();
			
			Node node = new Node(word, freq);
			
			table.put(word, node);
			
			length = file_bytes.getInt();
		}
		

		if (VERBOSE_ENCODING_TREE) {
			System.out.println("\n\tRead encoding table. Size:  " + file_bytes.position() + " bytes");
		}

		return table;
	}

	/**
	 * transfer all the data from the file into an array list
	 * 
	 * @param infile
	 *            - file we are compressing
	 * 
	 * @return the ArrayList representation of the file (ordered of course)
	 */
	static ArrayList<Character> read_file(File infile) {
		
		final int End_Of_Stream = -1;
		ArrayList<Character> buffer = new ArrayList<Character>(1000);

		try (FileReader reader = new FileReader(infile)) {

			while (true) {
				int character_code = reader.read();

				if (character_code == End_Of_Stream) {
					break;
				}

				buffer.add((char) character_code);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error: reading the file.");
		}

		return buffer;
	}


	/**
	* To build the Huffman tree (for compression), we must compute the list of symbols from the file.
	* 
	* Algorithm:
	* 
	* 1) counts how often all the words appear
	* 2) keep the N most common words
	* o) put every symbol into a Node and store this in a hash table 
	*
	* @param buffer - list of all characters in file in order
	* @param count - find the top N (count) words
	* 
	* @return a hash table containing nodes, where each node contains the word and the frequency of that word
	* 
	*/
	static Hashtable<String, Node> compute_most_common_word_symbols(ArrayList<Character> buffer, int count) {
		
		// write code to find the N most frequently used words (word --> more than one letter in a row)
	
		String word = "";
		Hashtable<String, Node> table = new Hashtable<>();
		ArrayList<Node> keys = new ArrayList<>();

		//for every character in the buffer
		for(Character ch : buffer) {
			
			//if(character)
			if(Character.isLetter(ch)) {
				
				//word += character;
				word += ch;
			}
			//else
			else {
				
				//histogram.increment(word);
				if(word.length() >= 1){
					Utility.increment(word, table);
				}
				//set word back to nothing
				word = "";
			}
		}
		
		for(Node node : table.values())
		{
			keys.add(node);
		}

		keys.sort((a,b) -> b.get_frequency() - a.get_frequency());
		
		table.clear();
		
		for(int i = 0; i < count && i < keys.size(); i++)
		{
			Node currentNode = keys.get(i);
			
			table.put(currentNode.get_symbol(), currentNode);
		}

		// return a hash table containing nodes containing these words and frequencies
		return table;
	}

	/**
	* given the list of all characters in the file, count all symbols in the file
	* that are not the "most frequent" word symbols (which have already been counted).
	* Return the hash table containing ALL nodes(symbols and counts) for the given characters
	* 
	* ADDITIONALLY - return the ordered list of all symbols via the "out" parameter
	* 
	* @param buffer - the file's characters
	* @param word_symbols - the words that have already been identified as most common and are to be used as symbols
	* @param ordered_list_of_symbols - RETURNS an array list of all symbols in the file.
	* 
	* @return the final symbol table representing the huffman nodes (not connected yet) for the symbols in the file. 
	*/
	public static Hashtable<String, Node> compute_remaining_single_character_symbols(ArrayList<Character> buffer, Hashtable<String, Node> word_symbols, List<String> ordered_list_of_symbols) {
		//
		// Now count all the other symbols (e.g., single characters not in
		// symbol words)
		//

		Hashtable<String, Node> all_symbols = new Hashtable<>();
		String current_symbol = "";

		all_symbols.putAll(word_symbols);

		for (Character ch : buffer) {
			if (Character.isLetter(ch)) { // build up words

				current_symbol += ch;
				
			} else 
				// a non letter (thus marking the division between possible word symbols
			{
				// 1) if we have started to build a word
				if (current_symbol.length() > 0) {
					
					// if it is not a TOP word
					
					if (!word_symbols.containsKey(current_symbol)) {
						
						// add all it's letters to the symbols table and the ordered list
						
						for (int i = 0; i < current_symbol.length(); i++) {
							
							increment("" + current_symbol.charAt(i), all_symbols);
							ordered_list_of_symbols.add("" + current_symbol.charAt(i));
						}
					} else { // just add the word to the ordered list
					
						ordered_list_of_symbols.add(current_symbol);
					}
				}

				// 2) account for the current character (non-letter)
				increment("" + ch, all_symbols);
				ordered_list_of_symbols.add("" + ch);

				// start over building another word
				current_symbol = "";
			}
		}

		// add end of file at end of symbols
		all_symbols.put(EOF, new Node(EOF, 1));
		ordered_list_of_symbols.add(EOF);

		return all_symbols;
	}

	/**
	 * given a list of bits (and the root of the huffman tree) create a list of
	 * symbols
	 * 
	 * 
	 * DECOMPRESSION Pseudocode
	 * 
	 * For each bit in the bit stream (the compressed file, after the header),
	 * code += get the next bit, if code forms path from root of huffman tree to
	 * leaf we have a symbol, save it, reset code to empty, end
	 * 
	 * @param bit_stream
	 *            - all the bits representing the symbols in the file
	 * @param root
	 *            - the root of the huffman tree
	 * 
	 * @return the reconstructed list of symbols
	 */
	static List<String> convert_bitstream_to_original_symbols(ByteBuffer bit_stream, Node root) {

		if (VERBOSE_PRINT_SYMBOL_BITS) {
			System.out.println("------------- Converting bit sequences back into symbols -------------------");
		}
		
		List<String> symbols = new ArrayList<>();
		boolean eof = false;
		String code = "";
		
		while(!eof){	
			
			byte nextByte = bit_stream.get();
			for(int bitIdx = 0; bitIdx < 8; bitIdx++) {
				boolean bit = Bit_Operations.get_bit(nextByte, bitIdx);
				if(!bit){
					code += 0;
				}else{
					code += 1;
				}
				String symbol = root.get_symbol(code);
				if(symbol != null)
				{
					if(symbol.equals(EOF)){
						eof = true;
						break;
					}
					symbols.add(symbol);
					//reset code to get the next symbol
					code = "";
				}
			}
		}

		if(!eof){
			throw new RuntimeException("Error: did not find EOF termination character");
		}
		return symbols;
	}

	/**
	 * COMPRESSION - write the symbol frequencies
	 * 
	 * 1) Writes the symbols and frequency information to the output file, o)
	 * This allows the Huffman tree to be reconstructed at the time of
	 * decompression.
	 * 
	 * 2) NOTE: for debug purposes, the symbols are written from most frequent
	 * to least frequent... but this is not necessary
	 * 
	 * 3) FORMAT of HEADER is:
	 * 
	 * LENGTH, SYMBOL, FREQUENCY (repeated for all symbols) ZERO (so we know we
	 * are out of symbols - okay because a length of 0 doesn't make sense)
	 * 
	 * 4) EXAMPLE (for the following symbols and frequencies: (a,5) (hello,10),
	 * (EOF,1)
	 * 
	 * 1a5, 5hello10, 3EOF1 (note: there of course are no spaces or commas and
	 * this information is written as bits....)
	 * 
	 * @param huffman_nodes
	 *            - the collection of symbols and frequencies (i.e., Nodes) in
	 *            the document
	 * 
	 * @throws IOException
	 *             - if something goes wrong with the file writing
	 */
	private static byte[] build_file_header(Collection<Node> huffman_nodes) throws IOException {
		
		// Note: you will want to use the convert_integer_to_bytes method
		// you will want to use the out.write method
		
		int count = 0;
		byte[] bytes = null;

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		if (VERBOSE_ENCODING_TREE) {
			System.out.printf("------------ encoding table (ordered by frequency) ------------\n");
		}
		
		// for every node in the list of huffman_nodes
		for(Node node: huffman_nodes) {
			
			byte[] buffer = convert_integer_to_bytes(node.get_symbol().length());
			
			// write the length of the symbol (to the out variable)
			out.write(buffer);
			
			buffer = node.get_symbol().getBytes();
			
			// write the symbol itself
			out.write(buffer);

			buffer = convert_integer_to_bytes(node.get_frequency());
			
			// write the frequency
			out.write(buffer);
			
			count++;
		}
		
		// write a close 0
		out.write(convert_integer_to_bytes(0));
		
		// convert out into a byte array and return it.
		bytes = out.toByteArray();

		if (VERBOSE_ENCODING_TREE) {
			System.out.println("\n\tEncoding Table Size:  " + count + " bytes");
		}

		return bytes;

	}

	/**
	 * DECOMPRESSION
	 * 
	 * Writes the decompressed data (Symbols) to the output file.
	 * 
	 * As each symbol is decompressed, write its component characters
	 * 
	 * @param outfile
	 *            - stream for the output file
	 * @param symbol_list
	 *            - the symbolss to write
	 * 
	 * @throws IOException
	 */
	static void write_data(File outfile, List<String> symbol_list) throws IOException {
		
		try (FileOutputStream fs = new FileOutputStream(outfile)) {
			for (String symbol : symbol_list) {
				for (int i = 0; i < symbol.length(); i++) {
					fs.write(symbol.charAt(i));
				}
			}
		}
	}

	/**
	 * COMPRESSION
	 * 
	 * For each symbol in the input file, encode it using the Huffman tree by
	 * writing the bit code to the output file.
	 * 
	 * This method uses the "determine_bit_pattern_for_symbol" method
	 * 
	 * PSEUDOCODE:
	 * 
	 * for every symbol (in order ) find bit pattern, put bits from pattern into
	 * bitset, return the byte[] from the bitset
	 * 
	 * @param ordered_list_of_symbols
	 *            - all the letters (words/symbols) from the file in order
	 * @param table
	 *            - the hashtable from symbol string to node
	 * 
	 * @return the bytes representing the bit stream of the compressed symbols
	 * 
	 * @throws IOException
	 */
	static byte[] build_compressed_bit_stream(List<String> ordered_list_of_symbols, Hashtable<String, Node> table)
			throws IOException {
		
		BitSet bitset = new BitSet();
		
		//bitset.set(bitIndex, true);

		if (VERBOSE_PRINT_SYMBOL_BITS) {
			System.out.println("\n----------- Compressing  --------------");
			System.out.println(
					"Building bit representation of each symbol for " + ordered_list_of_symbols.size() + " symbols");
		}
		
		int position = 0;
		
		while(!ordered_list_of_symbols.isEmpty()){
			String element = ordered_list_of_symbols.remove(0); //elements shift as they are removed
			Node node = table.get(element);
			
			LinkedList<Integer> bit_pattern = determine_bit_pattern_for_symbol(node);
			
			while(bit_pattern.size() > 0){ 
				int bit = bit_pattern.remove();
				if(bit == 1){
					bitset.set(position);
				}
				position++;
			}
		}

		if (VERBOSE_PRINT_SYMBOL_BITS) {
			System.out.println("\n----------- done --------------");
		}

		return get_bytes(bitset);
	}

	/**
	 * Constructs a Huffman tree to represent bit codes for each character.
	 * 
	 * This is the method is the HEART of the huffman algorithm.
	 * 
	 * Algorithm:
	 * 
	 * o) put all the nodes into a priority queue
	 * 
	 * 1) choose the two least frequent symbols (removing from PQ) 2) combine
	 * these in a new huffman node 3) put this new node back in the PQ 4) repeat
	 * until no nodes in PQ
	 * 
	 * @return the root of the tree
	 * @param the
	 *            nodes to be built into a tree
	 */
	static Node create_tree(Collection<Node> nodes) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.addAll(nodes);
		Node root = null;
		int count = 0;
		
		while(!pq.isEmpty()){
			Node left = pq.poll();
			if(pq.isEmpty()){
				root = left;
				break;
			}
			Node right = pq.poll();
			String number_sym = "NO_" + count;
			Node parent = new Node(number_sym, left, right);
			left.set_parent(parent);
			right.set_parent(parent);
			pq.add(parent);
			count++;
		}

		 if ( VERBOSE_PRINT_TREE ) { System.out.println( root.createDot()); }

		return root;
	}

	/**
	 * Returns the bit code for a symbol.
	 * 
	 * This is computed by traversing the path from the given leaf node up to
	 * the root of the tree.
	 * 
	 * 1) when encountering a left child, a 0 to be pre-appended to the bit
	 * code, and 2) when encountering a right child causes a 1 to be
	 * pre-appended.
	 * 
	 * For example: the symbol "A" might return the code "1011101"
	 * 
	 * QUESTION: why do we use a linkedlist as the return type?
	 * 
	 * @param symbol
	 *            - symbol to be encoded
	 * @param node
	 *            - the node in the huffman tree containing the symbol
	 * 
	 */
	@SuppressWarnings("unused")
	private static LinkedList<Integer> determine_bit_pattern_for_symbol(Node leaf) {
		
		LinkedList<Integer> bit_pattern = new LinkedList<>();
		Node current = leaf;
		
		while(current != null){
			
			Node parent = current.get_parent();
			if(parent == null){
				break;
			}
			Node node = current.parents_left();
			
			//left: add 0
			if(current == current.parents_left()){
				bit_pattern.add(0);
			//right: add 1	
			}else{
				bit_pattern.add(1);
			}
			current = current.get_parent();
		}
		return bit_pattern;
	}
}