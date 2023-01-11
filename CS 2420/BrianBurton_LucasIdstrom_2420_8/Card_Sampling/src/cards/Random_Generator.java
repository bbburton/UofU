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
 * Random_Generator - A simple random number generator interface
 */
public interface Random_Generator {
  /**
   * This function returns a random integer between [0,max)
   * @param max the upper bound for the range of the random number,
   * non-inclusive.
   * @return an integer between [0, max).
   */
  public int next_int(int max);

  /**
   * This function sets a seed for the random number
   * generator.  A random number generator should return
   * the same sequence of numbers for the same seed.
   * @param seed the seed parameter used to initialize the
   * random number generator.
   */
  public void set_seed(long seed);

  /**
   * This function sets the two constants for use with the random
   * generator (see your textbook for more information).  
   * If your generator does not use such constants
   * then you are free to ignore the input from this function.
   */
  public void set_constants(long const1, long const2);
}