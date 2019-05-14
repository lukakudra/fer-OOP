package hr.fer.oop.lab4.prob2;

import java.util.NoSuchElementException;

/**
 * The class represents a demonstration method for the SimpleHashTable
 * 
 * @author Luka
 *
 */

public class HashTableTest {

	public static void main(String[] args) {
		// create collection:
		SimpleHashTable<String,Integer> examMarks = new SimpleHashTable<>(2);
		// fill data:
		examMarks.put("Ivana", Integer.valueOf(2));
		examMarks.put("Ante", Integer.valueOf(2));
		examMarks.put("Jasna", Integer.valueOf(2));
		examMarks.put("Kristina", Integer.valueOf(5));
		examMarks.put("Ivana", Integer.valueOf(5)); // overwrites old grade for Ivana
		
		// query collection:
		Integer kristinaGrade = examMarks.get("Kristina");
		System.out.println("Kristina's exam grade is: " + kristinaGrade); // writes: 5
		// What is collection's size? Must be four!
		System.out.println("Number of stored pairs: " + examMarks.size()); // writes: 4
		
		System.out.println();
		System.out.println("HashTable:");
		System.out.println(examMarks);
		
		System.out.println("Key \"Ivana\" found: " + examMarks.containsKey("Ivana"));
		System.out.println("Key \"Ivana123\" found: " + examMarks.containsKey("Ivana123"));
		System.out.println("Key \"Kristina\" found: " + examMarks.containsKey("Kristina"));
		
		System.out.println();
		
		System.out.println("Value \"2\" found: " + examMarks.containsValue(2));
		System.out.println("Value \"6\" found: " + examMarks.containsValue(6));
		System.out.println("Value \"5\" found: " + examMarks.containsValue(5));
		
		System.out.println();
		
		System.out.println("Removing \"Kristina\"");
		examMarks.remove("Kristina");
		System.out.println("Key \"Kristina\" found: " + examMarks.containsKey("Krisitna"));
		
		System.out.println();
		System.out.println("HashTable:");;
		System.out.println(examMarks);
		
        System.out.println("Is hash table empty: " + examMarks.isEmpty());
        System.out.println("Hash table current size is: " + examMarks.size());
        
        System.out.println();
		
		//testing with unwanted values of key and value
		examMarks.put(null, 5);
		examMarks.get(null);
		examMarks.put("Luka", null);
		
		try{
			examMarks.remove("NewLuka");
		} catch(NoSuchElementException exc) {
			System.err.println("ERROR: " + exc.getMessage());
		}
		System.out.println("HashTable:");
		System.out.println(examMarks);

	}

}
