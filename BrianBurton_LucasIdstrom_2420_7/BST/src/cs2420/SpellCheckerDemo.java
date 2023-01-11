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
 * Partner name: Lucas Idstrom
 */

package cs2420;

import java.io.File;
import java.util.List;

/**
 * A small demonstration of the SpellChecker class.
 * 
 * @author Lucas Idstrom
 * @author Brian Burton
 */
public class SpellCheckerDemo {

	public static void main(String[] args) {

		SpellChecker mySC = new SpellChecker(new File("Resources/dictionary"));

		run_spell_check(mySC, "Resources/hello_world");
		run_spell_check(mySC, "Resources/good_luck");
	}

	private static void run_spell_check(SpellChecker sc, String documentFilename) {

		File doc = new File(documentFilename);
		List<String> misspelledWords = sc.spellCheck(doc);
		
		if (misspelledWords.size() == 0) {
			
			System.out.println("There are no misspelled words in file " + doc + ".");
		} 
		
		else {
			System.out.println("The misspelled words in file " + doc + " are:");
			
				for (String w : misspelledWords) {
					System.out.println("\t" + w);
				}
		}
	}
}