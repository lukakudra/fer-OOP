package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.*;

/**
 * The abstract superclass from which all the geometrical figures should be derived.
 * The default methods for every geometrical figure are methods for drawing the
 * shape and for checking if the figure contains a certain point. The drawing 
 * method is defaullt for all subclasses and it is recommended for them to override
 * this method. Subclasses must also implement the method hasPoint as it is impossible
 * to do so without knowing what the geometrical figure is.
 * 
 * @author Luka
 * @see Rectangle
 * @see RectangleFast
 * @see Circle
 * @see CircleFast
 * @see EquilateralTriangle
 * @see EquilateralTriangleFast
 *
 */

public abstract class GeometricalFigure {
	
	/**
	 * Checks if a certain point (x,y) is contained inside the geometrical figure
	 * This method must return false only if the location of the point is outside the
	 * geometrical figure, otherwise it should return true
	 * 
	 * @param x x coordinate of a point
	 * @param y y coordinate of a point
	 * @return true if the point is inside the geometrical figure, false otherwise
	 */
	
	public abstract boolean hasPoint(int x, int y);
	
	
	/**
	 * This method draws a filled image of the geometrical figure. This method is
	 * the assumed drawing method for all figures and checks the whole picture of points.
	 * 
	 * @param pic picture
	 */
	
	public void drawOnPicture(Picture pic) {
		for(int y=0, h=pic.getHeight(); y<h; y++) {
			for(int x=0, w=pic.getWidth(); x<w; x++) {
				if(this.hasPoint(x, y)) {
					pic.turnPixelOn(x, y);
				}
			}
		}
	}
}
