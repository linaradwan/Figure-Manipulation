
public class Trial {
	private TreeNode root; 

	public Trial() {
		root=new TreeNode(null);
	}
	
	
	public DictEntry find (Position key){
		TreeNode r=findAgain(key);

		if(r.getKey()==null){
			return null;
		}
		else{
			return r.getKey();
		}
	}

	private TreeNode findAgain(Position key){
		TreeNode r=root;

		while(r.getKey()!=null){
			if(r.getKey().getPosition().compareTo(key)==0){
				return r;

			}
			else if(r.getKey().getPosition().compareTo(key)==1){
				r= r.getLeft();

			}
			else{	
				r= r.getRight();
			}
		}
		return r;


	}

	/// Inserts the given data in the tree if no data item with the same key 
	//is already there. If a node already stores the same key, 
	//the algorithm throws  a BSTException.


	public void insert (DictEntry data) throws BSTException {


		TreeNode p=findAgain(data.getPosition());
		if(p.getKey() !=null){
			throw new BSTException("The key is already inserted "); //	WRITE SOMETHING HERE
		}
		p.setKey(data);

	}
	
	
	public void remove (Position key) throws BSTException {
	delete(root,key);
	
	}
	
	
	private TreeNode delete(TreeNode root, Position key){
	TreeNode r=root;
TreeNode left,right;
	if (r==null) {
			throw new BSTException ("Error: This key does not exist!");
	}
	else{
		if (key.compareTo(r.getKey().getPosition())==-1){
			left=r.getLeft();
			left=delete(r.getLeft(),key);
		}
		else if(key.compareTo(r.getKey().getPosition())==1){
			right=r.getRight();
		right=delete(r.getRight(),key);
	}
		else{
		if(r.getLeft()==null){
			return r.getRight();
		}
		if(r.getRight()==null){
			return r.getLeft();
		}
		else{
		DictEntry data=	r.getKey();
		data=successor(r.getLeft().getKey().getPosition());
			left=r.getLeft();
			left=delete(r.getLeft(),data.getPosition());
		}
		}
	}
	return r;
	}
	
	
	
	// Removes the data item with the given key, if the key is stored in the tree. Throws a BSTException otherwise.
	
	
	public DictEntry successor (Position key) {
	TreeNode r=root;
	TreeNode successor = new TreeNode(null);
	if(r==null){
		return null;
	}
	while(r.getKey()!=null){
	 if(key.compareTo(r.getKey().getPosition())==1){
		 r=r.getRight();
	 }
	 else{
		 successor=r;
		 r=r.getLeft();
	 }
	 
	}
return successor.getKey();

	} //Returns the DictEntry with the smallest key larger than the given one (note that the tree does not need to store a node with the given key). Re- turns null if the given key has no successor.
	public DictEntry predecessor (Position key) {
		TreeNode r=root;
		TreeNode predecessor = new TreeNode(null);
		if(r==null){
			return null;
		}
		while(r.getKey()!=null){
			
		 if(r.getKey().getPosition().compareTo(key)==-1){
			 r=r.getRight();
		 }
		 else{
			 predecessor=r;
			 r=r.getLeft();
		 }
		 
		}
	return predecessor.getKey();
	}
	
	//Returns the DictEntry with the largest key smaller than the given one (note that the tree does not need to store a node with the given key). Returns null if the given key has no predecessor.
	public DictEntry smallest() {
		TreeNode r=root;
		if (r!=null){
			while(r.getLeft().getKey()!=null){
				r=r.getLeft();
			}
		
		return r.getKey();
	}
		return null;
	}
	
	
	
private TreeNode successor(TreeNode root){
	TreeNode r=root;
	if (r!=null){
		while(r.getRight().getKey()!=null){
			r=r.getRight();
		}
	
	return r;
}
	return null;
}


	// Returns the DictEntry with the smallest key. Returns null if the tree does not contain any data.
	public DictEntry largest(){
		TreeNode r=root;
		if (r!=null){
			while(r.getRight().getKey()!=null){
				r=r.getRight();
			}
		
		return r.getKey();
		}
		return null;
	}
}
/*
/**
 * BinarySearchTree is tree constructed from BinarySearchTreeNodes that are linked together to store DictEntry values
 * in an order manner. Every node will contain a root that can have a right and left values, where the value of the right
 * is larger and left value is smaller, than the roots value.
 * 
 * @author Zaid Albirawi
 * Student #: 
 * Mail: zalbiraw@uwo.ca
 * Course #: CS2210
 * Assignment #4
 * 
 * @version 1.0 15/11/2013
 */
