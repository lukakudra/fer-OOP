package hr.fer.oop.lab2.prob4;

/**
 * This program accepts one argument from command line: an integer n that is
 * greater than 0, and computes and prints out first n prime numbers.
 * 
 * @author Luka
 *
 */

public class PrimeNumbers {
	
	/**
	 * This is the program's main method. One argument is expected and
	 * processed.
	 * 
	 * @param args arguments from command line, possible number of prime numbers
	 */
	
	public static void main(String [] args) {
		if(args.length!=1) {
			System.out.println("Expected 1 agument.");
			return;
		}
		String nString=args[0];
		int n=Integer.parseInt(nString); //n is number of prime numbers that need to printed
		if (n<=0) {
			System.out.println("Number of prime numbers must be greater than 0.");
			return;
		}
		
		System.out.printf("You requested calculation of first %d prime numbers. Here they are:%n", n);
		printPrimeNumbers(n);
		
	}
	
	/**
	 * Computes and prints out first n prime numbers.
	 * 
	 * @param n number of prime numbers to be computed
	 */
	
	
	private static void printPrimeNumbers(int n) {
		int count=0;
		int number=2;
		while(count!=n) {
			boolean isPrime=true;
			for (int i=2; i<Math.sqrt(number); i++) {
				if(number%i==0) {
					isPrime=false;
					break;
				}
			}
			if(isPrime==true) {
				System.out.printf("%d. ", count+1);
				count++;
				System.out.printf("%d%n", number);
			}
			number++;
		}
	}
}
