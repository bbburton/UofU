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

public class Star extends Satellite
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double radius;
	private boolean super_nova = false;

	/**
	 * 
	 * @param _xPosition
	 *            - the x position of the Star.
	 * @param _yPosition
	 *            - the y position of the Star.
	 * @param _xVelocity
	 *            - the x velocity of the Star.
	 * @param _yVelocity
	 *            - the y velocity of the Star.
	 * @param _mass
	 *            - the mass of the Star.
	 * @param _radius
	 *            - the radius of the Star;
	 * @param _name
	 *            - the name of the Star;
	 */

	public Star(double _xPosition, double _yPosition, double _xVelocity, double _yVelocity, double _mass,
			double _radius, String _name)
	{

		super(_xPosition, _yPosition, _xVelocity, _yVelocity, _mass, _radius, _name);
		this.radius = _radius;
	}

	/**
	 * Updates the display size of the satellite so it shows on screen.
	 */

	@Override
	protected void update_display_size(double radius_of_system)
	{
		this.setSize((int) (radius * 75_000 / radius_of_system), (int) (radius * 75_000 / radius_of_system));
	}

	/**
	 * Supposed to draw differently if super_nova is true.
	 */
	
	@Override
	public void paintComponent(Graphics g)
	{
		if (super_nova == true)
		{
			g.setColor(Color.red);
			g.fillOval(0, 0, getWidth() * 10, getHeight() * 10);
		} else
		{
			g.fillOval(0, 0, getWidth(), getHeight());
		}
	}

	/**
	 * Supposed to make the sun swell.
	 * 
	 * @param system_radius
	 */

	public void super_nova()
	{
		super_nova = true;
	}

}
