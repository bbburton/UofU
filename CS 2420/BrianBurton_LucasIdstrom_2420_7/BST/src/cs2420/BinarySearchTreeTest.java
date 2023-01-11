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
 * Partner name: Lucas Idstrom
 */

package cs2420;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import cs2420.BinarySearchTree.Node;


/**
 * Test class for testing the BinarySearchTree
 * This tests all of the methods inside of the BinarySearchTree
 * 
 * @author Lucas Idstrom
 * @author Brian Burton
 * @Date March 2, 2017
 *
 */
public class BinarySearchTreeTest {
	
	//Node set up
	Node<Integer> root;
	Node<Integer> root_left;
	Node<Integer> root_right;
	Node<Integer> root_left_right;
	
	//BST set up
	BinarySearchTree<Integer> binary_search_tree;
	
	@Before
	public void setUp() {
		
		//Node set up
		root = new Node<>(8);
		root_left = new Node<>(4);
		root_right = new Node<>(12);
		root_left_right = new Node<>(6);
		
		root.left = root_left;
		root.right = root_right;
		root_left.right = root_left_right;
		
		//BST set up
		binary_search_tree = new BinarySearchTree<>();
		
		binary_search_tree.add(8);
		binary_search_tree.add(4);
		binary_search_tree.add(12);
		binary_search_tree.add(6);
	}
	
	//BST Node Testing
	@Test
	public void height() {
		
		Node<Integer> empty = new Node<>(0);
		
		empty.left = null;
		empty.right = null;

		assertEquals(1, empty.height());
		
		assertEquals(3, root.height());
	}
	
	/**
	 * Test the contains method inside of the node class
	 */
	@Test
	public void node_contains() {
		
		assertEquals(true, root.contains(12));
		assertEquals(false, root.contains(15));
		
		Node<Integer> empty = new Node<>(0);
		
		empty.left = null;
		empty.right = null;
		
		assertEquals(false, empty.contains(8));
	}
	
	/**
	 * Test the insert method inside of the node class
	 */
	@Test
	public void insert() {
		
		//Empty BST testing
		Node<Integer> empty = new Node<>(0);
		
		empty.left = null;
		empty.right = null;
		
		empty.insert(-1);
		
		assertEquals((Object)(-1), empty.left.data);
		
		empty.insert(1);
		
		assertEquals((Object)1, empty.right.data);
		
		//Root BST testing
		root.insert(2);
		
		assertEquals((Object)2, root_left.left.data);
		
		root.insert(10);
		
		assertEquals((Object)10, root_right.left.data);
		
		root.insert(14);
		
		assertEquals((Object)14, root_right.right.data);
	}

	//BST Testing
	
	/**
	 * Test the add method.
	 */
	@Test
	public void add() {
		
		binary_search_tree.add(14);
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		answer.add(4);
		answer.add(6);
		answer.add(8);
		answer.add(12);
		answer.add(14);
		
		assertEquals(answer, binary_search_tree.toArrayList());
		
		assertEquals(5, binary_search_tree.size());
	}

	/**
	 * Tests the addAll method
	 */
	@Test
	public void addAll() {
		
		BinarySearchTree<Integer> list = new BinarySearchTree<>();
		ArrayList<Integer> nums = new ArrayList<>();
		
		for(int index = 0; index < 100; index++){
			nums.add(index);
		}
		
		list.addAll(nums);
		
		assertTrue(list.containsAll(nums));
	}
	
	/**
	 * Tests the clear method
	 */
	@Test
	public void clear() {
		
		binary_search_tree.clear();
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		assertEquals(answer, binary_search_tree.toArrayList());
	}
	
	/**
	 * Tests the contains method
	 */
	@Test 
	public void contains() {
		
		assertEquals(true, binary_search_tree.contains(8));
		assertEquals(true, binary_search_tree.contains(12));
		assertEquals(true, binary_search_tree.contains(6));
		assertEquals(true, binary_search_tree.contains(4));
	}
	
