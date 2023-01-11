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

import org.junit.Before;
import org.junit.Test;

public class Node_Tests {
	
	//Node Set Up
	Node node1;
	Node node2;
	Node node3;
	Node node4;
	Node node5;
	Node node6;
	Node node7;
	Node node8;
	
	//Non Leaf Node Set Up
	Node non_leaf1;
	Node non_leaf2;
	Node non_leaf3;
	Node non_leaf4;
	Node non_leaf5;
	Node non_leaf6;
	Node non_leaf7;
	Node non_leaf8;
	
	//Left Node Set Up
	Node left_node1;
	Node left_node2;
	Node left_node3;
	Node left_node4;
	Node left_node5;
	Node left_node6;
	Node left_node7;
	Node left_node8;
	
	//Right Node Set Up
	Node right_node1;
	Node right_node2;
	Node right_node3;
	Node right_node4;
	Node right_node5;
	Node right_node6;
	Node right_node7;
	Node right_node8;
	
	//Connected Nodes
	Node connect1;
	Node connect2; 
	Node connect3;
	Node connect4;

	@Before
	public void setUp() throws Exception {
		
		//Node Set Up
		node1 = new Node("node1", 1);
		node2 = new Node("node2", 1);
		node3 = new Node("node3", 1);
		node4 = new Node("node4", 1);
		node5 = new Node("node5", 1);
		node6 = new Node("node6", 1);
		node7 = new Node("node7", 1);
		node8 = new Node("node8", 1);
		
		//Left Node Set Up
		left_node1 = new Node("left_node1", 1);
		left_node2 = new Node("left_node2", 1);
		left_node3 = new Node("left_node3", 1);
		left_node4 = new Node("left_node4", 1);
		left_node5 = new Node("left_node5", 1);
		left_node6 = new Node("left_node6", 1);
		left_node7 = new Node("left_node7", 1);
		left_node8 = new Node("left_node8", 1);
		
		//Right Node Set Up
		right_node1 = new Node("right_node1", 1);
		right_node2 = new Node("right_node2", 1);
		right_node3 = new Node("right_node3", 1);
		right_node4 = new Node("right_node4", 1);
		right_node5 = new Node("right_node5", 1);
		right_node6 = new Node("right_node6", 1);
		right_node7 = new Node("right_node7", 1);
		right_node8 = new Node("right_node8", 1);
		
		//Non Leaf Node Set Up
		non_leaf1 = new Node("N", left_node1, right_node1);
		non_leaf2 = new Node("N", left_node2, right_node2);
		non_leaf3 = new Node("N", left_node3, right_node3);
		non_leaf4 = new Node("N", left_node4, right_node4);
		non_leaf5 = new Node("N", left_node5, right_node5);
		non_leaf6 = new Node("N", left_node6, right_node6);
		non_leaf7 = new Node("N", left_node7, right_node7);
		non_leaf8 = new Node("N", left_node8, right_node8);
		
		//Connected Nodes
		connect1 = new Node("a", 1);
		connect2 = new Node("b", 1);
		connect3 = new Node("c", 1);
		connect4 = new Node("d", 1);
		
		connect4.set_parent(connect3);
		connect3.set_parent(connect2);
		connect2.set_parent(connect1);
	}
	
	@Test
	public void get_symbol_with_byte_test() {
		
		String code = "0b01100001";
		
		assertEquals(null, node1.get_symbol(code));
	}
	
	@Test
	public void left_most_child_test() {
		
		assertEquals(connect1, connect1.left_most_child());
		assertEquals(connect2, connect2.left_most_child());
		assertEquals(connect3, connect3.left_most_child());
		assertEquals(connect4, connect4.left_most_child());
	}
	
	@Test
	public void compareTo_test() {
		
		assertEquals(-1, node1.compareTo(non_leaf1));
		assertEquals(-7, node1.compareTo(node8));
		assertEquals(5, node8.compareTo(node3));
	}

	@Test
	public void get_symbol_test() {
		
		assertEquals("node1", node1.get_symbol());
		assertEquals("node2", node2.get_symbol());
		assertEquals("node3", node3.get_symbol());
		assertEquals("node4", node4.get_symbol());
		assertEquals("node5", node5.get_symbol());
		assertEquals("node6", node6.get_symbol());
		assertEquals("node7", node7.get_symbol());
		assertEquals("node8", node8.get_symbol());
		
		assertEquals("N", non_leaf1.get_symbol());
		assertEquals("N", non_leaf2.get_symbol());
		assertEquals("N", non_leaf3.get_symbol());
		assertEquals("N", non_leaf4.get_symbol());
		assertEquals("N", non_leaf5.get_symbol());
		assertEquals("N", non_leaf6.get_symbol());
		assertEquals("N", non_leaf7.get_symbol());
		assertEquals("N", non_leaf8.get_symbol());
	}
	
	@Test
	public void leaf_test() {
		
		assertEquals(true, node1.leaf());
		assertEquals(true, node2.leaf());
		assertEquals(true, node3.leaf());
		assertEquals(true, node4.leaf());
		assertEquals(true, node5.leaf());
		assertEquals(true, node6.leaf());
		assertEquals(true, node7.leaf());
		assertEquals(true, node8.leaf());
		
		assertEquals(false, non_leaf1.leaf());
		assertEquals(false, non_leaf2.leaf());
		assertEquals(false, non_leaf3.leaf());
		assertEquals(false, non_leaf4.leaf());
		assertEquals(false, non_leaf5.leaf());
		assertEquals(false, non_leaf6.leaf());
		assertEquals(false, non_leaf7.leaf());
		assertEquals(false, non_leaf8.leaf());
	}
	
