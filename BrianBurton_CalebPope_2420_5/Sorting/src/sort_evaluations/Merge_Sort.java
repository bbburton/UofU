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
 *       regular  sort
 */

public class Merge_Sort<Type extends Comparable<? super Type>> implements Sorter<Type> {

  /**
   * FIXME: have a value for switching over to insertion sort
   */
   public int switchover = 10;

  /**
   * FIXME: The name of the sort
   */
  @Override
  public String name_of_sort() {
    return "Merge Sort (Cutoff: " + this.switchover + ")";
  }

  /**
   * Merge Sort
   *
   * split array in half
   * sort left
   * sort right
   * combine
   *
   *
   * @param array          the values to sort from small to high
   * @param low            the index of the starting value in the "virtual array"
   * @param high           the index of the ending value in the "virtual array"
   *
   */
  private void merge_sort(ArrayList<Type> array, ArrayList<Type> auxillary, int low, int high) {

    if(high - low == 0) {
      return;
    }

    // mid equals starting place, plus half way to the ending place.
    int mid = low + (high - low)/2;

    merge_sort(array, auxillary, low, mid);
    merge_sort(array, auxillary, mid + 1, high);

    combine(array, auxillary, low, mid, high);
  }

  /**
   * combine the values in array into the auxiliary
   *
   * @param array           - original values (the entire array)
   * @param auxillary       - spare space
   * @param low             - low,mid are the lower array
   * @param mid             - mid,high are the upper array
   * @param high
   *
   * combine the sub arrays in the _array_ parameter. use the _auxillary_ parameter for scratch space
   */

  private void combine(ArrayList<Type> array, ArrayList<Type> auxillary, int low, int mid, int high) {
    int index1 = low;
    int index2 = mid + 1;

    for (int index = low; index <= high; index++) {
      auxillary.set(index, array.get(index));
    }

        // For every index in the original array, place an item from the auxilary into it.
    for (int array_index = low; array_index <= high; array_index++) {
        // If we run out of left items, only use right ones.
        if (index1 > mid) {
          array.set(array_index, auxillary.get(index2));
          index2++;
        }
        // If we run out of right items, only use left ones.
        else if (index2 > high) {
          array.set(array_index, auxillary.get(index1));
          index1++;
        }
        // If right item comes before left item, use it.
        else if (auxillary.get(index2).compareTo(auxillary.get(index1)) < 0) {
          array.set(array_index, auxillary.get(index2));
          index2++;
        }
        // else then use index1's item
        else {
          array.set(array_index, auxillary.get(index1));
          index1++;
        }
    }
  }

  /**
   * Allow the insertion sort cut off to be changed
   */
  @Override
  public void set_constant(double cutoff) {
    this.switchover = (int) cutoff;
  }

  /**
   * sort the array
   */
  @Override
  public void sort(ArrayList<Type> array) {
    // Build the auxiliary array outside the recursive method
    ArrayList<Type> auxillary = new ArrayList<Type>();
    for (int i = 0; i < array.size(); i++) {
      auxillary.add((Type) (Integer) 0);
    }

    // call recursive sort method
    merge_sort(array, auxillary, 0, array.size() - 1);
  }

  @Override
  public Complexity_Class get_expected_complexity_class() {
    return Complexity_Class.NlogN;
  }
}
