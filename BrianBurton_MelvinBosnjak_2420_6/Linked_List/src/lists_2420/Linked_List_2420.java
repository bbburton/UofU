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
 * Represents a Linked List.
 * 
 * @author Brian Burton & Melvin Bosnjak
 */
public class Linked_List_2420<Type> implements List_2420<Type> {
	
	Node<Type> first;
	Node<Type> last;
	int size;
	
	/**
	 * Linked_List_2420 Constructor.
	 */
	Linked_List_2420() {
		
		this.first = null;
		this.last = null;
		size = 0;
	}
	
	/**
	 * FIXME: comments
	 *
	 * Pictorially, a node is:
	 *
	 * data next ---------- | 5 |---+---> ----------
	 * 
	 * Note, while a 5 is used above any "Type" could be contained in the node
	 */
	static class Node<Type> {
		
		Type data;
		Node<Type> next;

		/**
		 * The Node Constructor.
		 * 
		 * @param the_data - the element that is in the Node.
		 * @param after_me - the reference in the Node.
		 */
		Node(Type the_data, Node<Type> after_me) {
			
			this.data = the_data;
			this.next = after_me;
		}

		/**
		 * 
		 * This function must be written recursively.
		 * 
		 * @return the length of this "chain of nodes", including self.
		 * 
		 *         Note: 1) it doesn't matter if something (or multiple
		 *         somethings) points to this node, 2) if this node doesn't
		 *         point at anything, then the size would be 1.
		 */
		int length() {
			
			if(this.next == null){
				
				return 1;
			}

			return 1 + this.next.length();
		}

		/**
		 * recursive determine if the item is in this node or the nodes after
		 * 
		 * @param item - needle
		 * 
		 * @return true if item in chain
		 */
		boolean contains_recursive(Type item) {
			
			while(this.data != null) {
				
				if(this.data == item) {
					
					return true;
				}
			}
			
			if(this.next == null) {
				
				return false;
			}

			return this.next.contains_recursive(item);
		}

		/**
		 * This function must be written recursively (using a helper method,
		 * with the arraylist as a parameter, to do the recursion)
		 * 
		 * Create an array list containing the data from this node and all nodes
		 * after it.
		 * 
		 * In the helper method, add the data to the array list after the
		 * recursive call, thus "reversing" the list.
		 */
		ArrayList<Type> to_ArrayList_post_recursive() {
			
			ArrayList<Type> array = new ArrayList<Type>();
			
			add_node_data_to_ArrayList(array);
			
			return array;
		}
		
		/**
		 * A HELPER METHOD that adds the node data to an ArrayList 
		 * after the recursive call, thus "reversing" the list.
		 * 
		 * @return - An ArrayList 
		 */
		protected void add_node_data_to_ArrayList(ArrayList<Type> array) {
			
			if(this.data != null) {
				
				this.next.add_node_data_to_ArrayList(array);
			}
				
			array.add(this.data);
		}

		/**
		 *
		 * FIXME: this method must be implemented using recursion
		 *
		 * Creates a string that describes the current node and all following
		 * nodes, for example, a list of the nubmers 0, 1, 2, 3 would print as:
		 * 
		 * "[0]--> [1]--> [2]--> [3]--> null"
		 *
		 * WARNING: the syntax must be exact. "open square bracket, data, close
		 * square bracket, hyphen, hyphen, greater than space, ... null"
		 *
		 * @return a string representation of this chain of nodes
		 */
		public String toString() {
			
			String result = "[" + this.data + "] --> ";
			
			if(this.next == null) {
				
				result += "null";
			}

			return result + this.next.toString();
		}
	}

	/**
	 * FIXME: this method must NOT use recursion FIXME: for our purposes DO NOT
	 * use the Node toString method here
	 *
	 * Creates a string that describes the contents of the list, starting with
	 * the size in parentheses for example, a list of the numbers 0, 1, 2, 3
	 * would print as:
	 * 
	 * "(4) [0]--> [1]--> [2]--> [3]--> null"
	 *
	 * an empty list should simply return the string "empty"
	 *
	 * WARNING: the syntax must be exact. "open parenthesis, size, close
	 * parenthesis, space, open square bracket, data, close square bracket,
	 * hyphen, hyphen, greater than space, ... null"
	 *
	 * @return a string representation of this chain of nodes.
	 */
	public String toString() {
		
		Node<Type> temp = this.first;
		
		String result = "";
		
		if(temp == null) {
			
			return "empty";
		}
		
		result = "(" + this.size + ") ";
		
		while(temp != null) {
			
			result += "[" + temp.data + "] --> ";
			
			temp = temp.next;
		}
		
		result += "null";
		
		return result;
	}

	/**
	 * Adds a node to the beginning of a Linked List.
	 */
	@Override
	public void add_first(Type data) {
		
		if(this.first == null) {
			
			this.first = new Node<Type>(data, null);
			this.last = this.first;
			this.size++;
		}
		else {
			
			Node<Type> temp = new Node<Type>(data, null);
			
			temp.next = this.first;
			this.first = temp;
			this.size++;
		}
	}

