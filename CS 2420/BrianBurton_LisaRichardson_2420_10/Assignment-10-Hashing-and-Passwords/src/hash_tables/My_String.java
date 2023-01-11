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
 * Partner name: Lisa Richardson
 */

package hash_tables;

/**
 * @author H. James de St. Germain
 * @date   Spring 2007
 * 
 * a dummy wrapper for a string to allow us experiment with hash functions
 */
public class My_String implements Comparable<My_String> {
	
  public String value;
  
  /**
   * The My_String Constructor.
   * 
   * @param name - the String to be hashed.
   */
  public My_String(String name) {
	  
    this.value = name;
  }

  /**
   * Returns the hash code value field of the My_String class.
   * 
   * @return the hash code for the "value" field of the My_String
   */
//  @Override
//  public int hashCode() {
//	  
//	  int hash_value = 23245;
//	  
//	  if(hash_value == 0 && this.value.length() > 0) {
//		  
//		  char val[] = this.value.toCharArray();
//		  
//		  for(int increment = 0; increment < this.value.length(); increment+=2) {
//			  hash_value = 31 * hash_value + val[increment];
//		  }
//	  }
//	  
//      return hash_value;
//  }
  
  @Override
  public int hashCode() {
	  
      return this.value.hashCode();
  }
  
  /**
   * string value equality
   */
  @Override
  public boolean equals(Object other) {
	  
    if (other instanceof My_String) {
    	
        return this.value.equals(((My_String)other).value);
      }
    return false;
  }

  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(My_String o) {
	  
    return this.value.compareTo(o.value);
  }
  
  /**
   * Returns a String representation of the hash value.
   */
  public String toString() {
	  
    return this.value;
  }
}
