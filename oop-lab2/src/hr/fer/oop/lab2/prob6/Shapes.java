package hr.fer.oop.lab2.prob6;

/**
 * Prints out various shapes.
 * 
 * @author Luka
 *
 */

public class Shapes {
	
	public static void main(String[] args){
		drawHourGlass();
		drawGeometricalFigure();
		System.out.println();
		drawCup();
		drawHat();
	}
	
	private static void drawHourGlass() {
		printTopOrBottom();
		printBottomOfCup();
		printTopOfCup();
		printTopOrBottom();
	}
	
	private static void drawGeometricalFigure() {
		printTopOfCup();
		printBottomOfCup();
	}
	
	private static void drawCup() {
		printBottomOfCup();
		printTopOrBottom();
	}
	
	private static void drawHat() {
		printTopOfCup();
		printTopOrBottom();
	}
	
	private static void printTopOrBottom() {
		System.out.println("+--------+");
	}
	
	private static void printTopOfCup() {
		System.out.println("  ______");
		System.out.println(" /      \\");
		System.out.println("/        \\");
	}
	
	private static void printBottomOfCup() {
		System.out.println("\\        /");
		System.out.println(" \\______/");
	}
}
