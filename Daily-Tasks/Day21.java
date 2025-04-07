package hexawareTraining.collectionsLearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;


class Student implements Comparable<Student> {
	public Student(String name, int mark ,int age) {
		// TODO Auto-generated constructor stub
		super();
		this.name=name;
		this.mark=mark;
		this.age=age;
		
	}
	String name;
	int mark, age;
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return Integer.compare( this.mark,o.mark);
		//return 0;
	}
	
	public int getMark() {
        return mark;
    }
}

public class LearningCollections {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
//		Object arr[]= new Object[5];
//		
//		arr[0]=new Employee("Joseph",22);
//		arr[1]=new Employee("Pranes",22);
//		arr[2]=new Employee("Levi",22);
//		arr[3]=new Employee("Jevaa",22);
//		arr[4]=new Employee("Aadi",21);
//		
//		for(Object employee: arr) {
//			System.out.println(employee.age+" "+employee.age);
//		}
		
		List<Integer> linkedList= new LinkedList<>();
		for(int i=0;i<=20;i+=2) {
			linkedList.add(i);
		}
		
		System.out.println("Enter the number of elements to print : ");
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		scanner.nextLine();
		System.out.println(linkedList);
		for(int i=0;i<n;i++) {
		    System.out.print(linkedList.get(i)+" ");
			
		}
		System.out.println();
		Iterable<Integer> itr= linkedList;
		Iterator<Integer> iterator=itr.iterator(); 
		System.out.println(iterator);
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+ " ");
		}

		List<Student> list = new ArrayList<>();
		String nameString="Name1";
		for(int i=1;i<=30;i++) {
			list.add(new Student(nameString,(int) Math.ceil(Math.random()*100),43));
			nameString=nameString.substring(0,4)+i;
		}
		
		for(Student student : list) {
			System.out.println("Name : "+ student.name+" Marks : "+student.mark);	
		}
		
		Student deleted=list.remove(0);
		System.out.println("Deleted Student\n"+ deleted.name+" "+deleted.mark);
		
		list.add(new Student("NewStudent", 87,54));
		System.out.println("After adding student : ");
		list.forEach(student->System.out.println("Name : "+ student.name+" Marks : "+student.mark));
		
		System.out.println("Enter top N students : ");
		n= scanner.nextInt();
		scanner.nextLine();
		
		List<Student> topNStudents = list.stream()
                .sorted(Comparator.comparingInt(Student::getMark).reversed()).limit(n).collect(Collectors.toList());
		
		System.out.println("Top "+n+" Students marks are : ");
		
		topNStudents.forEach(student->System.out.println("Name : "+ student.name+" Marks : "+student.mark));
		
		


	
	}
}

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
