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
 * Partner name: Melvin Bosnjak
 */

package lists_2420;

import java.util.ArrayList; 
import java.util.NoSuchElementException;

/**  
 * This interface represents common actions done to Collections, whether 
 * they are stacks, queues, bags, etc.  
 *  
 * All operations should list expected Big O time.
 * 
 * You are to implement this interface as a Generic Linked List and as an Integer Array List. 
 */

public interface List_2420<Type> {
	
	/*
	 * The following functions should behave in the same manner
	 * as the java.LinkedList Class
	 */
	void add_first(Type data);
	void add_last(Type data);
	
	/*
	 * Add a node after the given node index.
	 * 
	 * @param after
	 * 				(For example, after = 0, would mean after the first node)
	 * 				if after is larger or equal to the length of the list, then
	 * 				put the new node at the end of the list. If the value of
	 * 				after is larger than the length of the list, then add
	 * 				to the end.
	 */
	void add_middle(int after, Type data);
	
	//remove all nodes
	void clear();
	
	//return true if the item is in the list - iterative
	boolean contains(Type item);
	
	//return true if the item is in the list - recursive
	boolean contains_recursive(Type item);
	
	//the following method throw an exception if the data does not exist
	//(rather than return null)
	Type get_first() throws NoSuchElementException;
	Type get_last() throws NoSuchElementException;
	
	//get value of first item and remove the node from the list
	Type remove_first() throws NoSuchElementException;
	Type remove_last() throws NoSuchElementException;
	
	//return the size of the list (non-recursive)
	int size();
	
	/**
	 * With a single traversal of the list, in place,
	 * swap the order of the entire list, such that
	 * that which was last is first and that which was
	 * first is last.
	 */
	void reverse();
	
	/**
	 * @return the length of the list
	 * 
	 * 			for linked list: determine the size of a list using the
	 * 			Node<Type>.size_recursive() function.
	 * 
	 * 			for array list: write a recursive size method.
	 */
	int compute_size_recursive();
	
	/**
	 * @return an ArrayList of the data in the linked list in reverse order.
	 * 
	 * 	recursively traverse the list, building up an ArrayList of the data.
	 * 	using the Node<Type>.to_ArrayList_post_recurse() function.
	 */
	ArrayList<Type> to_ArrayList_post_recurse();
	
	/**
	 * iteratively traverse the list, building up an ArrayList of the data
	 * in order.
	 * 
	 * Do no use Node methods.
	 */
	ArrayList<Type> to_ArrayList();
}