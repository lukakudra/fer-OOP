package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;

/**
 * The class generates a faster solution to draw a circle
 * 
 * @author Luka
 *
 */

public class CircleFast extends Circle {
	
	/**
	 * Constructs a new circle with given arguments
	 * 
	 * @param x x coordinate of the circle's center
	 * @param y y coordinate of the circle's center
	 * @param r radius of a circle
	 */
	
	public CircleFast(int x, int y, int r) {
		super(x,y,r);
	}
	
	/**
	 * Construct a new circle equal to the argument
	 * @param circle circle
	 */
	
	public CircleFast(Circle circle){
		super(circle);
	}
	
	/**
	 * Overrides the original method to draw a circle 
	 * using the method drawLine from the class Picture
	 */
	
	@Override
	public void drawOnPicture(Picture pic) {
		int r = this.getR();
        int x = this.getX();
        int y = this.getY();
        int picWidth = pic.getWidth();
        int picHeight = pic.getHeight();

        for(int y1 = y - r, bottom = y + r; y1 < bottom; y1++){
           int yDifference = Math.abs(y - y1);
           int dx = (int) Math.sqrt(r * r - yDifference * yDifference);
           int x1 = x - dx;
           int x2 = x + dx;
            
           //if the given coordinates are out of picture bounds
           if(x1<0) {
        	   x1=0;
           } else {
        	   if(x1>=picWidth) {
        		   x1=-1;
        	   } 
           }
           if(x2<0) {
        	  x2=-1;
           } else {
        	   if(x2>=picWidth) {
        		   x2=-1;
        	   } 
           }
           if(y1 >= picHeight){
        	   break;
           }
           
           if(y1 < 0 || x1 < 0 || x2 < 0){
        	   continue;
           }
           
           pic.drawLine(x1, x2, y1);
        }
	}
}
