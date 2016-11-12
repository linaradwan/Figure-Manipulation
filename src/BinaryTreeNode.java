public class BinaryTreeNode {

	private BinaryTreeNode left, right, parent; //left and right child node, parent node
	//private DictEntry entry;				//Dictionary entry of node
	private DictEntry key;
	
	public DictEntry getKey() {
		return key;
	}

	public void setKey(DictEntry key) {
		this.key = key;
	}

	/** creates node with links to two children, parent, and stores data */ 
	public BinaryTreeNode(DictEntry data)
	{
	//	this.entry = data;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	
	/** set left child to node */
	public void setLeft(BinaryTreeNode node)
	{
		this.left = node;
	}

	/** set right child to node */
	public void setRight(BinaryTreeNode node)
	{
		this.right = node;
	}
	
	/** set parent to node */
	public void setParent(BinaryTreeNode node)
	{
		this.parent = node;
	}
	
	/** set entry to data*/
//	public void setEntry(DictEntry data)
	//{
		//this.entry = data;
		//key = entry.getPosition();
	//}

	/** returns left child of this node */
	public BinaryTreeNode getLeft()
	{
		if(left==null){
			left =new BinaryTreeNode(null);
		}
		return left;
	}

	/** returns right child of this node */
	public BinaryTreeNode getRight()
	{
		if(right==null){
			right =new BinaryTreeNode(null);
		}
		return right;
	}
	
	/** returns parent of this node */
	public BinaryTreeNode getParent()
	{
		return parent;
	}

	//public DictEntry getEntry() {
		//return entry;
	//}

	
}