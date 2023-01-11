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
 * Partner name: Lisa Richardson
 */

package hash_tables;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import cracking.Crack;

/**
 * Hash Table testing.
 * 
 * @author Brian Burton
 * @author Lisa Richardson
 */
public class Hash_Table_Testing {
	
	//Hash_Table_Linear_Probing
//	Hash_Table_Linear_Probing<String, Integer> linear;
	Hash_Map<String, Integer> tester;

	@Before
	public void setUp() throws Exception {
		
		//2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 are prime.
		
//		linear = new Hash_Table_Linear_Probing<>(1);
//		tester = new Hash_Table_Linear_Probing<>(73);
//		tester = new Hash_Table_Quadratic_Probing<>(73);
		tester = new Hash_Table_Chaining<>(73);
	}
	
	@Test
	public void insert_and_find_test_found(){
		
		String edi = "Edi";
		
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert(edi, edi.hashCode());
		
		Integer ed_hash = edi.hashCode();
		
		assertEquals(ed_hash, tester.find("Edi"));
	}
	
	@Test
	public void find_test_not_found(){
				
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Edi", "Edi".hashCode());
		tester.insert("Skullkid", "Skullkid".hashCode());
		
		assertEquals(null, tester.find("George"));
	}
	
	@Test
	public void print_stats_test() {
		
		ArrayList<Double> answer = new ArrayList<>();
		
		answer.add(0.0);
		answer.add(3.0);
		answer.add(79.0);
		
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Edi", "Edi".hashCode());
		tester.insert("Skullkid", "Skullkid".hashCode());
		
		assertEquals(answer, tester.print_stats());
	}
	
	@Test
	public void clear_test() {
		
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Edi", "Edi".hashCode());
		tester.insert("Skullkid", "Skullkid".hashCode());
		tester.insert("Suga", "Suga".hashCode());
		tester.insert("Geno", "Geno".hashCode());
		tester.insert("Sora", "Sora".hashCode());
		tester.insert("Sheena", "Sheena".hashCode());
		tester.insert("Edgar", "Edgar".hashCode());
		tester.insert("Ghirahim", "Ghirahim".hashCode());
		
		tester.clear();
	}
	
	@Test
	public void resize_test() {
		
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Edi", "Edi".hashCode());
		tester.insert("Skullkid", "Skullkid".hashCode());
		tester.insert("Suga", "Suga".hashCode());
		tester.insert("Geno", "Geno".hashCode());
		tester.insert("Sora", "Sora".hashCode());
		tester.insert("Sheena", "Sheena".hashCode());
		tester.insert("Edgar", "Edgar".hashCode());
		tester.insert("Ghirahim", "Ghirahim".hashCode());
		tester.insert("George", "George".hashCode());
		tester.insert("Adam", "Adam".hashCode());
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Timone", "Timone".hashCode());
		tester.insert("Burton", "Burton".hashCode());
		tester.insert("Lisa", "Lisa".hashCode());
		tester.insert("Paisley", "Paisley".hashCode());
		tester.insert("Jacob", "Jacob".hashCode());
		tester.insert("Beka", "Beka".hashCode());
		tester.insert("Craig", "Craig".hashCode());
		tester.insert("Severus", "Severus".hashCode());
		tester.insert("12", "12".hashCode());
		tester.insert("ZUTTER", "ZUTTER".hashCode());
		tester.insert("Travis", "Travis".hashCode());
		tester.insert("Jessica", "Jessica".hashCode());
		tester.insert("Allan", "Allan".hashCode());
		tester.insert("Ali", "Ali".hashCode());
		tester.insert("Jeff", "Jeff".hashCode());
		tester.insert("Skyler", "Skyler".hashCode());
		tester.insert("Heather", "Heather".hashCode());
		tester.insert("Matthew", "Matthew".hashCode());
		tester.insert("Sydney", "Sydney".hashCode());
		tester.insert("Emily", "Emily".hashCode());
		tester.insert("Alyssa", "Alyssa".hashCode());
		tester.insert("Lexi", "Lexi".hashCode());
		tester.insert("Austin", "Austin".hashCode());
		tester.insert("Annie", "Annie".hashCode());
		tester.insert("Kylie", "Kylie".hashCode());
		tester.insert("Lori", "Lori".hashCode());
		tester.insert("Rachel", "Rachel".hashCode());
		tester.insert("Chris", "Chris".hashCode());
		tester.insert("Maddie", "Maddie".hashCode());
		tester.insert("Janae", "Janae".hashCode());
		
		tester.resize(tester.size() * 2);
		
		assertEquals(83, tester.capacity());
	}
	
	@Test
	public void set_resize_allowable_test() {
		
		tester.set_resize_allowable(false);
		
		ArrayList<String> names = Crack.read_file_into_array("Resources/names.txt");
		
		for(int iter = 0; iter < 79; iter++){
			tester.insert(names.get(iter), names.get(iter).hashCode());
		}
		
		System.out.println(tester.toString());
	}
}
