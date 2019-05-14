package hr.fer.oop.lab5.first;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class visits the subtree of the given path and writes all txt files from all 
 * directories in the subtree in one txt file.
 * 
 * @author Luka
 *
 */

public class MultipleFileProgram {
	
	/**
	 * This is the program's main method. It uses the class MyByteReader as a FileVisitor
	 * to walk through the file tree and write all txt files from all directories into one
	 * txt file on the given path.
	 * 
	 * @param args string arguments that are never used.
	 */
	
	public static void main(String[] args) {
		
		Path out=null;
		try {
			out=Files.createFile(Paths.get("C:/OOP/eclipse-neon/oop-lab5/multipleout.txt"));
		} catch (FileAlreadyExistsException exc) {
			out=Paths.get("C:/OOP/eclipse-neon/oop-lab5/multipleout.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		Path in=Paths.get("C:/OOP/eclipse-neon/oop-lab5/racuni3");
		
		OutputStream os=null;
		try {
			os=new FileOutputStream(out.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		MyByteReader visitor=new MyByteReader(os);
		try {
			Files.walkFileTree(in, visitor);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
