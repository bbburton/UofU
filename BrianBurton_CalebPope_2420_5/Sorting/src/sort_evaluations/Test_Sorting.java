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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_Sorting {
  private int array_size    = 30;
  private int array_element = 5;
  private ArrayList<Integer> sorted_array         = new ArrayList<Integer>();
  private ArrayList<Integer> reverse_sorted_array = new ArrayList<Integer>();
  private ArrayList<Integer> random_array         = new ArrayList<Integer>();
  private ArrayList<Integer> same_element_array   = new ArrayList<Integer>();

  @Before
  public void setup_arrays() {
    Random random = new Random();

    // Sorted array
    for (int index = 0; index < array_size; index++) {
      sorted_array.add(index);
    }

    // Reverse sorted array
    for (int index = array_size; index > 0; --index) {
      reverse_sorted_array.add(index);
    }

    // Random array
    for (int index = 0; index < array_size; index++) {
      random_array.add(random.nextInt(array_size));
    }

    // Same element array
    for (int index = 0; index < array_size; index++) {
      same_element_array.add(array_element);
    }
  }

  @After
  public void tear_down_arrays() {
    sorted_array.clear();
    reverse_sorted_array.clear();
    random_array.clear();
    same_element_array.clear();
  }

  @Test
  public void simple_test_for_sort_algorithms() {
    Quick_Sort_Naive<Integer>                quick_sort_naive                = new Quick_Sort_Naive<>();
//    Quick_Sort_Inplace_First_Pivot<Integer>  quick_sort_inplace_first_pivot  = new Quick_Sort_Inplace_First_Pivot<>();
//    Quick_Sort_Inplace_M3<Integer>           quick_sort_inplace_m3           = new Quick_Sort_Inplace_M3<>();
//    Quick_Sort_Inplace_Random_Pivot<Integer> quick_sort_inplace_random_pivot = new Quick_Sort_Inplace_Random_Pivot<>();
//    Java_Sort<Integer>                       java_sort                       = new Java_Sort<>();
//    Merge_Sort<Integer>                      merge_sort                      = new Merge_Sort<>();
    ArrayList<Sorter<Integer>> list_of_sorters = new ArrayList<>();
    list_of_sorters.add(quick_sort_naive);
//    list_of_sorters.add(quick_sort_inplace_first_pivot);
//    list_of_sorters.add(quick_sort_inplace_m3);
//    list_of_sorters.add(quick_sort_inplace_random_pivot);
//    list_of_sorters.add(java_sort);
//    list_of_sorters.add(merge_sort);

    for (Sorter<Integer> sorter : list_of_sorters) {
      sorter.sort(sorted_array);
      assertTrue(is_sorted(sorted_array));

      sorter.sort(reverse_sorted_array);
      assertTrue(is_sorted(reverse_sorted_array));

      sorter.sort(random_array);
      assertTrue(is_sorted(random_array));

      sorter.sort(same_element_array);
      assertTrue(is_sorted(same_element_array));

      tear_down_arrays();
      setup_arrays();
    }
  }

  @Test
  public void test_quick_sort_first_pivot() {
    /*
    int array_size = 10000;
    Random random = new Random();
    Quick_Sort_Inplace_First_Pivot<Integer>  quick_sort_inplace_first_pivot  = new Quick_Sort_Inplace_First_Pivot<>();

    for (int size = array_size; size < array_size * 100; size *= 10) {
      for (int index = 0; index < size; index++) {
        sorted_array.add(index);
      }

      // Reverse sorted array
      for (int index = size; index > 0; --index) {
        reverse_sorted_array.add(index);
      }

      // Random array
      for (int index = 0; index < size; index++) {
        random_array.add(random.nextInt(size));
      }

      // Same element array
      for (int index = 0; index < size; index++) {
        same_element_array.add(array_element);
      }


      quick_sort_inplace_first_pivot.sort(sorted_array);
      assertTrue(is_sorted(sorted_array));
      quick_sort_inplace_first_pivot.sort(reverse_sorted_array);
      assertTrue(is_sorted(reverse_sorted_array));
      quick_sort_inplace_first_pivot.sort(random_array);
      assertTrue(is_sorted(random_array));
      quick_sort_inplace_first_pivot.sort(same_element_array);
      assertTrue(is_sorted(same_element_array));


      sorted_array.clear();
      reverse_sorted_array.clear();
      random_array.clear();
      same_element_array.clear();
    }
    */
  }

  private static boolean is_sorted(ArrayList<Integer> array) {
    for (int index = 0; index < array.size() - 1; index++) {
      if (array.get(index) > array.get(index + 1)) { return false; }
    }

    return true;
  }

  @Test
  public void test_sorter_swap_for_integers() {
    ArrayList<Integer> swapables = new ArrayList<>();

    swapables.add(3);
    swapables.add(7);
    assertEquals(3, (int) swapables.get(0));
    assertEquals(7, (int) swapables.get(1));

    Sorter.swap(swapables, 0, 1);
    assertEquals(7, (int) swapables.get(0));
    assertEquals(3, (int) swapables.get(1));

    Sorter.swap(swapables, 1, 0);
    assertEquals(3, (int) swapables.get(0));
    assertEquals(7, (int) swapables.get(1));
  }

  @Test
  public void test_sorter_swap_for_strings() {
    ArrayList<String> swapables = new ArrayList<>();

    swapables.add("a");
    swapables.add("b");
    assertEquals("a", swapables.get(0));
    assertEquals("b", swapables.get(1));
    Sorter.swap(swapables, 0, 1);
    assertEquals("b", swapables.get(0));
    assertEquals("a", swapables.get(1));
    Sorter.swap(swapables, 1, 0);
    assertEquals("a", swapables.get(0));
    assertEquals("b", swapables.get(1));
  }
}













/*
  @Test
  public void test_Sort_Utils() {
//    Sort_Utils sort_utils = new Sort_Utils();
//    Sorter sorter = new Sorter();
    ArrayList<Sorter<Integer>> sorters = new ArrayList<Sorter<Integer>>();
    sorters.add(new Insertion_Sort());










    // test_and_time will be called from the main method
//    public void test_and_time(Sorter<Integer> sort_routine, int start_count, int count_increment, int max_count, int timeout_threshold_seconds) {
//    Sort_Utils.test_and_time(new Insertion_Sort(), 10, 1, 10, 60_000_000);
  }
*/
