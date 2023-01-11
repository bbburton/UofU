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
 * Calculates the total percentage error between our Stochastic and Exhaustive
 * methods from the Odds Class.
 * 
 * @author Brian Burton
 * @author Lucas Idstrom
 */
public class Main_Program {

	/**
	 * The Main method that calculated the total percentage error between our 
	 * Stochastic and Exhaustive Methods from the Odds Class.
	 * 
	 * @param args - the String Array arguments.
	 */
	public static void main(String[] args) {

		double[] actual_values = Odds.percentage_per_hand_category_exhaustive(7);
		
		for(int count = 1000; count < 50000; count+= 2500){
			double total_error = 0;
			for(int error = 0; error < 100; error++){
				double[] computed_values = Odds.percentage_per_hand_category_stochastic(7, count);
				
				for(int index = 0; index < computed_values.length; index++){
					
					total_error+= Math.abs(computed_values[index] - actual_values[index]);
				}
			}
			
			System.out.println(total_error/10);
		}
	}
}
