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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing class for the PathFinder project.
 *
 * @author Brian Burton
 * @author Caleb Pope
 */
public class PathFinderTesting {

  // Node Set Up
  Node n0;
  Node n1;
  Node n2;
  Node n3;
  Node n4;
  Node n5;

  // Graph Set Up
  Graph graph;

  @Before
  public void setUp() {
    // Node Set Up
    n0 = new Node(0);
    n1 = new Node(1);
    n2 = new Node(2);
    n3 = new Node(3);
    n4 = new Node(4);
    n5 = new Node(5);

    // Graph Set Up
    graph = new Graph(6);
    graph.add_edge(0, 1);
    graph.add_edge(1, 2);
    graph.add_edge(0, 2);
    graph.add_edge(1, 3);
    graph.add_edge(2, 4);
    graph.add_edge(3, 5);
    graph.add_edge(2, 5);

    graph.set_start(0);
    graph.set_goal(5);
  }

  // Node Testing
  @Test
  public void was_visited_and_set_visited_test() {
    n0.set_visited(true);

    assertEquals(true, n0.was_visited());
  }

  @Test
  public void add_neighbor_test() {
    n0.add_neighbor(n4);

    ArrayList<Node> answer = new ArrayList<>();

    answer.add(n4);

    assertEquals(answer, n0.get_neighbors());

    n0.add_neighbor(n3);

    answer.add(n3);

    assertEquals(answer, n0.get_neighbors());
  }

  @Test
  public void get_neighbors_test() {
    ArrayList<Node> answer = new ArrayList<>();

    assertEquals(answer, n0.get_neighbors());

    n0.add_neighbor(n1);

    answer.add(n1);

    assertEquals(answer, n0.get_neighbors());
  }

  @Test
  public void previous_and_set_previous_test() {
    n3.add_neighbor(n0);
    n2.add_neighbor(n5);
    n3.add_neighbor(n1);
    n4.add_neighbor(n5);

    assertEquals(null, n3.previous());

    n3.set_previous(n0);

    assertEquals(n0, n3.previous());
  }

  @Test
  public void is_start_and_set_as_start() {
    assertEquals(false, n0.is_start());

    n0.set_as_start();

    assertEquals(true, n0.is_start());
  }

  @Test
  public void is_goal_and_set_as_goal() {
    assertEquals(false, n0.is_goal());

    n0.set_as_goal();

    assertEquals(true, n0.is_goal());
  }

  @Test
  public void get_id_test() {
    assertEquals(0, n0.get_id());
    assertEquals(1, n1.get_id());
    assertEquals(2, n2.get_id());
    assertEquals(3, n3.get_id());
    assertEquals(4, n4.get_id());
    assertEquals(5, n5.get_id());
  }

  // Graph Testing
  @Test
  public void get_start_test() {
    assertEquals(0, graph.get_start());
  }

  @Test
  public void set_start_test() {
    graph.set_start(5);

    assertEquals(5, graph.get_start());
  }

  @Test
  public void test_goal_setter_and_getter() {
    // Setup fresh graph without setting start and goal.
    graph = new Graph(6);
    graph.add_edge(0, 1);
    graph.add_edge(0, 2);
    graph.add_edge(1, 2);
    graph.add_edge(1, 3);
    graph.add_edge(2, 4);
    graph.add_edge(2, 5);
    graph.add_edge(3, 5);
    assertEquals(-1, graph.get_goal());

    graph.set_goal(4);
    assertEquals(4, graph.get_goal());
  }

  @Test
  public void test_start_setter_and_getter() {
    // Setup fresh graph without setting start and goal.
    graph = new Graph(6);
    graph.add_edge(0, 1);
    graph.add_edge(0, 2);
    graph.add_edge(1, 2);
    graph.add_edge(1, 3);
    graph.add_edge(2, 4);
    graph.add_edge(2, 5);
    graph.add_edge(3, 5);
    assertEquals(-1, graph.get_start());

    graph.set_start(4);
    assertEquals(4, graph.get_start());
  }

  @Test
  public void get_vertex_count_test() {
    assertEquals(6, graph.get_vertex_count());
  }

  @Test
  public void add_edge_test() {
    graph = new Graph(6);
    // New graph should not have any edges.
    for (Node node : graph.get_adjacencies()) {
      assertEquals(new ArrayList<Node>(), node.get_neighbors());
    }

    graph.add_edge(0, 1);
    for (Node node : graph.get_adjacencies()) {
      // Skip the first two since they should be neighbors now.
      if (node.get_id() == 0 || node.get_id() == 1) continue;
      assertEquals(new ArrayList<Node>(), node.get_neighbors());
    }
    // 0 and 1's neighbors lists should only have one element.
    assertEquals(1, graph.get_adjacencies().get(0).get_neighbors().size());
    assertEquals(1, graph.get_adjacencies().get(1).get_neighbors().size());
    // They should have each other in their neighbors lists.
    assertEquals(1, graph.get_adjacencies().get(0).get_neighbors().get(0).get_id());
    assertEquals(0, graph.get_adjacencies().get(1).get_neighbors().get(0).get_id());
  }

  @Test
  public void graph_get_adjacencies_returns_a_list_with_some_nodes_in_it() {
    assertEquals(6, graph.get_adjacencies().size());
    for (int index = 0; index < 6; index++) {
      assertEquals(index, graph.get_adjacencies().get(index).get_id());
    }
  }

  @Test
  public void bfs_test() {
    graph.bfs(0);

    assertEquals(graph.get_adjacencies().get(5).previous(),
    graph.get_adjacencies().get(2));
    assertEquals(graph.get_adjacencies().get(2).previous(),
    graph.get_adjacencies().get(0));
    assertEquals(graph.get_adjacencies().get(3).previous(),
    graph.get_adjacencies().get(1));
  }

  /*
   * Maze looks like:
   * 6 5
   * XXXXXX
   * XS XXX
   * X   XX
   * XGXXXX
   * XXXXXX
   *
   * Path back is 5->2->0 where goal=5 and start=0.
   */
  @Test
  public void test_writing_graph_to_solution_matrix() {
    int[][] map_matrix = new int[][] {
      new int[] {-1,-1,-1,-1,-1,-1},
      new int[] {-1, 0, 1,-1,-1,-1},
      new int[] {-1, 2, 3, 4,-1,-1},
      new int[] {-1, 5,-1,-1,-1,-1},
      new int[] {-1,-1,-1,-1,-1,-1}
    };
    String expected_matrix_string = "5 6\nXXXXXX\nXS XXX\nX.  XX\nXGXXXX\nXXXXXX\n";
    String solved_matrix_string;
    // Add row and column in formation to the nodes.
    graph.get_adjacencies().get(0).set_row_and_col(1, 1);
    graph.get_adjacencies().get(1).set_row_and_col(1, 2);
    graph.get_adjacencies().get(2).set_row_and_col(2, 1);
    graph.get_adjacencies().get(3).set_row_and_col(2, 2);
    graph.get_adjacencies().get(4).set_row_and_col(2, 3);
    graph.get_adjacencies().get(5).set_row_and_col(3, 1);

    PathFinder pf = new PathFinder();

    // setup pathfinder
    pf.set_start(0);
    pf.set_goal(5);
    pf.set_graph(graph);
    pf.set_map_matrix(map_matrix);

    // solve graph
    pf.solve_graph();

    pf.write_graph_to_solution_matrix();
    solved_matrix_string = pf.solved_matrix_to_string();

    assertEquals(expected_matrix_string, solved_matrix_string);
  }
}