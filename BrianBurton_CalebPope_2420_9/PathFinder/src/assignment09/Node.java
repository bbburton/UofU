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

import java.util.ArrayList;

/**
 * Represents each open position on a PacMan maze.
 *
 * @author Brian Burton
 * @author Caleb Pope
 */
public class Node {

  private int id;
  private int row;
  private int col;
  private boolean visited;
  private boolean start;
  private boolean goal;
  private Node previous;
  private ArrayList<Node> neighbors;

  /**
   * Node Constructor.
   */
  public Node(int _id) {
    id = _id;
    neighbors = new ArrayList<>();
    visited = false;
    previous = null;
    start = false;
    goal = false;
  }

  /**
   * Determines whether or not a Node has been seen.
   *
   * @return - true if Node has been seen.
   */
  public boolean was_visited() {
    return visited;
  }

  /**
   * Sets if the Node as been seen or not.
   *
   * @param visited
   *          - true if Node has already been seen.
   */
  public void set_visited(boolean visited) {
    this.visited = visited;
  }

  /**
   * Returns an ArrayList of Nodes that share edges with current Node.
   *
   * @return - an ArrayList of Nodes that share edges with current Node.
   */
  public ArrayList<Node> get_neighbors() {
    return neighbors;
  }

  /**
   * Determines the Node behind the current Node.
   *
   * @param back
   *          - the current Node.
   */
  public void set_previous(Node back) {
    this.previous = back;
  }

  /**
   * Determines how the current node was discovered.
   *
   * @return - the previous Node to the current Node.
   */
  public Node previous() {
    return previous;
  }

  /**
   * Determines if the current Node is the starting Node.
   *
   * @return - true if the current Node is the starting Node.
   */
  public boolean is_start() {
    return start;
  }

  /**
   * Determines if the current Node is the goal Node.
   *
   * @return - true if the current Node is the goal Node.
   */
  public boolean is_goal() {
    return goal;
  }

  /**
   * Adds a Node to the ArrayList which determines which Nodes share edges with
   * the current Node.
   *
   * @param vert
   *          - the Node to be added.
   */
  public void add_neighbor(Node vert) {
    neighbors.add(vert);
  }

  /**
   * Sets the current Node as the starting Node.
   */
  public void set_as_start() {
    this.start = true;
  }

  /**
   * Sets the current Node as the goal Node.
   */
  public void set_as_goal() {
    this.goal = true;
  }

  /**
   * Gets a Nodes id number.
   *
   * @return - the Nodes id number.
   */
  public int get_id() {
    return this.id;
  }

  /**
   * Sets the row and col of the original position in the maze.
   *
   * @param row - the height position of the maze.
   * @param col - the width position of the maze.
   */
  public void set_row_and_col(int row, int col) {
    this.row = row;
    this.col = col;
  }

  /**
   * Returns an array containing the coordinates of the node's original position in the maze.
   *
   * @return [row, col]
   */
  public int[] coordinates() {
    return new int[] { row, col };
  }

  /**
   * A String representation of a Node.
   */
  @Override
  public String toString() {
    String result = "";

    result += id + ":" + (previous != null ? previous.get_id() : "-");

    result += "[";

    for (Node neighbor : neighbors) {
      result += neighbor.get_id();
    }

    result += "]";

    return result;
  }
}
