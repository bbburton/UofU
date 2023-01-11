/**
 * Your Name: Brian Burton
 * Your UID: u1038667
 * The Date: 01/26/17
 * The Class Number: CS 2420
 * The Assignment Number: #2
 * 
 * I pledge that the work done here was my own and that I have learned how to write 
 * this program, such that I could throw it out and restart and finish it in a timely 
 * manner. I am not turning in any work that I cannot understand, describe, or recreate. 
 * I further acknowledge that I contributed substantially to all code handed in and vouch 
 * for it's authenticity. Brian Burton.
 *
 */

/**
 * @author H. James de St. Germain
 *
 * Build the GUI. Run the simulation
 *
 */

package stars;

import javax.swing.JFrame;

public class Main_Program
{

	/**
	 * THE MAIN METHOD
	 * 
	 * Create the Swing Graphics JFrame, the star field, etc. and get the ball rolling.
	 * 
	 * Creates the Simulator Thread to run the simulation
	 */

	static public void main( String[] args )
	{
		
		JFrame window = new JFrame("Star Field");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(100, 100, 1000, 1000);
		window.setLayout(null);

		Star_Field stars = new Star_Field(1000, 1000);

		window.setContentPane(stars);

		stars.setVisible(true);

		window.setJMenuBar(stars.create_up_menu_bar()); // put the menu bar in the frame

		window.setVisible(true);

		Simulator_Loop_Thread simulator = new Simulator_Loop_Thread(stars);
		simulator.start(); 
	}
}