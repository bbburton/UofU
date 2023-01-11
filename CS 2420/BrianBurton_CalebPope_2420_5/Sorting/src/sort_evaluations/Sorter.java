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

/**
 * @author H. James de St. Germain
 * @date Spring 2017
 *
 *       This interface allows a sort routine to be tested by turning the sort
 *       into a "function". All the sorts of interest must be created to follow
 *       the functions required by this interface.
 *
 */
public interface Sorter<Type extends Comparable<? super Type>> {
  /**
   * put the array list in order from smallest to largest
   *
   * @param array
   *            - an array of comparable objects
   */
  public abstract void sort(ArrayList<Type> array);

  /**
   * for testing purposes, get the name of the sort
   *
   * @return the name of the sort
   */
  public abstract String name_of_sort();

  /**
   * If you want to change the behavior of the sort, such as for quicksort,
   * changing, the insertion sort cutoff or for shell sort, the gap size.
   *
   * @param constant
   *            - any one constant in an algorithm
   */
  public default void set_constant(double constant) {
    // the default case is to do nothing....
  }

  /**
   * @return the expected complexity class of the sort
   *
   *         For example, NLogN, NSquared, etc.
   */
  public abstract Complexity_Class get_expected_complexity_class();

  /**
   * FIXME: write a Swap Routine that will swap the given two values in the
   * array In in of your code where you swap things, use this swap method.
   */
  public static <Type> void swap(ArrayList<Type> array, int from, int to) {
    Type temp;

    temp = array.get(from);
    array.set(from, array.get(to));
    array.set(to,   temp);
  }
}
