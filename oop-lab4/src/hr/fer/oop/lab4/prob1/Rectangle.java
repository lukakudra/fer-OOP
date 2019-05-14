package hr.fer.oop.lab4.prob1;

/**
 * The class extends the abstract class GeometricalFigure as it represents 
 * a rectangle
 * 
 * @author Luka
 *
 */

public class Rectangle extends GeometricalFigure {
	private int x;
	private int y;
	private int width;
	private int height;
	
	/**
	 * Constructs a new rectangle with given coordinates and the width and height
	 * of that rectangle
	 *  
	 * @param x x coordinate of the upper left corner
	 * @param y y coordinate of the upper left corner
	 * @param width width of a rectangle
	 * @param height height of a rectangle
	 */

	public Rectangle(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	/**
	 * Constructs a new rectangle equal to the argument
	 * 
	 * @param rectangle rectangle
	 */
	
	public Rectangle(Rectangle rectangle) {
		this(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}
	
	/**
	 * Getter for the x coordinate of the upper left corner 
	 * @return x
	 */
	
	public int getX() {
		return x;
	}
	
	/**
	 * Getter for the y coordinate of the upper right corner
	 * @return y
	 */
	
	public int getY() {
		return y;
	}
	
	/**
	 * Getter for the width of a rectangle
	 * @return width
	 */
	
	public int getWidth() {
		return width;
	}
	
	/**
	 * Getter for the height of a rectangle
	 * @return height
	 */
	
	public int getHeight() {
		return height;
	}
	
	/**
	 * Overrides the original method from the abstract class GeometricalFigure
	 * to fit for this specific geometrical figure that is rectangle
	 */
	
	@Override
	public boolean hasPoint(int x, int y) {
		if(x>this.x) {
			return false;
		}
		if(y>this.y) {
			return false;
		}
		if((x+width)<=this.x) {
			return false;
		}
		if((y+height)<=this.y) {
			return false;
		}
		
		return true;
	}
}
