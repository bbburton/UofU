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
 * Javas_Random_Generator - build a Random_Generator implemented
 * by simplying wrapping the java.util.Random class
 *
 * @author germain
 * @date   Sep 2005
 * Course  CS2020
 *
 * Class Description:
 *
 * This class uses Java's implementation of a random number
 * generator to implement the Random_Generator interface.
 * It is simply a wrapper to make sure the API for our
 * Random_Generator class meshes with the API for the
 * java.util.Random class.
 * 
 */

/**
 * This class uses Java's implementation of a random number
 * generator to implement the Random_Generator interface.
 * It is simply a wrapper to make sure the API for our
 * Random_Generator class meshes with the API for the
 * java.util.Random class.
 * 
 * @author Brian Burton
 * @author Lucas Idstrom
 */
public class Javas_Random_Generator implements Random_Generator {
  /*
   * Create a Java.util.Random object to do the actual "work"
   * of this class.
   */
  private java.util.Random random_generator_ = new java.util.Random();

  /**
   * This function returns a random integer between [0,max)
   * @param max the upper bound for the range of the random number,
   * non-inclusive.
   * @return an integer between [0, max).
   */
  public int next_int(int max) {
    return this.random_generator_.nextInt(max);
  }

  /**
   * This function sets a seed for the random number
   * generator.  A random number generator should return
   * the same sequence of numbers for the same seed.
   * @param seed the seed parameter used to initialize the
   * random number generator.
   */
  public void set_seed(long seed) {
    this.random_generator_.setSeed(seed);
  }

  /**
   * Not used for Java's Random Generator
   */
  public void set_constants(long _const1, long _const2) {
    // not needed
  }
}