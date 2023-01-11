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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Main {
	
	static public void main(String[] args) {
		
		BufferedReader reader = null;
		
		try
		{
			reader = new BufferedReader(new FileReader("puzzles/Brian_Burton_puzzle.txt"));
		} 
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "No file found.");
			e.printStackTrace();
			System.exit(0);
		}

		Sudoku puzzle = new Sudoku(reader);
		puzzle.solve_sudoku();
		System.out.println(puzzle);
		puzzle.solve_by_elimination();
	}
}