/**
 * @author Lina Radwan
 * Assignment 4 Cs 2210
 * This class represents the node of a binary search Tree
 */
public class TreeNode {

	private DictEntry key;
	private TreeNode left,right; 

	/**
	 *  A constructor that takes the key and sets it to as the key of the node
	 * @param key (dictEntry)
	 */
	
	public TreeNode(DictEntry key) {
		this.key=key;
		left=null;
		right=null;
		
	}
 /**
  * getters for the key
  * @return the key
  */
	public DictEntry getKey() {

		return key;
	}
	 /**
	  * setters for the key
	  * sets the key as the the one given in the parameter
	  */

	public void setKey(DictEntry key) {
		this.key = key;
	}

	 /**
	  * getters for the left key
	  * @return the TreeNode
	  */ 
	
	public TreeNode getLeft() {
		//if left is null create a new Node with null key so that when the the methods aren't used on a null treeNode
				if (left==null) {
					left = new TreeNode(null);
				}
		return left;
	}

	 /**
	  * setters for the key
	  * sets the left key as the the one given in the parameter
	  */ 
	
	public void setLeft(DictEntry left) {
		this.left = new TreeNode(left);
		
	}
	/**
	  * getters for the right key
	  * @return the TreeNode
	  */ 
	public TreeNode getRight() {
		//if right is null create a new Node with null key so that when the the methods aren't used on a null treeNode

		if (right==null){ 
			right = new TreeNode(null);
		}
		return right;
	}
	
	 /**
	  * setters for the key
	  * sets the right key as the the one given in the parameter
	  */ 
	
	public void setRight(DictEntry right) {
		this.right = new TreeNode(right);
	}
}
