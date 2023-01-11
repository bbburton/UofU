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
 * Represents a deck of playing cards.
 * 
 * @author Brian Burton
 * @author Lucas Idstrom
 */
public class Deck {

	private boolean shuffled;
	public static Card[] deck;

	/**
	 * The Deck Constructor.
	 */
	public Deck() {
		deck = new Card[52];
		 
		 for (int i = 0; i < 52; i++) {
			 deck[i] = new Card(i);
		 }
		
		shuffled = false;
	}

	/**
	 * Shuffles a deck of Cards, by setting shuffled to true and drawing a random card from the deck
	 */
	 public void shuffle() {
		 shuffled = true;
	 }

	/**
	 * Deals a Card at random.
	 * 
	 * @return - a random Card
	 */
	public Card deal() {

		//RNG
		Random_Generator random = new Javas_Random_Generator();

		if (shuffled) {
			int index = random.next_int(deck.length);
			while (deck[index] == null) {
				index = random.next_int(deck.length);
			}
			Card temp = deck[index];
			deck[index] = null;

			return temp;
		}

		int index = 0;

		while (deck[index] == null) {
			index++;
		}

		Card temp = deck[index];
		deck[index] = null;

		return temp;
	}

	/**
	 * Returns the current card in the deck.
	 * 
	 * @param index
	 *            - the next card to be dealt.
	 * @return the current card in the deck
	 */
	public Card getCard(int index) {
		if (index < 0 || index > 52) {
			throw new IndexOutOfBoundsException();
		}

		return deck[index];
	}

	/**
	 * Returns a formated String of a deck.
	 */
	public String toString() {
		String result = "";

		for (int index = 0; index < deck.length; index++) {
			result += deck[index];
			result += " ";
		}

		return result;
	}
}