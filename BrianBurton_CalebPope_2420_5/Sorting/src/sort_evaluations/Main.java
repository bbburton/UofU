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
 * FIXME: put your code to time all of your sorts here.
 *
 * Pseudocode:
 *     built a list of sorters
 *     add all of the sorts (e.g., Quick_Sort_Naive, Quick_Sort_Inplace...) to the list
 *     for each element of the list
 *        time it for a wide range of values (e.g., 10,000 -> 100,000,000)
 *     test insertion sort separately because you can't wait that long...
 *
 */
public class Main
{
  /**
   * @param args
   */
  public static void main( String[] args ) {
    ArrayList<Sorter<Integer>> list_of_sorters = new ArrayList<>();
    list_of_sorters.add(new Quick_Sort_Naive<Integer>());
//    list_of_sorters.add(new Quick_Sort_Inplace_First_Pivot<Integer>());
//    list_of_sorters.add(new Quick_Sort_Inplace_M3<Integer>());
//    list_of_sorters.add(new Quick_Sort_Inplace_Random_Pivot<Integer>());
    list_of_sorters.add(new Java_Sort<Integer>());
    list_of_sorters.add(new Merge_Sort());
    list_of_sorters.add(new Shell_Sort());
    
    Sort_Utils sort_utils = new Sort_Utils();

    for (Sorter<Integer> sorter : list_of_sorters) {
      sort_utils.test_and_time(sorter, 1000, 100000, 1000000, 20);
    }

    System.out.println("DONE");
  }
}
