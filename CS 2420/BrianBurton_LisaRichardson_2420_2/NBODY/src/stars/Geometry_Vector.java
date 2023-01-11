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

import java.awt.geom.Point2D;

/**
 * @author germain and Brian Burton.
 * 
 *         Last updated: 01/26/17
 *
 */
public class Geometry_Vector extends Point2D.Double
{

	/**
	 * The Geometry Vector constructor.
	 *
	 * @param xx
	 *            -- the x value.
	 * @param yy
	 *            -- the y value.
	 */
	public Geometry_Vector(double xx, double yy)
	{

		x = xx;
		y = yy;
	}

	/**
	 *
	 * A "copy" constructor. Creates another vector based on the given vector.
	 * 
	 * @param the_copy
	 *            -- a vector that we wish to copy.
	 */
	public Geometry_Vector(Geometry_Vector the_copy)
	{

		x = the_copy.getX();
		y = the_copy.getY();
	}

	/**
	 * Adds the x and y values of the given vector.
	 *
	 * @param vector
	 *            -- the vector to be added.
	 */
	public void add_to_me(Geometry_Vector vector)
	{

		x += vector.getX();
		y += vector.getY();
	}

	/**
	 * Subtracts the x and y values of the given vector.
	 * 
	 * @param vector
	 *            -- the vector to be subtracted.
	 */
	public void subtract_from_me(Geometry_Vector vector)
	{

		x -= vector.getX();
		y -= vector.getY();
	}

	/**
	 * Divides the x and y values by the scalar.
	 * 
	 * @param scalar
	 *            -- a number to divide the vector by. The number CANNOT be 0.
	 */
	public void divide_by(double scalar)
	{

		x /= scalar;
		y /= scalar;
	}

	/**
	 * Multiplies the x and y values by the scalar.
	 * 
	 * @param scalar
	 *            -- a number to multiply the vector by.
	 */
	public void multiply_me_by(double scalar)
	{

		x *= scalar;
		y *= scalar;
	}

	/**
	 * Calculates the magnitude of a vectors.
	 * 
	 * @returns the distance from the origin to my x,y.
	 */
	public double magnitude()
	{

		double answer = Math.sqrt(x * x + y * y);

		return answer;
	}

	/**
	 * @returns a String to the console representing a vector.
	 */
	public String toString()
	{

		return "<" + x + ", " + y + ">";
	}

	/**
	 * Takes a vector and converts it to a normal vector.
	 */
	public void normalize()
	{

		double myMag = this.magnitude();

		x /= myMag;
		y /= myMag;
	}

	/**
	 * No use for this method.
	 */
	private static final long serialVersionUID = 1L;
}
