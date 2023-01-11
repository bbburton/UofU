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

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * A Testing class for the Card_Sampling Java Project.
 * 
 * @author Brian Burton
 * @author Lucas Idstrom
 */
public class Card_Sampling_Testing {
	
	//Card Set Up
	Card card1;
	Card card2;
	Card card3;
	Card card4;
	Card card5;
	Card card6;
	Card card7;
	Card card8;
	
	Card testSpades = new Card(0);
	Card testDiamonds = new Card(13);
	Card testClubs = new Card(26);
	Card testHearts = new Card(39);
	
	//Deck Set Up
	Deck deck;
	
	//Hand Set Up
	Hand hand;
	
	@Before
	public void setUp() {
		//Card Set Up
		card1 = new Card(CardSuit.SPADES, CardValue.FIVE);
		card2 = new Card(CardSuit.CLUBS, CardValue.ACE);
		card3 = new Card(CardSuit.DIAMONDS, CardValue.QUEEN);
		card4 = new Card(CardSuit.CLUBS, CardValue.KING);
		card5 = new Card(CardSuit.CLUBS, CardValue.JACK);
		card6 = new Card(CardSuit.DIAMONDS, CardValue.EIGHT);
		card7 = new Card(CardSuit.HEARTS, CardValue.ACE);
		card8 = new Card(CardSuit.SPADES, CardValue.NINE);
		
		//Deck Set Up
		deck = new Deck();
		
		//Hand Set Up
		hand = new Hand();
		
	}

	//Card Testing
	@Test
	public void getSuitTest() {
		assertEquals(CardSuit.SPADES, card1.getSuit());
		assertEquals(CardSuit.CLUBS, card2.getSuit());
	}
	
	@Test
	public void getValueTest() {
		assertEquals(CardValue.FIVE, card1.getValue());
		assertEquals(CardValue.ACE, card2.getValue());
	}
	
	@Test
	public void compareToTest() {
		assertEquals(-9, card1.compareTo(card2));
		assertEquals(-2, card5.compareTo(card4));
	}
	
	@Test
	public void equalsTest() {
		assertEquals(false, card1.equals(card8));
		assertEquals(true, card2.equals(card2));
	}
	
	//Hand Testing
	@Test
	public void cardCountTest() {
		hand.addCard(card1);
		hand.addCard(card2);
		hand.addCard(card3);
		
		assertEquals(3, hand.cardCount());
	}
	
	@Test
	public void toArrayTest() {
		hand.addCard(card1);
		hand.addCard(card2);
		hand.addCard(card3);
		
		ArrayList<String> answer = new ArrayList<>();
		
		answer.add(card1.toString());
		answer.add(card2.toString());
		answer.add(card3.toString());
		
		assertEquals(answer, hand.toArray());
	}
	
	@Test
	public void sortTest() {
		hand.addCard(card1);
		hand.addCard(card2);
		hand.addCard(card3);
		hand.addCard(card4);
		hand.addCard(card5);
		hand.addCard(card6);
		hand.addCard(card7);
		hand.addCard(card8);
		
		hand.sort();
		
		Hand hand2 = new Hand();
		
		hand2.addCard(card1);
		hand2.addCard(card6);
		hand2.addCard(card8);
		hand2.addCard(card5);
		hand2.addCard(card3);
		hand2.addCard(card4);
		hand2.addCard(card2);
		hand2.addCard(card7);
		
		assertEquals(hand2.toArray(), hand.toArray());
	}
	
	@Test
	public void getHighestCardTest() {
		hand.addCard(card4);
		hand.addCard(card5);
		hand.addCard(card6);
		hand.addCard(card7);
		hand.addCard(card8);
		
		assertEquals(card7, hand.getHighestCard());
	}
	
	@Test
	public void getLowestCardTest() {
		hand.addCard(card4);
		hand.addCard(card5);
		hand.addCard(card6);
		hand.addCard(card7);
		hand.addCard(card8);
		
		assertEquals(card6, hand.getLowestCard());
	}
	
	@Test
	public void test_isFlush() {
		hand.addCard(card4);
		hand.addCard(card5);
		hand.addCard(card6);
		hand.addCard(card7);
		hand.addCard(card8);
		
		assertEquals(false, hand.isFlush());
		
		hand.addCard(card2);
		hand.addCard(card3);
		hand.addCard(card4);
		hand.addCard(card5);
		hand.addCard(card6);
		
		assertEquals(true, hand.isFlush());
	}
	
	@Test
	public void test_isStraight(){
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.TWO));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.SIX));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.EIGHT));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.NINE));
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.NINE));
		hand.addCard(new Card(CardSuit.SPADES, CardValue.ACE));
		
		assertFalse(hand.isStraight());
	}
	
	@Test
	public void test_isRoyal() {
		hand.removeAllCards();
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.QUEEN));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.KING));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.TEN));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.JACK));
		
		assertTrue(hand.isRoyal());
		}
	
	@Test
	public void test_isFour() {
		hand.removeAllCards();
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.FOUR));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.FOUR));
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.FOUR));
		hand.addCard(new Card(CardSuit.SPADES, CardValue.FOUR));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.JACK));
		
		assertTrue(hand.isFour());
		//Works
		}
	
	@Test
	public void test_isThree() {
		hand.removeAllCards();
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.TWO));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.TWO));
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.TWO));
		hand.addCard(new Card(CardSuit.SPADES, CardValue.TEN));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.JACK));
		
		assertTrue(hand.isThree());
		//Works
		}
	
	@Test
	public void test_isTwo() {
		hand.removeAllCards();
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.FIVE));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.FIVE));
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(CardSuit.SPADES, CardValue.TEN));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.JACK));
		
		assertTrue(hand.isTwo());
		//Works
	}
	
	@Test
	public void test_isFullHouse() {
		hand.removeAllCards();
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.FOUR));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.FOUR));
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.SEVEN));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.EIGHT));
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.EIGHT));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.TEN));
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.TEN));
			
		assertFalse(hand.isFullHouse());
		//Works
		}
	
	@Test
	public void test_isTwoPair() {
		hand.removeAllCards();
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.EIGHT));
		hand.addCard(new Card(CardSuit.HEARTS, CardValue.EIGHT));
		hand.addCard(new Card(CardSuit.DIAMONDS, CardValue.NINE));
		hand.addCard(new Card(CardSuit.SPADES, CardValue.NINE));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.FIVE));
		
		assertTrue(hand.isTwoPair());
		//Works
	}
	
	@Test
	public void isStraightFlush() {
		hand.removeAllCards();
		hand.addCard(new Card(CardSuit.SPADES, CardValue.TWO));
		hand.addCard(new Card(CardSuit.SPADES, CardValue.THREE));
		hand.addCard(new Card(CardSuit.SPADES, CardValue.FOUR));
		hand.addCard(new Card(CardSuit.SPADES, CardValue.FIVE));
		hand.addCard(new Card(CardSuit.SPADES, CardValue.SIX));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.TEN));
		hand.addCard(new Card(CardSuit.CLUBS, CardValue.JACK));
		
		assertTrue(hand.isStraightFlush());
		//Works
		}
	
	@Test
	public void test_odds(){
		
//		double[] test = Odds.percentage_per_hand_category_exhaustive(7);
		

	}
	
	
}