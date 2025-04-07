package hexawareTraining.collectionsLearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class SetPractice {
	
	public static void main(String[] args) {
//		HashSet<Student> set = new HashSet<>();
//		Scanner scanner = new Scanner(System.in);
//		mainLoop:
//		while(true) {
//			System.out.println("Enter student name : ");
//			String name=scanner.nextLine();
//			
//			System.out.println("Enter the mark");
//			int mark=scanner.nextInt();
//			scanner.nextLine();
//			
//			set.add(new Student(name, mark));
//			System.out.println("Do you like to continue (yes/no) :");
//			String choice=scanner.nextLine();
//			if(choice.equalsIgnoreCase("no")) break mainLoop;
//			
//		}
//		
//		set.forEach(student->System.out.println("Student Name :"+ student.name+" Student Mark : "+student.mark));
//		
//		LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>();
		TreeSet<Student> treeSet = new TreeSet<>();
//		
		
//		List<Student> treeSet= new ArrayList<>();
		
		treeSet.add(new Student("Joseph ", 90,22));
		treeSet.add(new Student("Bharath ", 34,23));
		treeSet.add(new Student("John ", 87,24));
		
		System.out.println("\nInsertion order : ");
		treeSet.forEach(student-> System.out.println("Name : "+student.name+" Mark : "+student.mark+" Age : "+student.age));
		System.out.println("\nComparable order : ");
//		Collections.sort(treeSet);
		treeSet.forEach(student-> System.out.println("Name : "+student.name+" Mark : "+student.mark+" Age : "+student.age));
		System.out.println("\nComparator Order : ");
		
//		Collections.sort(treeSet,(s1,s2)->s2.age-s1.age);
		treeSet.forEach(student-> System.out.println("Name : "+student.name+" Mark : "+student.mark+" Age : "+student.age));
		
		//treeSet.sort((student1,student2)->student1.mark-student2.mark);
		
//		arrayList.forEach(student-> System.out.println("Name : "+student.name+" Mark : "+student.mark));
		
		
//		applicants.sort((app1,app2)->app1.name-app2.name); //ascending
//		applicants.sort((app1,app2)->app2.name-app1.name); //descending
		
		
	}
}
