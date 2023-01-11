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
 * @date Spring 2007
 *
 *       Code inspired by Mark Allen Weiss' code
 *
 *       this is an implementation of the Shell Sort Routine
 *
 */
public class Shell_Sort<Type extends Comparable<? super Type>> implements Sorter<Type>
{

  /**
   * the choice of "gap" for shell sort
   */
  double GAP = 2.2;

  /**
   * The name of the sort
   */
  @Override
  public String name_of_sort()
  {
    return "Shell Sort using a gap of " + this.GAP;
  }

  /**
   * For details on Shell Sort, see the Text or google
   *
   *
   * @param array
   *            the values to sort from small to high
   */
  private void shell_sort( ArrayList<Type> array )
  {
    int gap = array.size() / 2;

    while (gap > 0)
    {
      for (int i = gap; i < array.size(); i++)
      {
        Type tmp = array.get(i);
        int j = i;
        while (j >= gap && tmp.compareTo(array.get(j - gap)) < 0)
        {
          //Swap.
          Sorter.swap(array, j, j-gap);

          j -= gap;
        }
      }

      // change the gap value to a smaller value
      if (gap == 2)
      {
        gap = 1;
      }
      else
      {
        gap = (int) (gap / this.GAP);
      }
    }

  }

  /**
   * Allow the gap to be changed more time testing
   */
  @Override
  public void set_constant( double cutoff )
  {
    this.GAP = cutoff;
  }

  /**
   *  sort the array
   */
  @Override
  public void sort( ArrayList<Type> array )
  {
    shell_sort(array);
  }

  @Override
  public Complexity_Class get_expected_complexity_class()
  {
    // ????? what is the complexity class of shell sort?
    return Complexity_Class.Nsquared;
  }

}
