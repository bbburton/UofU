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

package cards;

/**
 * Represents the four possible suits of a playing card.
 * 
 * @author Brian Burton & Lucas Idstrom, last updated on 3/23/17
 */
public enum CardSuit {

	CLUBS, DIAMONDS, HEARTS, SPADES;

	/**
	 * Returns the value of this card suit as a formatted string.
	 */
	public String toString() {

		if (this == CLUBS) {
			return "Clubs";
		}
		if (this == DIAMONDS) {
			return "Diamonds";
		}
		if (this == HEARTS) {
			return "Hearts";
		}

		return "Spades";
	}
}