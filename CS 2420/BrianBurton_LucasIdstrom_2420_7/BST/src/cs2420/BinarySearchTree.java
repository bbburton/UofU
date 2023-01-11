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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * BinarySearchTree is the class that creates the BST. Implementing the SortedSet interface methods,
 * BinarySearchTree creates a tree made of nodes, each containing a value and a pointer to a left and
 * a right node. The top of the tree is the root of the tree.
 * 
 * @author Lucas Idstrom
 * @author Brian Burton
 * @Date March 2, 2017
 *
 */
public class BinarySearchTree<Type extends Comparable<? super Type>> implements SortedSet<Type> {
	
	Node<Type> root;
	int size;
	
	/**
	 * Binary Search Tree Constructor
	 */
	BinarySearchTree(){
		root = null;
		size = 0;
	}

	/**
	 * An inner class named Node
	 *
	 * Pictorially, a node is:
	 *
	 * left data right --------------- <--+ | 5 | +---> ---------------
	 * 
	 * Note, while a 5 is used above any "Type" could be contained in the node
	 */
	static class Node<Type extends Comparable<? super Type>> {

		protected Type data;
		protected Node<Type> left;
		protected Node<Type> right;

		/**
		 * The Node Constructor
		 * 
		 * @param the_data - The data stored in a single node
		 */
		Node(Type the_data) {

			data = the_data;
		}
		
		/**
		 * This function must be written recursively.
		 *
		 * Height is defined as the 1 plus the maximum height of the left vs
		 * right sub tree
		 * 
		 * @return the height from this node to its leaves
		 */
		int height() {
			
			int left_height = 0;
			int right_height = 0;

			// The base case
			if(this.left == null && this.right == null) {
				return 1;
			}
			
			// Go left if not null
			if(this.left != null) {
				left_height = left.height();
			}
		
			//Go right if not null
			else if(this.right != null) {
				right_height = right.height();
			}
			
			return 1 + Math.max(left_height, right_height);
		}

		/**
		 * recursive determine if the item is in this node or the nodes after
		 * 
		 * @param item - needle
		 * 
		 * @return true if item in tree
		 */
		boolean contains(Type item) {

			// The base case
			if (this.data.compareTo(item) == 0) {
				return true;
			}
			
			// Go right if the node data compared to the item is negative
			if (this.data.compareTo(item) < 0){
				if(this.right != null){
					return right.contains(item);
				}
			}
			
			// Go left if the node data compared to the item is positive
			if(this.data.compareTo(item) > 0){
				if(this.left != null){
					return left.contains(item);
				}
			}
			
			return false;
		}

		/**
		 * recursive - add a node
		 * 
		 * @param item - data to add
		 */
		void insert(Type item) {
			
			Node<Type> new_node = new Node<>(item);
			// The base case
			if (this.data == null) {
				this.data = item;
			}
			
			//Go right if the node data compared to the item is positive
			if(new_node.data.compareTo(this.data) >= 0){
				if(this.right == null){
					this.right = new_node;
					return;
				}else{
					this.right.insert(new_node.data);
				}
			}else{
				// Go left if the node data compared to the item is negative
				if(new_node.data.compareTo(this.data) < 0){
					if(this.left == null){
						this.left = new_node;
						return;
					}else{
						this.left.insert(new_node.data);
					}
				}
			}
		}
	}
	
