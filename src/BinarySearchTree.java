/**
 * @author Lina Radwan
 * Assignment 4 CS 2210
 * 
 * This class implements an ordered dictionary using a binary search tree.
 * Each node of the tree will store a DictEntry object
 */


public class BinarySearchTree implements BinarySearchTreeADT {

	private TreeNode root; 

	/**
	 * A constructor that will create a tree whose root is a leaf node
	 */
	public BinarySearchTree() {
		root=new TreeNode(null);
	}


	/**
	 * The method find the DictEntry storing the key
	 * @param Position of the key	
	 * @return the DictEntry storing the key
	 */
	public DictEntry find (Position key)
	{
		
		TreeNode r=findNode(key);

		if(r==null){
			return null;
		}
		else{	
			return r.getKey();
		}
	}


	/**
	 * a helper method that will return the TreeNode storing the specified key
	 * @param the position of the key we are looking for
	 */ 
	private TreeNode findNode( Position key){

		TreeNode r=root;
		while(r.getKey()!=null){
			//if the r is equal to the key return the node r
			if(r.getKey().getPosition().compareTo(key)==0){
				return r;

			}
			//if the r is greater to the key set the node r to its left child

			else if(r.getKey().getPosition().compareTo(key)==1){
				r= r.getLeft();


			}
			//if the r is less than to the key set the node r to its left child

			else{	
				r= r.getRight();

			}
		}
		return r;

	}

	/**
	 * Inserts the given data in the tree if no data item with the same key is already there. 
	 * If a node already stores the same key, the algorithm throws a BSTException.
	 *@param the data we want to inserted int the tree
	 */



	public void insert (DictEntry data) throws BSTException {


		TreeNode p=findNode(data.getPosition());
		if(p.getKey() !=null){
			throw new BSTException("The key is already inserted in the tree"); 
		}
		else{
			p.setKey(data);
		}
	}


	/**
	 * Removes the data item with the given key, if the key is stored in the tree.
	 *  Throws a BSTException otherwise.
	 */
	public void remove(Position key) throws BSTException 
	{
		TreeNode r=findNode(key);
		DictEntry entry;
		//check whether the key is already in the tree if this is the case throw an exception
		if (r.getKey()==null) {
			throw new BSTException (" This key does not exist in the tree");
		}
		else
		{

			TreeNode right=r.getRight();
			TreeNode left=r.getLeft();

			// if the root's left and right children are null set the the root to null
			if (left.getKey()==null&&right.getKey()==null)
			{
				r.setKey(null);
			}

			else
			{
				//else find the successor of the key
				entry=successor(r.getKey().getPosition());
				TreeNode p= findNode(entry.getPosition());

				// if the successor has a a right child set the successor to the value of the right child set the right child to p
				//and call on the remove method on the right child;
				if(p.getLeft()==null && p.getRight()!=null){
					p.setKey(right.getKey());
					remove(right.getKey().getPosition());
				}
				//otherwise just remove the successor and set the root to the value of the successor
				else{
					remove(entry.getPosition());
				}
				r.setKey(entry);
			}
		}
	}


	/**
	 * Returns the DictEntry with the smallest key larger than the given one in the parameter  
	 *  Re-turns null if the given key has no successor.
	 */
	public DictEntry successor (Position key) {

		TreeNode r=root;

		TreeNode successor = new TreeNode(null);
		if(r.getKey()==null){
			return null;
		}
		else{
		while(r.getKey()!=null){
			//if the root is less than the key or equal to the key then we check on the right by setting r to its right child
			if(r.getKey().getPosition().compareTo(key)==-1 || r.getKey().getPosition().compareTo(key)==0){
				r=r.getRight();
			}
			else{	//if the root is greater than the key  then we check on the left by setting r to its left child

				successor=r;
				r=r.getLeft();

			}	 

		}
		}
		return successor.getKey();
	}




	/**
	 * Returns the DictEntry with the largest key smaller than the given one  and null if the given key has no predecessor.
	 */ 


	public DictEntry predecessor (Position key) {

		TreeNode r=root;

		TreeNode predecessor = new TreeNode(null);
		
		if(r.getKey()==null){
			return null;
		}
		else{
		while(r.getKey()!=null){
			//if the root is greater than the key or equal to the key then we check on the left by setting r to its left child

			if(r.getKey().getPosition().compareTo(key)==1 || r.getKey().getPosition().compareTo(key)==0){
				r=r.getLeft();

			}
			else{
				//if the root is less than the key  then we check on the right by setting r to its right child
				predecessor=r;
				r=r.getRight();
			}	 

		}
		}
		return predecessor.getKey();
	}

	/**
	 * Finds the smallest key in the tree
	 * @return the dictEntry with the smallest Key and null if the tree doesn't contain any data
	 */
	public DictEntry smallest() {
		TreeNode r=root;
		if (r!=null){
			//loop through the left keys until the last left key

			while(r.getLeft().getKey()!=null){
				r=r.getLeft();
			}

			return r.getKey();
		}
		else
			return null;
	}


	/**
	 * Finds the largest key in the tree
	 * @return the dictEntry with the largest Key and null if the tree doesn't contain any data
	 */
	public DictEntry largest(){
		TreeNode r=root;
		if (r!=null){
			//loop through the right keys until the last right key
			while(r.getRight().getKey()!=null){
				r=r.getRight();
			}

			return r.getKey();
		}
		else
			return null;
	}
}