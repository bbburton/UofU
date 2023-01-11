package stars;

public class Black_Hole extends Satellite
{

	/**
	 * Serial ID to make program happy.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The black hole constructor.
	 * 
	 * @param _xPosition
	 *            - the x position of the black hole.
	 * @param _yPosition
	 *            - the y position of the black hole.
	 * @param _mass
	 *            - the mass of the black hole.
	 * @param _name
	 *            - the name of the black hole.
	 */

	public Black_Hole(double _xPosition, double _yPosition, double _mass, String _name)
	{
		super(_xPosition, _yPosition, 0, 0, _mass, 500000, _name);
	}

	/**
	 * Updates the display size of the satellite so it shows on screen.
	 */

	@Override
	protected void update_display_size(double radius_of_system)
	{
		// You can't see black holes.....

	}

}
