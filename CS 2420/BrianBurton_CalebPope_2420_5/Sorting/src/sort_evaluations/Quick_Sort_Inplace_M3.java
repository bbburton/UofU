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
import java.util.Collections;

/**
 *  use the median of three technique to compare vs random pivot selection, etc.
 */
public class Quick_Sort_Inplace_M3<Type extends Comparable<? super Type>> extends Quick_Sort<Type> {

  /**
   * Median of Three (choose the middle element position)
   *
   * WARNING: this not only chooses the pivot, but modifies the position of the three elements.
   *
   * 1) Choose 3 elements from the array (start, middle, end)
   * 2) Place the median element at array[end-1]
   * 3) Place low element at array[start]
   * 4) Place high element at array[end]
   *
   * You shouldn't call this method when the array is smaller than 3 elements
   *
   * @param array the array with all the data (we sort a sub piece of the array)
   * @param start  = index of start of array
   * @param end    = index of end of array
   * @return pivot value
   */
  @Override
  protected Type choose_pivot( ArrayList<Type> array, int start, int end ) {
    int middle_index = start + ((end + 1) - start) / 2;
    Type value_of_first  = array.get(start);
    Type value_of_middle = array.get(middle_index);
    Type value_of_last   = array.get(end);
    Type high = maximum(value_of_first, maximum(value_of_middle, value_of_last));
    Type low  = minimum(value_of_first, minimum(value_of_middle, value_of_last));
    Type pivot;

    // Make a list of everything, and factor out high and low.
    ArrayList<Type> values = new ArrayList<>();
    Collections.addAll(values, value_of_first, value_of_middle, value_of_last);
    values.remove(high);
    values.remove(low);
    pivot = values.get(0);  // should only be one left

    array.set(start, low);
    array.set(end,   high);

    // Shift everything left toward the middle, and insert pivot near the end.
    for (int index = middle_index; index < end; index++) {
      array.set(index, array.get(index + 1));
    }
    array.set(end - 1, pivot);

    return pivot;
  }


  /**
   * Name the sort
   */
  @Override
  public String name_of_sort() {
    return "Quick Sort Inplace Median of 3 (Cutoff: " + this.switchover + ")";
  }

  public Type maximum(Type left, Type right) {
    if (left.compareTo(right) > 0) { return left; }
    return right;
  }

  public Type minimum(Type left, Type right) {
    if (left.compareTo(right) < 0) { return left; }
    return right;
  }
}
