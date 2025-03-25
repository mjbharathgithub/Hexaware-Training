package hexawareTraining;
import java.util.*;

class Student{
    String name;
    int rollNo;
    int[] marks;  
    int total;
    float average;

    Student(String name,int rollNo,int[] marks){
        this.name= name;
        this.rollNo= rollNo;
        this.marks= marks;
        
        calculateTotalAndAverage();
    }

    void calculateTotalAndAverage(){
        total=0;
        for(int mark : marks){
            total+= mark;
        }
        average= total/(float)marks.length;
    }

    void display(){
        System.out.println("\nName: " + name+"\nRoll No: " + rollNo+"\nMarks: ");
        for(int i=0;i<marks.length;i++){
        	System.out.println("Subject "+(i+1)+": "+marks[i]);
        }
        
        System.out.println("Total Marks: " + total+"\nAverage Marks: " + average);
        System.out.println("-------------------------");
    }
}

public class ReportCard{
    static ArrayList<Student> students= new ArrayList<>();
    static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Report Card Management =====\n1. Add Student Record\n2. Display All Records\n3. Search Student by Name\n4. Update Student Marks");
            System.out.println("5. Exit\nEnter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine();

            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                    
                case 2:
                    displayAll();
                    break;
                    
                case 3:
                    searchStudent();
                    break;
                    
                case 4:
                    updateMarks();
                    break;
                    
                case 5:
                    System.out.println("Exiting Report Card System. Thank you!");
                    break;
                    
                    
                default:
                    System.out.println("Invalid Choice. Try Again!");
            }
        } while(choice!=5);
    }

    static void addStudent() {
        
    	System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        int rollNo = sc.nextInt();
        
        int[] marks = new int[5];
        System.out.println("Enter Marks for 5 Subjects: ");
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject "+(i+1)+": ");
            marks[i] = sc.nextInt();
        
        }
        
        students.add(new Student(name,rollNo,marks));
        System.out.println("Student Record Added Successfully!");
    }

    static void displayAll(){
        if (students.isEmpty()){
            System.out.println("No Records Found!");
            return;
        }
        
        for(Student s :students){
            s.display();
            
        }
    }

    static void searchStudent() {
        System.out.print("Enter Student Name to Search: ");
        String searchName = sc.nextLine();
        boolean found= false;
        
        
        for (Student s : students) {
            if(s.name.equalsIgnoreCase(searchName)){
                s.display();
                found= true;
                break;
            }
        }
        if(!found){
            System.out.println("Student Not Found!");
        }
    }

    static void updateMarks() {
        System.out.print("Enter Roll No to Update Marks: ");
        int roll= sc.nextInt();
        boolean found= false;
        for (Student s: students) {
            
        	if(s.rollNo==roll){
                System.out.println("Enter New Marks for 3 Subjects:");
                
                
                for (int i=0;i<5;i++) {
                    System.out.print("Subject "+(i+1)+": ");
                    s.marks[i]=sc.nextInt();
                }
                
                s.calculateTotalAndAverage();
                System.out.println("Marks Updated Successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with Roll No " + roll + " Not Found!");
        }
    }
}
