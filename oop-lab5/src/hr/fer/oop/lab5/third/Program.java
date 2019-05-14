package hr.fer.oop.lab5.third;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class reads a file and then encrypts it by using the class MaskStream. It then
 * decrypts that encrypted file using the same method as with encrpytion.
 * 
 * @author Luka
 *
 */

public class Program {
	
	/**
	 * This is the program's main method. It creates two input streams to read the two files. One is the
	 * original file to be encrypted and the other is decrypted file that will be generated by using the same method 
	 * that is used on the original file to create the crypted file, only to create the decrypted file, that method will
	 * be used on the encrypted file.
	 * 
	 * @param args string of args that is never used
	 */
	
	public static void main(String[] args) {
		
		Path p1=Paths.get("C:/OOP/eclipse-neon/oop-lab5/racuni3/2003/1/Racun_0.txt");
		Path p2=Paths.get("C:/OOP/eclipse-neon/oop-lab5/encryption.txt");
		Path p3=Paths.get("C:/OOP/eclipse-neon/oop-lab5/decryption.txt");
		
		InputStream is1=null;
		InputStream is2=null;
		
		try {
			is1=new FileInputStream(p1.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			MyCriptByteWriter mcbw1=new MyCriptByteWriter(is1, p2);
			mcbw1.run();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			is2=new FileInputStream(p2.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			MyCriptByteWriter mcbw2=new MyCriptByteWriter(is2, p3);
			mcbw2.run();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
