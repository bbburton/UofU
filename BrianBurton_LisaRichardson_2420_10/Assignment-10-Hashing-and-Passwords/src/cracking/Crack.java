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

package cracking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The Crack class allows one to discover a users password.
 * 
 * @author Brian Burton
 * @author Lisa Richardson
 */
public class Crack {
	
	static final boolean I_DID_NOT_STUDY_ALGORITHMS = false;
	static final String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	public static void main(String[] args){
		ArrayList<String> hashes = read_file_into_array("Resources/a_few_hashes.txt");
		ArrayList<String> dictionary = read_file_into_array("Resources/a_few_words.txt");
		System.out.println(brute_force_attack(hashes, 5));
//		System.out.println(dictionary_attack(dictionary, hashes));
		
	}
	
	/**
	 * This method reads words from the provided file and loads them into an ArrayList.
	 * 
	 * @param file_name - The file being read into an ArrayList.
	 * @return - The ArrayList of words.
	 */
	public static ArrayList<String> read_file_into_array(String file_name) {
		
		ArrayList<String> words = new ArrayList<>();
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file_name));
			String element = null;
			
			for(element = reader.readLine(); element != null; element = reader.readLine()){
				words.add(element);
			}
			reader.close();
			
		} catch (FileNotFoundException e)
		{
			System.out.println("File cannot be found.");
			e.printStackTrace();
		} catch (IOException e)
		{
			System.out.println("The reader cannot find a line to read.");
			e.printStackTrace();
		}
		
    	return words;
	}

	/**
	 * This method reads words from the provided file and loads them into an HashSet.
	 * 
	 * @param file_name - The file being read into a HashSet.
	 * @return - The HashSet of words.
	 */
	static public HashSet<String> read_file_into_hash_set(String file_name) {

		HashSet<String> words = new HashSet<>();
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file_name));
			String element = null;
			
			for(element = reader.readLine(); element != null; element = reader.readLine()){
				words.add(element);
			}
			reader.close();
			
		} catch (FileNotFoundException e)
		{
			System.out.println("File cannot be found.");
			e.printStackTrace();
		} catch (IOException e)
		{
			System.out.println("The reader cannot find a line to read.");
			e.printStackTrace();
		}
		
    	return words;
	}

	/**
     * 
     * This method compares (hashes of) all permutations of up to "Max_Length" characters vs
     * the given list of hashes (the password file)
     * 
     * @param hashes
     *            - hashes that you are seeing if you can find matches to
     * @param max_length
     *            - how many characters the passwords can be (in length)
     * @return the list of found passwords and their corresponding md5 hashes (e.g., [ "cat :
     *         d077f244def8a70e5ea758bd8352fcd8AB3293292CEF2342ACD32342" ])
     */
    static public ArrayList<String> brute_force_attack(Collection<String> hashes, int max_length) {
    	
    	ArrayList<String> passwords = new ArrayList<>();
    	StringBuilder builder = new StringBuilder();
    	
    	brute_force_attack(hashes, passwords, builder, 0, max_length);
    	
    	return passwords;
    }

	static public void brute_force_attack(Collection<String> hashes, ArrayList<String> successes, StringBuilder so_far, int depth, int max_length) {
		
		if(depth < max_length){
			for(int iter = 0; iter < letters.length; iter++){
				so_far.append(letters[iter]);
				brute_force_attack(hashes, successes, so_far, ++depth, max_length);
				//updating depth out of recurse
				depth--;
				String candidate = so_far.toString();
				String hash = md_hash(candidate);
				if(hashes.contains(hash)){
					candidate += ": " + hash;
					successes.add(candidate);
				}
				// GET RID OF CHAR ADDED TO STRINGBUILDER
				so_far.deleteCharAt(so_far.length()-1);
			}
		}
	}

	/**
     * compare all words in the given list (dictionary) to the password collection we wish to crack
     *
     * @param dictionary
     *            - The list of likely passwords
     * @param hashes
     *            - Collection of the hashwords we are trying to break
     * @return the list of found passwords and their corresponding md5 hashes (e.g., "cat :
     *         d077f244def8a70e5ea758bd8352fcd8AB3293292CEF2342ACD32342")
     */
    static public ArrayList<String> dictionary_attack(ArrayList<String> dictionary, Collection<String> hashes) {
    	
    	ArrayList<String> success = new ArrayList<>();
    	
    	for(int idx = 0; idx < dictionary.size() - 1; idx++){
    		String hash = md_hash(dictionary.get(idx));
    		if(hashes.contains(hash)) {
    			success.add(dictionary.get(idx) + ": " + hash);
    		}
    	}
    	
    	return success;
    }
    
    public static String md_hash(String perm){
    	
    	MessageDigest hash_generator = null;
		try
		{
			hash_generator = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e)
		{
			System.out.println("That Algorithm doesn't exsist.");
			e.printStackTrace();
		}

    	// build MD5 hash of a permutation
    	hash_generator.update(perm.toString().getBytes());
    	byte[] digest = hash_generator.digest();

    	StringBuffer hashword_hex_code = new StringBuffer();
    	for (byte b : digest)
    	{
     	   hashword_hex_code.append(String.format("%02x", b & 0xff));
    	}
    	String hash = hashword_hex_code.toString();
    	
		return hash;
    }

	/**
	 * Begin a brute for attack on the password hashfile
	 * 
	 * Use up to 8 threads
	 * 
	 * compute all permutations of strings and compare them to a list of already
	 * hashed passwords to see if there is a match
	 * 
	 * @param max_permutation_length
	 *            - how long of passwords to attempt (suggest 6 or less)
	 * @return a list of successfully cracked passwords
	 */
	public static ArrayList<ArrayList<String>> multi_thread_brute_force_attack(int max_permutation_length, Collection<String> hashes) {
		
		long start_time = System.nanoTime();
		System.out.println("starting computation");

		ArrayList<Thread> threads = new ArrayList<>();

		int count = 0;
		int AVAILABLE_THREADS = 8;

		ExecutorService thread_pool = Executors.newFixedThreadPool(AVAILABLE_THREADS);
		ArrayList<ArrayList<String>> successes = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < 26; i++) {
			successes.add(new ArrayList<>());
		}

		for (int i = 0; i < 26; i++) {
			int temp = i;

			thread_pool.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println("working on permutation " + temp);
					brute_force_attack(hashes, successes.get(temp), new StringBuilder("" + (char) ('a' + temp + 1)), 1, max_permutation_length);
				}
			});
			;
		}

		try {
			thread_pool.shutdown();
			thread_pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long total_time = System.nanoTime() - start_time;
		System.out.println("done: ( " + (total_time / 1000000000.0) + " seconds )");

		return null;
	}
}
