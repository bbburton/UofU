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
 * Partner name: Lisa Richardson
 */

package hash_tables;

import java.util.ArrayList;
import cracking.Crack;

/**
 * Timing code for the Hash Table implementations.
 * 
 * @author Brian Burton
 * @author Lisa Richardson
 */
public class Timing {
	
	static ArrayList<String> names = Crack.read_file_into_array("Resources/names.txt");
	
	/**
	 * The main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		probe_time();
		//chain_time();
	}
	
	/**
	 * Timing code for the Chaining Hash Table
	 */
	public static void chain_time(){
		
		for(int iter = 10; iter < 1000; iter += 10){
			
			Hash_Table_Chaining<String, Integer> chain = new Hash_Table_Chaining<>(iter);
			
			chain.set_resize_allowable(true);
			
			System.out.println("Chaining Insert: " + iter);
			
			long start_time = System.nanoTime();
			
			for(String name: names) {
				chain.insert(name, name.hashCode());
				if(chain.num_of_entries == chain.capacity){
					break;
				}
			}
			
			long end_time = System.nanoTime();
			double elapsed = (double)(end_time - start_time);
			
			System.out.println(chain.print_stats());
			System.out.println(elapsed);
			
			chain.reset_stats();
			
			System.out.println("Chaining Find: " + iter);
			
			start_time = System.nanoTime();
			
			for(String name: names){
				chain.find(name);
			}
			
			end_time = System.nanoTime();
			elapsed = (double)(end_time - start_time);
			System.out.println(chain.print_stats());
			System.out.println(elapsed);
		}
	}

	/**
	 * Timing code for the Linear and Quadratic Hash Tables.
	 */
	public static void probe_time() {
		
		for(int iter = 1000; iter < 5000; iter += 200){
			
			Hash_Table_Linear_Probing<String, Integer> linear_table = new Hash_Table_Linear_Probing<>(iter);
			Hash_Table_Quadratic_Probing<String, Integer> quadratic_table = new Hash_Table_Quadratic_Probing<>(iter);
			
			linear_table.set_resize_allowable(false);
			quadratic_table.set_resize_allowable(false);
			
			System.out.println("Linear Insert: " + iter);
			
			long start_time = System.nanoTime();
			
			for(String name: names){
				linear_table.insert(name, name.hashCode());
				if(linear_table.num_of_entries == linear_table.capacity){
					break;
				}
			}
			
			long end_time = System.nanoTime();
			double elapsed = (double)(end_time - start_time);
			
			System.out.println(linear_table.print_stats());
			System.out.println(elapsed);
			
			System.out.println("Quadratic Insert: " + iter);
			
			start_time = System.nanoTime();
			
			for(String name: names){
				quadratic_table.insert(name, name.hashCode());
				if(quadratic_table.num_of_entries == quadratic_table.capacity){
					break;
				}
			}
			
			end_time = System.nanoTime();
			elapsed = (double)(end_time - start_time);
			System.out.println(quadratic_table.print_stats());
			System.out.println(elapsed);
			
			linear_table.reset_stats();
			quadratic_table.reset_stats();
			
			System.out.println("Linear Find: " + iter);
			
			start_time = System.nanoTime();
			
			for(String name: names){
				linear_table.find(name);
			}
			
			end_time = System.nanoTime();
			elapsed = (double)(end_time - start_time);
			
			System.out.println(linear_table.print_stats());
			System.out.println(elapsed);
			
			System.out.println("Quadratic Find: " + iter);
			
			start_time = System.nanoTime();
			
			for(String name: names){
				quadratic_table.find(name);
			}
			
			end_time = System.nanoTime();
			elapsed = (double)(end_time - start_time);
			System.out.println(quadratic_table.print_stats());
			System.out.println(elapsed);
		}
	}
}
