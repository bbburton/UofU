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

import java.awt.Color;
import java.awt.Graphics;

public class Flotsam extends Satellite
{

	/**
	 * Serial ID to keep the program happy.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The flotsam constructor.
	 * 
	 * @param _xPosition
	 *            - the x position of the flotsam.
	 * @param _yPosition
	 *            - the y position of the flotsam.
	 * @param _xVelocity
	 *            - the x velocity of the flotsam.
	 * @param _yVelocity
	 *            - the y velocity of the flotsam.
	 */

	public Flotsam(double _xPosition, double _yPosition, double _xVelocity, double _yVelocity)
	{

		super(_xPosition, _yPosition, _xVelocity, _yVelocity, 1000000000, Math.random() * 6378, "Flotsam");

	}

	/**
	 * Updates the display size of the satellite so it shows on screen.
	 */

	@Override
	protected void update_display_size(double radius_of_system)
	{
		this.setSize((int) ((radius * 500_000) / radius_of_system), (int) ((radius * 500_000) / radius_of_system));
	}

	/**
	 * The special paint component for the flotsam.
	 */

	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillOval(0, 0, getWidth(), getHeight());
	}
}
