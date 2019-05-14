package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;

/**
 * The class generates a faster solution to draw a rectangle
 * 
 * @author Luka
 *
 */

public class RectangleFast extends Rectangle {
	
	/**
	 * Constructs a new rectangle with given arguments
	 * 
	 * @param x x coordinate of the top left corner 
	 * @param y y coordinate of the top left corner
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 */
	
	public RectangleFast(int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	
	/**
	 * Constructs a new rectangle equal to the argument
	 * @param rectangle rectangle
	 */
	
	public RectangleFast(Rectangle rectangle) {
		super(rectangle);
	}
	
	/**
	 * Overrides the original method to draw a rectangle 
	 * using the method drawLine from the class Picture
	 */
	
	@Override
	public void drawOnPicture(Picture pic) {
		int x=this.getX();
		int y=this.getY();
		int width=x+this.getWidth();
		int height=y+this.getHeight();
		
		int picWidth=pic.getWidth();
		int picHeight=pic.getHeight();
		
		if(x<0) {
			x=0;
		} else {
			if(x>=picWidth) {
				x=0;
			}
		}
		if(y<0) {
			y=0;
		}
		
		while(y<height) {
			if(width<0 || width>=picWidth) {
				break;
			}
			if(y>=picHeight) {
				break;
			}
			pic.drawLine(x,width, y);
			y++;
		}	
	}
}
