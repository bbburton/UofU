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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Represents a priority queue of generically-typed items.
 * The queue is implemented as a min heap.
 * 
 * The min heap is implemented implicitly as an array.
 * 
 * @author Brian Burton, Lisa Richardson
 */
public class Heap<Type> implements Priority_Queue<Type>
{
	/** 
	 * The number of elements in the heap (NOT: the capacity of the array)
	 */
	private int							size;

	/**
	 * The implementation array used to store heap values.
	 * 
	 * NOTE: the capacity of the array will be larger (or equal) to the size (of the heap).
	 * 
	 * WARNING: to simplify math, you are to use a 1 INDEXED array. (this means you ignore 0 bucket) and
	 * the capacity of the array has to be 1 larger
	 */
	private Type[]					heap_array;

	/**
	 * If the user provides a comparator, use it instead of default comparable
	 */
	private Comparator<? super Type>	comparator;

	/**
	 * Constructs an empty priority queue. Orders elements according
	 * to their natural ordering (i.e., AnyType is expected to be Comparable)
	 * 
	 * AnyType is not forced to be Comparable.
	 */
	@SuppressWarnings("unchecked")
	public Heap(int length) {
		
		size = 0;
		comparator = null;
		heap_array = (Type[]) new Object[length];
	}

	/**
	 * Construct an empty priority queue with a specified comparator.
	 * 
	 * Orders elements according to the input Comparator (i.e., AnyType need not be Comparable).
	 */
	public Heap(Comparator<? super Type> c) {
		
		this(10);
		comparator = c;
	}

	/**
	 * Removes and returns the minimum item in this priority queue.
	 * 
	 * @throws NoSuchElementException if this priority queue is empty.
	 * (Runs in logarithmic time.)
	 */
	public Type dequeue() throws NoSuchElementException { 

		// if the heap is empty, throw a NoSuchElementException
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		// store the minimum item so that it may be returned at the end
		Type result = this.peek();
		
		// replace the item at minIndex with the last item in the tree
		heap_array[1] = heap_array[size];
		heap_array[size] = null;
		
		// update size
		size--;
			
		// percolate the item at minIndex down the tree until heap order is restored
		bubble_down(1);	
		
		// return the minimum item that was stored
		return result;
	}

	/**
	 * Exchanges two nodes if the current node is larger than either of it's children.
	 * 
	 * @param index - The index of an array.
	 */
	protected void bubble_down(int index) { 
		
		//While(children of index exist)
		while(index * 2 <= size) {
			
			//left child <-- array[left index from index];
			int left = index * 2;
			//right child <-- array[right index from index];
			int right = index * 2 + 1;
			
			//smallest <-- smallest of left or right (if right exists)
			int smallest = left;
			
			if(right <= size && this.compare(heap_array[left], heap_array[right]) > 0) {
				
				smallest = right;
			}
			
			//if current <= smallest
			if(this.compare(heap_array[index], heap_array[smallest]) < 0) {
				
				//DONE
				return;
			}
			else {
				
				//swap index with smallest
				this.swap(index, smallest);
			}
			
			//index <-- smallest
			index = smallest;
		}
	}

	/**
	 * Adds an item to this priority queue.
	 * (Runs in logarithmic time.) Can sometimes terminate early.
	 * 
	 * WARNING: make sure you use the compare method defined for you below
	 * 
	 * @param x
	 *            -- the item to be inserted
	 */
	public void add(Type x) { 
		
		// if the array is full, double its capacity
		if(size + 1 >= heap_array.length) { 
			
			double_array();
		}
		
		// add the new item to the next available node in the tree, so that
		heap_array[size + 1] = x;
				
		// percolate the new item up the levels of the tree until heap order is restored
		bubble_up(size + 1);
		
		// update size
		size++;
	}
	
	/**
	 * Exchanges two nodes if the parent is larger than the current node.
	 * 
	 * @param index - The index of an array.
	 */
	protected void bubble_up(int index) { 
		
		//While the current index value is larger than its parent's.
		while(index > 1 && less(index/2, index)) { 
			swap(index, index/2);
			index = index/2;
		}
	}
	
	/**
	 * Returns true if the parent's value is larger than the child's.
	 * 
	 * @param parent - The parent node index.
	 * @param child - The child node index.
	 * 
	 * @returns true if the child's value is larger than the parent's.
	 */
	private boolean less(int parent, int child) { 
		
		//heap_array[parent] > heap_array[child];
		if(this.compare(heap_array[parent], heap_array[child]) > 0) {
			
			return true;
		}
		
		return false;
	}

