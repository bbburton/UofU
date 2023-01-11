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
 * Partner name: Caleb Pope
 */

package sort_evaluations;

/**
 * This enum allows us to "tag" sorts with an expected performance
 * and perhaps compute different statistics based on this.
 *
 * @author germain
 *
 */
public enum Complexity_Class
{
    NlogN, Nsquared;

    /**
     * Returns the value of this complexity as a formatted string.
     */
    @Override
    public String toString() {

        if(this == NlogN) {
            return "NlogN";
        }

        return "Nsquared";
    }
}
