/*
 * 		   I pledge that the work done here was my own and that I have learned how to write
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Represents a hand of Cards in Poker or Texas Hold'em.
 * 
 * @author Brian Burton
 * @author Lucas Idstrom
 */
public class Hand {
	
	private ArrayList<Card> hand;
	private double num_rank = 0.0;
	private Rank rank;

	/**
	 * Hand Constructor.
	 */
	public Hand() {
		hand = new ArrayList<Card>();
	}

	/**
	 * Adds one Card to a players hand.
	 * 
	 * @param card -- The Card to add.
	 */
	public void addCard(Card card) {

		hand.add(card);
	}

	/**
	 * Removes one Card from a players hand if there is one to remove.
	 * 
	 * @param c -- The Card to remove.
	 */
	public void removeCard(Card card) {

		if(hand.contains(card)){
			hand.remove(card);
		}
	}

	/**
	 * Removes all of the Cards in a players hand.
	 */
	public void removeAllCards() {

		hand.removeAll(hand);
	}

	/**
	 * Determines how many cards a player has in his hand.
	 * 
	 * @returns the number of cards in a players hand.
	 */
	public int cardCount() {

		int count = 0;

		for(int i = 0; i < hand.size(); i++){
			count++;
		}

		return count;
	}

	/**
	 * Orders a players hand from greatest to smallest.
	 */
	public void sort() {

		Collections.sort(hand);
	}

	/**
	 * Returns a players card.
	 * 
	 * @param i -- the index at which you wish to get a playing card.
	 * @returns the playing card at a curtain index.
	 */
	public Card getCard(int i) {

		if(i < 0 || i > hand.size()){
			throw new IndexOutOfBoundsException();
		}

		return hand.get(i);
	}

	/**
	 * Determines the highest playing card in a players hand.
	 * 
	 * @returns the highest playing card in a players hand.
	 */
	public Card getHighestCard() {

		if(hand.size() < 0){
			throw new NoSuchElementException();
		}
		
		this.sort();
		
		return hand.get(hand.size() - 1);
	}

	/**
	 * Determines the lowest playing card in a players hand.
	 * 
	 * @returns the lowest playing card in a players hand.
	 */
	public Card getLowestCard() {

		if(hand.size() < 0){
			throw new NoSuchElementException();
		}
		
		this.sort();

		return hand.get(0);
	}
	
	/**
	 * Creates a random Hand of Cards.
	 * 
	 * @param num_cards - Number of Cards in Hand
	 */
	public static Hand get_random_hand(int num_cards){
		
		Hand random = new Hand();
		Deck deck = new Deck();
		
		deck.shuffle();
		
		//Deals the number of cards
		for(int index = 0; index < num_cards; index++) {
			random.hand.add(deck.deal());
		}
		
		return random;
	}

	//You will need a "get two random hands" method which takes in two hands and initializes 
	//each to a set of 7 cards. 5 cards should be chosen by random and placed in the last 5 
	//"spots" of each hand. Two cards should be assigned by the caller to "fill in" the first 
	//hand. Two cards should be assigned by the caller to "fill in" the second hand. You will
	//need this function when stochasticly computing the probability of one hand with a given 
	//two cards beating a random hand.
	
	/**
	 * 
	 * 
	 * @param h1c1 - Hand 1 Card 1
	 * @param h1c2 - Hand 1 Card 2
	 * @param h2c1 - Hand 2 Card 1
	 * @param h2c2 - Hand 2 Card 2
	 * @return
	 */
	public static boolean get_two_random_hands(int h1c1, int h1c2, int h2c1, int h2c2){
		Hand hand_1 = new Hand();
		Hand hand_2 = new Hand();
		
		Deck deck = new Deck();
		
		//Sets the players cards as dealt
		Deck.deck[h1c1] = null;
		Deck.deck[h1c2] = null;
		Deck.deck[h2c1] = null;
		Deck.deck[h2c2] = null;
		
		deck.shuffle();
		
		hand_1.addCard(new Card(h1c1));
		hand_1.addCard(new Card(h1c2));
		
		hand_2.addCard(new Card(h2c1));
		hand_2.addCard(new Card(h2c2));
		
		//Set the players other 5 cards
		for(int index = 0; index < 5; index++){
			Card temp = deck.deal();
			hand_1.addCard(temp);
			hand_2.addCard(temp);
		}
		
		//Get the rank of the players hands
		double hand_1_rank = hand_1.get_rank();
		double hand_2_rank = hand_2.get_rank();
		
		//Sees if hand 1 beats hand 2
		if(hand_1_rank >= hand_2_rank){
			return true;
		}
		return false;
	}
	
