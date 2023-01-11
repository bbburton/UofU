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
import static hash_tables.Primes.next_prime;

/**
 * @author H. James de St. Germain, April 2007
 *         # Adapted by Erin Parker to accept generic items for keys and values
 *
 *         Represents a hash table of key-value pairs.
 *         Linear probing is used to handle conflicts.
 */

/**
 * Represents a hash table of key-value pairs. Linear probing is used to handle conflicts.
 * 
 * @author Brian Burton
 * @author Lisa Richardson
 *
 * @param <KeyType> - the key of a hash.
 * @param <ValueType> - the value of a hash.
 */
public class Hash_Table_Linear_Probing<KeyType, ValueType> implements Hash_Map<KeyType, ValueType> {

	/**
	 * Hash Table Field Variables
	 */
	protected ArrayList<Pair<KeyType, ValueType>>	table;
	protected int								capacity;
	protected int								num_of_entries;
	protected boolean							resize_allowed = true;
	
	//stat variables
	protected int 								collisions = 0;
	protected double							hash_funct_time = 0;
	protected double							insert_time = 0;
	protected double							find_time = 0;
	protected int								num_of_operations = 0;

	/**
	 * Hash Table Constructor
	 * 
	 * @param initial_capacity - try to make this equal to twice the expected number of values
	 */
	public Hash_Table_Linear_Probing(int initial_capacity) {
		
		this.capacity = next_prime(initial_capacity);
		init_table();
	}

	/**
	 * Puts the given "value" into the hash table under the given "key".
	 * On a duplicate entry, replaces the old data with the new "value".
	 * 
	 * For Probing Tables: This method will double* the size of the table if the number
	 *                     of elements is > 1/2 the capacity.
	 */
	public void insert(KeyType key, ValueType value) {
		
		num_of_operations++;
		
		long start_time = System.nanoTime();
		
		doubling_behavior(resize_allowed);
		
		Pair<KeyType, ValueType> pair = new Pair<KeyType, ValueType>(key, value);
		
		int index = Math.abs(key.hashCode() % capacity);
		int count = 0;
		
		boolean was_added = false;
		
		//Step forward in array until empty bucket is found.
		while(was_added == false) {
			
			if(table.get(index) == null) {
				table.set(index, pair);
				num_of_entries++;
				was_added = true;
			}
			else {
				if(key.equals(table.get(index).key)) {
					table.set(index, pair);
					was_added = true;
				}
				else {
					collisions++;
					index = advance(index, ++count); //++count or it checks 1 index 2ice
				}
			}
		}
		
		long end_time = System.nanoTime();
		insert_time = (end_time - start_time)/1_000_000_000;
	}
	
	/**
	 * If there is not an empty spot in the hash table, then move forward one spot.
	 * 
	 * @param initial - current index.
	 * @param count - how many spots to jump.
	 * 
	 * @returns the next index to check.
	 */
	protected int advance(int initial, int count) {
		
		return (initial + count) % capacity;
	}

	/**
	 * If doubling is off, then do not change table size in insert method.
	 * 
	 * @param on - turns doubling on (the default value for a hash table should be on).
	 */
	public void doubling_behavior(boolean on) { 
		
		if(on == true && num_of_entries == capacity/2) {
			resize(capacity * 2);
		}
	}

	/**
	 * Search for an item in the hash table, using the given "key".
	 * Return the item if it exists in the hash table.
	 * Otherwise, returns null.
	 */
	public ValueType find(KeyType key) { 
		
		num_of_operations++;
		
		long start_time = System.nanoTime();
		
		int index = Math.abs(key.hashCode() % capacity);
		
		int count = 0;
		
		boolean was_found = false;
		
		//Step forward in array until empty bucket is found.
		while(was_found == false) {
			
			if(table.get(index) == null){
				return null;
			}
			else if(key.equals(table.get(index).key)) {
				was_found = true;
				long end_time = System.nanoTime();
				find_time = (end_time - start_time)/1_000_000_000;
				return table.get(index).value;
			}
			else {
				collisions++;
				index = advance(index, count++);
			}
		}
		
		long end_time = System.nanoTime();
		find_time = (end_time - start_time)/1_000_000_000;
		
		//returns null if item could not be found.
		return null;
	}

	/**
	 * Remove all items from the hash table (and resets stats).
	 */
	public void clear() {
		
		init_table();
		reset_stats();
	}

	/**
	 * Returns the capacity of the hash table.
	 */
	public int capacity() {
		
		//return the number of total buckets
		return this.capacity;
	}

	/**
	 * Returns the number of entries in the hash table (i.e., the number of stored key-value pairs).
	 */
	public int size() {
		
		//return the number of filled buckets
		return num_of_entries;
	}

	/**
	 * Returns the Hash Tables stats in an ArrayList. The first index in the 
	 * ArrayList tells the number of collisions. The second index in the ArrayList
	 * tells the number of elements in the Hash Table. The third index in the ArrayList
	 * tells the capacity of the Hash Table.
	 */
	public ArrayList<Double> print_stats() {
		
		ArrayList<Double> answer = new ArrayList<>();
		
		answer.add((double) collisions);
		answer.add((double) num_of_entries);
		answer.add((double) capacity);
		
		return answer;
	}

	/**
	 * Display's the stats about the hash table to the console.
	 */
	public String toString() {
		
		String result = new String();
		String holder = "[";
		for(int iter = 0; iter < capacity; iter++){
			holder += table.get(iter) + ", ";
		}
		holder += "]";
		
		result = "------------ Linear Hash Table ------------\n"
					+ "  Average collisions: " + collisions/num_of_operations + "  Average Hash Function Time: " + hash_funct_time
					+ "\n  Average Insertion Time: " + insert_time + "  Average Find Time: " + find_time
					+ "\n  Percent filled : " + (double)(num_of_entries/capacity)/100 + "  Size of Table  : "+ num_of_entries
					+ "\n  Elements       : " + holder
					+ "\n  Actual Capacity: " + capacity
					+ "\n-----------------------------------------\n";

		return result;
	}

	/**
	 * Resets the hash table stats.
	 */
	public void reset_stats() { 
		
		this.collisions = 0;
		this.hash_funct_time = 0;
		this.insert_time = 0;
		this.find_time = 0;
		this.num_of_operations = 0;
	}

	/**
	 * Clear the hash table array and initializes all of the entries in the table to null.
	 */
	private void init_table() {

		table = new ArrayList<Pair<KeyType, ValueType>>(capacity);
		
		for(int index = 0; index < capacity; index++) {
			table.add(index, null);
		}
		
		num_of_entries = 0;
	}

	/**
	 * Determines if the ArrayList is more than half full of elements.
	 */
	public void set_resize_allowable(boolean status) {
		
		resize_allowed = status;
	}
	
	/**
	 * Expand the hash table to the new size, IF the new_size is GREATER than the current size
	 * (if not, doesn't do anything).
	 * 
	 * NOTE: The new hash table should have buckets equal in number the next prime number
	 * greater than or equal to the given "new_size". All the data in the original hash
	 * table must be maintained in the recreated hash table.
	 * 
	 * Note: make sure if you change the size, you rebuild your statistics...
	 */
	public void resize(int new_size) {
		
		if(new_size > capacity && resize_allowed) {
			
			capacity = next_prime(new_size);
			ArrayList<Pair<KeyType, ValueType>>	old_table = table;
			init_table();
			
			for(int index = 0; index < old_table.size(); index++) {
				if(old_table.get(index) != null){
					this.insert(old_table.get(index).key, old_table.get(index).value);
				}
			}
		}
	}
}