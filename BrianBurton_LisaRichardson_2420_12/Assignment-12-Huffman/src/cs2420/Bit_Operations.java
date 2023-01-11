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

import java.nio.ByteBuffer;
import java.util.BitSet;

/**
 * Helper methods for dealing with bytes and bits
 * 
 * @author H. James de St. Germain
 *
 */
public final class Bit_Operations {

	/**
	 * this is a "static" class (all methods are static), don't allow one to be
	 * created
	 */
	private Bit_Operations() {
		;
	}

	/**
	 * 
	 * Return a byte array representing the bitset data.
	 * 
	 * This method converts a bitset to a list of bytes. To complicate matters,
	 * because BitSets use LITTLE ENDIAN notation, we have to first convert the
	 * bits to BIG ENDIAN (the way we want the bits), and then output as bytes
	 * 
	 * Here is what that means:
	 * 
	 * if our bit stream is as follows (1 1 0 0 0 0 0 0) and you just use
	 * bitset.toByteArray, the output byte would be: (0 0 0 0 0 0 1 1)
	 * 
	 * To swap from little to big, you must reverse the order of the bits on a
	 * byte by byte basis. Thus if you have the bit set:
	 *
	 * 0 1 2 3 4 5 6 7 8 9 a b c d e f -------------------------------
	 * 1 0 1 1 0 1 1 1 0 0 0 0 0 1 1 0
	 * 
	 * which is two bytes
	 * 
	 * 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 --------------- ---------------
	 * 1 0 1 1 0 1 1 1|0 0 0 0 0 1 1 0
	 * 
	 * we reverse the first byte and then the second giving us
	 * 
	 * 1 1 1 0 1 1 0 1 | 0 1 1 0 0 0 0 0
	 * 
	 * then when we dump the byteArray, these will be again reversed and we get
	 * what we expected
	 * 
	 * 
	 * tldr; For each 8 bits (byte) in the bit set, reverse the order of those
	 * bits.
	 * 
	 * @param bits
	 *            - the bitset to convert from little endian to big endian
	 * 
	 * @return the new bitset
	 */
	public static byte[] get_bytes(BitSet bits) {
		
		// 1) Create a new bit set: RESULT
		BitSet result = new BitSet(bits.length());
		
		int byte_offset = 0;
		
		// 2) for every bit in the bit set
		for(int bit_index = 0; bit_index < bits.length(); bit_index++) {
			
			// if divisible by 8 we are at a new byte, so remember this fact
			if(bit_index % 8 == 0) {
				
				byte_offset = bit_index;
			}
			
			// if the bit is true, set the appropriate bit in RESULT
			if(bits.get(bit_index)) {
				
				result.set(byte_offset + (7 - (bit_index % 8)));
			}
		}
		
		// 3) return a byte array from the RESULT
		return result.toByteArray();
	}

	/**
	 * convert an integer into 4 bytes
	 * 
	 * @param value
	 *            - an integer value
	 * @return the four bytes that make up the integer
	 */
	public static byte[] convert_integer_to_bytes(int value) {
		
		ByteBuffer int_to_byte_converter = ByteBuffer.allocate(4);

		int_to_byte_converter.putInt(value);
		
		return int_to_byte_converter.array();
	}

	/**
	 * Get a single bit out of an 8 bit byte
	 * 
	 * remember the bit sequence for the number 7 is: 00000111 indexes: 01234567
	 * get_bit(7,0) --> false get_bit(7,1) --> false get_bit(7,2) --> false
	 * get_bit(7,3) --> false get_bit(7,4) --> false get_bit(7,5) --> true
	 * get_bit(7,6) --> true get_bit(7,7) --> true
	 * 
	 * @param the_byte
	 * @param position
	 *            - 0 to 7 with 0 being on the left and 7 being on the right
	 * @return the bit as a boolean
	 */
	public static boolean get_bit(byte the_byte, int position) {
		
		return ((0b10000000 >> position) & the_byte) != 0;
	}
}