	/**
	 * Creates a picture of what the Binary Search Tree looks like
	 * 
	 * @param filename - the file you wish to see
	 */
	void writeDot(String filename) {
		try{
		    PrintWriter writer = new PrintWriter(filename, "UTF-8");
		    writer.println("digraph");
		    writer.println("{");
		    
		    if(root != null){
		    	writeDot(writer, root, 0);	
		    }
		    
		    writer.println("}");
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
	}
	
	/**
	 * Helper method for the writeDot method
	 * 
	 * @param writer - the PrintWriter
	 * @param node - the root node
	 * @param currentNull - the current position
	 */
	void writeDot(PrintWriter writer, Node<Type> node, int currentNull){
		currentNull++;
		if(node.left != null){
    		writer.println(node.data + " -> " + node.left.data);
    		writeDot(writer, node.left, currentNull+1);
    	}else{
    		if(node.right != null){
    			String empty = "null" + currentNull+2;
    			writer.println(empty + "[shape=point];");
    			writer.println(node.data + " -> " + empty);
    		}
    		if(node == root){
    			writer.println(node.data);
    		}
    	}
		currentNull++;
		if(node.right != null){
    		writer.println(node.data + " -> " + node.right.data);
    		writeDot(writer, node.right, currentNull+3);
    	}else{
    		if(node.left != null){
    			String empty = "null" + currentNull+4;
    			writer.println(empty + "[shape=point];");
    			writer.println(node.data + " -> " + empty);
    		}
    	}
	}
	
	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item - the item whose presence is ensured in this set
	 * 
	 * @return true if this set changed as a result of this method call (that
	 *         is, if the input item was actually inserted); otherwise, returns
	 *         false
	 * 
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean add(Type item){
		
		if(item == null){
			throw new NullPointerException();
		}
		
		if(this.root == null) {
			this.root = new Node<Type>(item);
			size++;
		}
		
		//Check if set contains item
		if(this.root.contains(item)){
			return false;
		}
		
		//Insert item
		this.root.insert(item);
		size++;
		return true;
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items - the collection of items whose presence is ensured in this set
	 * 
	 * @return true if this set changed as a result of this method call (that
	 *         is, if any item in the input collection was actually inserted);
	 *         otherwise, returns false
	 *         
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean addAll(Collection<? extends Type> items) {

		boolean changed = false;
		
		Collections.shuffle((List<?>) items);
		
		for(Type index : items){
			if(add(index) == true){
				changed = true;
			}
			
		}
		return changed;
	}

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	@Override
	public void clear() {
		
		root = null;
		size = 0;
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item - the item sought in this set
	 * 
	 * @return true if there is an item in this set that is equal to the input
	 *         item; otherwise, returns false
	 *         
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean contains(Type item) {
		
		if(item == null) {
			throw new NullPointerException();
		}
		
		if(root == null) {
			return false;
		}

		return root.contains(item);
	}

	/**
	 * Determines if for each item in the specified collection, there is an item
	 * in this set that is equal to it.
	 * 
	 * @param items - the collection of items sought in this set
	 * 
	 * @return true if for each item in the specified collection, there is an
	 *         item in this set that is equal to it; otherwise, returns false
	 *         
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean containsAll(Collection<? extends Type> items) {
		
		//Iteratively go through the collection checking the items, setting changed to true if any change
		for (Type index : items){
			if(this.contains(index) != true){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Recursively go through tree going to the left until the left node is empty
	 * 
	 * @param node - the root node
	 * 
	 * @return smallest value (Left most side)
	 */
	private Type first(Node<Type> node) {
		
		if(node.left == null) {
			return node.data;
		}
		
		return first(node.left);
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * 
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public Type first() throws NoSuchElementException {
		
		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		return first(root);
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() {
		
		return root == null;
	}

	/**
	 * Recursively go through tree going to the left until the left node is empty
	 * 
	 * @param node - the root node
	 * 
	 * @return smallest value (Left most side)
	 */
	private Type last(Node<Type> node) {
		
		if(node.right == null) {
			return node.data;
		}
		
		return first(node.right);
	}
	
	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public Type last() throws NoSuchElementException {
		
		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		return last(root);
	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item - the item whose absence is ensured in this set
	 * 
	 * @return true if this set changed as a result of this method call (that
	 *         is, if the input item was actually removed); otherwise, returns
	 *         false
	 *         
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean remove(Type item) {
		
		if(item == null){
			throw new NullPointerException();
		}
		if(!contains(item)){
			return false;
		}
		
		Node<Type> remove = findNode(item, root);
		Node<Type> parent = findParent(item, root);
	
		//If right of remove node is null
		if(remove.right == null){
			
			if(remove.left == null){ // Case for removed node having no left or right
				
				//Set the parent pointer to null
				if(parent != null){
					if(parent.left != null){
						if(parent.left.data == item){
							parent.left = null;
						}else{
							parent.right = null;
						}
					}else{
						parent.right = null;
					}
				}
				if(parent == null){
					root = null;
				}
				
			}else{ // Case for removed node having only left
				
				if(parent != null){
					if(parent.left != null){
						if(parent.left.data == item){
							parent.left = remove.left;
						}else{
							parent.right = remove.left;
						}
					}else{
						parent.right = remove.left;
					}
				}
				if(parent == null){
					root = remove.left;
				}
			}
		}else{
			if(remove.left == null){ // Case for removed node having only right
				
				if(parent != null){
					if(parent.left != null){
						if(parent.left.data == item){
							parent.left = remove.right;
						}else{
							parent.right = remove.right;
						}
					}else{
						parent.right = remove.right;
					}
				}if(parent == null){
					root = remove.right;
				}
			}else{ // Case for removed node having left and right
				Node<Type> newRoot = findNode(first(remove.right), remove.right);
				newRoot.left = remove.left;
				
				if(parent != null){
					if(parent.left != null){
						if(parent.left.data == item){
							parent.left = remove.right;
						}else{
							parent.right = remove.right;
						}
					}else{
						parent.right = remove.right;
					}
				}
				if(parent == null){
					root = remove.right;
				}
			}
		}
		
		size--;
		return true;
	}
	
	/**
	 * Returns the node with the passed in item
	 * 
	 * @param item - the data
	 * @return - Node with item
	 * @throws - NoSuchElementException
	 */
	private Node<Type> findNode(Type item, Node<Type> node){
		
		if(node.data == item){
			return node;
		}
		
		// Go right if the item is larger than the node data
		if(item.compareTo(node.data) > 0){
			
			if(node.right == null){
				throw new NoSuchElementException();
			}
			return findNode(item, node.right);
		}
		// Go left if the item is smaller than the node data
		if(item.compareTo(node.data) < 0){
			
			if(node.left == null){
				throw new NoSuchElementException();
			}
			return findNode(item, node.left);
		}	
		return null;
	}

	/**
	 * Returns the parent node of the passed in item
	 * 
	 * @param item - the data
	 * @return - Parent of node with the item
	 * @throws NoSuchElementException
	 */
	private Node<Type> findParent(Type item, Node<Type> node){
		
		if(node.right != null){
			if(node.right.data == item){
				return node;
			}
		}
		if(node.left != null){
			if(node.left.data == item){
				return node;
			}
		}
		
		// Go right if the item is larger than the node data
		if(item.compareTo(node.data) > 0){
			
			return findParent(item, node.right);
		}
		//Go left if the item is smaller than the node data
		if(item.compareTo(node.data) < 0){
			
			return findParent(item, node.left);
		}	
		return null;
	}
	
	/**
	 * Ensures that this set does not contain any of the items in the specified
	 * collection.
	 * 
	 * @param items - the collection of items whose absence is ensured in this set
	 * 
	 * @return true if this set changed as a result of this method call (that
	 *         is, if any item in the input collection was actually removed);
	 *         otherwise, returns false
	 *         
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean removeAll(Collection<? extends Type> items) {

		boolean changed = false;
		//Iteratively go through the collection removing the items, setting changed to true if any change
		for (Type index : items){
			if(this.remove(index) == true){
				changed = true;
			}
		}
		
		return changed;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() {

		return size;
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order.
	 */
	@Override
	public ArrayList<Type> toArrayList() {
		
		ArrayList<Type> tree = new ArrayList<>();
		
		return toArrayList(root, tree);
	}
	
	/**
	 * Recursively adds the Binary Search Tree values to an ArrayList
	 * 
	 * @param node - the root node
	 * @param tree - an empty ArrayList
	 * @returns an in order ArrayList
	 */
	protected ArrayList<Type> toArrayList(Node<Type> node, ArrayList<Type> tree){
		
		//If the node is empty the return an empty ArrayList
		if(node == null) {
			return new ArrayList<Type>();
		}
		
		//If bottom of tree is reached, add value to the ArrayList
		if(node.left == null && node.right == null){
			tree.add(node.data);
			return tree;
		}
		
		//If left is possible, move left
		if(node.left != null){
			toArrayList(node.left, tree);
		}
		
		//Add current node to the ArrayList
		tree.add(node.data);
		
		//If right is possible, move right
		if(node.right != null) {
			toArrayList(node.right, tree);
		}
	
		return tree;
	}
}