/*
 * I pledge that the work done here was my own and that I have learned how to write
 *         this program (such that I could throw it out and restart and finish it in a timely
 *         manner).  I am not turning in any work that I cannot understand, describe, or
 *         recreate.  Any sources (e.g., web sites) other than the lecture that I used to
 *         help write the code are cited in my work.  When working with a partner, I have
 *         contributed an equal share and understand all the submitted work.  Further, I have
 *         helped write all the code assigned as pair-programming and reviewed all code that
 *         was written separately.
 *                      -- Brian Burton
 */

/*
 * My name: Brian Burton
 * Partner name: Lucas Idstrom
 */

package cs2420;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Timing runs and compares the times for the insertion and comparison of elements inside of the BST and Java TreeSet.
 * The tests are run 50 times each and averaged out to increase accuracy.
 * 
 * @author Lucas Idstrom
 * @author Brian Burton
 * @Date March 2, 2017
 *
 */

public class Timing {
	
	
	/**
	 * Main runs all of the timing code, comparing the BST and java TreeSet
	 * 
	 * @param args
	 */
	public static <Type> void main(String[] args) {
		
		long start;	
		
		//Create Header
		System.out.println("                   BST                                         JAVA            ");
		System.out.println("       Ordered              Random                Ordered               Random     ");
		System.out.println("  Adding   Contains    Adding    Contains    Adding    Contains    Adding    Contains");
		
		//Run test on x amount of integers increasing y amount until x
		for(int count = 1000; count <= 10000; count+= 1000){
			
			//Create number list with ordered integers
			ArrayList<Integer> num_list = new ArrayList<>();
			for(int index = 1; index <= count; index++){
				num_list.add(index);
			}
			double total_time = 0;
			double total_contains_time = 0;
			
			
			//Repeating 50 times, add the ordered list to the BST
			for(int repeat = 0; repeat < 50; repeat++){
				BinarySearchTree<Integer> in_order = new BinarySearchTree<>();
				start = System.nanoTime();
				for(Integer index : num_list){
					in_order.add(index);
				}
				total_time += (System.nanoTime() -start)/1e+9;
				
				start = System.nanoTime();
				in_order.containsAll(num_list);
				total_contains_time += (System.nanoTime() -start)/1e+9;
				in_order.clear();
			}
			
			//Print out the average of the BST ordered adding
			System.out.printf("%.6f", (total_time / 50.0));
			System.out.print("   ");
			System.out.printf("%.6f", (total_contains_time / 50.0));
			System.out.print("   ");
			

			//Repeating 50 times, add the random list to the BST
			total_time = 0;
			total_contains_time = 0;
			for(int repeat = 0; repeat < 50; repeat++){
				Collections.shuffle(num_list);
				BinarySearchTree<Integer> shuffled = new BinarySearchTree<>();
				start = System.nanoTime();
				for(Integer index : num_list){
					shuffled.add(index);
				}
				total_time += (System.nanoTime() -start)/1e+9;
				
				start = System.nanoTime();
				shuffled.containsAll(num_list);
				total_contains_time += (System.nanoTime() -start)/1e+9;
				
				shuffled.clear();
			}
				
			//Print out the average of the BST random adding
			System.out.printf("%.6f", (total_time / 50.0));
			System.out.print("   ");
			System.out.printf("%.6f", (total_contains_time / 50.0));
			System.out.print("   ");
			
			
			//Move to Java Tree Set
			
			//Repeating 50 times, add the ordered list to the TreeSet
			for(int index = 1; index <= count; index++){
				num_list.add(index);
			}
			total_time = 0;
			total_contains_time = 0;
			for(int repeat = 0; repeat < 50; repeat++){
				TreeSet<Integer> tree_in_order = new TreeSet<>();
				start = System.nanoTime();
				for(Integer index : num_list){
					tree_in_order.add(index);
				}
				total_time += (System.nanoTime() -start)/1e+9;
				
				start = System.nanoTime();
				tree_in_order.containsAll(num_list);
				total_contains_time += (System.nanoTime() -start)/1e+9;
				
				tree_in_order.clear();
			}
			
			//Print out the average of the TreeSet ordered adding
			System.out.printf("%.6f", (total_time / 50.0));
			System.out.print("   ");
			System.out.printf("%.6f", (total_contains_time / 50.0));
			System.out.print("   ");
			
			
			//Repeating 50 times, add the random list to the TreeSet
			total_time = 0;
			total_contains_time = 0;
			for(int repeat = 0; repeat < 50; repeat++){
				Collections.shuffle(num_list);
				TreeSet<Integer> tree_shuffled= new TreeSet<>();
				start = System.nanoTime();
				for(Integer index : num_list){
					tree_shuffled.add(index);
				}
				total_time += (System.nanoTime() -start)/1e+9;
				
				start = System.nanoTime();
				tree_shuffled.containsAll(num_list);
				total_contains_time += (System.nanoTime() -start)/1e+9;
				
				tree_shuffled.clear();
			}
				
			//Print out the average of the TreeSet random adding
			System.out.printf("%.6f", (total_time / 50.0));
			System.out.print("   ");
			System.out.printf("%.6f", (total_contains_time / 50.0));
			System.out.println("");

		}
	}
}
