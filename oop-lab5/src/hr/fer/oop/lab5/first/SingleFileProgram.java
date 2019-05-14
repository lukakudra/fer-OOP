package hr.fer.oop.lab5.first;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class writes the data from one txt file to the other txt file
 * and then it checks if the newly created file actually exists. 
 * 
 * @author Luka
 *
 */

public class SingleFileProgram {
	
	/**
	 * This is the program's main method. It uses the method run from
	 * MyByteWriter to write the data to a new txt file located on the
	 * given path.
	 * 
	 * @param args string of arguments that are never used
	 * @throws IOException
	 */
	
	
	public static void main(String[] args) throws IOException {
		
		InputStream is=null;
		Path path=Paths.get("C:/OOP/eclipse-neon/oop-lab5/singleout.txt");
		
		try {
			is=new FileInputStream("C:/OOP/eclipse-neon/oop-lab5/racuni3/2003/1/Racun_0.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		
		MyByteWriter writer=new MyByteWriter(is, path);
		writer.run();
		
		File f=new File(path.toString());
		if(f.exists() && !f.isDirectory()) {
			System.out.println("File is succesfully created");
		} else {
			throw new FileNotFoundException();
		}
	}
}
