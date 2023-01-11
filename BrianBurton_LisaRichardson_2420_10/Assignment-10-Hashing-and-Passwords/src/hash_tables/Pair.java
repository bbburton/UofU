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
 * Represents a key-value pair of generic items.
 * 
 * @author Brian Burton
 * @author Lisa Richardson
 *
 * @param <KeyType> - the key.
 * @param <ValueType> - the value.
 */
public class Pair<KeyType, ValueType> {
	public KeyType		key;
	public ValueType	value;

	/**
	 * The Pair Constructor.
	 * 
	 * @param key - the key.
	 * @param value - the value.
	 */
	public Pair(KeyType key, ValueType value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Returns a String representation of a Pair.
	 */
	public String toString() {
		return "<" + this.key + " " + this.value + ">";
	}
}
