public class alaabst implements BinarySearchTreeADT{

	private BinaryTreeNode root;

	public alaabst()
	{
		this.root = new BinaryTreeNode(null);
	}
	/**
	 * Returns DictEntry storing the key 
	 */
	public DictEntry find(Position key){
		BinaryTreeNode temp = findHelper(root, key);
		if(temp.getKey() == null){
			return null;
		}
		else{
			return temp.getKey();
		}
	}
	/**
	 * method used to search for a given key
	 */
	private BinaryTreeNode findHelper(BinaryTreeNode node, Position key){
		if(node.getKey() == null){
			return node;
		}
		//check if the key is stored in the right child and return the right child and key
		if(key.compareTo(node.getKey().getPosition()) == 1){
			return findHelper(node.getRight(), key);
		}
		//check if the key is stored in the left child and return the left child and key
		else if(key.compareTo(node.getKey().getPosition()) == -1){
			return findHelper(node.getLeft(), key);
		}
		//check if the key is stored in the current node
		else{

			return node;
		}
	}




	public void insert(DictEntry data) throws BSTException {
		BinaryTreeNode search = findHelper(root,data.getPosition());
		BinaryTreeNode temp = new BinaryTreeNode(data);
		//check if the tree contains a duplicate
		if(search.getKey() !=null){
			throw new BSTException("Entry is already in the tree");
		}
		//enter the data and set it to the parameter passed
		else{
			search.setKey(data);
			temp.setLeft(null);
			temp.setRight(null);
		}
	}




	public void remove(Position key) throws BSTException {
		if (find(key)==null) throw new BSTException ("Error: This key does not exist!");
		else
		{
			BinaryTreeNode r=findHelper(root,key),  rRight=r.getRight(), rLeft=r.getLeft();
			DictEntry entry;
			
			//case 1: no children
			if (rRight.getKey()==null&&rLeft.getKey()==null)
			{
				//sets the right and left nodes to null, and then sets the root value to null;
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


	public DictEntry successor(Position key) {

		BinaryTreeNode temp = findHelper(root, key);
		if(temp == null){
			return null;
		}
		if(temp.getRight() != null){
			return smallestHelper(temp.getRight()).getKey();
		}
		else{
			BinaryTreeNode ancestor = temp.getParent();
			while(ancestor.getRight() != null && ancestor.getRight().equals(temp)){
				temp = ancestor;
				ancestor = temp.getParent();
		
		}
		}
		return temp.getParent().getKey();
		
	}
		
	

	@Override
	public DictEntry predecessor(Position key) {
		BinaryTreeNode temp = findHelper(root,key);
		if(temp.getKey() == null){
			return null;
		}
		if(temp.getLeft() != null){
			return largestHelper(temp.getLeft()).getKey();
		}
		else{
			BinaryTreeNode ancestor = temp.getParent();
			while(ancestor.getLeft() != null && ancestor.getLeft().equals(temp)){
				temp = ancestor;
				ancestor = temp.getParent();
		}
		
		}
		return temp.getParent().getKey();
		

	}
	public DictEntry smallest() {
		return smallestHelper(this.root).getKey();
	}

	private BinaryTreeNode smallestHelper(BinaryTreeNode root){
		if(root == null){
			return null;
		}
		else{
			//
			BinaryTreeNode temp = root;
			while(temp.getLeft().getKey()!=null){
				temp = temp.getLeft();
			}
			return temp;
		}
	}

	/**
	 * @return DictEntry with largest key, null if the tree is empty
	 **/
	public DictEntry largest() {
		return largestHelper(this.root).getKey();
			}
		private BinaryTreeNode largestHelper(BinaryTreeNode root){
			if(root == null){
				return null;
				}
				else{
					BinaryTreeNode temp = root;
					while(temp.getRight().getKey()!=null){
						temp = temp.getRight();
					}
					
					return temp;
		}
		}
}
