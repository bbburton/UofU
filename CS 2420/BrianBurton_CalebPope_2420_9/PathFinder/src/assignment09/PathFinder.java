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
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Takes in a maze file and determines the shortest path from the start to the goal.
 *
 * @author Brian Burton
 * @author Caleb Pope
 */
public class PathFinder {
  private Graph graph;
  private char[][] solution_matrix;
  private int[][] map_matrix;
  private int start = -1;
  private int goal  = -1;

  /**
   * Takes in a PacMan maze as a file. Changes that file into a matrix. Converts the matrix into
   * a Graph. Finds the shortest path in the maze for PacMan to follow. Converts the Graph back into 
   * a matrix then back into a file indicating the shortest path with periods.
   *
   * @param inputFileName - path to file containing map.
   * @param outputFileName - path to file containing map solution.
   */
  public static boolean solveMaze(String inputFileName, String outputFileName) {
    boolean is_solved;
    // initialize the maze and read into a 2D array
    PathFinder pf = new PathFinder();
    // transfer 2D array into a graph
    pf.build_graph_from_file(inputFileName);

    // use BFS to find shortest path
    if (is_solved = pf.solve_graph()) {
      // write shortest path back to map_matrix
      pf.write_graph_to_solution_matrix();
      // write map_matrix to solution file
      pf.write_solution_matrix_to_file(outputFileName);
    }

    return is_solved;
  }

  /**
   * Calls the Breadth First Search method on graph.
   *
   * @return true if the graph was solved, false if not.
   */
  public boolean solve_graph() {
    return graph.bfs(graph.get_start());
  }

  /**
   * Returns the current Graph.
   *
   * @return - the current Graph.
   */
  public Graph get_graph() {
    return graph;
  }

  /**
   * Sets the graph field.
   *
   * @param _graph : a graph to set
   */
  public void set_graph(Graph _graph) {
    this.graph = _graph;
  }

  /**
   * Sets the map_matrix field
   *
   * @param _map_matrix : a matrix to set
   */
  public void set_map_matrix(int[][] _map_matrix) {
    this.map_matrix = _map_matrix;
  }

  /**
   * Sets the start field
   *
   * @param _start : a start to set
   */
  public void set_start(int _start) {
    this.start = _start;
  }

  /**
   * Sets the goal field
   *
   * @param _goal : a goal to set
   */
  public void set_goal(int _goal) {
    this.goal = _goal;
  }

  /**
   * Reads from file into a 2D array/matrix.
   *
   * @param input_filepath : path to file containing map.
   */
  public void populate_matrix_from_file(String input_filepath) {
    // Set up file reader
    BufferedReader input = null;
    try {
      input = new BufferedReader(new FileReader(input_filepath));
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "File not found.");
      e.printStackTrace();
      System.exit(0);
    }

    // Read the first line which contains the dimensions of the map.
    int height = 0;
    int width = 0;
    String[] dimensions;
    try {
      dimensions = input.readLine().split(" ");
      height = Integer.parseInt(dimensions[0]);
      width = Integer.parseInt(dimensions[1]);
    } catch (IOException e) {
      e.printStackTrace();
    }

    this.map_matrix = new int[height][width];
    // Start at -1 so we can increment before saving the number, that way
    // node_num contains the current number after we save it, not the next
    // number.
    int node_num = -1;

