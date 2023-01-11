/*
 * I pledge that the work done here was my own and that I have learned how to write
 *         this program (such that I could throw it out and restart and finish it in a timely
 *         manner).  I am not turning in any work that I cannot understand, describe, or
 *         recreate.  Any sources (e.g., web sites) other than the lecture that I used to
 *         help write the code are cited in my work.  When working with a partner, I have
 *         contributed an equal share and understand all the submitted work.  Further, I have
 *         helped write all the code assigned as pair-programming and reviewed all code that
 *         was written separately.
 *                      -- Brian Burton, Lisa Richardson
 */

/*
 * My name: Brian Burton
 * Partner name: Lisa Richardson
 */

package cs2420;

/**
 * Represents a single node of a Huffman Tree.
 */
class Node implements Comparable<Node> {

	private String symbol;
	private Node left;
	private Node right;
	private Node parent;
	private int frequency;

	/**
	 * Constructs a leaf node.
	 * 
	 * @param sym
	 *            - the symbol
	 * @param frequency
	 *            - how often the symbol occurs
	 */
	public Node(String sym, int frequency) {
		
		this.symbol = sym;
		this.frequency = frequency;
	}

	/**
	 * Constructs an internal node. Note that a non-leaf/internal node has a
	 * weight (sum of the weights of its children) but no character.
	 * 
	 * @param left
	 *            - left child of the new node
	 * @param right
	 *            - right child of the new node
	 */
	public Node(String sym, Node left, Node right) {
		
		this.symbol = sym;
		this.left = left;
		this.right = right;
		this.frequency = left.frequency + right.frequency;
	}

	/**
	 * @return the symbol associated with the node
	 */
	public String get_symbol() {
		
		return this.symbol;
	}

	/**
	 * concisely print the Node
	 */
	public String toString() {
		
		String result = "";
		
		result += "Node Symbol: " + this.symbol +" " +  "Frequency: " + this.frequency;
		
		return result;
	}

	/**
	 * @return true if a leaf (valid symbol) node
	 */
	boolean leaf() {
		
		if(this.left == null && this.right == null) {
			
			return true;
		}
		
		return false;
	}

	/**
	 * Setter for parent node
	 * 
	 * @param parent
	 */
	public void set_parent(Node parent) { 
		
		this.parent = parent;
	}

	/**
	 * @return the parent of this node
	 */
	public Node get_parent() { 
		
		return this.parent;
	}

	/**
	 * @return the left child of the parent of this node
	 */
	public Node parents_left() { 
		
		if(this.parent == null) {
			
			return this.left;
		}
		
		return this.parent.left;
	}

	/**
	 * @return the weight (frequency of appearance) associated with this node
	 */
	public int get_frequency() {
		
		return this.frequency;
	}

	/**
	 * add one to the frequency field
	 */
	public void increment_frequency() { 
		
		this.frequency++;
	}

	/**
	 * WARNING: only call this method on the "root" of the tree
	 * 
	 * Returns the symbol encoded by a bit string, by traversing the path from
	 * the root of the tree to the leaf node containing the character. A '0' in
	 * the bit string causes the path to follow a left child, and a '1' in the
	 * bit string causes the path to follow a right child.
	 * 
	 * @param code
	 *            - bit string to be decoded, such as "01010001"
	 * @return return null if the bit string does not lead to a symbol,
	 *         otherwise return the symbol string
	 */
	String get_symbol(String code) { 
		
		Node current_node = this;
		
		for(int index = 0; index < code.length(); index++) {
			
			char ch = code.charAt(index);
			
			if(ch == '0') {
				
				if(current_node.left == null) {
					
					return null;
				}
				
				current_node = current_node.left;
			}
			else {
				
				if(current_node.right == null) {
					
					return null;
				}
				
				current_node = current_node.right;
			}
		}
		if(!current_node.leaf()){
			return null;
		}
		return current_node.symbol;
	}

	/**
	 * @return the left most child of this node
	 */
	//Was private. Set to public for testing purposes.
	public Node left_most_child() { 
		
		if(this.left != null) {
			left.left_most_child();
		}
		
		return this;
	}

	/**
	 * Compare to Huffman nodes, using frequencies.
	 * 
	 * @param rhs
	 *            - right-hand side node
	 * @return a value > 0 if this node is larger than rhs, a value < 0 if this
	 *         node is smaller than rhs, 0 if the nodes are equal
	 * 
	 *         larger means node occurs more often (has a higher frequency).
	 *         when tied, compare the symbol of this node's left most child vs
	 *         the symbol of rhs.left_most_child
	 */
	@Override
	public int compareTo(Node rhs) { 
		int result = this.frequency - rhs.frequency;
		
		if(result == 0) {
			if(this.get_symbol().startsWith("NO_") || rhs.get_symbol().startsWith("NO_")) {
				result = -1;
//			if((this.get_symbol().startsWith("NO_") && 
//					!rhs.get_symbol().startsWith("NO_"))) {
//				result = 1;
//			} else if((rhs.get_symbol().startsWith("NO_") && 
//					!this.get_symbol().startsWith("NO_"))) {
//				result = -1;
			} else {
				result = this.get_symbol().compareTo(rhs.get_symbol());
			}
		}
		
		return result;
	}

	// ------------------ DOT description methods and data
	// -------------------------------

	static int null_count = 0;

	/**
	 * write the edges in the graph in the form used by the DOT language
	 * 
	 * @param print_line
	 *            - the file to print to
	 * @param null_count
	 *            - to keep track of nice "null" edges, we need this as each one
	 *            has to have a new name
	 */
	public String createDot() {
		
		String result = "";

		null_count = 0;

		result += "digraph huffman_tree{\n";

		result += "\thuffman_root -> " + this.symbol + ";\n";
		result += "\thuffman_root [shape=\"none\"];\n";

		// recursively build the dot file
		result += write_dot_helper();

		// create all the null values so they look goodn
		for (int i = 0; i < null_count; i++) {
			result += "null" + i + " [shape=point];\n";
		}

		result += "}";

		return result;
	}

	/**
	 * create the DOT syntax for a graph
	 * 
	 * @param print_line
	 */
	public String write_dot_helper() {
		
		String result = "";

		String label = Utility.printable_symbol(this.symbol);

		if (this.leaf()) {
			result += "\t" + label + " [label=\"" + label + "\\n" + this.frequency + "\"];\n";

			return result;
		}

		result += "\t" + label + " [label=\"" + label + "\\n" + this.frequency + "\"];\n";

		if (this.left == null || this.right == null) {
			System.out.println("ERROR");
			throw new RuntimeException(" nodes must eith have 0 or 2 children");
		}
		
		String left_label = Utility.printable_symbol(left.symbol);
		String right_label = Utility.printable_symbol(right.symbol);

		result += "\t" + label + "-> " + left_label + "[ label=0 ];\n";
		result += "\t" + label + "-> " + right_label + "[ label=1 ];\n";
		result += this.left.write_dot_helper();
		result += this.right.write_dot_helper();

		return result;
	}
}