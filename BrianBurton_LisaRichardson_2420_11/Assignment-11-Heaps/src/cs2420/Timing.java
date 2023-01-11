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

import java.util.Random;

public class Timing
{
	protected static Heap<Integer> sorted_arr;
	protected static Heap<Integer> rev_sorted_arr;
	protected static Heap<Integer> random_arr;
	
	public static void main(String[] args){
		
		Random generator = new Random();
		
		for(int items = 1000; items < 101_000; items+=1000){
			sorted_arr = new Heap<>(items);
			rev_sorted_arr = new Heap<>(items);
			random_arr = new Heap<>(items);
			
			int[] sorted = new int[items];
			int[] rev_sorted = new int[items];
			int[] random = new int[items];
			
			for(int iter = 0; iter < sorted.length; iter++){
				sorted[iter] = iter;
			}
			int idx = 0;
			for(int iter2 = rev_sorted.length; iter2 > 0; iter2--){
				rev_sorted[idx] = iter2;
				idx++;
			}
			for(int iter3 = 0; iter3 < random.length; iter3++){
				random[iter3] = generator.nextInt(items);
			}
			
			//testing sorted
			long start = System.nanoTime();
			
			for(int iter4 = 0; iter4 < sorted.length; iter4++){
				sorted_arr.add(sorted[iter4]);
			}
			
			long end = System.nanoTime();
			double elapsed = (end - start);
			
			System.out.println(elapsed);
			
			//testing reverse sorted
			start = System.nanoTime();
			
			for(int iter5 = 0; iter5 < sorted.length; iter5++){
				rev_sorted_arr.add(rev_sorted[iter5]);
			}
			
			end = System.nanoTime();
			elapsed = (end - start);
			System.out.println(elapsed);
			
			//testing random
			start = System.nanoTime();
			
			for(int iter5 = 0; iter5 < sorted.length; iter5++){
				random_arr.add(random[iter5]);
			}
			
			end = System.nanoTime();
			elapsed = (end - start);
			System.out.println(elapsed);
		}
	}
}