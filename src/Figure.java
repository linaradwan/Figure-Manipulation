/**
 * 
 * @author Lina Radwan
 *Assignment 4 CS 2210
 *This class  represents the figure in the game 
 */

public class Figure implements FigureADT {

	private Position pos;
	private int id, width,height, type;
	private BinarySearchTree tree;

	/**
	 * 
	 * @param id the figure's identifier
	 * @param width of the enclosing rectangle
	 * @param height of the enclosing rectangle
	 * @param type is the type of the figure
	 * @param pos is the position of the figure
	 */
	public Figure (int id, int width, int height, int type, Position pos){
		tree=new BinarySearchTree();
		this.id=id;
		this.width=width;
		this.height=height;
		this.type=type;
		this.pos=pos;
	}
	/**
	 * 
	 * @return the tree of the figure
	 */
	private BinarySearchTree getBST() {
		return tree;
	}

	/**
	 * return the the id of this figure
	 */
	public int getId() {
		return id;
	}

	/**
	 * changes the offset of this figure to the specified value
	 */
	public void setOffset(Position value) {
		this.pos = value;
	}

	/**
	 * @return the offeset of this figure
	 */
	public Position getOffset() {
		return pos;
	}
	/**
	 * sets the type to the specified value
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * returns the width of the enclosing rectangle  for this figure
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * returns the height of the enclosing rectangle  for this figure
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * returns the type of the enclosing rectangle  for this figure
	 */
	public int getType() {
		return type;
	}
	/**
	 * Creates a DictEntry to represent the given pixel and inserts it into the binary search tree associated with this figure. 
	 * Throws a BSTException if an error occurs when inserting the pixel into the tree.
	 */
	public void addPixel(int x, int y, int rgb) throws BSTException {

		Position p = new Position(x,y);
		DictEntry pixel= new DictEntry(p,rgb);
		tree.insert(pixel);

	}

	/**
	 * Returns true if this figure intersects the one specified in the parameter and false otherwise.
	 */
	public boolean intersects(Figure fig) {
		
		//get the tree of of the one calling the method and the figure in the parameter
		
		BinarySearchTree thisFigureTree=this.getBST();
		BinarySearchTree otherFigureTree=fig.getBST();

		//get the smallest and the largest from each of the trees	
		Position otherSmallestPosition=otherFigureTree.smallest().getPosition();
		Position thisSmallestPosition=thisFigureTree.smallest().getPosition();

		Position thisLargestPosition=thisFigureTree.largest().getPosition(); 
		Position otherLargestPosition=otherFigureTree.largest().getPosition();

		//loop through every data item in the binary search tree
		while(thisSmallestPosition!=null && otherSmallestPosition!=null)
		{
			
			//returns false if the figures  reached the largest element in the tree; this indicates that the figures have reached the end and there wasn't any intersection 

			if (thisSmallestPosition.compareTo(thisLargestPosition)==0|| otherSmallestPosition.compareTo(otherLargestPosition)==0){
				return false;
			}

			//update the offset of f for each figure to figure position + the offset
			Position otherOffsetPosition=new Position (otherSmallestPosition.getX() + fig.getOffset().getX(),otherSmallestPosition.getY() + fig.getOffset().getY() );

			Position thisOffsetPosition=new Position (thisSmallestPosition.getX() + this.getOffset().getX(),thisSmallestPosition.getY() + this.getOffset().getY() );

			//if the position of each figure is the same then they do intersect
			if(thisOffsetPosition.compareTo(otherOffsetPosition)==0)
			{
				return true;

			}

			//otherwise check which figure is smaller and set the position to next one in the tree or basically incrementing it to the next position
			else if (thisOffsetPosition.compareTo(otherOffsetPosition)==1)
			{

				otherSmallestPosition=otherFigureTree.successor(otherSmallestPosition).getPosition();
			}

			else{
				thisSmallestPosition=thisFigureTree.successor(thisSmallestPosition).getPosition();

			}

		}
		return false;
	}
}

