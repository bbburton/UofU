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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing for the Primes Class.
 * 
 * @author Brian Burton
 * @author Lisa Richardson
 */
public class Prime_Testing {
	
	Primes prime;

	@Before
	public void setUp() throws Exception {
		prime = new Primes();
	}

	@Test
	public void is_prime_test() {
		
		//2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 are prime.
		
		assertEquals(false, prime.is_prime(1));
		
		assertEquals(true, prime.is_prime(2));
		
		assertEquals(true, prime.is_prime(3));
		
		assertEquals(false, prime.is_prime(4));
		
		assertEquals(true, prime.is_prime(5));
		
		assertEquals(true, prime.is_prime(7));
		
		assertEquals(true, prime.is_prime(11));
		
		assertEquals(true, prime.is_prime(13));
		
		assertEquals(true, prime.is_prime(17));
		
		assertEquals(true, prime.is_prime(19));
		
		assertEquals(true, prime.is_prime(23));
		
		assertEquals(true, prime.is_prime(29));
		
		assertEquals(true, prime.is_prime(101));
		
		assertEquals(true, prime.is_prime(1011013));
		
		assertEquals(false, prime.is_prime(10110133));
		
		assertEquals(true, prime.is_prime(101101331));
	}

	@Test
	public void next_prime_test() {
		
		//2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 are prime.
		
		assertEquals(2, prime.next_prime(0));
		
		assertEquals(2, prime.next_prime(1));
		
		assertEquals(3, prime.next_prime(2));
		
		assertEquals(5, prime.next_prime(3));
		
		assertEquals(61, prime.next_prime(59));
		
		assertEquals(97, prime.next_prime(89));
		
		assertEquals(1011029, prime.next_prime(1011013));
		
		assertEquals(1011037, prime.next_prime(1011029));
	}
}
