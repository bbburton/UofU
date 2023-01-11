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

/**
 * Represents a hash table of key-value pairs. Quadratic probing is used to handle conflicts.
 * 
 * @author Brian Burton
 * @author Lisa Richardson
 *
 * @param <KeyType> - the key of a hash.
 * @param <ValueType> - the value of a hash.
 */
public class Hash_Table_Quadratic_Probing<KeyType, ValueType> extends Hash_Table_Linear_Probing<KeyType, ValueType> {

	/**
	 * Hash Table Constructor
	 * 
	 * @param initial_capacity - try to make this equal to twice the expected number of values
	 */
	public Hash_Table_Quadratic_Probing(int initial_capacity) {
		super(initial_capacity);
	}
	
	/**
	 * If there is not an empty spot in the hash table, then move forward count spots.
	 * 
	 * @param initial - current index.
	 * @param count - how many spots to jump.
	 * 
	 * @returns the next index to check.
	 */
	@Override
	protected int advance(int initial, int count) {
		
		return (initial + count * count) % capacity;
	}
	
	/**
	 * Display's the stats about the hash table to the console.
	 */
	@Override
	public String toString() {
		
		String result = new String();
		String holder = "[";
		for(int iter = 0; iter < capacity; iter++){
			holder += table.get(iter) + ", ";
		}
		holder += "]";
		
		result = "------------ Quadratic Hash Table ------------\n"
					+ "  Average collisions: " + collisions/num_of_operations + "  Average Hash Function Time: " + hash_funct_time
					+ "\n  Average Insertion Time: " + insert_time + "  Average Find Time: " + find_time
					+ "\n  Percent filled : " + (double)(num_of_entries/capacity)/100 + "  Size of Table  : "+ num_of_entries
					+ "\n  Elements       : " + holder
					+ "\n  Actual Capacity: " + capacity
					+ "\n-----------------------------------------\n";

		return result;
	}
}
