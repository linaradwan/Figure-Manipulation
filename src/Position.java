/**
 * @author Lina Radwan
 * Assignment 4 Cs 2210
 *class Position represents the position (x,y) of a pixel
 */

public class Position {

	private int x,y;

	/**
	 * A constructor which returns a new Position with the specified coordinates
	 * @param x
	 * @param y
	 */
	public Position(int x,int y) {
		this.x=x;
		this.y=y;

	}
	/**
	 * Getter for the x 
	 * @returns the x coordinate of this Position
	 */
	public int getX() {
		return x;
	}
	/**
	 * getter for the y
	 * @return the y coordinate of this Position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Compare this Position with p using row order
	 * @param position p
	 * @return an int representing the comparison between both positions
	 */
	public int compareTo(Position p){

		if(this.getY()> p.getY()){
			return 1;
		}
		else if (this.getY() < p.getY()){
			return -1;
		}
		else{
			if (this.getX()< p.getX())
				return -1;
			else if (this.getX() > p.getX())
				return 1;

			else return 0;
		}

	}
}
