package hr.fer.oop.lab1;

public class MyFirstProgram {
	public static void main(String[] args) {
		System.out.println("Moj prvi program!");
		for (int i=0; i<args.length; i++) {
			int argNo=i+1;
			System.out.println("" + argNo + ". argument programa= " + args[i]);
		}
		cluelessMethod(args);
	}
	
	public static void cluelessMethod(String [] args) {
		String result="";
		int step=0;
		for (int i=0; i<args.length; i++) {
			step++;
			String arg=args[i];
			int argLength=arg.length();
			String upperCase=arg.toUpperCase();
			result+=" " + arg;
			
			
			if ((i+1)<args.length) {
				/*System.out.print("Korak " + step + ": ");
				System.out.println("Ne znam zasto ali resetirat cu brojac i...");
				result="";
				i=0;*/
			}
		}
		System.out.println("Argumenti programa su: " + result);
		
	}
	
}
