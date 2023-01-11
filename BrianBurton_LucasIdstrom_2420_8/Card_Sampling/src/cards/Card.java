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
 * A card represents a card with a value and a suit.
 * They are arranged 2-A, SPADE, DIAMOND, CLUB, HEART
 * 
 * @author Brian Burton
 * @author Lucas Idstrom
 */
public class Card implements Comparable<Card> {

	private CardSuit cardSuit;
	private CardValue cardValue;

	/**
	 * Card Constructor, using the suit and value instead of card number
	 * 
	 * @param _suit - Card Suit
	 * @param _value - Card Value
	 */
	Card(CardSuit _suit, CardValue _value) {
		cardSuit = _suit;
		cardValue = _value;
	}

	/**
	 * Card Constructor.
	 * 
	 * @param num - Card number
	 */
	Card(int num) {
		//Get card Suit
		if (num / 13 == 0) {
			cardSuit = CardSuit.SPADES;
		} else {
			if (num / 13 == 1) {
				cardSuit = CardSuit.DIAMONDS;
			} else {
				if (num / 13 == 2) {
					cardSuit = CardSuit.CLUBS;
				} else {
					cardSuit = CardSuit.HEARTS;
				}
			}
		}
		num++;
		
		//Get Card value
		if (num % 13 == 1){
			cardValue = CardValue.TWO;
		}else{
			if (num % 13 == 2){
				cardValue = CardValue.THREE;
			}else{
				if (num % 13 == 3){
					cardValue = CardValue.FOUR;
				}else{
					if (num % 13 == 4){
						cardValue = CardValue.FIVE;
					}else{
						if (num % 13 == 5){
							cardValue = CardValue.SIX;
						}else{
							if (num % 13 == 6){
								cardValue = CardValue.SEVEN;
							}else{
								if (num % 13 == 7){
									cardValue = CardValue.EIGHT;
								}else{
									if (num % 13 == 8){
										cardValue = CardValue.NINE;
									}else{
										if (num % 13 == 9){
											cardValue = CardValue.TEN;
										}else{
											if (num % 13 == 10){
												cardValue = CardValue.JACK;
											}else{
												if (num % 13 == 11){
													cardValue = CardValue.QUEEN;
												}else{
													if (num % 13 == 12){
														cardValue = CardValue.KING;
													}else{
														cardValue = CardValue.ACE;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Returns the suit of this playing card.
	 */
	public CardSuit getSuit() {
		return cardSuit;
	}

	/**
	 * Returns the value of this playing card.
	 */
	public CardValue getValue() {
		return cardValue;
	}
	
	/**
	 * Returns an integer value for a Card.
	 * 
	 * @return - integer value of Card
	 */
	public int getIntValue(){

		if (this.cardValue == CardValue.TWO) {
			return 2;
		}
		if (this.cardValue == CardValue.THREE) {
			return 3;
		}
		if (this.cardValue == CardValue.FOUR) {
			return 4;
		}
		if (this.cardValue == CardValue.FIVE) {
			return 5;
		}
		if (this.cardValue == CardValue.SIX) {
			return 6;
		}
		if (this.cardValue == CardValue.SEVEN) {
			return 7;
		}
		if (this.cardValue == CardValue.EIGHT) {
			return 8;
		}
		if (this.cardValue == CardValue.NINE) {
			return 9;
		}
		if (this.cardValue == CardValue.TEN) {
			return 10;
		}
		if (this.cardValue == CardValue.JACK) {
			return 11;
		}
		if (this.cardValue == CardValue.QUEEN) {
			return 12;
		}
		if (this.cardValue == CardValue.KING) {
			return 13;
		}
		return 14;
	}

	/**
	 * Returns a negative integer, zero, or a positive integer as this object is
	 * less than, equal to, or greater than the specified object.
	 */
	public int compareTo(Card otherCard) {

		int count = 0;

		count = this.getValue().ordinal() - otherCard.getValue().ordinal();

		if (count == 0) {
			count = this.getSuit().ordinal() - otherCard.getSuit().ordinal();
		}

		return count;
	}

	/**
	 * Returns true if the card represented by this object is equal to the other
	 * card.
	 * 
	 * @param other
	 *            - another Card
	 * @return true if this is equal to other
	 */
	public boolean equals(Object otherCard) {
		if (!(otherCard instanceof Card)) {
			return false;
		}

		Card rhs = (Card) otherCard;

		return cardSuit == rhs.cardSuit && cardValue == rhs.cardValue;
	}

	/**
	 * Returns a formatted string representation of this card.
	 */
	@Override
	public String toString() {

		return cardValue + " of " + cardSuit;
	}
}
