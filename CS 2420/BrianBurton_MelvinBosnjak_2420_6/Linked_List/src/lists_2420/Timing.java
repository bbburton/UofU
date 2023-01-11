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

import java.util.Random;

/**
 * 
 * @author Brian Burton & Melvin Bosnjak
 */
public class Timing {

	/**
	 * This method test and times the middle, first, and last adds for both the
	 * Linked List and ArrayList
	 */
	public static void testAndTime() {
		Random rand = new Random();
		List_2420 testLinked = new Linked_List_2420();
		List_2420 testLinked2 = new Linked_List_2420();
		List_2420 testLinked3 = new Linked_List_2420();

		List_2420 testArray = new Array_List_2420();
		List_2420 testArray2 = new Array_List_2420();
		List_2420 testArray3 = new Array_List_2420();

		int numElements = 1000000;
		//Change this value to change how many insertions desired to test
		int numInsertions = 1000;

		// builds the Lists of numElements
		for (int index = 0; index < numElements; index++) {
			testLinked.add_last(rand.nextInt(9));
			testArray.add_last(rand.nextInt(9));
			testLinked2.add_last(rand.nextInt(9));
			testArray2.add_last(rand.nextInt(9));
			testLinked3.add_last(rand.nextInt(9));
			testArray3.add_last(rand.nextInt(9));
		}

		// times the middle insertions for linkedList
		long elapsedTime = 0;
		for (int iterations = 0; iterations < numInsertions; iterations++) {
			long startTime = System.nanoTime();
			testLinked.add_middle(rand.nextInt(testLinked.size()), rand.nextInt(9));
			long endTime = System.nanoTime();
			elapsedTime += (endTime - startTime)/100;
		}
		double averageTimeMiddleLinked = elapsedTime / numInsertions;

		// times the middle insertions for ArrayList
		long elapsedTime2 = 0;
		for (int iterations = 0; iterations < numInsertions; iterations++) {
			long startTime = System.nanoTime();
			testArray.add_middle(rand.nextInt(testLinked.size()), rand.nextInt(9));
			long endTime = System.nanoTime();
			elapsedTime2 += (endTime - startTime)/100;
		}
		double averageTimeMiddleArray = elapsedTime2 / numInsertions;

		// times the first insertions for linkedList
		long elapsedTime3 = 0;
		for (int iterations = 0; iterations < numInsertions; iterations++) {
			long startTime = System.nanoTime();
			testLinked2.add_first(rand.nextInt(9));
			long endTime = System.nanoTime();
			elapsedTime3 += (endTime - startTime)/100;
		}
		double averageTimeFirstLinked = elapsedTime3 / numInsertions;

		// times the first insertions for ArrayList
		long elapsedTime4 = 0;
		for (int iterations = 0; iterations < numInsertions; iterations++) {
			long startTime = System.nanoTime();
			testArray2.add_first(rand.nextInt(9));
			long endTime = System.nanoTime();
			elapsedTime4 += (endTime - startTime)/100;
		}
		double averageTimeFirstArray = elapsedTime4 / numInsertions;

		// times the last insertions for linkedList
		long elapsedTime5 = 0;
		for (int iterations = 0; iterations < numInsertions; iterations++) {
			long startTime = System.nanoTime();
			testLinked3.add_last(rand.nextInt(9));
			long endTime = System.nanoTime();
			elapsedTime5 += (endTime - startTime)/100;
		}
		double averageTimeLastLinked = elapsedTime5 / numInsertions;

		// times the last insertions for ArrayList
		long elapsedTime6 = 0;
		for (int iterations = 0; iterations < numInsertions; iterations++) {
			long startTime = System.nanoTime();
			testArray3.add_last(rand.nextInt(9));
			long endTime = System.nanoTime();
			elapsedTime6 += (endTime - startTime)/100;
		}
		double averageTimeLastArray = elapsedTime6 / numInsertions;

		// times the remove first for LinkedList
		long elapsedTime7 = 0;
		for (int iterations = 0; iterations < numInsertions; iterations++) {
			long startTime = System.nanoTime();
			testLinked2.remove_first();
			long endTime = System.nanoTime();
			elapsedTime7 += (endTime - startTime)/100;
		}
		double averageTimeRemoveFirstLinked = elapsedTime7 / numInsertions;

		// times the remove last for LinkedList
		long elapsedTime8 = 0;
		for (int iterations = 0; iterations < numInsertions; iterations++) {
			long startTime = System.nanoTime();
			testLinked3.remove_last();
			long endTime = System.nanoTime();
			elapsedTime8 += (endTime - startTime)/100;
		}
		double averageTimeRemoveLastLinked = elapsedTime8 / numInsertions;

		System.out.println("Timing for " + numInsertions + " insertions on a " + numElements + " length List:" + "\n");
		System.out.println(
				"First Insertions on a Linked Array:\t" + elapsedTime3 + " \tAverage Time:\t" + averageTimeFirstLinked);
		System.out.println(
				"Middle Insertions on a Linked Array:\t" + elapsedTime + "\tAverage Time:\t" + averageTimeMiddleLinked);
		System.out.println(
				"Last Insertions on a Linked Array:\t" + elapsedTime5 + " \tAverage Time:\t" + averageTimeLastLinked);
		System.out.println();
		System.out.println(
				"First Insertions on a ArrayList:\t" + elapsedTime4 + " \tAverage Time:\t" + averageTimeFirstArray);
		System.out.println(
				"Middle Insertions on a ArrayList:\t" + elapsedTime2 + "\tAverage Time:\t" + averageTimeMiddleArray);
		System.out.println(
				"Last Insertions on a ArrayList: \t" + elapsedTime6 + " \tAverage Time:\t" + averageTimeLastArray);
		System.out.println("\nTiming for " + numInsertions + " removals:\n");
		System.out.println("First Removals on a Linked List:\t" + elapsedTime7 + " \tAverage Time:\t"
				+ averageTimeRemoveFirstLinked);
		System.out.println("Last Removals on a Linked List: \t" + elapsedTime8 + "\tAverage Time:\t"
				+ averageTimeRemoveLastLinked);
	}

	public static void main(String args[]) {
		testAndTime();
	}
}
