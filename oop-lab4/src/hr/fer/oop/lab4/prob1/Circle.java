package hr.fer.oop.lab4.prob1;
/**
 * The class extends the abstract class GeometricalFigure as it represents
 * a circle
 * 
 * @author Luka
 *
 */

public class Circle extends GeometricalFigure {
	
	private int x;
	private int y;
	private int r;
	
	/**
	 * Constructs a new circle using the given coordinates and the radius
	 * 
	 * @param x x coordinate of the center of a cricle
	 * @param y y coordinate of the center of a circle
	 * @param r radius of a circle
	 */
	
	public Circle(int x, int y, int r) {
		this.x=x;
		this.y=y;
		this.r=r;
	}
	
	/**
	 * Constructs a  new circle equal to the argument
	 * 
	 * @param circle circle
	 */
	
	public Circle(Circle circle) {
		this(circle.x, circle.y, circle.r);
	}
	
	/**
	 * Getter for the x coordinate of the center
	 * @return x
	 */
	
	public int getX() {
		return x;
	}
	
	/**
	 * Getter for the y coordinate of the center
	 * @return y
	 */
	
	public int getY() {
		return y;
	}
	
	/**
	 * Getter for the circle's radius
	 * @return
	 */
	
	public int getR() {
		return r;
	}
	
	/**
	 * Overrides the original method from the abstract class GeometricalFigure
	 * to fit for this specific geometrical figure that is circle
	 */
	
	@Override
	public boolean hasPoint(int x, int y) {
		int distanceX=this.x-x;
		int distanceY=this.y-y;
		
		if(distanceX*distanceX + distanceY*distanceY > r*r) {
			return false;
		}
		
		return true;
	}
}
