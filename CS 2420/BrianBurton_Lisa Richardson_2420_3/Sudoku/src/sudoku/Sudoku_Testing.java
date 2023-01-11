/**
 * Your Name: Brian Burton
 * Your UID: u1038667
 * The Date: 02/02/17
 * The Class Number: CS 2420
 * The Assignment Number: #3
 * 
 * I pledge that the work done here was my own and that I have learned how to write 
 * this program, such that I could throw it out and restart and finish it in a timely 
 * manner. I am not turning in any work that I cannot understand, describe, or recreate. 
 * I further acknowledge that I contributed substantially to all code handed in and vouch 
 * for it's authenticity. Brian Burton.
 *
 */

package sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Sudoku_Testing {
	
	@Test
	public void get_puzzle_1D() {
		
		Sudoku s = new Sudoku();
		
		int[] nothing_1d = new int[81];
		int[] new_1d = s.get_puzzle_1D();
		
		assertTrue(new_1d[34] == nothing_1d[34]);
		
	}

	@Test
	public void get_puzzle_2D() {
		
		Sudoku s = new Sudoku();
		
		int[][] nothing_2d = new int[9][9];
		int[][] new_2d = s.get_puzzle_2D();
		
		assertTrue(new_2d[4][4] == nothing_2d[4][4]);
	}
	
	@Test
	public void valid_for_row(){
		Sudoku blah = new Sudoku();
		assertTrue(blah.valid_for_row(6, 2));
	}
	
	
}
