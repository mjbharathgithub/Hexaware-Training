package hexawareTraining.collectionsLearning;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student{
	public Student(String name,int age) {
		// TODO Auto-generated constructor stub
		super();
		this.name=name;
				this.age=age;
		
	}
	String name;
	int age;
	
	
}

public class StudentBatchManagerUsingMap {
		Scanner scanner = new Scanner(System.in);
//		int id;
		Map<Integer,Student> students= new HashMap<>();
	
	public void addStudent() {
		System.out.println("Enter Student ID : ");
		int id=scanner.nextInt();
		scanner.nextLine();
		if(students.containsKey(id)) {
			System.out.println("The Student ID is already Present\nExiting AddStudent Window...");
			return;
		}
		
		System.out.println("Adding Student\nEnter Student Name : ");
		String name =scanner.nextLine();
		System.out.println("Enter Age : ");
		int age=scanner.nextInt();
		scanner.nextLine();
		
		students.put(id, new Student(name, age));
		
		System.out.println("Student Added SuccessFully...");
		
		
	}
	
	public void deleteStudent() {
		
		System.out.println("Enter Student ID : ");
		int id=scanner.nextInt();
		scanner.nextLine();
		if(!students.containsKey(id)) {
			System.out.println("The Student ID is not Present\nExiting deleteStudent Window...");
			return;
		}
		Student student=students.get(id);
		System.out.println("Student : "+student.name+" is deleted Successfully");
		
		students.remove(id);
		
		System.out.println("Exiting deleteStudent Window...");
		
	}
	
	public void viewStudentByID() {
		System.out.println("Enter Student ID : ");
		int id=scanner.nextInt();
		scanner.nextLine();
		if(!students.containsKey(id)) {
			System.out.println("The Student ID is not Present\nExiting ViewStudent Window...");
			return;
		}
		Student student=students.get(id);
		System.out.println("Student Detail");
		
		System.out.println("Student Name : "+ student.name+" Student Age : "+student.age);
		
		
		System.out.println("Exiting ViewStudnet Window...");
		
	}
	
	public void viewAll() {
		
		System.out.println("Students Details");
		if(students.isEmpty()) {
			System.out.println("There are No studnets to view");
		}
		students.forEach((id,student)->System.out.println("Student ID : "+id+" Student Name : "+student.name+" Studnet Mark : "+student.age));;
	}
	
	public void clearAllStudents() {
		if(students.isEmpty()) {
			System.out.println("There are No studnets to clear\n");
			return;
		}
		System.out.println("Are you sure All the Records will be deleted\n(yes/no)");
		String option=scanner.next();
		if(option.equalsIgnoreCase("yes")) {
			students.clear();
			System.out.println("Students Details are Deleted Successfully ");
			return;
		}
		
		System.out.println("Students Details are not deleted\nExiting ClearALLStudents window...");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentBatchManagerUsingMap manager=new StudentBatchManagerUsingMap();
		int choice=5;
		mainLoop:
		while(true) {
			
//			try {
			System.out.println("Enter Options\n1.Add student\n2.Delete Student by ID\n3.View All Student\n4.ClearAll Studnets\n5.View Student By ID\nChoice : ");
//			try {
			 choice =manager.scanner.nextInt();
			manager.scanner.nextLine();
//			}catch (Exception e) {
//				// TODO: handle exception
//				System.out.println(e.getLocalizedMessage());
//				continue;
//			}
			
			switch (choice) {
			case 1: {
				
				manager.addStudent();
				break;
			}
			
			case 2:
				manager.deleteStudent();
				break;
				
			case 3:
				manager.viewAll();
				break;
				
			case 4:
				manager.clearAllStudents();
				break;
				
			case 5:
				manager.viewStudentByID();
				break;
				
			default:
				break mainLoop;
			}
			
		}

	}

}
