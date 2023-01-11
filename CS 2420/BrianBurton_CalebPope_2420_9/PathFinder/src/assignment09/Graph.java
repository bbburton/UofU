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
import java.util.LinkedList;
import java.util.Queue;

/**
* Represents a set of vertices and edges in the game PacMan.
 *
 * @author Brian Burton
 * @author Caleb Pope
 */
public class Graph {

  private final int vertices_count;
  private int start = -1;
  private int goal = -1;
  private ArrayList<Node> adjacencies;

  /**
   * The Graph Constructor.
   *
   * @param vertices_count - the number of vertices.
   */
  public Graph(int _vertices_count) {
    this.vertices_count = _vertices_count;
    adjacencies = new ArrayList<Node>(_vertices_count);

    for (int vert = 0; vert < _vertices_count; vert++) {
      adjacencies.add(new Node(vert));
    }
  }

  /**
   * Adds one vertex to the others vertex ArrayList and vice versa.
   *
   * @param vert1 - the first vertex to add to the graph.
   * @param vert2 - the second vertex to add to the graph.
   */
  public void add_edge(int vert1, int vert2) {
	  
	if(!this.adjacencies.get(vert1).get_neighbors().contains(this.adjacencies.get(vert2))) {
		this.adjacencies.get(vert1).add_neighbor(this.adjacencies.get(vert2));
	}
	if(!this.adjacencies.get(vert2).get_neighbors().contains(this.adjacencies.get(vert1))) {
		this.adjacencies.get(vert2).add_neighbor(this.adjacencies.get(vert1));
	}
  }

  /**
   * Searches through a graph and finds the shortest path from the starting
   * vertex to the goal vertex.
   *
   * @param start - the starting vertex number id.
   * @return - true if the the goal was found, false if not.
   */
  public boolean bfs(int start) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(this.adjacencies.get(start));
    this.adjacencies.get(start).set_visited(true);
    Node node;

    while (!queue.isEmpty()) {
      node = queue.remove();

      if (node.is_goal()) {
        return true;
      }

      for (Node neighbor : node.get_neighbors()) {
        if (!neighbor.was_visited()) {
          queue.add(neighbor);
          neighbor.set_previous(node);
          neighbor.set_visited(true);
        }
      }
    }

    return false;
  }

  /**
   * Returns the number of vertices.
   *
   * @return - the number of vertices.
   */
  public int get_vertex_count() {
    return vertices_count;
  }

  /**
   * Returns the starting vertex.
   *
   * @return - the starting vertex.
   */
  public int get_start() {
    return start;
  }

  /**
   * Sets the starting vertex.
   *
   * @param start - vertex number id.
   */
  public void set_start(int start) {
    this.start = start;
    this.adjacencies.get(start).set_as_start();
  }

  /**
   * Returns the goal vertex.
   *
   * @return - the goal vertex.
   */
  public int get_goal() {
    return goal;
  }

  /**
   * Sets the goal vertex.
   *
   * @param goal - vertex number id.
   */
  public void set_goal(int goal) {
    this.goal = goal;
    this.adjacencies.get(goal).set_as_goal();
  }

  /**
   * Returns an ArrayList filled with the Nodes that share an edge with the
   * current Node. Those Nodes are stored in an ArrayList.
   *
   * @return - an ArrayList filled with the Nodes that share an edge with the
   *         current Node.
   */
  public ArrayList<Node> get_adjacencies() {
    return adjacencies;
  }
}
