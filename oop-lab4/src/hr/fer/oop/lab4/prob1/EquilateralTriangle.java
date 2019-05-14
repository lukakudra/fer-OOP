package hr.fer.oop.lab4.prob1;

/**
 * The class extends the abstract class GeometricalFigure as it represents
 * an equilateral triangle.
 * 
 * @author Luka
 *
 */

public class EquilateralTriangle extends GeometricalFigure {
	private int x;
	private int y;
	private int lengthOfBase;
	
	/**
	 * Constructs a new equilateral triangle using the given coordinates and
	 * the length of base
	 * 
	 * @param x x coordinate of the top point
	 * @param y y coordinate of the top point
	 * @param lengthOfBase length equilateral triangle's base
	 */
	
	public EquilateralTriangle(int x, int y, int lengthOfBase) {
		this.x=x;
		this.y=y;
		this.lengthOfBase=lengthOfBase;
	}
	
	/**
	 * Constructs a new equilateral triangle equal to the argument
	 * 
	 * @param triangle equilateral triangle
	 */
	
	
	public EquilateralTriangle(EquilateralTriangle triangle) {
		this(triangle.x, triangle.y, triangle.lengthOfBase);
	}
	
	/**
	 * Getter for the x coordinate of the top point
	 * @return x
	 */
	
	public int getX() {
		return x;
	}
	
	/**
	 * Getter for the y coordinate of the top point
	 * @return y
	 */
	
	public int getY() {
		return y;
	}
	
	/**
	 * Getter for the length of base
	 * @return length of base
	 */
	
	public int getLengthOfBase() {
		return lengthOfBase;
	}
	
	/**
	 * Overrides the original method from the abstract class GeometricalFigure
	 * to fit for this specific geometrical figure that is equilateral triangle
	 */
	
	@Override
	public boolean hasPoint(int x, int y) {
		int height = (int) (lengthOfBase / 2 * Math.sqrt(3));
		if(y<this.y) {
			return false;
		}
		if(y>this.y+height) {
			return false;
		}
		
		int xSpace=(int)(Math.tan(Math.PI/6) * (y-this.y));
		
		if(x<this.x-xSpace) {
			return false;
		}
		if(x>this.x+xSpace) {
			return false;
		}
		return true;
	}
}