//public class BinarySearchTree 
{
	private TreeNode root;
	
	public BinarySearchTree()  
	{
		root=new TreeNode(null);
	}
	
	/**
	  * The method find uses the method findRoot to find a value that is stored in the BST.
	  * 
	  * @param		p			is a Position that contains the position of the entry we are trying to find. 
	  * 
	  * @return					returns a DictEntry that contains the the value of p.
	  */
	public DictEntry find (Position p)
	{
		TreeNode r= findRoot(p);
		if (r.getKey()!=null)return r.getKey();
		return null;
	}
	
	/**
	  * The method findRoot iterates through the tree to find the position of the value required.
	  * 
	  * @param		p			is a Position that contains the position of the entry we are trying to find. 
	  * 
	  * @return					returns a BinarySearchTreeNode that is the position p.
	  */
	private TreeNode findRoot (Position p)
	{
		TreeNode r = root;
		int check;
		while (r.getKey()!=null)
		{
			check=r.getKey().getPosition().compareTo(p);
			if (check==0)return r;
			//iterates through the BST depending on the value of compareTo method.
			else if (check==1)r=r.getLeft();
			else if (check==-1)r=r.getRight();
		}
		return r;
	}

	/**
	  * The method insert uses the method findRoot to find where value should be inserted and inserts it.
	  * 
	  * @param		data		is a DictEntry value that contains the data values that you want to add to the BST.
	  */
	public void insert(DictEntry data) throws BSTException 
	{
		Position p = data.getPosition();
		if (find(p)!=null) throw new BSTException ("Error: This key already exists!");
		else findRoot(p).setKey(data);
	}
	
	/**
	  * The method remove removes a DictEntry at a specific position form the BST.
	  * 
	  * @param		p			is a Position that contains the position of the entry we are trying to remove. 
	  */
	public void remove(Position key) throws BSTException 
	{
		if (find(key)==null) throw new BSTException ("Error: This key does not exist!");
		else
		{
			TreeNode r=findRoot(key),  rRight=r.getRight(), rLeft=r.getLeft();
			DictEntry entry;
			
			//case 1: no children
			if (rRight.getKey()==null&&rLeft.getKey()==null)
			{
				//sets the right and left nodes to null, and then sets the root value to null;
				//r.nullLeft();r.nullRight();
				r.setKey(null);
			}
			//case 2: 1 child (right child)
			else if (rRight.getKey()!=null&&rLeft.getKey()==null)
			{
				/*
				saves the right child's value, and calls on the remove method to remove the right node. Then it sets 
				the root's value to that saved entry.
				*/
				entry=rRight.getKey();
				remove(entry.getPosition());
				r.setKey(entry);
			}
			//case 3: 1 child (left child)
			else if (rRight.getKey()==null&&rLeft.getKey()!=null)
			{
				/*
				saves the left child's value, and calls on the remove method to remove the left node. Then it sets 
				the root's value to that saved entry.
				*/
				entry=rLeft.getKey();
				remove(entry.getPosition());
				r.setKey(entry);
			}
			//case 3: 2 children
			else
			{
				/*
				saves the  successor's value, and calls on the remove method to remove the node that contains the successor's 
				value. Then it sets the root's value to that saved entry.
				*/
				entry=successor(r.getKey().getPosition());
				remove(entry.getPosition());
				r.setKey(entry);
			}
		}
	}
	
	/**
	  * The method successor method returns the successor of a specific position if it exists.
	  * 
	  * @param		p			is a Position that contains the position of the entry we are trying to find the successor for. 
	  * 
	  * @return					returns a DictEntry that contains the the value of p's successor.
	  */
	public DictEntry successor(Position key) 
	{
		TreeNode r = root, rParent=new TreeNode(null);
		DictEntry entry=r.getKey();
		int check;
		while (entry!=null)
		{
			check=entry.getPosition().compareTo(key);
			//iterates through the BST and tries to find a successor
			if (check==1)
			{
				rParent=r;
				r=r.getLeft();
			}
			else r=r.getRight();
			entry=r.getKey();
		}
		return rParent.getKey();
	}

	/**
	  * The method predecessor method returns the predecessor of a specific position if it exists.
	  * 
	  * @param		p			is a Position that contains the position of the entry we are trying to find the predecessor for. 
	  * 
	  * @return					returns a DictEntry that contains the the value of p's predecessor.
	  */
	public DictEntry predecessor(Position key) 
	{
		TreeNode r = root, rParent=new TreeNode(null);
		DictEntry entry=r.getKey();
		int check;
		while (entry!=null)
		{
			check=entry.getPosition().compareTo(key);
			//iterates through the BST and tries to find a predecessor
			if (check==-1)
			{
				rParent=r;
				r=r.getRight();
			}
			else r=r.getLeft();
			entry=r.getKey();
		}
		return rParent.getKey();
	}
	
	/**
	  * The method smallest method returns the smallest value in the BST.
	  *  
	  * @return					returns a DictEntry that contains the the value of smallest value.
	  */
	public DictEntry smallest() 
	{
		TreeNode r = root;
		if (r.getKey()!=null)
			//iterates to the left of the try until it reaches a null value
			while (r.getLeft().getKey()!=null) r=r.getLeft();
		return r.getKey();
	}

	/**
	  * The method largest method returns the largest value in the BST.
	  *  
	  * @return					returns a DictEntry that contains the the value of largest value.
	  */
	public DictEntry largest() 
	{
		TreeNode r = root;
		if (r.getKey()!=null)
			//iterates to the right of the try until it reaches a null value
			while (r.getRight().getKey()!=null) r=r.getRight();
		return r.getKey();
	}
}
*/