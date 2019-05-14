package hr.fer.oop.lab2.prob5;

/**
 * This program accepts one command line argument: an integer number that
 * is greater than 1. It also computes and prints out the factorization of 
 * that number onto prime factors.
 * 
 * @author Luka
 *
 */

public class PrimeFactorization {
	
	/**
	 * This is the program's main method. One argument is expected and 
	 * processed.
	 * 
	 * @param args arguments from command line, possible integer to be decomposed
	 */
	
	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("Expected 1 argument.");
			return;
		}
		String numberString=args[0];
		int number=Integer.parseInt(numberString);
		if (number<=1) {
			System.out.println("Number must be greater than 1.");
			return;
		}
		System.out.printf("You requested decomposition of number %d into prime factors. Here they are:%n", number);
		printFactors(number);
		
	}
	
	/**
	 * Decomposes a number onto prime factors and prints them out.
	 * 
	 * @param number integer to be decomposed onto prime factors
	 */
	
	private static void printFactors(int number) {
		int i=1;
		for (int factor=2; factor<=number; factor++) {
			while (number%factor==0) {
				number=number/factor;
				System.out.printf("%d. ", i++);
				System.out.println(factor);
			}
		}
	}
}