    // First line has already been read, now read the map.
    for (int row = 0; row < height; row++) {
      String[] string = null;
      try {
        // split to individual characters
        string = input.readLine().trim().split("");
      } catch (IOException e) {
        e.printStackTrace();
      }
      for (int col = 0; col < width; col++) {
        // if it's a space, set it to -1.
        if (string[col].equals("X")) {
          this.map_matrix[row][col] = -1; // Using -1 to denote a wall
        } else {
          this.map_matrix[row][col] = ++node_num;

          if (string[col].equals("S")) {
            this.start = node_num;
          }
          if (string[col].equals("G")) {
            this.goal = node_num;
          }
        }
      }
    }
    // map_matrix should now be filled with -1's for X's and positive integers for the vertices.
  }

  /*
   * The map file looks like this:
   * 3 7
   * XXXXXXX
   * XS   GX
   * XXXXXXX
   *
   */
  /**
   * Converts a file maze into a graph.
   *
   * @param input_filepath - path to file containing map.
   */
  public void build_graph_from_file(String input_filepath) {
    populate_matrix_from_file(input_filepath);
    // find number of spaces/vertices for the graph
    int number_of_verticies = get_number_of_verticies();
    this.graph = new Graph(number_of_verticies);

    // fill the graph from the matrix
    for (int row = 0; row < map_matrix.length; row++) {
      for (int col = 0; col < map_matrix[0].length; col++) {
        if (map_matrix[row][col] > -1) { // This is a vertex, check for
                                         // neighbors and add it.
          // Check for neighbors and add edges
          if (neighbor_to_north(row, col)) { graph.add_edge(map_matrix[row][col], map_matrix[row - 1][col]); }
          if (neighbor_to_south(row, col)) { graph.add_edge(map_matrix[row][col], map_matrix[row + 1][col]); }
          if (neighbor_to_east(row, col)) { graph.add_edge(map_matrix[row][col], map_matrix[row][col + 1]); }
          if (neighbor_to_west(row, col)) { graph.add_edge(map_matrix[row][col], map_matrix[row][col - 1]); }

          // Set row and col for each node for future reference.
          graph.get_adjacencies().get(map_matrix[row][col]).set_row_and_col(row, col);
        }
      }
    }

    graph.set_start(this.start);
    graph.set_goal(this.goal);
  }

  /**
   * Determines if there is a wall to the north of the current Node.
   *
   * @param row - row of the maze.
   * @param col - column of the maze.
   * @return - true if there is not a wall to the north.
   */
  public boolean neighbor_to_north(int row, int col) {
    if (row < 2) {
      return false;
    }
    if (map_matrix[row - 1][col] < 0) {
      return false;
    }
    return true;
  }

  /**
   * Determines if there is a wall to the south of the current Node.
   *
   * @param row - row of the maze.
   * @param col - column of the maze.
   * @return - true if there is not a wall to the south.
   */
  public boolean neighbor_to_south(int row, int col) {
    if (row > (map_matrix.length - 3)) {
      return false;
    }
    if (map_matrix[row + 1][col] < 0) {
      return false;
    }
    return true;
  }

  /**
   * Determines if there is a wall to the east of the current Node.
   *
   * @param row - row of the maze.
   * @param col - column of the maze.
   * @return - true if there is not a wall to the east.
   */
  public boolean neighbor_to_east(int row, int col) {
    if (col > (map_matrix[0].length - 3)) {
      return false;
    }
    if (map_matrix[row][col + 1] < 0) {
      return false;
    }
    return true;
  }

  /**
   * Determines if there is a wall to the west of the current Node.
   *
   * @param row - row of the maze.
   * @param col - column of the maze.
   * @return - true if there is not a wall to the east.
   */
  public boolean neighbor_to_west(int row, int col) {
    if (col < 2) {
      return false;
    }
    if (map_matrix[row][col - 1] < 0) {
      return false;
    }
    return true;
  }

  /**
   * Finds the number of vertices by returning 1 + the id of the largest
   * numbered element in the matrix
   *
   * @param map_matrix : 2D array of the map
   * @return : the largest number + 1
   */
  public int get_number_of_verticies() {
    int largest = 0;

    for (int row = map_matrix.length - 1; row > -1; row--) {
      for (int col = map_matrix[0].length - 1; col > -1; col--) {
        if (map_matrix[row][col] != -1 && map_matrix[row][col] > largest) {
          largest = map_matrix[row][col];
        }
      }
    }

    return largest + 1; // largest + 1 because the vertices numbers start at 0
  }

  /**
   * Converts a Graph to a matrix.
   */
  public void write_graph_to_solution_matrix() {
    int row,col, rows,cols;
    rows = map_matrix.length;
    cols = map_matrix[0].length;
    solution_matrix = new char[rows][cols];

    // Start at the goal and move backwards to the start;
    Node node = graph.get_adjacencies().get(goal);
    row = node.coordinates()[0];
    col = node.coordinates()[1];

    solution_matrix[row][col] = 'G';
    node = node.previous();
    // Now follow the previouses until we get to start.
    while (node != null) {
      row = node.coordinates()[0];
      col = node.coordinates()[1];

      if (node.get_id() == start) break;
      solution_matrix[row][col] = '.';
      node = node.previous();
    }
    // Set start as an S;
    solution_matrix[row][col] = 'S';

    // Fill in all the rest of the verticies that weren't in the path.
    for (Node vert : graph.get_adjacencies()) {
      row = vert.coordinates()[0];
      col = vert.coordinates()[1];
      if (solution_matrix[row][col] == 'S' ||
        solution_matrix[row][col] == '.' ||
        solution_matrix[row][col] == 'G') {
          continue;
      }

      solution_matrix[row][col] = ' ';
    }

    // Fill in all the rest of the spaces with an X.
    for (row = 0; row < rows; row++) {
      for (col = 0; col < cols; col++) {
        if (solution_matrix[row][col] == 'S' ||
            solution_matrix[row][col] == '.' ||
            solution_matrix[row][col] == 'G' ||
            solution_matrix[row][col] == ' ') {
              continue;
        }

        solution_matrix[row][col] = 'X';
      }
    }
  }

  /**
   * Converts solution_matrix to a string.
   *
   * @return : a string representation of the solution matrix.
   */
  public String solved_matrix_to_string() {
    // Convert solution_matrix to string.
    String solution_string = "";
    int rows = solution_matrix.length;
    int cols = solution_matrix[0].length;

    solution_string += rows + " " + cols + "\n";
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        solution_string += String.valueOf(solution_matrix[row][col]);
      }
      solution_string += "\n";
    }

    return solution_string;
  }

  /**
   * Converts the solution matrix to the solution file.
   *
   * @param output_filename - path to file containing map solution.
   */
  public void write_solution_matrix_to_file(String output_filename) {
    // Convert solution_matrix to string.
    String solution_string = solved_matrix_to_string();

    // Write solution_string to file.
    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new FileWriter(output_filename));
      writer.write(solution_string);
    } catch (IOException e) {
    } finally {
      try {
        if (writer != null)
          writer.close();
      } catch (IOException e) { }
    }
  }
}
