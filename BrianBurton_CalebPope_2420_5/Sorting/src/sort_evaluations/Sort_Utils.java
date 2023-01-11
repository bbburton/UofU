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

package sort_evaluations;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * Methods for generating test data, testing sortedness, timing, etc.
 *
 *
 *
 */
public class Sort_Utils {

    // Fields used in the timer methods.
    private double start_time;
    private double end_time;

  // FIXME: create two fields to store start time and end time values

  /**
   * test to make sure the array is sorted from smallest to largest
   */
  private static boolean is_sorted(ArrayList<Integer> array) {
    for (int index = 0; index < array.size() - 1; index++) {
      if (array.get(index) > array.get(index + 1)) { return false; }
    }

    return true;
  }


  /**
   * test to (kindof) make sure two arrays contain the same values
   */
  private static boolean sum_equals(ArrayList<Integer> array1, ArrayList<Integer> array2) {
    // FIXME: write code to sum up the values in the two arrays and return
    // true if they are the same.
    // this is an approximation to the question: do the two arrays contain
    // the same
    // elements. This is used when you are concerned your sort may be
    // "clobbering" data
    int count1 = 0;
    int count2 = 0;

    for(int index1 = 0; index1 < array1.size(); index1++) {
       count1 += array1.get(index1);
    }

    for(int index2 = 0; index2 < array1.size(); index2++) {
      count2 += array2.get(index2);
    }

    if(count1 == count2) {
      return true;
    }

    return false;
  }

  /**
   * generate an array of 'size' which is already sorted
   */
  private static ArrayList<Integer> generate_sorted_array(int size) {
    // FIXME: write this code. should take less than 2 minutes to write
    // the first value in the array should be 0, and each value after that
    // one greater.

    ArrayList<Integer> sorted_array = new ArrayList<Integer>();

    for (int index = 0; index < size; index++) {
      sorted_array.add(index);
    }

    return sorted_array;
  }

  /**
   * generate an array of 'size' which is in reverse order largest to smallest
   */
  private static ArrayList<Integer> generate_reverse_sorted_array(int size) {
    // FIXME: copy and paste the above and then make the very simple changes
    // to store reverse sorted values.

    ArrayList<Integer> reverse_sorted_array = new ArrayList<Integer>();

    for (int index = size; index > -1; index--) {
      reverse_sorted_array.add(index);
    }

    return reverse_sorted_array;
  }

  /**
   * generate an array of 'size' that has random elements with values from 0
   * to max
   */
  private static ArrayList<Integer> generate_random_array(int size, int max) {
    // FIXME: write this code. should take less than 3 minutes to write. Use
    // a Random number generator

    Random random = new Random();
    ArrayList<Integer> random_array = new ArrayList<Integer>();

    for (int index = 0; index < size; index++) {
      random_array.add(random.nextInt(max));
    }

    return random_array;
  }

  /**
   * generate an array of 'size' that has all the same element
   */
  private static ArrayList<Integer> generate_same_array(int size, int element) {
    // FIXME: write this code. should generate an array of SIZE elements
    // each of value ELEMENT

    ArrayList<Integer> element_array = new ArrayList<Integer>();

    for (int index = 0; index < size; index++) {
      element_array.add(element);
    }

    return element_array;
  }