	/**
	 * Tests the containsAll method
	 */
	@Test
	public void containsAll() {
		
		BinarySearchTree<Integer> ordered = new BinarySearchTree<>();
		ArrayList<Integer> nums = new ArrayList<>();
		
		for(int index = 0; index < 100; index++){
			nums.add(index);
		}
		
		ordered.addAll(nums);
		
		assertTrue(ordered.containsAll(nums));
		ordered.remove(1);
		assertFalse(ordered.containsAll(nums));
		
	}
	
	/**
	 * Tests the first method
	 */
	@Test
	public void first() {
		
		assertTrue(binary_search_tree.first().compareTo(4) == 0);
		
		binary_search_tree.remove(4);
		
		assertTrue(binary_search_tree.first().compareTo(6) == 0);
		
		binary_search_tree.remove(8);

	}
	
	/**
	 * Tests the isEmpty method
	 */
	@Test
	public void isEmpty() {
		
		assertEquals(false, binary_search_tree.isEmpty());
		
		binary_search_tree.clear();
		
		assertEquals(true, binary_search_tree.isEmpty());
	}
	
	/**
	 * Tests the last method
	 */
	@Test 
	public void last() {
		
		assertEquals((Object)12, binary_search_tree.last());
	}
	
	/**
	 * Tests the remove method
	 */
	@Test
	public void remove() {
		
		binary_search_tree.remove(6);
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		answer.add(4);
		answer.add(8);
		answer.add(12);
		
		assertEquals(answer, binary_search_tree.toArrayList());
	}
	
	/**
	 * Tests the removeAll method
	 */
	@Test 
	public void removeAll() {
		
		BinarySearchTree<Integer> ordered = new BinarySearchTree<>();
		ArrayList<Integer> nums = new ArrayList<>();
		
		for(int index = 0; index < 10; index++){
			nums.add(index);
		}
		
		ordered.addAll(nums);
		ArrayList<Integer> offset = new ArrayList<>();
		for(int index = 1; index < 10; index += 2){
			offset.add(index);
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		for(int index = 0; index < 10; index += 2){
			answer.add(index);
		}
		
		ordered.removeAll(offset);
		assertTrue(ordered.containsAll(answer));
		

		ordered.removeAll(nums);
		
		assertTrue(ordered.size == 0);
	}
	
	/**
	 * Tests the size method
	 */
	@Test
	public void size() {
		
		assertEquals(4, binary_search_tree.size());
		
		binary_search_tree.clear();
		
		assertEquals(0, binary_search_tree.size());
	}
	
	/**
	 * Tests the toArrayList method
	 */
	@Test
	public void toArrayList() {
		
		ArrayList<Integer> answer = new ArrayList<>();
		
		answer.add(4);
		answer.add(6);
		answer.add(8);
		answer.add(12);
		
		assertEquals(answer, binary_search_tree.toArrayList());
		
		binary_search_tree.add(10);
		
		ArrayList<Integer> answer2 = new ArrayList<>();
		
		answer2.add(4);
		answer2.add(6);
		answer2.add(8);
		answer2.add(10);
		answer2.add(12);
		
		assertEquals(answer2, binary_search_tree.toArrayList());
	}
	
	/**
	 * Tests the writeDot method
	 * 
	 * NOTE: This doesnt actually run any tests, but is useful for doing different operations
	 * to the BST and looking at the DOT files to see what has happened to the Tree
	 */
	@Test
	public void writeDot(){
		BinarySearchTree<Integer> dotTest = new BinarySearchTree<>();
		
		dotTest.add(8);
		dotTest.add(4);
		dotTest.add(12);
		dotTest.add(2);
		dotTest.add(6);
		dotTest.add(10);
		dotTest.add(14);
		dotTest.add(1);
		dotTest.add(3);
		dotTest.add(5);
		dotTest.add(7);
		dotTest.add(9);
		dotTest.add(11);
		dotTest.add(13);
		dotTest.add(15);
		
		dotTest.writeDot("test.DOT");
		dotTest.remove(8);
		dotTest.writeDot("testAfter.DOT");
		
	}
}