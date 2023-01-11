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

package stars;

/**
 * 
 * This is an example of how to use a thread
 * to tell a gui to take some action for animation purposes.
 * 
 * @author germain
 *
 */
public class Simulator_Loop_Thread extends Thread {

	/**
	 * A Reference back to the main GUI window so we access
	 * the circles and modify them.
	 */
	private Star_Field stars;

	/**
	 * Keep track of if we are pulsing or just idling
	 */
	public boolean idle	= false;

	/**
	 * Store a reference to the GUI that built this thread.
	 */
	public Simulator_Loop_Thread(Star_Field my_stars) {
	
		this.stars = my_stars;
	}

	/**
	 * Run the thread (Invoked by the START method called by another thread)
	 * 
	 * Randomly move every component inside of the main_window
	 */
	public void run() {
	
		while (true) {
		
			if (this.stars.move) {
			
				double start_calc_time = System.nanoTime();

				this.stars.update_positions();

				this.stars.total_calc_time += System.nanoTime() - start_calc_time;
				this.stars.gravity_calculations++;
			}
			
			else {
			
				this.stars.repaint();
				
				try {
				
					Thread.sleep(10);
				}
				
				catch (Exception e) {
				 
					/* nothing needed */
				}
			}
		}
	}
}