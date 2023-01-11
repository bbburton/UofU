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
 * Calculates the odds of winning a Poker or Texas Hold'em Game.
 * 
 * @author Brian Burton
 * @author Lucas Idstrom
 */
public class Odds {

	static Deck deck;
	
	/**
	 * Given two cards for player one and two cards for player two. 
	 * Calculates how often player one wins.
	 * 
	 * @param h1c1 - Hand 1 Card 1
	 * @param h1c2 - Hand 1 Card 2
	 * @param h2c1 - Hand 2 Card 1
	 * @param h2c2 - Hand 2 Card 2
	 * @param samples - Number of times tested
	 * @return - percentage change of the winning hand
	 */
	static double odds_to_win(int h1c1, int h1c2, int h2c1, int h2c2, int samples){
		
		double num_beat = 0.0;
		
		for (int index = 0; index < samples; index++){
			deck = new Deck();
			
			if(Hand.get_two_random_hands(h1c1, h1c2, h2c1, h2c2)){
				num_beat++;
			}	
		}
		
		return (num_beat/samples) * 100;
	}

	/**
	 * Goes through every hand possibility and gets the rank for all of the cards
	 * 
	 * @param hand_size - number of cards per hand
	 * @return - array of percentages
	 */
	static double[] percentage_per_hand_category_exhaustive(int hand_size){
		double[] result = new double[10];
		
		Deck deck = new Deck();
		int count = 0;
		
		//For 5 card
		if(hand_size == 5){
			for(int c1 = 0; c1 < 48; c1++){
				for(int c2 = c1+1; c2 < 49; c2++){
					for(int c3 = c2+1; c3 < 50; c3++){
						for(int c4 = c3+1; c4 < 51; c4++){
							for(int c5 = c4+1; c5 < 52; c5++){
								Hand hand = new Hand();
								hand.addCard(deck.getCard(c1));
								hand.addCard(deck.getCard(c2));
								hand.addCard(deck.getCard(c3));
								hand.addCard(deck.getCard(c4));
								hand.addCard(deck.getCard(c5));
								
								count++;
								double rank = hand.get_rank();
								
								if(rank >= 10) {
									result[0]++;
								}
								else if(rank >= 9) {
									result[1]++;
								}			
								else if(rank >= 8) {
									result[2]++;
								}
								else if(rank >= 7) {
									result[3]++;
								}
								else if(rank >= 6) {
									result[4]++;
								}
								else if(rank >= 5) {
									result[5]++;
								}
								else if(rank >= 4) {
									result[6]++;
								}
								else if(rank >= 3) {
									result[7]++;
								}
								else if(rank >= 2) {
									result[8]++;
								}
								else {
									result[9]++;
								}
							}
						}
					}
				}
			}
		}
		//For 7 card
		else{
			for(int c_ = 0; c_ < 46; c_++){
				for(int c0 = c_+1; c0 < 47; c0++){
					for(int c1 = c0+1; c1 < 48; c1++){
						for(int c2 = c1+1; c2 < 49; c2++){
							for(int c3 = c2+1; c3 < 50; c3++){
								for(int c4 = c3+1; c4 < 51; c4++){
									for(int c5 = c4+1; c5 < 52; c5++){
										Hand hand = new Hand();
										hand.addCard(deck.getCard(c_));
										hand.addCard(deck.getCard(c0));
										hand.addCard(deck.getCard(c1));
										hand.addCard(deck.getCard(c2));
										hand.addCard(deck.getCard(c3));
										hand.addCard(deck.getCard(c4));
										hand.addCard(deck.getCard(c5));
										
										count++;
										double rank = hand.get_rank();
										
										if(rank >= 10) {
											result[0]++;
										}
										else if(rank >= 9) {
											result[1]++;
										}			
										else if(rank >= 8) {
											result[2]++;
										}
										else if(rank >= 7) {
											result[3]++;
										}
										else if(rank >= 6) {
											result[4]++;
										}
										else if(rank >= 5) {
											result[5]++;
										}
										else if(rank >= 4) {
											result[6]++;
										}
										else if(rank >= 3) {
											result[7]++;
										}
										else if(rank >= 2) {
											result[8]++;
										}
										else {
											result[9]++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		//Compute the percentages
		for(int index = 0; index < result.length; index++){
			result[index] = result[index] / count * 100.0;
		}
		return result;
	}

		//The Odds class must have the following method signatures
		//return the same array as above, but computed using stochastic sampling.
	static double[] percentage_per_hand_category_stochastic(int hand_size, int random_samples){
		
		double[] result = new double[10];
		
		for (int index = 0; index < random_samples; index++){
			
			deck = new Deck();
			double rank = Hand.get_random_hand(hand_size).get_rank();
			
			if(rank >= 10) {
				result[0]++;
			}
			else if(rank >= 9) {
				result[1]++;
			}			
			else if(rank >= 8) {
				result[2]++;
			}
			else if(rank >= 7) {
				result[3]++;
			}
			else if(rank >= 6) {
				result[4]++;
			}
			else if(rank >= 5) {
				result[5]++;
			}
			else if(rank >= 4) {
				result[6]++;
			}
			else if(rank >= 3) {
				result[7]++;
			}
			else if(rank >= 2) {
				result[8]++;
			}
			else {
				result[9]++;
			}
		}
		
		//Compute the percentages
		for(int index = 0; index < result.length; index++){
			result[index] = result[index] / random_samples * 100.0;
		}
		
		return result;
	}
}
