package hr.fer.oop.lab5.second;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * This class writes all the articles found in the subtree in two txt files. One with
 * ISO-8859-2 encoding and the other with UTF-8 encoding.
 * 
 * @author Luka
 *
 */

public class Program {
	
	/**
	 * This is the program's main method. It uses the visitor from MySecondByteReader to walk the 
	 * file tree and write all the articles in a collection. It then uses two buffered readers to 
	 * write that collection to two different txt files according to their paths. Txt files differ 
	 * by the encoding of the strings in them.
	 * 
	 * @param args string arguments that are never used
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		
		Path p1=Paths.get("C:/OOP/eclipse-neon/oop-lab5/racuni3");
		Path p2=Paths.get("C:/OOP/eclipse-neon/oop-lab5/cjenik.88592.txt");
		Path p3=Paths.get("C:/OOP/eclipse-neon/oop-lab5/cjenik.utf8.txt");
		
		MySecondByteReader visitor=new MySecondByteReader();
		try {
			Files.walkFileTree(p1, visitor);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		BufferedWriter bw1=new BufferedWriter(
			new OutputStreamWriter(
			new BufferedOutputStream(
			new FileOutputStream(p2.toString())), "ISO-8859-2"));
		
		BufferedWriter bw2=new BufferedWriter(
				new OutputStreamWriter(
				new BufferedOutputStream(
				new FileOutputStream(p3.toString())), "UTF-8"));
		
		Artikl[] arts=visitor.articles.toArray(new Artikl[0]);
		for(Artikl a : arts) {
			String ar=a.toString();
			try {
				bw1.write(ar);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			try {
				bw2.write(ar);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		try {
			bw1.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			bw2.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}	
