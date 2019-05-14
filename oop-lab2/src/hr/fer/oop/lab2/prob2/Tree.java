package hr.fer.oop.lab2.prob2;

class TreeNode {
	TreeNode left;
	TreeNode right;
	String data;
}

/**
 * This program writes string data to a tree, reverses that tree,
 * calculates the size of the tree and checks if a certain string 
 * exists in the ordered tree. Program is run with no arguments.
 * 
 * @author Luka
 *
 */

class TreeProgram {
	
	/**
	 * This is the program's main method.
	 * @param args string data
	 */
	
	public static void main(String[] args) {
		TreeNode node = null;
		
		node = insert(node, "Jasna");
		node = insert(node, "Ana");
		node = insert(node, "Ivana");
		node = insert(node, "Anamarija");
		node = insert(node, "Vesna");
		node = insert(node, "Kristina");
		
		System.out.println("Writing tree inorder:");
		writeTree(node);
		
		node = reverseTreeOrder(node);
		
		System.out.println("Writing reversed tree inorder:");
		writeTree(node);
		
		int size = sizeOfTree(node);
		System.out.println("Number of nodes in tree is "+size+".");
		
		boolean found = containsData(node, "Ivana");
		System.out.println("Searched element is found: "+found);
	}
	
	/**
	 * Returns true if the given string data is found in tree.
	 * The tree must be ordered.
	 * 
	 * @param treeRoot tree root
	 * @param data string data
	 * @return true if data is found, false otherwise
	 */
	
	static boolean containsData(TreeNode treeRoot, String data) {
		int resultOfComparison;
		if(treeRoot==null) {
			return false;
		} else {
			resultOfComparison=treeRoot.data.compareTo(data);
			if(resultOfComparison==0) {
				return true;
			} else {
				if(resultOfComparison>=0) {
					return containsData(treeRoot.left, data);
				} else {
					return containsData(treeRoot.right, data);
				}
			}
		}
		
	}
	
	/**
	 * Returns true if given string data is found in tree.
	 * The tree does not have to be ordered.
	 * 
	 * @param treeRoot tree root
	 * @param data string data
	 * @return true if data is found, false otherwise
	 */
	
	static boolean containsData2(TreeNode treeRoot, String data) {
		int resultOfComparison;
		if(treeRoot==null) {
			return false;
		} else {
			resultOfComparison=treeRoot.data.compareTo(data);
			if(resultOfComparison==0) {
				return true;
			} else {
				return containsData2(treeRoot.left, data) || containsData2(treeRoot.right, data);
			}
		}
	}
	
	/**
	 * Calculate number of nodes in a tree.
	 * 
	 * @param treeRoot tree root
	 * @return number of nodes found
	 */

	static int sizeOfTree(TreeNode treeRoot) {
		if(treeRoot==null) {
			return 0;
		} else {
			int left=sizeOfTree(treeRoot.left);
			int right=sizeOfTree(treeRoot.right);
			return left + right +1;
		}
		
	}
	
	/**
	 * Returns the inserted tree node containing data that was passed
	 * as an argument, sorting the tree in order. Children that are smaller 
	 * than the parent node go to the left side of the tree and children that 
	 * are bigger than the parent node go to the right side of the tree.
	 * 
	 * @param treeRoot tree root
	 * @param data string data
	 * @return new tree node containing string data
	 */
	
	static TreeNode insert(TreeNode treeRoot, String data) {
		int resultOfComparison;
		if(treeRoot==null) {
			return newTreeNode(data);
		}
		resultOfComparison=treeRoot.data.compareTo(data);
		if(resultOfComparison>=0) {
			if(treeRoot.left!=null) {
				insert(treeRoot.left, data);
			} else {
				treeRoot.left=newTreeNode(data);
			}
		} else if(resultOfComparison<0) {
			if(treeRoot.right!=null) {
				insert(treeRoot.right, data);
 			} else {
 				treeRoot.right=newTreeNode(data);
 			}
		}
		return treeRoot;
	}
	
	/**
	 * Prints the tree in order.
	 * 
	 * @param treeRoot tree root
	 */

	static void writeTree(TreeNode treeRoot) {
		if(treeRoot!=null) {
			writeTree(treeRoot.left);
			System.out.println(treeRoot.data);
			writeTree(treeRoot.right);
		}
		return;
	}
	
	/**
	 * Returns the tree root of the reversed tree where children bigger
	 * than the parent node go to the left and children smaller than the 
	 * parent node go to the right side of the tree.
	 * 
	 * @param treeRoot
	 * @return
	 */

	static TreeNode reverseTreeOrder(TreeNode treeRoot) {
		if(treeRoot!=null) {
			TreeNode tmp=treeRoot.left;
			treeRoot.left=reverseTreeOrder(treeRoot.right);
			treeRoot.right=reverseTreeOrder(tmp);
		}
		return treeRoot;
	}
	
	/**
	 * Allocates memory for the new tree node and returns that new tree node.
	 * 
	 * @param data data in the tree node
	 * @return new tree node
	 */
	
	static TreeNode newTreeNode(String data) {
		TreeNode treeRoot=new TreeNode();
		treeRoot.left=null;
		treeRoot.right=null;
		treeRoot.data=data;
		return treeRoot;
	}
}