	/**
	 * Determines the rank of a players hand.
	 * 
	 * @return - The rank of a players hand.
	 */
	public double get_rank(){
		
		if(isRoyal()){
			rank = Rank.ROYAL_FLUSH;
			num_rank += 10;
		}
		else if(isStraightFlush()) {
			rank = Rank.STRAIGHT_FLUSH;
			num_rank += 9;
		}
		else if(isFour()) {
			rank = Rank.FOUR_KIND;
			num_rank += 8;
		}
		else if(isFullHouse()) {
			rank = Rank.FULL_HOUSE;
			num_rank += 7;
		}
		else if(isFlush()) {
			rank = Rank.FLUSH;
			num_rank += 6;
		}
		else if(isStraight()) {
			rank = Rank.STRAIGHT;
			num_rank += 5;
		}
		else if(isThree()) {
			rank = Rank.THREE_KIND;
			num_rank += 4;
		}
		else if(isTwoPair()) {
			rank = Rank.TWO_PAIR;
			num_rank += 3;
		}
		else if(isTwo()) {
			rank = Rank.ONE_PAIR;
			num_rank += 2;
		}
		else {
			highCard();
			rank = Rank.HIGH_CARD;
			num_rank += 1;
		}
		return num_rank;
	}
	
	/**
	 * Check the hand to see if it is a straight flush
	 * 
	 * @return - True if Straight Flush
	 */
	public boolean isStraightFlush(){
		
		sort();
		Hand temp = new Hand();
		int number_straight = 1;
		
		if(this.getHighestCard().getValue() == CardValue.ACE && getLowestCard().getValue() == CardValue.TWO){
			number_straight++;
		}
		
		//Finds the straight
		for(int index = 0; index < hand.size(); index++){
			temp.addCard(hand.get(index));
			if(index < hand.size()-1){
				if(hand.get(index).getValue().compareTo(hand.get(index+1).getValue()) == 0){
					continue;
				}
				
				if(hand.get(index).getValue().compareTo(hand.get(index+1).getValue()) == -1){
					number_straight++;
				}else{
					if(number_straight < 5){
						temp.removeAllCards();
						number_straight = 1;
					}
				}
			}
			if(number_straight >= 5){
				this.num_rank = hand.get(index).getIntValue() / 100.0;
			}
			
		}
		if(number_straight >= 5){
			
			//Makes sure that the straight is a flush
			if(temp.isFlush()){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns true if a hands rank is a Flush.
	 * 
	 * @return true if hand is a Flush
	 */
	public boolean isFlush(){
		int hearts = 0;
		double high_heart = 0.0;
		int spades = 0;
		double high_spade = 0.0;
		int clubs = 0;
		double high_club = 0.0;
		int diamonds = 0;
		double high_diamond = 0.0;
		
		//Finds the suits of the cards
		for(int index = 0; index < this.hand.size(); index++){
			if(hand.get(index).getSuit() == CardSuit.SPADES){
				spades++;
				if(hand.get(index).getIntValue() > high_spade){
					high_spade = hand.get(index).getIntValue();
				}
			}else{
				if(hand.get(index).getSuit() == CardSuit.HEARTS){
					hearts++;
					if(hand.get(index).getIntValue() > high_heart){
						high_heart = hand.get(index).getIntValue();
					}
				}else{
					if(hand.get(index).getSuit() == CardSuit.CLUBS){
						clubs++;
						if(hand.get(index).getIntValue() > high_club){
							high_club = hand.get(index).getIntValue();
						}
					}else{
						if(hand.get(index).getSuit() == CardSuit.DIAMONDS){
							diamonds++;
							if(hand.get(index).getIntValue() > high_diamond){
								high_diamond = hand.get(index).getIntValue();
							}
						}
					}
				}
			}
		}
			
		//Checks to see if one suit has >5
		if(hearts >= 5){
			this.num_rank = high_heart/100.0;
			return true;
		}else{
			if(spades >= 5){
				this.num_rank = high_spade/100.0;
				return true;
			}else{
				if(diamonds >= 5){
					this.num_rank = high_diamond/100.0;
					return true;
				}else{
					if(clubs >= 5){
						this.num_rank = high_club/100.0;
						return true;
					}else{
						return false;
					}
				}
			}
		}
	}
	
	/**
	 * Returns true if a hands rank is a Straight.
	 * 
	 * @return true if hand is a Straight
	 */
	public boolean isStraight(){
		
		sort();
		
		int number_straight = 1;
		
		//If ace is present, and 2 present, set number straight + 1
		if(this.getHighestCard().getValue() == CardValue.ACE && getLowestCard().getValue() == CardValue.TWO){
			number_straight++;
		}
		
		//Find longest straight
		for(int index = 0; index < hand.size()-1; index++){
			if(index < hand.size()-1){
				if(hand.get(index).getValue().compareTo(hand.get(index+1).getValue()) == 0){
					continue;
				}
				
				if(hand.get(index).getValue().compareTo(hand.get(index+1).getValue()) == -1){
					number_straight++;
				}else{
					if(number_straight < 5){
						number_straight = 1;
					}
				}
			}
			if(number_straight >= 5){
				this.num_rank = hand.get(index).getIntValue() / 100.0;
			}
			
		}
		
		//Check if straight >5
		if(number_straight >= 5){
				return true;
		}
		return false;
	}
	
	/**
	 * Returns true if a hands rank is Royal.
	 * 
	 * @return true if hand is Royal
	 */
	public boolean isRoyal(){
		boolean has_ace = false;
		boolean has_king = false;
		boolean has_queen = false;
		boolean has_jack = false;
		boolean has_ten = false;
		
		Hand temp = new Hand();
		if(isStraight() == true){
			
			//Checks for each of the royal cards
			for(int index = 0; index < hand.size(); index++){
				if(hand.get(index).getValue() == CardValue.ACE){
					has_ace = true;
					temp.addCard(hand.get(index));
				}
				if(hand.get(index).getValue() == CardValue.KING){
					has_king = true;
					temp.addCard(hand.get(index));
				}
				if(hand.get(index).getValue() == CardValue.QUEEN){
					has_queen = true;
					temp.addCard(hand.get(index));
				}
				if(hand.get(index).getValue() == CardValue.JACK){
					has_jack = true;
					temp.addCard(hand.get(index));
				}
				if(hand.get(index).getValue() == CardValue.TEN){
					has_ten = true;
					temp.addCard(hand.get(index));
				}
			}
			if(has_king && has_ace && has_queen && has_jack && has_ten){
				if(temp.isFlush()){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Returns true if a hands rank is four of a kind.
	 * 
	 * @return true if hand is four of a kind
	 */
	public boolean isFour(){
		return numKind(true, hand) == 4;
	}
	
	/**
	 * Returns true if a hands rank is three of a kind.
	 * 
	 * @return true if hand is three of a kind
	 */
	public boolean isThree(){
		return numKind(true, hand) == 3;
	}
	
	/**
	 * Returns true if a hands rank is two of a kind.
	 * 
	 * @return true if hand is two of a kind
	 */
	public boolean isTwo(){
		return numKind(true, hand) == 2;
	}
	
	/**
	 * Private helper method to determine how many Cards values in a players hand 
	 * are the same.
	 * 
	 * @return the number of Cards that have the same value
	 */
	private int numKind(boolean do_value, ArrayList<Card> temp){	
		
		int kind = 1;
		int largest = 1;
		double largest_value = 0;
		
		//Finds cards that are the same
		for(int index = 0; index < temp.size()-1; index++){
			for(int compare = index+1; compare < temp.size(); compare++){
				if(temp.get(index).getValue() == temp.get(compare).getValue()){
					kind++;
				}
			}
			if(kind > largest){
				largest = kind;
				largest_value = temp.get(index).getIntValue()/100.0;
			}
			kind = 1;
		}
		
		//Sets the high card value
		if(this.num_rank < largest_value){
			this.num_rank = largest_value;
		}
		return largest;
	}
	
	/**
	 * Returns true if a hands rank is a Full House.
	 * 
	 * @return true if hand is a Full House
	 */
	public boolean isFullHouse(){
		
		ArrayList<Card> temp = new ArrayList<>(hand);
		//Checks if 3 of a kind exists
		if(this.numKind(true, temp) < 3){
			return false;
		}
		
		CardValue current = temp.get(0).getValue();
		CardValue highest = temp.get(0).getValue();
		
		int kind = 1;
		int largest = 1;
		
		//Finds 3 of a kind
		for(int index = 0; index < temp.size()-1; index++){
			current = temp.get(index).getValue();
			for(int compare = index+1; compare < temp.size(); compare++){
				if(temp.get(index).getValue() == temp.get(compare).getValue()){
					kind++;
				}
			}
			if(kind > largest){
				largest = kind;
				kind = 1;
				highest = current;
			}
		}
		
		//Temporarily removes the three of a kind
		for(int index = 0; index < temp.size(); index++){
			if(temp.get(index).getValue() == highest){
				temp.remove(index);
				index = -1;
			}
		}
		
		//Finds the pair
		if(this.numKind(false, temp) >= 2){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if a hands rank is a Two Pair.
	 * 
	 * @return true if hand is Two Pair
	 */
	public boolean isTwoPair(){
		
		ArrayList<Card> temp = new ArrayList<>(hand);
		//Checks if hand has at least one pair
		if(this.numKind(true, temp) < 2){
			return false;
		}
		
		CardValue current = temp.get(0).getValue();
		CardValue highest = temp.get(0).getValue();
		
		int kind = 1;
		int largest = 1;
		
		//Finds first pair
		for(int index = 0; index < temp.size()-1; index++){
			current = temp.get(index).getValue();
			for(int compare = index+1; compare < temp.size(); compare++){
				if(temp.get(index).getValue() == temp.get(compare).getValue()){
					kind++;
				}
			}
			if(kind > largest){
				largest = kind;
				kind = 1;
				highest = current;
			}
		}
			
		//Temporarily removes the first pair
		for(int index = 0; index < temp.size(); index++){
			if(temp.get(index).getValue() == highest){
				temp.remove(index);
				index = -1;
			}
		}
		
		//Checks if second pair exists
		if(this.numKind(true, temp) >= 2){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns a high Card.
	 */
	public void highCard(){
		
		this.num_rank = getHighestCard().getIntValue() /100.0;
	}
	
	/**
	 * Returns the rank of the hand
	 * @return
	 */
	public Rank getRank(){
		return rank;
	}
	
	/**
	 * Returns the players hand in an ArrayList.
	 * 
	 * @return the players hand.
	 */
	public ArrayList<String> toArray() {
		
		ArrayList<String> result = new ArrayList<>();
		
		for(int index = 0; index < hand.size(); index++) {
			result.add(hand.get(index).toString());
		}
	
		return result;
	}

	/**
	 * Returns a formatted string representing the hand.
	 */
	public String toString() {

		String result = "";

		for(Card cards: hand){
			if(result.length() > 0){
				result += ", ";
			}
			result += cards.getValue() + " of " + cards.getSuit();
		}

		return result;
	}
}
