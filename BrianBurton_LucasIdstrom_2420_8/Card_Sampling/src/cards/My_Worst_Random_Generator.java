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
 * Implementation of a generator that produces a very
 * non-random sequence of numbers.
 * @author Erin Parker
 * @date February 23, 2007
 */

/**
 * Produces a very non-random sequence of numbers.
 * 
 * @author Brian Burton
 * @author Lucas Idstrom
 */
public class My_Worst_Random_Generator implements Random_Generator {

  long seed;
  long const1;
  long const2;

  public int next_int(int max) {
    return 1;
  }

  public void set_seed(long _seed) {
    this.seed = _seed;
  }

  public void set_constants(long _const1, long _const2) {
    this.const1 = _const1;
    this.const2 = _const2;
  }
}