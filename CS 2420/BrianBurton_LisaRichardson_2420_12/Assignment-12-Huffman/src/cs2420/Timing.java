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

public class Timing {
	
	/**
	 * The Main Method timing code.
	 * 
	 * @param args - the arguments.
	 */
	public static void main(String[] args) {
		
		// TEST #1
		System.out.println("Test #1");
		
		for (int iterate = 0; iterate < 100; iterate++) {

			HuffmanTreeUsingWords huffman;

			String file_name = "";
			boolean compress = true;

			// Testing 0 words
			long start = System.nanoTime();

			huffman = new HuffmanTreeUsingWords(0);
			// file_name = "Resources/two_cities";
			file_name = "Resources/constitution";
			// file_name = "Resources/green_eggs_and_ham";
			// file_name = "Resources/alphabetplus";
			// file_name = "Resources/alphabet";
			// file_name = "Resources/simple";
			// file_name = "Resources/a_few_letters";

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

			long end = System.nanoTime();
			double elapsed = (end - start);
			double elapsed_average = (end - start)/100;

			System.out.println(elapsed);
			System.out.println(elapsed_average);

		}
		
//		// TEST #2
//		System.out.println("Test #2");
//		
//		for (int iterate = 0; iterate < 100; iterate++) {
//
//			HuffmanTreeUsingWords huffman;
//
//			String file_name = "";
//			boolean compress = true;
//
//			// Testing 10 words
//			long start = System.nanoTime();
//
//			huffman = new HuffmanTreeUsingWords(10);
//			// file_name = "Resources/two_cities";
//			file_name = "Resources/constitution";
//			// file_name = "Resources/green_eggs_and_ham";
//			// file_name = "Resources/alphabetplus";
//			// file_name = "Resources/alphabet";
//			// file_name = "Resources/simple";
//			// file_name = "Resources/a_few_letters";
//
//			// ignore . extensions
//			String[] new_file_name = new String[0]; // file_name.split("\\.");
//
//			if (new_file_name.length > 1) {
//				file_name = new_file_name[0];
//			}
//
//			if (compress) {
//				huffman.compress_file(new File(file_name), new File(file_name + "." + huffman.WORD_COUNT + ".huf"));
//			} else {
//				huffman.decompress_file(Paths.get(file_name + ".huf"), new File(file_name + ".uncompress"));
//			}
//
//			long end = System.nanoTime();
//			double elapsed = (end - start);
//			double elapsed_average = (end - start)/100;
//
//			System.out.println(elapsed);
//			System.out.println(elapsed_average);
//		}
		
//		// TEST #3
//		System.out.println("Test #3");
//		
//		for (int iterate = 0; iterate < 100; iterate++) {
//
//			HuffmanTreeUsingWords huffman;
//
//			String file_name = "";
//			boolean compress = true;
//
//			// Testing 20 words
//			long start = System.nanoTime();
//
//			huffman = new HuffmanTreeUsingWords(20);
//			// file_name = "Resources/two_cities";
//			file_name = "Resources/constitution";
//			// file_name = "Resources/green_eggs_and_ham";
//			// file_name = "Resources/alphabetplus";
//			// file_name = "Resources/alphabet";
//			// file_name = "Resources/simple";
//			// file_name = "Resources/a_few_letters";
//
//			// ignore . extensions
//			String[] new_file_name = new String[0]; // file_name.split("\\.");
//
//			if (new_file_name.length > 1) {
//				file_name = new_file_name[0];
//			}
//
//			if (compress) {
//				huffman.compress_file(new File(file_name), new File(file_name + "." + huffman.WORD_COUNT + ".huf"));
//			} else {
//				huffman.decompress_file(Paths.get(file_name + ".huf"), new File(file_name + ".uncompress"));
//			}
//
//			long end = System.nanoTime();
//			double elapsed = (end - start);
//			double elapsed_average = (end - start)/100;
//
//			//System.out.println(elapsed);
//			System.out.println(elapsed_average);
//		}
		
//		// TEST #4
//		System.out.println("Test #4");
//		
//		for (int iterate = 0; iterate < 100; iterate++) {
//
//			HuffmanTreeUsingWords huffman;
//
//			String file_name = "";
//			boolean compress = true;
//
//			// Testing 30 words
//			long start = System.nanoTime();
//
//			huffman = new HuffmanTreeUsingWords(30);
//			// file_name = "Resources/two_cities";
//			file_name = "Resources/constitution";
//			// file_name = "Resources/green_eggs_and_ham";
//			// file_name = "Resources/alphabetplus";
//			// file_name = "Resources/alphabet";
//			// file_name = "Resources/simple";
//			// file_name = "Resources/a_few_letters";
//
//			// ignore . extensions
//			String[] new_file_name = new String[0]; // file_name.split("\\.");
//
//			if (new_file_name.length > 1) {
//				file_name = new_file_name[0];
//			}
//
//			if (compress) {
//				huffman.compress_file(new File(file_name), new File(file_name + "." + huffman.WORD_COUNT + ".huf"));
//			} else {
//				huffman.decompress_file(Paths.get(file_name + ".huf"), new File(file_name + ".uncompress"));
//			}
//
//			long end = System.nanoTime();
//			double elapsed = (end - start);
//			double elapsed_average = (end - start)/100;
//
//			System.out.println(elapsed);
//			System.out.println(elapsed_average);
//		}
	}
}