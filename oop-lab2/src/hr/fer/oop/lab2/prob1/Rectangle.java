package hr.fer.oop.lab2.prob1;
import java.util.Scanner;

/**
 * This program calculates the perimeter and area of a rectangle.
 * The rectangle parameters can be obtained either through command
 * line as program arguments or through keyboard while program is
 * running. If there are arguments from the command line and if there 
 * aren't two, the program stops with an error message. Else the 
 * program reads from keyboard untill the user inputs a non-negative
 * width and height.
 * 
 * @author Luka
 *
 */

public class Rectangle {
	
	/**
	 * This is the program's main method. It accepts two arguments,
	 * width and height of a rectangle and prints out the area and 
	 * perimeter of that rectangle.
	 * 
	 * @param args arguments from command line, possible width and height
	 */
	
	public static void main(String[] args) {
		double width;
		double height;
		if(args.length!=0) {
			if(args.length!=2) {
				System.out.println("Invalid number of arguments provided.");
				return;
			}
			width=Double.parseDouble(args[0]);
			height=Double.parseDouble(args[1]);
		} else {
			Scanner scan=new Scanner(System.in);
			width=getWidth(scan);
			height=getHeight(scan);
		}
		
		double perimeter=calculatePerimeter(width, height);
		double area=calculateArea(width, height);
		
		System.out.format("You have specified a rectangle of width %.1f and height %.1f. "
						 +"Its area is %.1f and its perimeter is %.1f.", width, height, area, perimeter);
	}
	
	/**
	 * Calculates and returns rectangle's perimeter based on the
	 * given parameters
	 * 
	 * @param width width of a rectangle
	 * @param height height of a rectangle
	 * @return the perimeter of a rectangle
	 */
	
	
	private static double calculatePerimeter(double width, double height) {
		return 2*width+2*height;
	}
	
	/**
	 * Calculates and returns rectangle's area based on the
	 * give parameters
	 * 
	 * @param width the width of a rectangle
	 * @param height the height of a rectangle
	 * @return the area of a rectangle
	 */
	
	private static double calculateArea(double width, double height) {
		return  width*height;
	}
	
	/**
	 * Reads the user's input of rectangle's width as a string.
	 * If it's empty gives an error message and expects a new input.
	 * Turns the width into a double value. If it's negative gives an
	 * error message and expects a new input. Returns a positive double 
	 * value of rectangle's width.
	 * 
	 * @param scan argument of type Scanner
	 * @return the double value of rectangle's width
	 */

	private static double getWidth(Scanner scan) {
		double widthNumber;
		while(true) {
			System.out.println("Please provide width:");
			String width=scan.nextLine();
			width=width.trim();
			if(width.isEmpty()) {
				System.out.println("The input must not be blank.");
				continue;
			}
			widthNumber=Double.parseDouble(width);
			if(widthNumber<0) {
				System.out.println("The width must not be negative.");
				continue;
			}
			break;
		}
		return widthNumber;
	}
	
	/**
	 * Reads the user's input of rectangle's height as a string.
	 * If it's empty gives an error message and expects a new input.
	 * Turns the height into a double value. If it's negative gives an
	 * error message and expects a new input. Returns a positive double 
	 * value of rectangle's height.
	 * 
	 * @param scan argument of type Scanner
	 * @return the double value of rectangle's height
	 */
	
	private static double getHeight(Scanner scan) {
		double heightNumber;
		while(true) {
			System.out.println("Please provide heght:");
			String height=scan.nextLine();
			height=height.trim();
			if(height.isEmpty()) {
				System.out.println("The input must not be blank.");
				continue;
			}
			heightNumber=Double.parseDouble(height);
			if(heightNumber<0) {
				System.out.println("The height must not be negative.");
				continue;
			}
			break;
		}
		return heightNumber;
	}
}