	@Test
	public void get_parent_test() {
		
		assertEquals(null, node1.get_parent());
		assertEquals(null, node2.get_parent());
		assertEquals(null, node3.get_parent());
		assertEquals(null, node4.get_parent());
		assertEquals(null, node5.get_parent());
		assertEquals(null, node6.get_parent());
		assertEquals(null, node7.get_parent());
		assertEquals(null, node8.get_parent());
		
		assertEquals(null, non_leaf1.get_parent());
		assertEquals(null, non_leaf2.get_parent());
		assertEquals(null, non_leaf3.get_parent());
		assertEquals(null, non_leaf4.get_parent());
		assertEquals(null, non_leaf5.get_parent());
		assertEquals(null, non_leaf6.get_parent());
		assertEquals(null, non_leaf7.get_parent());
		assertEquals(null, non_leaf8.get_parent());
	}

	@Test
	public void set_parent_test() {
		
		node1.set_parent(node2);
		
		assertEquals(node2, node1.get_parent());
		
		node2.set_parent(node3);
		
		assertEquals(node3, node2.get_parent());
		
		node3.set_parent(node4);
		
		assertEquals(node4, node3.get_parent());
		
		node4.set_parent(node5);
		
		assertEquals(node5, node4.get_parent());
		
		node5.set_parent(node6);
		
		assertEquals(node6, node5.get_parent());
		
		node6.set_parent(node7);
		
		assertEquals(node7, node6.get_parent());
		
		node7.set_parent(node8);
		
		assertEquals(node8, node7.get_parent());
	}
	
	@Test
	public void parents_left_test() {
		
		assertEquals(null, node1.parents_left());
		assertEquals(null, node2.parents_left());
		assertEquals(null, node3.parents_left());
		assertEquals(null, node4.parents_left());
		assertEquals(null, node5.parents_left());
		assertEquals(null, node6.parents_left());
		assertEquals(null, node7.parents_left());
		assertEquals(null, node8.parents_left());
		
		assertEquals(left_node1, non_leaf1.parents_left());
		assertEquals(left_node2, non_leaf2.parents_left());
		assertEquals(left_node3, non_leaf3.parents_left());
		assertEquals(left_node4, non_leaf4.parents_left());
		assertEquals(left_node5, non_leaf5.parents_left());
		assertEquals(left_node6, non_leaf6.parents_left());
		assertEquals(left_node7, non_leaf7.parents_left());
		assertEquals(left_node8, non_leaf8.parents_left());
	}
	
	@Test
	public void get_frequency_test() {
		
		assertEquals(1, node1.get_frequency());
		assertEquals(1, node2.get_frequency());
		assertEquals(1, node3.get_frequency());
		assertEquals(1, node4.get_frequency());
		assertEquals(1, node5.get_frequency());
		assertEquals(1, node6.get_frequency());
		assertEquals(1, node7.get_frequency());
		assertEquals(1, node8.get_frequency());
		
		assertEquals(2, non_leaf1.get_frequency());
		assertEquals(2, non_leaf2.get_frequency());
		assertEquals(2, non_leaf3.get_frequency());
		assertEquals(2, non_leaf4.get_frequency());
		assertEquals(2, non_leaf5.get_frequency());
		assertEquals(2, non_leaf6.get_frequency());
		assertEquals(2, non_leaf7.get_frequency());
		assertEquals(2, non_leaf8.get_frequency());
	}
	
	@Test
	public void increment_frequency_test() {
		
		node1.increment_frequency();
		node2.increment_frequency();
		node3.increment_frequency();
		node4.increment_frequency();
		node5.increment_frequency();
		node6.increment_frequency();
		node7.increment_frequency();
		node8.increment_frequency();
		
		assertEquals(2, node1.get_frequency());
		assertEquals(2, node2.get_frequency());
		assertEquals(2, node3.get_frequency());
		assertEquals(2, node4.get_frequency());
		assertEquals(2, node5.get_frequency());
		assertEquals(2, node6.get_frequency());
		assertEquals(2, node7.get_frequency());
		assertEquals(2, node8.get_frequency());
		
		non_leaf1.increment_frequency();
		non_leaf2.increment_frequency();
		non_leaf3.increment_frequency();
		non_leaf4.increment_frequency();
		non_leaf5.increment_frequency();
		non_leaf6.increment_frequency();
		non_leaf7.increment_frequency();
		non_leaf8.increment_frequency();
		
		assertEquals(3, non_leaf1.get_frequency());
		assertEquals(3, non_leaf2.get_frequency());
		assertEquals(3, non_leaf3.get_frequency());
		assertEquals(3, non_leaf4.get_frequency());
		assertEquals(3, non_leaf5.get_frequency());
		assertEquals(3, non_leaf6.get_frequency());
		assertEquals(3, non_leaf7.get_frequency());
		assertEquals(3, non_leaf8.get_frequency());
	}
	
	@Test
	public void write_dot(){
		
	}
}