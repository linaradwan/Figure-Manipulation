/**
 * @author Lina Radwan
 * Assignment 4 Cs 2210
 * This class represents a data item stored in the binary search tree and it consist of 2 parts a position and a color
 */
public class DictEntry {
	private Position p;
	private int color;
	
	/**
	 * a constructor which returns a new DictEntry with the specified coordinates and color.
	 * @param p is the key for the DictEntry
	 * @param color
	 */
	public DictEntry(Position p, int color) {
		this.p=p;
		this.color=color;
	}
	/**
	 * getter for the position
	 * @return the position int the dictEntry
	 */
	public Position getPosition() {
		return p;
	}
	/**
	 * getter for the color
	 * @return the color in  the dictEntry
	 */
	public int getColor() {
		return color;
	}

}
