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
 *
 *
 */
public class Quick_Sort_Inplace_Random_Pivot<Type extends Comparable<? super Type>> extends Quick_Sort<Type> {

  /**
   * Random_Pivot
   *
   * 1) Choose an element at random in the array and use it as pivot
   * 2) Place this element at array[end]
   *
   * @param array        = the array with all the data (we sort a sub piece of the array)
   * @param start        = index of start of array
   * @param end          = index of end of array
   * @return pivot value = an element in the array that is picked as the pivot
   */
  @Override
  protected Type choose_pivot(ArrayList<Type> array, int start, int end) {
    Type pivot_value;

    int random_element = (int)(Math.random() * array.size());

    //Select a random element in the array.
    pivot_value = array.get(random_element);

    //Place the pivot at the end of the array.
    for (int index = random_element; index < end; index++) {
      array.set(index, array.get(index + 1));
    }

    array.set(end, pivot_value);

    return pivot_value;
  }

  /**
   * Name the sort
   */
  @Override
  public String name_of_sort() {
    return "Quick Sort Random Pivot (Cutoff: " + this.switchover + ")";
  }
}