  /**
   * This function will call the implemented sorted routines and time them. It
   * will check already sorted arrays, reverse sorted arrays, random value
   * arrays, and the same value arrays
   *
   *
   * @param sort_routine
   *            - the routine to test
   * @param start_count
   *            - how many elements to put in the array
   * @param count_increment
   *            - how many elements to go up for each iteration
   * @param max_count
   *            - when to stop testing
   * @param timeout_threshold_seconds
   *            - if the last iteration of the test took more time than this
   *            number, don't do any more tests in this category.
   *
   *            Note: the timeout_threshold_seconds probably won't come into
   *            consideration until you start timing really big array sets
   */
  public void test_and_time(Sorter<Integer> sort_routine, int start_count, int count_increment, int max_count, int timeout_threshold_seconds) {
    System.out.printf("Sorting Using %s:\n", sort_routine.name_of_sort());
    System.out.printf("Time Analysis for \n");
    System.out.printf("\t\t\t\t\t\tRandom * 10e6 vs.\tWorst Case * 10e6 vs. \n");
    System.out.printf("   count\tsorted\treverse\trandom\tsame\t%10s\t%10s\n",
        sort_routine.get_expected_complexity_class().toString(),
        sort_routine.get_expected_complexity_class().toString());
    System.out.flush();

    double time_sorted = -1;
    double time_reverse_sorted = -1;
    double time_random = -1;
    double time_all_same = -1;

    boolean do_sorted  = true;
    boolean do_reverse = true;
    boolean do_random  = true;
    boolean do_same    = true;

    for (int count = start_count; count <= max_count; count += count_increment) {

      ArrayList<Integer> test = null;

      ///////////////////////////////////////////////////
      // TEST All Same
      if (do_same) {

        try {
          test = generate_same_array(count, count);

          timer_on();
          sort_routine.sort(test);
          timer_off();
          time_all_same = get_time();

          if (!is_sorted(test)) {
            System.out.printf("Error encountered. Array not sorted!\n");
            return;
          }

          if (time_all_same > timeout_threshold_seconds) {
            System.out.println("Sorting all same array taking too long");
            do_same = false;
            time_all_same = -1;
          }

        } catch (java.lang.OutOfMemoryError error) {
          System.out.println(" Sorting the same numbers caused an out of memory error");
          do_same = false;
          time_all_same = -1;
        } catch (java.lang.StackOverflowError error) {
          System.out.println(
              " Stack Overflow - Probably sorting the same numbers caused an stack overflow error");
          do_same = false;
          time_all_same = -1;
        }
      }

      ///////////////////////////////////////////////////
      // FIXME: TEST RANDOM
      if (do_random) {

        try {
          test = generate_random_array(count, count);

          timer_on();
          sort_routine.sort(test);
          timer_off();
          time_random = get_time();

          if (!is_sorted(test)) {
            System.out.printf("Error encountered. Array not sorted!\n");
            return;
          }

          if (time_random > timeout_threshold_seconds) {
            System.out.println("Sorting all same array taking too long");
            do_same = false;
            time_random = -1;
          }

        } catch (java.lang.OutOfMemoryError error) {
          System.out.println(" Sorting the same numbers caused an out of memory error");
          do_random = false;
          time_random = -1;
        } catch (java.lang.StackOverflowError error) {
          System.out.println(
              " Stack Overflow - Probably sorting the same numbers caused an stack overflow error");
          do_random = false;
          time_random = -1;
        }
      }

      /////////////////////////////////////////////////////////
      // FIXME: TEST already SORTED
      if (do_sorted) {

        try {
          test = generate_sorted_array(count);

          timer_on();
          sort_routine.sort(test);
          timer_off();
          time_sorted = get_time();

          if (!is_sorted(test)) {
            System.out.printf("Error encountered. Array not sorted!\n");
            return;
          }

          if (time_sorted > timeout_threshold_seconds) {
            System.out.println("Sorting all same array taking too long");
            do_sorted = false;
            time_sorted = -1;
          }

        } catch (java.lang.OutOfMemoryError error) {
          System.out.println(" Sorting the same numbers caused an out of memory error");
          do_sorted = false;
          time_sorted = -1;
        } catch (java.lang.StackOverflowError error) {
          System.out.println(
              " Stack Overflow - Probably sorting the same numbers caused an stack overflow error");
          do_sorted = false;
          time_sorted = -1;
        }
      }

      ////////////////////////////////////////////////////////////////
      // FIXME: TEST REVERSE SORTED
      if (do_reverse) {

        try {
          test = generate_reverse_sorted_array(count);

          timer_on();
          sort_routine.sort(test);
          timer_off();
          time_reverse_sorted = get_time();

          if (!is_sorted(test)) {
            System.out.printf("Error encountered. Array not sorted!\n");
            return;
          }

          if (time_random > timeout_threshold_seconds) {
            System.out.println("Sorting all same array taking too long");
            do_reverse = false;
            time_reverse_sorted = -1;
          }

        } catch (java.lang.OutOfMemoryError error) {
          System.out.println(" Sorting the same numbers caused an out of memory error");
          do_reverse = false;
          time_reverse_sorted = -1;
        } catch (java.lang.StackOverflowError error) {
          System.out.println(
              " Stack Overflow - Probably sorting the same numbers caused an stack overflow error");
          do_reverse = false;
          time_reverse_sorted = -1;
        }
      }

      //////////////////////////////////////////////////////////////////////
      // Print out timing information!

      System.out.printf("%8d\t%s\t%s\t%s\t%s\t", count,
          time_sorted < 0 ?         "     " : String.format("%5.3f", time_sorted),
          time_reverse_sorted < 0 ? "     " : String.format("%5.3f", time_reverse_sorted),
          time_random < 0 ?         "     " : String.format("%5.3f", time_random),
          time_all_same < 0 ?       "     " : String.format("%5.3f", time_all_same));

      double time_worst = Math.max(time_random,
          Math.max(time_sorted, Math.max(time_reverse_sorted, time_all_same)));

      if (sort_routine.get_expected_complexity_class() == Complexity_Class.NlogN) {
          // divide time by N Log N
        double time_random_divided_by_N_log_N = (double) time_random / ((double) count * (Math.log(count) / Math.log(2)));
        double time_worst_divided_by_N_log_N  = (double) time_worst  / ((double) count * (Math.log(count) / Math.log(2)));

        System.out.printf("%f\t%f\n", time_random_divided_by_N_log_N, time_worst_divided_by_N_log_N);
      } else if (sort_routine.get_expected_complexity_class() == Complexity_Class.Nsquared) {
          // divide time by N squared
        double time_random_divided_by_N_squared = (double) time_random / (double) (count * count);
        double time_worst_divided_by_N_squared  = (double) time_worst  / (double) (count * count);

        System.out.printf("%f\t%f\n", time_random_divided_by_N_squared, time_random_divided_by_N_squared);
      }

      System.out.flush();
    }

  }

