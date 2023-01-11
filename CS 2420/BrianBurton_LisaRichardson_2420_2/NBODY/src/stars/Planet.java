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

public class Planet extends Satellite
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double radius;

	/**
	 * The Planet constructor.
	 * 
	 * @param _xPosition
	 *            - the x position of the Planet.
	 * @param _yPosition
	 *            - the y position of the Planet.
	 * @param _xVelocity
	 *            - the x velocity of the Planet.
	 * @param _yVelocity
	 *            - the y velocity of the Planet.
	 * @param _mass
	 *            - the mass of the Planet.
	 * @param _radius
	 *            - the radius of the Planet.
	 * @param _name
	 *            - the name of the Planet.
	 */

	public Planet(double _xPosition, double _yPosition, double _xVelocity, double _yVelocity, double _mass,
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
		this.setSize((int) ((radius * 500_000) / radius_of_system), (int) ((radius * 500_000) / radius_of_system));
	}

}