	/**
	 * Swaps two indices in an array.
	 * 
	 * @param child - An index of an array to switch.
	 * @param parent - An index of an array to switch.
	 */
	protected void swap(int child, int parent) { 
		
		Type temp = heap_array[child];
		heap_array[child] = heap_array[parent];
		heap_array[parent] = temp;
	}
	
	/**
	 * Doubles an array to twice it's size.
	 * 
	 * @returns an array that is double the size of the given array.
	 */
	@SuppressWarnings("unchecked")
	protected void double_array() { 
		
		Type[] new_heap_array = (Type[]) new Object[heap_array.length * 2];
		
		for(int index = 1; index <= size; index++) {
			new_heap_array[index] = heap_array[index];
		}
		
		heap_array = new_heap_array;
	}

	/**
	 * Generates a DOT file for visualizing the binary heap.
	 */
	public void generateDotFile(String filename) { 
		
		try (PrintWriter out = new PrintWriter(filename)) {
			
			out.println(this);
		}
		catch (IOException e) {
			
			System.out.println(e);
		}
	}

	/**
	 * Internal method for comparing lhs and rhs using Comparator if provided by the
	 * user at construction time, or Comparable, if no Comparator was
	 * provided.
	 */
	@SuppressWarnings("unchecked")
	private int compare(Type lhs, Type rhs) { 
		
		if (comparator == null) {
			
			return ((Comparable<? super Type>) lhs).compareTo(rhs); // safe to ignore warning
		}

		// We won't test your code on non-Comparable types if we didn't supply a Comparator
		return comparator.compare(lhs, rhs);
	}

	/**
	 * @return a copy of the array used in the heap
	 */
	public Object[] toArray() { 
		
		Object[] copy_of_array = new Object[size+1];

		for (int i = 1; i <= size; i++) {
			
			copy_of_array[i] = heap_array[i];
		}

		return copy_of_array;
	}

	/**
	 * @return a string representing the DOT data of the heap 
	 * 
	 * This can be further augmented to print out any instrumented values that you think
	 * are important.  Note: To allow them not to conflict with the DOT notation, simply
	 * preface them with the // comment characters: e.g., "// numbers of insertions: 1234"
	 */
	@Override
	public String toString() { 
		
		String result = "digraph Heap {\n\tnode [shape=record]\n";
		for (int i = 1; i <= size; i++) {
			
			result += "\tnode" + i + " [label = \"<f0> |<f1> " + heap_array[i] + "|<f2> \"]\n";
			if (((i * 2)) <= size) result += "\tnode" + i + ":f0 -> node" + ((i * 2)) + ":f1\n";
			if (((i * 2) + 1) <= size) result += "\tnode" + i + ":f2 -> node" + ((i * 2) + 1) + ":f1\n";
		}
		
		result += "}";

		result += "\n//--------------------------------------------\n" + "// Any other info you want to put about your heap";

		return result;
	}

	/**
	 * 1) copy data from array into heap storage
	 * 2) do an "in place" creation of the heap
	 * The Array passed in must have a null at index 0.
	 * 
	 * @param array
	 *            - random data (unordered)
	 */
	public void build_heap_from_array(Type[] array) {
		
		this.heap_array = array;
		this.size = array.length - 1;
		
		int idx = size;
		while(idx > 1){
			bubble_up(idx);
			if(!less(idx/2, idx)){
				idx--;
			}
		}
	}

	/**
	 * convert the heap array into a sorted array from largest to smallest
	 * 
	 * Note: this destroys the heap property of the array and should be a terminal operation, which
	 *       is not what we would likely do in a real program, but is appropriate to for our purposes (i.e.,
	 *       understanding how heap sort works in place).
	 * 
	 */
	public void heap_sort() {
		
		int store = size;
		
		while(size > 1){
			swap(size, 1);
			size--;
			bubble_down(1);
		}
		
		size = store;
	}

	/**
	 * @return the smallest element the queue. 
	 * @throws NoSuchElementException if this priority queue is empty. (Must run in constant time.)
	 */
	@Override
	public Type peek() { 
		
		if(size == 0) {
			
			throw new NoSuchElementException();
		}
		
		return heap_array[1];
	}

	/**
	 * Returns the total number of elements in the queue.
	 */
	@Override
	public int size() { 
		
		return size;
	}

	/**
	 * Makes this priority queue empty. 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() { 
		
		size = 0;
		heap_array = (Type[]) new Object[10];
	}
}