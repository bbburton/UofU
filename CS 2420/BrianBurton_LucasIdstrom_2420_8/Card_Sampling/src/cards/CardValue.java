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
 * Represents the thirteen possible values of a playing card.
 * 
 * @author Brian Burton & Lucas Idstrom, last updated on 3/23/17
 *
 */
public enum CardValue {

	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

	/**
	 * Returns the value of this card value as a formatted string.
	 */
	public String toString() {

		if (this == TWO) {
			return "2";
		}
		if (this == THREE) {
			return "3";
		}
		if (this == FOUR) {
			return "4";
		}
		if (this == FIVE) {
			return "5";
		}
		if (this == SIX) {
			return "6";
		}
		if (this == SEVEN) {
			return "7";
		}
		if (this == EIGHT) {
			return "8";
		}
		if (this == NINE) {
			return "9";
		}
		if (this == TEN) {
			return "10";
		}
		if (this == JACK) {
			return "Jack";
		}
		if (this == QUEEN) {
			return "Queen";
		}
		if (this == KING) {
			return "King";
		}
		return "Ace";
	}
}