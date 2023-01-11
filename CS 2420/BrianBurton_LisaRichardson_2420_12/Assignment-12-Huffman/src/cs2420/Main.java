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

import java.io.File;
import java.nio.file.Paths;

public class Main {
	/**
	 * compress or uncompress a file
	 * 
	 * To compress, use the following command line arguments:
	 * 
	 * huffman -c COUNT file_name
	 * 
	 * To uncompress, use:
	 * 
	 * huffman file_name
	 * 
	 * @param args
	 *            - see above
	 */
	public static void main(String[] args) {

		HuffmanTreeUsingWords huffman;

		String file_name = "";
		boolean compress = false;

		
		// Uncomment to make this run on the command line

//		if (args.length == 3) {
//
//			huffman = new HuffmanTreeUsingWords(Integer.parseInt(args[1]));
//
//			if (!args[0].equals("-c")) {
//				System.out.println("to Compress, use args: '-c number file_name')");
//				return;
//			}
//
//			file_name = args[2];
//			compress = true;
//		} else if (args.length == 1) {
//
//			huffman = new HuffmanTreeUsingWords(0);
//			file_name = args[0];
//
//		} else {
//
//			System.out.println("to Compress, use args: '-c number file_name')");
//			System.out.println("to Uncompress, use args: 'file_name')");
//			System.out.println(
//					"Note: No extensions are necessary.  compressed files will automatically be extended with .huf");
//			System.out.println("      Files to uncompress will be assumed to end with .huf");
//			System.out.println("      Uncompressed files will end with .uncompress to avoid destroying the original.");
//			return;
//		}
		 

		// test code

		huffman = new HuffmanTreeUsingWords(0);
//		compress = true;
//		file_name = "Resources/two_cities";
//		file_name = "Resources/constitution";
//		file_name = "Resources/green_eggs_and_ham";
//		file_name = "Resources/alphabetplus";
//		file_name = "Resources/alphabet";
//		file_name = "Resources/simple";
		file_name = "Resources/a_few_letters";

		if (!compress) {
			
			file_name += "." + huffman.WORD_COUNT;
		}

		if (compress) {
			
			System.out.println("Compressing file(" + huffman.WORD_COUNT + ") : " + file_name);
		} else {
			
			System.out.println("Uncompressing file : " + file_name);
			System.out.println("using " + huffman.WORD_COUNT + " words as symbols.");
		}

		// ignore . extensions
		String[] new_file_name = new String[0]; // file_name.split("\\.");

		if (new_file_name.length > 1) {
			file_name = new_file_name[0];
		}

		if (compress) {
			huffman.compress_file(new File(file_name), new File(file_name + "." + huffman.WORD_COUNT + ".huf"));
		} else {
			huffman.decompress_file(Paths.get(file_name + ".huf"), new File(file_name + ".uncompress"));
		}
	}
}