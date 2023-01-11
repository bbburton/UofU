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
 * Our best shot a producing a Random Generator.
 * 
 * @author Brian Burton
 * @author Lucas Idstrom
 */
public class My_Best_Random_Generator implements Random_Generator{

	long prev;
	long multiplier = 25214903917L;
	long increment = 11;
	private static final long mask = (1L << 48) - 1;
	
	@Override
	public int next_int(int max) {
		prev = (((multiplier*prev) + increment) & mask);
		return (int)(prev % max);
	}
	
	@Override
	public void set_seed(long seed) {
		prev = seed;
	}

	@Override
	public void set_constants(long multiplier, long increment) {
		this.multiplier = multiplier;
		this.increment = increment;
	}
}
