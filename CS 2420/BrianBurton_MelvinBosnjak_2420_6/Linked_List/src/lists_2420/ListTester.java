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
 * Partner name: Melvin Bosnjak
 */

package lists_2420;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class ListTester {
	
	public List_2420 new_list()
	{
		//return new Array_List_2420();
		return new Linked_List_2420();
	}
	
	//TESTING ADD FIRST METHOD
	@Test
	public void testAddFirstNull() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_last(20);
		if (test instanceof Linked_List_2420) {
			test.add_first(null);
			Assert.assertEquals(null, test.get_first());
		}
	}
	
	@Test
	public void testAddFirstEmptyNull() {
		List_2420 test = new_list();
		if (test instanceof Linked_List_2420) {
			test.add_first(null);
			Assert.assertEquals(null, test.get_first());
		}
	}
	
	@Test
	public void testAddFirstEmptyFirst() {
		List_2420 test = new_list();
		test.add_first(7);
		Assert.assertEquals(7, test.get_first());
	}
	
	@Test
	public void testAddFirstEmptyLast() {
		List_2420 test = new_list();
		test.add_first(7);
		Assert.assertEquals(7, test.get_last());
	}
	
	@Test
	public void testAddFirstcommon() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_first(5);
		Assert.assertEquals(5, test.get_first());
	}
	
	@Test
	public void testAddFirstcommon2() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_first(5);
		test.add_last(20);
		Assert.assertEquals(5, test.get_first());
	}
	
	//TESTING ADD LAST METHOD
	@Test
	public void testAddLastNull() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_last(20);
		if (test instanceof Linked_List_2420) {
			test.add_last(null);
			Assert.assertEquals(null, test.get_last());
		}
	}
	
	@Test
	public void testAddLastEmptyNull() {
		List_2420 test = new_list();
		if (test instanceof Linked_List_2420) {
			test.add_last(null);
			Assert.assertEquals(null, test.get_last());
		}
	}
	
	@Test
	public void testAddLastEmptyLast() {
		List_2420 test = new_list();
		test.add_last(7);
		Assert.assertEquals(7, test.get_last());
	}
	
	@Test
	public void testAddLastEmptyFirst() {
		List_2420 test = new_list();
		test.add_first(7);
		Assert.assertEquals(7, test.get_first());
	}
	
	@Test
	public void testAddLastcommon() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_last(5);
		test.add_first(40);
		Assert.assertEquals(5, test.get_last());
	}
	
	@Test
	public void testAddLastcommon2() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_last(5);
		test.add_last(20);
		Assert.assertEquals(20, test.get_last());
	}
	
	@Test
	public void testContainsRecursiveTrue() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_last(5);
		test.add_first(40);
		//Assert.assertEquals(test.contains_recursive(5), true);
	}
	
	@Test
	public void testContainsRecursiveFalse() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_last(5);
		test.add_first(40);
		Assert.assertEquals(test.contains_recursive(6), false);
	}
	
	@Test
	public void testContainsTrue() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_last(5);
		test.add_first(40);
		Assert.assertEquals(test.contains(5), true);
	}
	
	@Test
	public void testContainsFalse() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_last(5);
		test.add_first(40);
		Assert.assertEquals(test.contains(6), false);
	}
	
	@Test
	public void testRemoveFirst() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_first(5);
		Assert.assertEquals(5, test.remove_first());
		Assert.assertEquals(7, test.get_first());
	}
	
	@Test
	public void testRemoveLast() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_first(5);
		test.add_first(14);
		Assert.assertEquals(7, test.remove_last());
		Assert.assertEquals(5, test.get_last());
	}
	
	@Test
	public void testClear() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_first(5);
		test.add_first(14);
		test.clear();
		if (test instanceof Array_List_2420){
			ArrayList<Integer> expectedAnswer = new ArrayList<Integer>();
			for (int index = 0; index < 3; index++) {
				expectedAnswer.add(null);
			}
			Assert.assertEquals(expectedAnswer, test.to_ArrayList());
		}
	}
	
	@Test
	public void testAddMiddleEmptymiddle() {
		List_2420 test = new_list();
		test.add_middle(-1, 7);
		Assert.assertEquals(7, test.get_first());
	}

	@Test
	public void testAddmiddlecommon() {
		List_2420 test = new_list();
		test.add_first(7);
		test.add_first(5);
		test.add_first(5);
		test.add_first(5);
		test.add_middle(1, 10);
		test.remove_first();
		test.remove_first();
		Assert.assertEquals(10, test.get_first());
	}
	
	@Test
	public void testSizeEmpty() {
		List_2420 test = new_list();
		Assert.assertEquals(0, test.size());
	}
	
	@Test
	public void testSizeCommon() {
		List_2420 test = new_list();
		test.add_first(5);
		test.add_first(5);
		test.add_first(5);
		test.add_first(5);
		test.add_first(5);
		Assert.assertEquals(5, test.size());
	}
	
	@Test
	public void testReverse() {
		List_2420 test = new_list();
		List_2420 test2 = new_list();
		test.add_last(5);
		test.add_last(6);
		test.add_last(7);
		test.add_last(8);
		test.add_last(9);
		test2.add_first(5);
		test2.add_first(6);
		test2.add_first(7);
		test2.add_first(8);
		test2.add_first(9);
		test.reverse();
		Assert.assertEquals(test.to_ArrayList(), test2.to_ArrayList());
	}
	
	@Test
	public void test1ElementReverse() {
		List_2420 test = new_list();
		List_2420 test2 = new_list();
		test.add_last(5);
		test2.add_first(5);
		//test.reverse();
		Assert.assertEquals(test.to_ArrayList(), test2.to_ArrayList());
	}
	
	@Test
	public void test2ElementReverse() {
		List_2420 test = new_list();
		List_2420 test2 = new_list();
		test.add_last(5);
		test.add_last(6);
		test2.add_first(5);
		test2.add_first(6);
		test.reverse();
		Assert.assertEquals(test.to_ArrayList(), test2.to_ArrayList());
	}
	
}