	/**
	 * Adds a node to the end of a Linked List.
	 */
	@Override
	public void add_last(Type data) {
		
		if(this.last == null) {
			
			this.first = new Node<Type>(data, null);
			this.last = this.first;
			this.size++;
		}
		else if(this.first == this.last) {
			
			Node<Type> temp = new Node<Type>(data, null);
			
			this.first.next = temp;
			
			this.last = temp;

			this.size++;
		}
		else{
			
			Node<Type> temp = new Node<Type>(data, null);
			
			this.last.next = temp;
			
			this.last = temp;

			this.size++;
		}
	}

	/**
	 * Adds a node to the middle of a Linked List at a designated index.
	 */
	@Override
	public void add_middle(int after, Type data) {
		
		if(this.first == null) {
			
			this.first = new Node<Type>(data, null);
			this.last = this.first;
			this.size++;
		}
		else {
		
			Node<Type> current = this.first;			
			Node<Type> temp = current;
			
				for(int iterate = 0; iterate < after; iterate++) {
			
					temp = temp.next;
				}
			
			Node<Type> newNode = new Node<Type> (data, temp.next);
			
//			this.last.next = newNode;
//			
//			this.last = newNode;
			
			temp.next = newNode;
		
			this.size++;
		}
	}

	/**
	 * Clears all nodes from a Linked List.
	 */
	@Override
	public void clear() {
		
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	/**
	 * Searches through a Linked List seeing if an element exists in it.
	 */
	@Override
	public boolean contains(Type item) {
		
		Node<Type> temp = this.first;
		
		while(temp != null) {
			
			if(temp.data == item) {
				
				return true;
			}
			temp = temp.next;
		}
		
		return false;
	}

	/**
	 * Searches through a Linked List recursively seeing if an element exists in it.
	 * 
	 * This method actually erases the original arrays while it counts.	
	 */
	@Override
	public boolean contains_recursive(Type item) {
			
		Node<Type> current = this.first;
		
		if(current.next == null || current.data == null) {
			
			return false;
		}
		else if(current.data == item) {
			
			return true;
		}
		else {
			
			remove_first();
		}
		
		return contains_recursive(item);
	}

	/**
	 * Retrieves the first element in a Linked List.
	 */
	@Override
	public Type get_first() throws NoSuchElementException {
		
		if(this.first == null) {
			
			return null;
		}
		
		return this.first.data;
	}

	/**
	 * Retrieves the last element in a Linked List.
	 */
	@Override
	public Type get_last() throws NoSuchElementException {
		
		if(this.last == null) {
			
			return null;
		}
		
		return this.last.data;
	}

	/**
	 * Removes the first node in a Linked List.
	 */
	@Override
	public Type remove_first() throws NoSuchElementException {
		
		if (this.first == null) {
			
			return null;
		}

		Type new_first = this.first.data;
		this.first.data = this.first.next.data;
		this.first = this.first.next;
		
		this.size--;
		
		return new_first;
	}
	/**
	 * Removes the last node in a Linked List.
	 */
	@Override
	public Type remove_last() throws NoSuchElementException {	
		
		Type result = null;
		
		if(this.last != null) {
					
		result = this.last.data;
		Node<Type> current = first;
					
			while(current.next != this.last) {
						
				current = current.next;
			}
					
			this.last = current;
		}
				
			return result;
	}

	/**
	 * Returns the number of nodes in a Linked List.
	 */
	@Override
	public int size() {

		return this.size;
	}

	/**
	 * Reverses the ordering of the nodes in a Linked List.
	 */
	@Override
	public void reverse() {
		
		Node<Type> current = this.first;
		Node<Type> reverse = this.first.next;
		
		if ( first.data == null || first.next.data == null) {
			
			return;
		}

		while(reverse != null && current != null) {

			Node<Type> temp = reverse.next;
			reverse.next = current;
			current = reverse;
			reverse = temp;
		}
		
		this.last = this.first;
		this.first.next = null;
		this.first = current;
	}

	/**
	 * Returns the number of nodes in a Linked List using recursion.
	 */
	@Override
	public int compute_size_recursive() {
		
		Node<Type> temp = this.first;
		
		if(temp == null) {
			
			return 0;
		}
		
		if(temp != null && temp.next == null) {
			
			return 1;
		}

		return first.length();
	}

	/**
	 * Changes a Linked List into an ArrayList recursively.
	 */
	@Override
	public ArrayList<Type> to_ArrayList_post_recurse() {		
		
		ArrayList <Type> result = new ArrayList<Type>();

		if (this.first != null)	{
			
			reverse();

			Node<Type> current = this.first;
			
			for (int index = 0; index < size(); index++) {
				
				result.add(current.data);
				current = current.next;
			}
		}

		return result;
	}

	/**
	 * Changes a Linked List into an ArrayList.
	 */
	@Override
	public ArrayList<Type> to_ArrayList() {
		
		ArrayList<Type> array = new ArrayList<Type>();
		
		Node<Type> temp = this.first;
		
		while(temp != null) {
			
			array.add(temp.data);
			temp = temp.next;
		}
		
		return array;
	}
}