  /**
   * Insertion Sort.
   *
   * FIXME: write an inplace insertion sort that works on the VIRTUAL array
   * defined by the actual array from [start --> end]
   */
  public static <Type extends Comparable<? super Type>> void insertion_sort(ArrayList<Type> array, int start, int end) {
        // insert our insertionSort code from last time, and adjust as needed
  // public static <T> void insertionSort(T[] array, Comparator<? super T> alpha_comparator) {
    int  tmp_index;
    Type moving_var;

    for (int index = start + 1; index <= end; index++) {
      // tmp_index allows us to follow the item down the array as it searches for it's place.
      tmp_index = index;
      moving_var = array.get(tmp_index);
      // In other words, while the item needs shifted to the left.
      while (( (int) array.get(tmp_index - 1) - (int) moving_var )  >  0) {
        // Swap item to the left.
        array.set(tmp_index,     array.get(tmp_index - 1));
        array.set(tmp_index - 1, moving_var);

        // Follow the item down the array as it searches for it's place.
        tmp_index--;
        // Stop if we hit the end.
        if (tmp_index < 1) { break; }
      }
    }
    // }

  }

  /**
   * test the sorting routines with RANDOM data but changing the "constant"
   * for the sort every time. This is useful to see what the best GAP for
   * shell sort is or the best Insertion Sort Cutoff for Quick Sort is
   *
   *
   * @param sort_routine
   *            - which routine to test for various "constant" changes
   * @param start_value
   *            - start value of "constant"
   * @param increment
   *            - increment value of "constant"
   * @param end_value
   *            - final value of "constant"
   * @param items_to_sort
   *            - number of items to sort on
   */
  public void time_constant_change(Sorter<Integer> sort_routine, double start_value, double increment,
      double end_value, int items_to_sort) {

    final int total = items_to_sort;

    System.out.printf("Sorting Using %s: (Cutoff, Time (Seconds), Constant(*10e6) (of %d elements)\n",
        sort_routine.name_of_sort(), total);

    double time_random = 0;

    ArrayList<Integer> sample = new ArrayList<Integer>(items_to_sort);

    System.out.printf("Insertion Sort Cutoff\tTotal Time\t Constant = time/NLogN\n");

    for (double cutoff = start_value; cutoff <= end_value; cutoff += increment) {
      // Slow things down so we can get other work (like debugging)
      // done
      /*
       * try { Thread.sleep(10); } catch (InterruptedException exception)
       * { // should never happen... exception.printStackTrace(); }
       */
      ///////////////////////////////////////////////////
      // TEST RANDOM
      //
      // Make X runs over random data and average time

      time_random = 0;
      sort_routine.set_constant(cutoff);
      int runs = 10;

      for (int run = 0; run < runs; run++) {

        sample = generate_random_array(total, total);

        timer_on();
        sort_routine.sort(sample);
        timer_off();

        if (!is_sorted(sample)) {
          System.out.printf("Error encountered Sorting an array of random numbers. Array not sorted!\n");
          time_random = -1;
          return;
        }

        time_random += get_time();
      }

      time_random /= runs;

      System.out.printf("%8d\t%9.4f\t%10.4f\n", (int) cutoff, time_random,
          1000000.0 * time_random / (total * (Math.log(total) / Math.log(Math.E))));

      System.out.flush();
    }
  }

  /**
   * start the timer
   */
  private void timer_on() {
    this.start_time = System.nanoTime();
  }

  /**
   * turn off the timer
   */
  private void timer_off() {
    this.end_time = System.nanoTime();
  }

  /**
   * get the time in seconds between on and off.
   */
  private double get_time() {
    return (this.end_time - this.start_time) / 1_000_000_000;
  }

}
