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

import static org.junit.Assert.*;
import java.util.BitSet;

import org.junit.Before;
import org.junit.Test;

public class Bit_Operations_Tests {
	
	//Byte Set Up
	byte byte_input;
	byte byte_zero;
	
	@Before
	public void setUp() throws Exception {
		
		//Byte Set Up
		byte_input = 0b00000111;
		byte_zero = 0b00000000;
	}

	@Test
	public void get_bytes_test() {
		
		BitSet input = BitSet.valueOf(new byte[] {(byte)0b10110111, 0b00000110});
		
		byte[] output = Bit_Operations.get_bytes(input);
		
		assertArrayEquals(new byte[] {(byte)0b11101101, 0b01100000}, output);
	}
	
	@Test
	public void get_bytes_all_zeros_test() {
		
		BitSet input = new BitSet(8);
		
		byte[] output = Bit_Operations.get_bytes(input);
		
		assertArrayEquals(new byte[] {}, output);
	}
	
	@Test
	public void get_bytes_no_bytes_input() {
		
		BitSet input = BitSet.valueOf(new byte[0]);
		
		byte[] output = Bit_Operations.get_bytes(input);
		
		assertArrayEquals(new byte[0], output);
	}
	
	@Test
	public void get_bit_test() {
		
		/*
		 * get_bit(7,0) --> false get_bit(7,1) --> false get_bit(7,2) --> false
		 * get_bit(7,3) --> false get_bit(7,4) --> false get_bit(7,5) --> true
		 * get_bit(7,6) --> true get_bit(7,7) --> true
		*/
		assertEquals(false, Bit_Operations.get_bit(byte_input, 0));
		assertEquals(false, Bit_Operations.get_bit(byte_input, 1));
		assertEquals(false, Bit_Operations.get_bit(byte_input, 2));
		assertEquals(false, Bit_Operations.get_bit(byte_input, 3));
		assertEquals(false, Bit_Operations.get_bit(byte_input, 4));
		assertEquals(true, Bit_Operations.get_bit(byte_input, 5));
		assertEquals(true, Bit_Operations.get_bit(byte_input, 6));
		assertEquals(true, Bit_Operations.get_bit(byte_input, 7));
	}
	
	@Test
	public void get_bit_all_zeros_test() {
		
		assertEquals(false, Bit_Operations.get_bit(byte_zero, 0));
		assertEquals(false, Bit_Operations.get_bit(byte_zero, 1));
		assertEquals(false, Bit_Operations.get_bit(byte_zero, 2));
		assertEquals(false, Bit_Operations.get_bit(byte_zero, 3));
		assertEquals(false, Bit_Operations.get_bit(byte_zero, 4));
		assertEquals(false, Bit_Operations.get_bit(byte_zero, 5));
		assertEquals(false, Bit_Operations.get_bit(byte_zero, 6));
		assertEquals(false, Bit_Operations.get_bit(byte_zero, 7));
	}
}