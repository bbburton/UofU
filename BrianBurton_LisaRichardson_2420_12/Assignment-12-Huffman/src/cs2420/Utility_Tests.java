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

import java.util.Hashtable;

import org.junit.Test;

public class Utility_Tests {

	@Test
	public void increment_test() { 
		
		Hashtable<String, Node> table = new Hashtable<>();
		
		Node node = new Node("a", 1);
		
		table.put("a", node);
		
		Utility.increment("a", table);
	}
}