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
 * FIXME: every file should have your name (and your partner's name) on it, as
 * well as the date, a useful description, etc.
 */

public class Insertion_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> {

  /**
   * FIXME: Return the Name of the sort
   */
  @Override
  public String name_of_sort() {

    return "Insertion Sort";
  }

  /**
   * No affect on insertion sort FIXME: Simply print a debug message saying
   * this is ignored
   */
  @Override
  public void set_constant(double constant) {
    System.out.print("This is ignored.");
  }

  /**
   * Note: the actual insertion sort code should be written in the Sort_Utils
   * package call that code in this method FIXME: sort the entire array using
   * insertion sort
   */
  @Override
  public void sort(ArrayList<Type> array) {
    Sort_Utils.insertion_sort(array, 0, array.size() - 1);
  }

  /**
   * FIXME: return what you believe the Big O of insertion sort should be
   *
   * @return the expected complexity of this algorithm
   */
  @Override
  public Complexity_Class get_expected_complexity_class() {
    return Complexity_Class.Nsquared;
  }

}
