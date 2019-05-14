package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;
import hr.fer.oop.lab4.pic.PictureDisplay;

/**
 * The demonstration class for the prob1
 * @author Luka
 *
 */

public class Demonstration {
	
	/**
	 * This is the program's main method
	 * @param args
	 */
	
	public static void main(String[] args) {

		EquilateralTriangle triangle=new EquilateralTriangle(20, 10, 15);
		EquilateralTriangleFast triangleFast=new EquilateralTriangleFast(15, 30, 15);
		Rectangle rectangle=new Rectangle(50, 20, 12, 10);
		RectangleFast rectangleFast=new RectangleFast(40, 32, 12, 10);
		Circle circle=new Circle(70, 15, 7);
		CircleFast circleFast=new CircleFast(70, 35, 7);
		
		Picture picture=new Picture(100, 50);
		
		//triangle
		triangle.drawOnPicture(picture);
		triangleFast.drawOnPicture(picture);
		
		//rectangle
		rectangle.drawOnPicture(picture);
		rectangleFast.drawOnPicture(picture);
		
		//circle
		circle.drawOnPicture(picture);
		circleFast.drawOnPicture(picture);
		
		picture.renderImageToStream(System.out);
		PictureDisplay.showPicture(picture);
	}
}

