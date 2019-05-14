package hr.fer.oop.lab2.prob3;

/**
 * This program accepts three command line arguments: real part of complex number,
 * imaginary part of complex number, and required root to calculate (must be an integer 
 * greater than 1). Program computes and prints all requested roots of given complex 
 * number in a formatted form.
 * 
 * @author Luka
 *
 */

class Roots{
	
	/**
	 * This is the program's main method. Three arguments are expected to be 
	 * passed through the command line.
	 * 
	 * @param args real part, imaginary part, root to calculate
	 */
	
	public static void main(String args[]) {
		if(args.length!=3) {
			System.out.println("Expected 3 arguments.");
			return;
		}
		String realString=args[0];
		String imaginaryString=args[1];
		String rootString=args[2];
		
		double real=Double.parseDouble(realString);
		double imaginary=Double.parseDouble(imaginaryString);
		int root=Integer.parseInt(rootString);
		
		if(root<=1) {
			System.out.println("Root must be an integer greater than 1.");
			return;
		}
		System.out.printf("You requested calculation of %d. roots. Solutions are:%n", root);
		double [] solutions=calculateSolutions(real, imaginary, root);
		printSolutions(solutions);
		
	}
	
	/**
	 * Returns an array of solutions for the n-th root of a complex number using 
	 * the given formula:
	 * r^(1/n)*(cos((phi+2*k*PI)/n)+i*sin((phi+2*k*PI)/n), where k=0,1,2,...,n-1.
	 * The returned array contains paired real-imaginary solutions, meaning that
	 * the first argument of the array is the real part of the first solution, the 
	 * second argument of the array is the imaginary part of the first solution, the 
	 * third argument of the array is the real part of the second solution, and so on.
	 * 
	 * @param real real part of the complex number
	 * @param imaginary imaginary part of the complex number
	 * @param root n-th root to be calculated
	 * @return array containing paired real and imaginary solutions
	 */
	
	private static double [] calculateSolutions(double real, double imaginary, int root) {
		double radius=Math.sqrt(real*real + imaginary*imaginary);
		double radiusRoot=Math.pow(radius, 1.0/root);
		double angle=Math.atan2(real, imaginary);
		
		double [] solutions=new double[2*root];
		
		for (int k=0; k<root; k++) {
			double realSolution=radiusRoot*Math.cos((angle+2*k*Math.PI)/root);
			double imaginarySolution=radiusRoot*Math.sin((angle+2*k*Math.PI)/root);
			
			solutions[2*k]=realSolution;
			solutions[2*k+1]=imaginarySolution;
		}
		return solutions;
	}
	
	/**
	 * Prints out a paired set of solutions passed as an array of doubles 
	 * in a format with no decimal places.
	 * 
	 * @param solutions array of paired complex solutions
	 */
	
	private static void printSolutions(double[] solutions) {
		
		for (int i=0; i<solutions.length; i=i+2) {
			int ordinalNumberOfSolution=i/2+1;
			System.out.printf("%d) ", ordinalNumberOfSolution);
			double realSolution=solutions[i];
			double imaginarySolution=solutions[i+1];
			
			if(Math.abs(realSolution)==0 && Math.abs(imaginarySolution)==0) {
				System.out.println("0");
				
			} else {
			
				//Real part and imaginary sign
				System.out.format("%.0f", realSolution);
				if(imaginarySolution>0) {
					System.out.print(" + ");
				} else if(imaginarySolution<0) {
					System.out.print(" - ");
				}
			
				//Imaginary part
				if(imaginarySolution==0) {
					System.out.println();
				}
				imaginarySolution=Math.abs(imaginarySolution);
				System.out.format("%.0f", imaginarySolution);
				System.out.println("i");
			}
			
		}
	}
}