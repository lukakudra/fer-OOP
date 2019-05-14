package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;

/**
 * The class generates a faster solution to draw an equilateral triangle
 * 
 * @author Luka
 *
 */

public class EquilateralTriangleFast extends EquilateralTriangle{
	
	/**
	 * Constructs a new equilateral triangle with given arguments
	 * @param x x coordinate of the top of the triangle
	 * @param y y coordinate of the top of the triangle
	 * @param lengthOfBase length of triangle's base
	 */
	
	public EquilateralTriangleFast(int x, int y, int lengthOfBase) {
		super(x,y,lengthOfBase);
	}
	
	/**
	 * Constructs a new equilateral triangle equal to the argument
	 * 
	 * @param triangle equilateral triangle
	 */
	
	public EquilateralTriangleFast(EquilateralTriangle triangle) {
		super(triangle);
	}
	
	/**
	 * Overrides the original method to draw an equilateral triangle 
	 * using the method drawLine from the class Picture
	 */
	
	@Override
	public void drawOnPicture(Picture pic) {
        int lengthOfBase=this.getLengthOfBase();
        int height = (int) (lengthOfBase / 2 * Math.sqrt(3));
        double limit=lengthOfBase/2;
        int x=this.getX();
        int y=this.getY();
        
        int picWidth=pic.getWidth();
        int picHeight=pic.getHeight();
  
        for(int i=y; i<=y+height; i++) {
        	if(i>=picHeight || i<0) {
        		break;
        	}
        	int x1=x+lengthOfBase-(int)limit;
         	int x2=x+(int)limit;
         	
         	if(x1<0) {
         		x1=0;
         	} else {
         		if(x1>=picWidth) {
         			x1=0;
         		}
         	}
         	if(x2<0) {
         		x2=0;
         	} else {
         		if(x2>=picWidth) {
         			x2=0;
         		}
         	}
        	pic.drawLine(x1, x2, i);
        	if(limit-Math.cos(Math.PI/6)>0) {
        		limit=limit-Math.tan(Math.PI/6);
        	}
        	
        }
	}

}
