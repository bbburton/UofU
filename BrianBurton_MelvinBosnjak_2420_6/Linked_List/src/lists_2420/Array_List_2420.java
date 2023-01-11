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
import java.util.Random;

/**
 * 
 * @author Brian Burton & Melvin Bosnjak
 */
public class Array_List_2420 implements List_2420<Integer>{

	private Integer[] backing_store;
	private int first;
	private int last;
	private int numElements;
	
	Array_List_2420() {
		backing_store = new Integer[1024];
		first = 0;
		last = 0;
		numElements = 0;
	}
	
	/**
	 * Expands the backing_store array by double
	 */
	private void expand() {
		Integer[] newArray = new Integer[backing_store.length*2];
		int count = 0;
		for (int index = first; index < numElements; index++) {
			newArray[count] = backing_store[bound(index)];
			count++;
		}
		backing_store = newArray;
		this.first = 0;
		this.last = count - 1;
	}
	
	/**
	 * Bounds the index because of the wrapping factor of the ArrayList
	 * @param index
	 * @return bounded index
	 */
	private int bound(int index) {
		if (index >= 0 && index < backing_store.length) {
			return index;
		}
		if (index >= backing_store.length) {
			return index % backing_store.length;
		}
		return index + backing_store.length;
	}
	
	/**
	 * Adds the @param data into the first index
	 */
	@Override
	public void add_first(Integer data) {
		// If the array is full, expand it. called in all add methods
		if (numElements == backing_store.length) {
			expand();
		}
		// Incase the array is empty just add it at the begining, similar to all add methods
		if (backing_store[first] != null) {
			first = bound(first - 1);			
		}
		backing_store[bound(first)] = (int) data;
		numElements++;
	}

	/**
	 * Adds the @param data into the last index
	 */
	@Override
	public void add_last(Integer data) {
		if (numElements == backing_store.length) {
			expand();
		}
		if (backing_store[last] != null) {
			last = bound(last + 1);
		}
		backing_store[bound(last)] = (int)data;
		numElements++;
	}

	/**
	 * Add @param data after the given @param index.
	 *
	 */
	@Override
	public void add_middle(int after, Integer data) {
		if (numElements == backing_store.length) {
			expand();
		}
		// the case where the after is larger than the array, then just add it to the end
		if(after >= last) {
			last = bound(last + 1);
			backing_store[last] = (int)data;
		}
		// the case where the after is smaller than the array, then just add it to the begining
		if(after < 0) {
			first = bound(first - 1);
			backing_store[first] = (int)data;
		}
		after = bound(after + first);
		// shifts the array so there is room to insert the element
		for (int index = last; index > after; index--) {
			backing_store[bound(index + 1)] = backing_store[bound(index)];
		}
		backing_store[bound(after + 1)] = (int)data;
		numElements++;
		last++;
	}

	/**
	 * Converts all of the elements in the array to nulls
	 */
	@Override
	public void clear() {
		int previousLength = backing_store.length;
		backing_store = new Integer[previousLength];
	}

	/**
	 * Returns true if the element is in the array, false if otherwise
	 */
	@Override
	public boolean contains(Integer item) {
		for (int index = first; index < first + numElements; index++) {
			if (backing_store[bound(index)] == null) {
				break;
			}
			if (backing_store[bound(index)] == (int)item) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The helper method for the recursive contain, stores the @param first
	 *  where the recursion is currently at
	 * @param item - the item it is searching for
	 * @param first - the location where it is at in the recursion
	 */
	private boolean contains_help(Integer item, int first) {
		// first base case, if it is null then it has gone through all of the elements 
		// and it returns false 
		if (backing_store[bound(first)] == null) {
			return false;
		}
		// second base case the item is found, return true
		if (backing_store[bound(first)] == item) {
			return true;
		}
		return contains_help(item, first + 1);
	}
	
	/**
	 * Driver method for the contains recursion method
	 */
	@Override
	public boolean contains_recursive(Integer item) {
		return contains_help(item, first);
	}

	/** 
	 * this method will @return the first element in the array
	 */
	@Override
	public Integer get_first() throws NoSuchElementException {
		if (backing_store[first] == null) {
			throw new NoSuchElementException();
		}
		return backing_store[first];
	}

	/**
	 * this method will @return the last element in the array
	 */
	@Override
	public Integer get_last() throws NoSuchElementException {
		if (backing_store[last] == null) {
			throw new NoSuchElementException();
		}
		return backing_store[last];
	}

	/**
	 * this method will @return the removed first element in the array
	 */
	@Override
	public Integer remove_first() throws NoSuchElementException {
		if (backing_store[first] == null) {
			throw new NoSuchElementException();
		}
		Integer firstElement = backing_store[first];
		backing_store[first] = null;
		first = bound(first + 1);
		numElements--;
		return firstElement;
	}

	/**
	 * this method will @return the removed last element in the array
	 */
	@Override
	public Integer remove_last() throws NoSuchElementException {
		if (backing_store[last] == null) {
			throw new NoSuchElementException();
		}
		Integer lastElement = backing_store[last];
		backing_store[last] = null;
		last = bound(last - 1);
		numElements--;
		return lastElement;
	}

	/**
	 * this method will @return size of the elements in the array (not counting nulls)
	 */
	@Override
	public int size() {
		int size = 0;
		for (int index = first; index < first + numElements; index++) {
			size++;
		}
		return size;
	}

	/**
	 * Puts the elements in the array in reverse order
	 */
	@Override
	public void reverse() {
		expand();
		// goes to length/2 and swaps the current element and the element on the 
		// mirror side of the array
		for (int index = first; index < (last + 1)/2; index++) {
			int temp = backing_store[index];
			backing_store[index] = backing_store[(last + 1) - index - 1];
		    backing_store[(last + 1) - index - 1] = temp;
		}
	}

	/**
	 * this method will @return number of the elements in the array (not counting nulls)
	 */
	@Override
	public int compute_size_recursive() {
		return this.size();
	}

	/**
	 * Converts the backing store array into an @return ArrayList
	 */
	@Override
	public ArrayList to_ArrayList() {
		ArrayList<Integer> result = new ArrayList<Integer>(this.size());
		for (int index = first; index < first + numElements; index++) {
			result.add(backing_store[bound(index)]);
		}
		return result;
	}

	/**
	 * converts the backing store array into an @return ArrayList
	 */
	@Override
	public ArrayList to_ArrayList_post_recurse() {
		return to_ArrayList();
	}
	
	/**
	 * Helper method that prints the array
	 */
	public void print() {
		String result = "[";
		for (int index = 0; index < backing_store.length; index++) {
			result += backing_store[index] + ", ";
			if (index == backing_store.length - 1) {
				result += backing_store[index];
			}
		}
		result += "]";
		System.out.println(result);
	}
	
}
