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
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class Heap_Testing {
	
	//Heap Set Up
	Heap<Integer> heap;

	@Before
	public void setUp() throws Exception {
		
		//Heap Set Up
		heap = new Heap<Integer>(10);
		
		for(int index = 0; index < 10; index++) {
			heap.add(index + 1);
		}
	}
	
	@Test
	public void double_array_test() {
		
		assertEquals(10, heap.size());
	}
	
	@Test
	public void swap_test() {
		
		heap.swap(1, 2);
		
		Object[] temp = heap.toArray();
		
		assertArrayEquals(new Integer[] {null, 2, 1, 3, 4, 5, 6, 7, 8, 9, 10}, temp);
	}
	
	@Test
	public void clear_test() {
		
		heap.clear();
		
		Object[] temp = heap.toArray();
		
		assertEquals(0, heap.size());
		
		assertArrayEquals(new Integer[] {null}, temp);
	}
	
	@Test
	public void peek_test() {
		
		Heap<Integer> heap = new Heap<>(10);

		heap.add(5);
		heap.add(6);
		heap.add(3);
		heap.add(7);
		heap.add(8);
		heap.add(1);

		assertEquals(new Integer(1), heap.peek());
	}

	@Test
	public void duplicate_insertion_test() {
		
		Heap<Integer> heap = new Heap<>(10);
		
		heap.add(1);
		heap.add(1);
		heap.add(4);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(9);
		heap.add(3);
		heap.add(3);
		heap.add(8);
		
		assertEquals(10, heap.size());
		
		Object[] temp = heap.toArray();

		assertArrayEquals(new Integer[] { null, 1, 1, 4, 2, 3, 4, 9, 3, 3, 8 }, temp);
		
		//heap.generateDotFile("Documents/test_heap.dot");
		
		//System.out.println(heap);
	}
	
	@Test
	public void insertion_test() {
	
		Heap<Integer> heap = new Heap<>(10);
		
		heap.add(1);
		heap.add(9);
		heap.add(0);
		heap.add(8);
		heap.add(1);
		heap.add(8);
		heap.add(3);
		heap.add(4);
		heap.add(1);
		heap.add(7);
		
		assertEquals(10, heap.size());
		
		Object[] temp = heap.toArray();

		assertArrayEquals(new Integer[] { null, 0, 1, 1, 1, 7, 8, 3, 9, 4, 8 }, temp);
		
		//heap.generateDotFile("Documents/test_heap.dot");
		
		//System.out.println(heap);
	}
	
	@Test
	public void insertion_test_again() {
	
		Heap<Integer> heap = new Heap<>(10);

		heap.add(5);
		heap.add(6);
		heap.add(3);
		heap.add(7);
		heap.add(8);
		heap.add(1);

		assertEquals(6, heap.size());

		Object[] temp = heap.toArray();

		assertArrayEquals(new Integer[] { null, 1, 6, 3, 7, 8, 5 }, temp);

		 //if you want to look at your heap, uncomment this line to generate a graph file,
		
		 //heap.generateDotFile("Documents/test_heap.dot");
		
		 //or uncomment this line, run the tests:
		
		 //System.out.println(heap);
		
		 //and then paste the output of the console into:
		 //http://www.webgraphviz.com/
	}
	
	@Test
	public void intense_insertion_test() {
		
		Heap<Integer> heap = new Heap<>(10);

		heap.add(5);
		heap.add(6);
		heap.add(3);
		heap.add(7);
		heap.add(8);
		heap.add(1);
		heap.add(10);
		heap.add(15);
		heap.add(20);
		heap.add(22);
		heap.add(-1);
		heap.add(0);
		heap.add(1);
		heap.add(3);
		heap.add(65);
		heap.add(25);
		heap.add(65);
		heap.add(54);
		heap.add(43);
		heap.add(33);

		assertEquals(20, heap.size());

		Object[] temp = heap.toArray();

		assertArrayEquals(new Integer[] { null, -1, 1, 0, 7, 6, 1, 3, 15, 20, 22, 8, 5, 3, 10, 65, 25, 65, 54, 43, 33}, temp);
		
		//heap.generateDotFile("Documents/test_heap.dot");
		
		//System.out.println(heap);
	}
	
	@Test
	public void duplicate_dequeue_test() {
		
		Heap<Integer> heap = new Heap<>(10);
		
		heap.add(1);
		heap.add(1);
		heap.add(4);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(9);
		heap.add(3);
		heap.add(3);
		heap.add(8);
		
		assertEquals(10, heap.size());
		
		heap.dequeue();
		
		Object[] temp = heap.toArray();
		
		assertArrayEquals(new Integer[] {null, 1, 2, 4, 3, 3, 4, 9, 8, 3 }, temp);
		
		//heap.generateDotFile("Documents/test_heap.dot");
		
		//System.out.print(heap);
	}
	
	@Test
	public void dequeue_test() {
		
		Heap<Integer> heap = new Heap<>(10);
		
		heap.add(1);
		heap.add(9);
		heap.add(0);
		heap.add(8);
		heap.add(1);
		heap.add(8);
		heap.add(3);
		heap.add(4);
		heap.add(1);
		heap.add(7);
		
		heap.dequeue();
		
		assertEquals(9, heap.size());
		
		Object[] temp = heap.toArray();
		
		assertArrayEquals(new Integer[] {null, 1, 1, 1, 4, 7, 8, 3, 9, 8 }, temp);
		
		//heap.generateDotFile("Documents/test_heap.dot");
		
		//System.out.print(heap);
	}
	
	@Test
	public void dequeue_test_again() {
		
		Heap<Integer> heap = new Heap<>(10);

		heap.add(5);
		heap.add(6);
		heap.add(3);
		heap.add(7);
		heap.add(8);
		heap.add(1);
		
		heap.dequeue();
		
		assertEquals(5, heap.size());
		
		Object[] temp = heap.toArray();
		
		assertArrayEquals(new Integer[] {null, 3, 6, 5, 7, 8 }, temp);
		
		//heap.generateDotFile("Documents/test_heap.dot");
		
		//System.out.print(heap);
	}
	
	@Test
	public void intense_dequeue_test() {
		
		Heap<Integer> heap = new Heap<>(10);

		heap.add(5);
		heap.add(6);
		heap.add(3);
		heap.add(7);
		heap.add(8);
		heap.add(1);
		heap.add(10);
		heap.add(15);
		heap.add(20);
		heap.add(22);
		heap.add(-1);
		heap.add(0);
		heap.add(1);
		heap.add(3);
		heap.add(65);
		heap.add(25);
		heap.add(65);
		heap.add(54);
		heap.add(43);
		heap.add(33);
		
		heap.dequeue();
		
		assertEquals(19, heap.size());
		
		Object[] temp = heap.toArray();
		
		assertArrayEquals(new Integer[] {null, 0, 1, 1, 7, 6, 3, 3, 15, 20, 22, 8, 5, 33, 10, 65, 25, 65, 54, 43 }, temp);
		
		//heap.generateDotFile("Documents/test_heap.dot");
		
		//System.out.print(heap);
	}

	@Test
	public void test_lots_of_insertions_deletions_peeks() {
		
		Heap<Integer> heap = new Heap<>(10);

		final int COUNT = 1000;
		Random generator = new Random();

		// add COUNT elements to HEAP
		for(int index = 0; index < COUNT; index++) {
			int num = generator.nextInt(COUNT);
			heap.add(num);
		}
		
		assertEquals(COUNT, heap.size());

		int smallest = heap.dequeue();

		// while the heap has elements
		while(heap.size() > 0) {
			
			// remove one, make sure it is larger than smallest, update smallest
			int larger = heap.dequeue();
			if(larger < smallest){
				System.out.println("Crap");
			}
			assertTrue(larger >= smallest);
			
			smallest = larger;
		}
	}
	
	@Test
	public void heap_sort_test(){
		heap.heap_sort();
		Object[] temp = heap.toArray();
		assertArrayEquals(new Integer[] {null, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, temp);
	}
	
	@Test
	public void build_heap_from_array_TEST() {
		
		Heap<Integer> heap = new Heap<>(10);
		
		Integer[] temp = new Integer[] {null, 5, 2, 7, 1, 0, 9 };
		
		heap.build_heap_from_array(temp);
		
		Object[] thing = heap.toArray();
		
		assertArrayEquals(new Integer[] {null, 0, 1, 7, 2, 5, 9}, thing);
	}
}