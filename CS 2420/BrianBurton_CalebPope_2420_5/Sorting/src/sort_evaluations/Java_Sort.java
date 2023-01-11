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
import java.util.Comparator;

/**
 *         FIXME: this code wraps JAVAs arraylist built in sort to see
 *         how it compares with our sorts
 *
 */
public class Java_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> {

  /**
   * FIXME: implement this to sort the array using the arraylist built in sort and natural order comparator
   */
  @Override
  public void sort(ArrayList<Type> array) {
    array.sort(new Comparator<Type>() {
      @Override
      public int compare(Type left, Type right) {
        return left.compareTo(right);
      }
    });

  }

  /**
   * FIXME: return the Name the sort (in this case Java's sort)
   */
  @Override
  public String name_of_sort() {
      return "Java's built in sort";
  }

  /**
   * FIXME: Nothing to do here. Print a message that you can't modify Java's sort algorithm
   */
  @Override
  public void set_constant(double constant) {
    System.out.println("INFO: Nothing to do: method 'set_constant' called on Java_Sort,"
      + "but we can't change java's sort method");
  }


  /**
   * FIXME: hypothesize what you think javas sort BIG O should be.
   * @return the expected complexity for javas sorts
   */
  @Override
  public Complexity_Class get_expected_complexity_class() {
    // TODO is this right?
    return Complexity_Class.Nsquared;
  }
}
