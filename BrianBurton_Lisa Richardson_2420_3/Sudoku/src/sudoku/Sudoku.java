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

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sudoku {
	

	int [] one_D_Array;
	int[][] array_2D;
	
	//Sudoku Variables
	private final static int empty = 0;
	private int correct_count = 0;
	private int guesses = 0;

    /**
     * Declare fields here as needed.
     *
     * You may choose to store your internal data as either a 1D array or a 2D array.
     * The 1D array will make the recursive solver slightly easier to write (why?).
     * The 2D array might make traversing the puzzle slightly easier (why?).
     */
	
    /**
     *  Sudoku's basic constructor. 
     */
    public Sudoku() {
    	array_2D = new int[9][9];
    	one_D_Array = new int[81];
    }

    /**
     * Create a new puzzle by reading a file
     *
     * the file should be 9 rows of 9 numbers separated by whitespace
     * the numbers should be 1-9 or 0 representing an empty square
     *
     * Improper format (too many numbers per line, no numbers, too many total numbers, etc)
     * should result in a runtime exception being thrown.
     *
     */
    
    /**
     * Sudoku's constructor when file is put in.
     * 
     * @param reader -- 
     */
    public Sudoku(BufferedReader reader) {
    	
    	this();
    	
    	try {
    		
    		String line = "";
    		int row_idx = 0;
			while((line = reader.readLine()) != null) {
				String[] str_array = line.split(" ");
				if(str_array.length > 9)
					throw new RuntimeException("TOO MANY NUMBERS");
				if(str_array.length < 9)
					throw new RuntimeException("NOT ENOUGH NUMBERS");
				if(row_idx > 9)
					throw new RuntimeException("TOO MANY LINES");
				
				for(int idx_col = 0; idx_col < array_2D[0].length; idx_col++){
					//for some reason switch row/col
					this.array_2D[idx_col][row_idx] = Integer.parseInt(str_array[idx_col]);
				}
				row_idx++;
			}
		}	  	
    	catch (Exception e1) {
			e1.printStackTrace();
			System.exit(0);
		}
    	
    }	

    /**
     * @return a copy of the puzzle as a 1D array
     */
    public int[] get_puzzle_1D() {
    	
    	int[] array_copy = new int[81];
    	int copy_idx = 0;
    	for(int idx_col = 0; idx_col < array_2D.length; idx_col++) {
    		for(int idx_row = 0; idx_row < array_2D[0].length; idx_row++){
    			//col might need be second loop.
    			array_copy[copy_idx] = this.array_2D[idx_col][idx_row];
    			copy_idx++;
    		}
    	}
    	return array_copy;
    }

    /**
     * @return a copy of the puzzle as a 2D matrix
     */
    public int [][] get_puzzle_2D() {
    	
    	int[][] two_D_Array = new int[9][9];
    	
    	for(int index = 0; index < this.one_D_Array.length; index++){
    		
    		int row = index/9;
        	int column = index%9;
        	
        	two_D_Array[row][column] = this.one_D_Array[index];
    	}
    	
    	return two_D_Array;
    }

    /**
     * @return how many guesses it took to recursively solve the problem.
     */
    public int get_guess_count() {
    	
    	return guesses;
    }

    /**
     * Function: valid_for_row
     *
     * Description: Determine if the given number can be placed in the
     * given row without violating the rules of sudoku
     *
     * Inputs:
     * @input row : which row to see if the number can go into
     * @input number: the number of interest
     *
     * Outputs:
     *
     * true if it is possible to place that number in the row without
     * violating the rule of 1 unique number per row.
     *
     * In other words, if the given number is already present in the row,
     * it is not possible to place it again (return false), otherwise
     * it is possible to place it (return true);
     * 
     * WARNING: call this function before placing the number in the puzzle...
     *
     */
    protected boolean valid_for_row(int row, int number) {
    	
    	//int position = row*9;? for one_dimension
    	
    	for(int idx = 0; idx < array_2D.length; idx++){
    		if(array_2D[idx][row] == number){
    			return false;
    		}
    	}
    	return true;
    }

    /**
     * Function: valid_for_col (see above)
     */
    protected boolean valid_for_column(int col, int number) {
    	
    	for(int idx = 0; idx < array_2D[0].length; idx++){
    		if(array_2D[col][idx] == number){
    			return false;
    		}
    	}
    	return true;
    }

    /**
     * Function: valid_for_box (see above)
     *
     * The sudoku boxes are:
     *
     * 0 | 1 | 2
     * ---+---+---
     * 3 | 4 | 5
     * ---+---+---
     * 6 | 7 | 8
     *
     * where each box represents a 3x3 square in the game.
     *
     */
    protected boolean valid_for_box(int box, int number) {
    	
    	Point corner = get_box_corner(box);
    	boolean valid = box_checker(corner.x, corner.x+3, corner.y, corner.y+3, number);
		return valid;
    }

    /**
     *
     * Function is_valid( position, value )
     *
     * Determine if the given value is valid in the puzzle at that position.(
     *
     * Inputs:
     * 
     * @param position - which bucket in the puzzle to check for validity - should be empty
     * @param possible_value - the value to check (1-9)
     * 
     * @return true if valid
     */
    protected boolean is_valid(int position, int possible_value) {
    	
    	int row = position/9;
    	int col = position %9;
    	int box_num = convert_to_box(position);
    	
    	boolean row_valid = valid_for_row(row, possible_value);
    	boolean col_valid = valid_for_column(col, possible_value);
    	boolean box_valid = valid_for_box(box_num, possible_value);
    	
    	guesses++;
    	
    	return col_valid && row_valid && box_valid;
    }

    /**
     * solve the sudoku problem
     * 
     * @return true if successful
     */
    public boolean solve_sudoku() {
    	return solve_sudoku(0);
      }
	
    /**
     *
     * Function solve_sudoku( puzzle, position )
     *
     * Recursively check to see if the puzzle can be solved following class algorithm
     *
     * Inputs:
     * position - the index of the "current" box in the array (should be set to 0 by initial call)
     *
     */
    public boolean solve_sudoku(int position) {
    	
    	int row = position/9;
    	int col = position%9;
    	
    	while(row < 9 && array_2D[col][row] != empty){
    		col++;
    		if(col == 9){
    			row++;
    			col = 0;
    		}
    	}
    	position = row*9 + col;
    	if(row == 9)
    		return true;
    	for(int iterate = 1; iterate < 10; iterate++){
    		if(is_valid(position, iterate)){
    			array_2D[col][row] = iterate;
    			if(solve_sudoku(position)){
    				return true;
    			}
    		}
    	}
    	
    	array_2D[col][row] = empty;
    	return false;
    }

    /**
     * Function: toString()
     *
     * @return a string showing the state of the board
     *
     */
    @Override
    public String toString() { 
    	
    	String result = "           Column:\n         012 345 678\n";
    	for(int idx_row = 0; idx_row < this.array_2D.length; idx_row++){
    		result += "Row " + idx_row + ": [|";
    		for(int idx_col = 0; idx_col < this.array_2D[0].length; idx_col++){
    			result += this.array_2D[idx_col][idx_row];
    			if (idx_col%3 == 2)
    				result += "|";
    		}
    		result += "]\n";
    		if(idx_row%3 == 2)
    			result += "       ---------------\n";
    	}
    	return result;
    }

    /**
     * Given a puzzle (filled or partial), verify that every element does not repeat in row, col, or box.
     * 
     * @return true if a validly solved puzzle
     */
    public boolean verify() {
    	for(int idx_col = 0; idx_col < array_2D.length; idx_col++){
    		for(int idx_row = 0; idx_row < array_2D.length; idx_row++) {
    			
    			if(array_2D[idx_row][idx_col] == empty) {
    				return false;
    			}
    		}
    	}
    	correct_count++;
    	return true;
    }

    /**
     * Attempt to solve a sudoku by eliminating obviously wrong values
     * Algorithm
     *
     *  1) build a 81 (representing 9x9) array of sets
     *  2) put a set of 1-9 in each of the 81 spots
     *  3) do initial elimination
     *      for each known value, eliminate nubmers from sets in same row, col, box
     *      eliminate all values in the given square
     *  4)  while progress is being made (initially true)
     *         find a non-processed square with one possible answer and  eliminate this number from row, col, box
     */
    public void solve_by_elimination() {
    	ArrayList<HashSet<Integer>> hash_array = new ArrayList<>();
    	HashSet<Integer> num_set = new HashSet<>();
    	for(int iterate = 1; iterate < 10; iterate++){
    		num_set.add(iterate);
    	}
    	for(int iterate = 0; iterate < 81; iterate++){
    		hash_array.add(num_set);
    	}
    	print_possibilities(hash_array);
    	prune_box(hash_array, 3, 1);
    	
    }

    /**
     * print a grid showing all possible valid answers  
     * This should be a 27x27 matrix.
     *
     * I would suggest you do this first to get good debugging help
     * 
     * @param possibilities - array list of all the sets of 1-9s
     */
    private static void print_possibilities(ArrayList<HashSet<Integer>> possibilities) {
    	String result = "";
    	for(int count = 0; count < possibilities.size(); count++){
    		if(count<10){
    		result += count + "\\ " + possibilities.get(count) + "\\";
    		}else{
    			result += count + "\\" + possibilities.get(count) + "\\";	
    		}
    		if((count+1)%3==0){
    			result += " | ";
    		}
    		if ((count+1)%9==0){
    			result += "\n";
    			result += "\n";
    			if((count+1)%27==0){
    				result += "--------------------------------------------------------------------------------------------------------------------------";
    				result += "\n";
    			}
    		}
    	}
    	System.out.println(result);
    }

    /**
     * Given a possibility constraint matrix (81 sets of [1-9]) remove the given number
     * from every matrix in the given box
     * 
     * @param possibilities - 81 sets of [1-9]
     * @param position      - where the value exists (transform to row,col)
     * @param value         - the value to prune
     * YOU WANT TO PRUNE EVERYWHERE BUT THE POSITION GIVEN
     */
    private static void prune_box(ArrayList<HashSet<Integer>> possibilities, int position, Integer value) {
    	int box_num = convert_to_box(position);
    	Point corner = get_box_corner(box_num);
//    	for(int idx = corner.x;)
//    	int row_min = corner.x;
//    	int row_max = corner.x+3;
//    	int col_min = corner.y;
//    	int col_max = corner.y+3;
//    	int count = 0;
//    	
//    	while(count < 3){
//    		for(int idx = row_min; row_min < row_max; row_min++){
//        		possibilities.remove(value);	
//        		System.out.println(possibilities);
//        	}
//    		row_min = corner.x + 9;
//    		row_max = row_min + 3;
//    	}
    	
    }
    
    private static void prune_column(ArrayList<HashSet<Integer>> possibilities, int position, Integer value) {
    	
    	
    }
    
    private static void prune_row(ArrayList<HashSet<Integer>> possibilities, int position, Integer value) {
    	
    	
    }

    /**
     * Add any private helper functions you need as appropriate
     */
    private boolean box_checker(int min_row, int max_row, int min_col, int max_col, int victim){
    	for(int idx_row = min_row; idx_row < max_row; idx_row++){
			for(int idx_col = min_col; idx_col < max_col; idx_col++){
				if(array_2D[idx_col][idx_row] == victim){
					return false;
				}
			}
		}
		return true;
    }
    
    private static int convert_to_box(int position){
    	int row = position/9;
    	int col = position %9;
    	int box_col = col/3;
    	int box_row = row/3;
    	int box_num = box_row*3 +box_col;
    	return box_num;
    }
    
    private static Point get_box_corner(int box){
    	int min_row = ((int)(box/3))*3;
    	int min_col = (box % 3)*3;
    	Point corner = new Point(min_row,min_col);
		return corner;
    	
    }
    
}
