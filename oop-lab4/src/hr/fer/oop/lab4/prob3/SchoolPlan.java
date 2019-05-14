package hr.fer.oop.lab4.prob3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * The class represents a demonstration for prob3
 * @author Luka
 *
 */

public class SchoolPlan {
	
	/**
	 * This is the main method. It demonstrates the use
	 * of Java Collection Framework as it uses Map, List, Set to
	 * summarise data of all students.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		HashMap<String, List<Integer>> students=new LinkedHashMap<>();
		System.out.println("Entering students, (END to end)");
		System.out.println("Enter student name and mark: ");
		inputParse(students, scan);
		scan.close();
		output(students);
	}
	
	/**
	 * This method asks the user to enter student names and marks with keyboard.
	 * Then, it stores them in HashMap.
	 * 
	 * @param students HashMap of students and their list of grades which will get
	 * 				   filled from the standard input
	 * @param scan scanner which is used to read data from standard input
	 */
	
	public static void inputParse(HashMap<String, List<Integer>> students, Scanner scan) {
		
		while(scan.hasNext()) {
			String string=scan.nextLine();
			if(string.equals("END")) {
				break;
			}
			
			String studentName;
			Integer studentMark;
			
			String[] data=string.split("\\s");
			studentName=data[0];
			studentMark=Integer.parseInt(data[1]);
			
			List<Integer> marks=students.get(studentName);
			
			if(marks==null) {
				marks=new ArrayList<>();
			}
			marks.add(studentMark);
			students.put(studentName, marks);
			
		}
	}
	
	/**
	 * This method generates a string representation of data stored in HashMap
	 * 
	 * @param students HashMap of students and their marks, which will be 
	 * 				   converted to their string representation
	 */
	
	public static void output(HashMap<String, List<Integer>> students) {
		
		for(Map.Entry<String, List<Integer>> student : students.entrySet()) {
			
			StringBuilder sb=new StringBuilder();
			String studentName=student.getKey();
			List<Integer> marks=student.getValue();
			
			int numOfGrades=marks.size();
			int sumOfGrades=0;
			
			sb.append("Student ").append(studentName).append("\n");
			sb.append("  Number of grades: ").append(numOfGrades).append("\n");
			sb.append("  Grades are: ");
			
			for(Integer mark : marks) {
				sumOfGrades+=mark;
				sb.append(mark).append(" ");
			}
			sb.append("\n");
			
			sb.append("  Different grades: ");
			
			Collections.sort(marks);
			Set<Integer> noDuplicates=new HashSet<>(marks);
			for(Integer mark : noDuplicates) {
				sb.append(mark).append(" ");
			}
			sb.append("\n");
			
			double mean;
			mean=(double)sumOfGrades/numOfGrades;
			sb.append("  Mean is: ").append(String.format("%.5f", mean)).append("\n");
			
			double standardDeviation;
			double sumOfSquares=0;
			
			for(Integer mark : marks) {
				sumOfSquares+=(mark-mean)*(mark-mean);
			}
			
			standardDeviation=Math.sqrt(sumOfSquares/numOfGrades);
			
			sb.append("  Standard deviation is: ").append(String.format("%.5f", standardDeviation)).append("\n");
			sb.append("\n");
			System.out.println(sb.toString());
			
		}
	}
}
