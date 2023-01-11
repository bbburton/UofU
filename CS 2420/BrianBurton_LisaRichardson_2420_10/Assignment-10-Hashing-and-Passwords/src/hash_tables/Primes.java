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
 * @author germain
 *
 * some helper methods dealing with prime numbers.  These methods can be "brute force"
 */

/**
 * Some helper methods dealing with prime numbers.
 * 
 * @author Brian Burton
 * @auhtor Lisa Richardson
 */
public class Primes {
	
	/**
	 * @param value - to check if prime
	 * 
	 * @return - return true if value is prime
	 */
	public static boolean is_prime(int value) { 
		
		boolean prime = false;
		
		if(value > 1) {
			
			prime = true;
			int next = 2;
			double n = Math.sqrt(value);
			
			while(next <= n && prime == true) {
				
				if(value % next == 0) {
					prime = false;
				}
				next++;
			}
		}
		
		return prime;
	}

	/**
	 * next_prime
	 * 
	 * Note: static function
	 * 
	 * @param value - the starting point to search for a prime
	 * 
	 * @return - the value if prime, otherwise the next prime after value
	 */
	public static int next_prime(int value) {
		
		int temp = value;
		
		for(int index = ++temp; index < Integer.MAX_VALUE; index++) {
			if(is_prime(index)) {
				value = index;
				break;
			}
		}

		return value;
	}
}
