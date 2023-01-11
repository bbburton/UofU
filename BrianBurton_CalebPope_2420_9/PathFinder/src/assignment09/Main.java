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
 * Partner name: Caleb Pope
 */
package assignment09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Runs our PathFinder code.
 *
 * @author Brian Burton
 * @author Caleb Pope
 */
public class Main {

  /**
   * The main method determines the shortest path in a PacMan maze and puts the solution into a file.
   *
   * @param args - the set of arguments.
   */
  public static void main(String[] args) {
    String input_file = "Mazes/unsolvable";
    String output_file = "MazeOutput";

    if (PathFinder.solveMaze(input_file, output_file)) {
      System.out.println("Solved!!\n");
      printout_file(input_file);
      System.out.println("\n");
      printout_file(output_file);
    } else {
      System.out.println("Unsolvable :(\n");
      printout_file(input_file);
    }

    System.out.println("\n\nDone");
  }

  /**
   * Prints a maze representation to the console.
   *
   * @param filename - the file to print.
   */
  public static void printout_file(String filename) {
    BufferedReader input = null;
    String string = "";

    try {
      input = new BufferedReader(new FileReader(filename));
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "File not found.");
      e.printStackTrace();
      System.exit(0);
    }

    try {
      while ((string = input.readLine()) != null) {

        // Print out the maze.
        System.out.println(string.trim());
      }
    } catch (IOException e) { }
  }
}
