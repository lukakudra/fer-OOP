package hr.fer.oop.lab5.third;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests two methods from this package by using JUnit Tests.
 * 
 * @author Luka
 *
 */

public class TestOfFiles {
	
	/**
	 * This method tests if the sizes of the decrypted file and the original file are the same.
	 */
	
	@Test
	public void sizeIsEqual() {
		File fileToBeTested=new File("C:/OOP/eclipse-neon/oop-lab5/decryption.txt");
		File originalFile=new File("C:/OOP/eclipse-neon/oop-lab5/racuni3/2003/1/Racun_0.txt");
		long size1=fileToBeTested.length();
		long size2=originalFile.length();
		Assert.assertEquals(size1, size2);
	}
	
	/**
	 * This method tests if the actual content of the decrypted file and the original file is the same.
	 */
	
	@Test
	public void linesAreEqual() {
		Path p1=Paths.get("C:/OOP/eclipse-neon/oop-lab5/decryption.txt");
		Path p2=Paths.get("C:/OOP/eclipse-neon/oop-lab5/racuni3/2003/1/Racun_0.txt");
		List<String> list1 = null;
		List<String> list2 = null;
		
		try {
			list1=Files.readAllLines(p1, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			list2=Files.readAllLines(p2, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Assert.assertEquals(list1, list2);
	}
	
}
