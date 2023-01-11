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
 * This code is an abstract base class for all versions of quicksort.
 *
 *  Write Quick sort using a single array(list) and doing it in place
 *
 *  Instrument it to allow the changing of the Insertion Sort Switch over
 *
 */
public abstract class Quick_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> {
    //FIXME: make generic on type comparable
    //FIXME: must implement the Sorter interface

  /**
   * create a field for the insertion sort switchover level
   */

   // From the videos we learned that Quick Sort has some overhead for small numbered arrays.
   // Switching to Insertion Sort for small arrays helps make the Quick Sort algorithm seem faster.
   public int switchover = 10;

  /**
   *  Choose a Pivot (return it's value in the array)
   *  Modify array as appropriate (e.g., median of three will move smallest value to front of array)
   *
   * @param array - the array of all values (we only sort a sub piece of the array)
   * @param start - the start position in the (sub) array
   * @param end   - the end position in the (sub) array
   * @return the pivot value
   */
  protected abstract Type choose_pivot(ArrayList<Type> array, int start, int end);


  /**
   * Given an array, partition the array such that
   * all the elements lower than or equal to the pivot are on the left,
   * all the elements greater than the pivot are on the right.
   *
   * @param array   - data to sort
   * @param left    - the start index of the sub array (inclusive)
   * @param right   - the end index of the sub array (inclusive)
   *
   * @return the location of the pivot
   */
  protected int partition(ArrayList<Type> array, int left, int right) {
    int lower_index  = left;
    int higher_index = right;
    Type pivot_value = choose_pivot(array, left, right);

    while (lower_index < higher_index) {
      while (array.get(lower_index).compareTo(pivot_value) <= 0) {
        if (lower_index == higher_index) { break; }
        lower_index++;
      }
      while (array.get(higher_index).compareTo(pivot_value) > 0) {
        if (higher_index == lower_index) { break; }
        higher_index--;
      }

      if (lower_index < higher_index) {
        Sorter.swap(array, lower_index, higher_index);
      }
    }

    // Put the pivot value back in the middle.
    Sorter.swap(array, higher_index, right);

    return higher_index;
  }

  /**
   * The actual Quick Sort on an Array routine.
   *
   * Algorithm:
   *   1) choose a pivot (store in first bucket for convenience)
   *   2) o) move all elements higher than the pivot to the right side of the array
   *      o) move all elements lower than the pivot to the left side of the array
   *   3) put the pivot back between upper and lower group
   *   4) sort left side
   *   5) sort right side   (WARNING: don't sort pivot again)
   *
   * @param array - data to be sorted
   * @param start is the index of the beginning element
   * @param end is the index of the last element
   *
   *
   */
  private void quick_sort(ArrayList<Type> array, int start, int end) {
    int pivot_index;
    // Base case
    if (end - start <= this.switchover) {
      Sort_Utils.insertion_sort(array, start, end);
      return;
    }

    pivot_index = partition(array, start, end);

    // Sort the left and the right halves.
    quick_sort(array, start, pivot_index - 1);
    quick_sort(array, pivot_index + 1, end);
  }

  /**
   * the sort interface method.
   *
   * call quicksort on the array
   *
   */
  @Override
  public void sort(ArrayList<Type> array) {
    quick_sort(array, 0, array.size() - 1);
  }

  /**
   * Name the sort
   */
  @Override
  public abstract String name_of_sort();

  /**
   * The constant in this case is the insertion sort cutoff level... always greater than 3
   */
  @Override
  public void set_constant(double constant) {
    this.switchover = (int) constant;
  }

  /**
   * @return the expected complexity for quick sort
   */
  @Override
  public Complexity_Class get_expected_complexity_class() {
    return Complexity_Class.NlogN;
  }
}
