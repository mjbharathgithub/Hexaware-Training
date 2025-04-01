package hexawareTraining.encapsulationPractice;
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
class Employee{
	
	private String employeeId, employeeName,phoneNumber,doucuments,jobDescription;
	
	private BigDecimal salary;
 
	public Employee(String employeeID, String employeeName, String phoneNumber, String jobDescrption) {
		super();
		this.employeeId=employeeID;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.jobDescription=jobDescrption;
		
		jobDescrption=jobDescrption.toLowerCase();
		switch (jobDescrption) {
		case "hr": {
			
			salary=new BigDecimal("30000");
			break;
		}
		
		case "it": {
					
					salary=new BigDecimal("50000");
					break;
				}
		
		case "admin": {
					
					salary=new BigDecimal("60000");
					break;
				}
		default:
			throw new IllegalArgumentException("Unexpected value: " + jobDescrption);
		}
	}
 
	public String getEmployeeId() {
		return employeeId;
	}
 
//	public void setEmployeeId(String employeeId) {
//		this.employeeId = employeeId;
//	}
 
	public String getEmployeeName() {
		return employeeName;
	}
 
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
 
	public String getPhoneNumber() {
		return phoneNumber;
	}
 
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
 
//	public String getDoucuments() {
//		return doucuments;
//	}
//
//	public void setDoucuments(String doucuments) {
//		this.doucuments = doucuments;
//	}
 
	public String getJobDescription() {
		return jobDescription;
	}
 
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
 
	public BigDecimal getSalary() {
		return salary;
	}
 
//	public void setSalary(BigDecimal salary) {
//		this.salary = salary;
//	}
	
	
	
}
 
public class EmployeeManger {
	static List<Employee> employees = new ArrayList<>();
	static	Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		mainLoop:
		while(true) {
			System.out.println("1.Add Employee\n2.View Employees\n3.Change Employee Name\n4.Change employee number\n5.Exit");
			int option= scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1: {
				
				addEmployee();
				break;
			}
			
			case 2:{
				viewEmployees();
				break;
			}
			
			case 3:{
				changeEmployeeName();
				break;
			}
			
			case 4:{
				changeEmployeeMoibleNumber();
				break;
			}
			default:
//				System.out.println("Program ended successfully");
				throw new IllegalArgumentException("UProgram ended successfully");
			}
		}
 
	}
	
	static	void addEmployee() {
		
		System.out.println("Enter your Document submission status\n(yes or no): ");
		String status=scanner.nextLine();
		if(status.equalsIgnoreCase("yes")) {
			System.out.println("Enter your employee ID : ");
			String empID=scanner.nextLine();
			System.out.println("Enter your name : ");
			String name=scanner.nextLine();
			System.out.println("Enter your mobile number : ");
			String mobile=scanner.nextLine();
			System.out.println("Enter your Job Descrption\noptions [HR, IT, Accounts]");
			String jobDescription=scanner.nextLine();
		
			employees.add(new Employee(empID,name,mobile,jobDescription));
		}
		else {
			System.out.println("You cannot add employee since the documents are yet to be submitted");
		}
		
	}
	
	static void viewEmployees() {
		System.out.println("-------Employee Details-------");
		for(Employee emp: employees) {
			System.out.println("Employee ID : "+ emp.getEmployeeId()+" | Employee Name : "+emp.getEmployeeName()+"| Employee Job Description : "+emp.getJobDescription()
			+"| Employee Salary : "+emp.getSalary()+"| Mobile number : "+emp.getPhoneNumber());
			
		}
	}
	
	static void changeEmployeeName() {
		System.out.println("Enter Employee ID");
		String empIDString=scanner.next();
		for(Employee emp: employees) {
			if(emp.getEmployeeId().equals(empIDString)) {
				System.out.println("Enter Employee New Name : ");
				String newNameString=scanner.next();
				emp.setEmployeeName(newNameString);
				System.out.println("Employee Name modifies successfully");
				return;
			}
		}
		System.out.println("Employee ID not found so can't change the Name");
	}
	static void changeEmployeeMoibleNumber() {
		System.out.println("Enter Employee ID");
		String empIDString=scanner.next();
		for(Employee emp: employees) {
			if(emp.getEmployeeId().equals(empIDString)) {
				System.out.println("Enter Employee new Mobile number : ");
				String newMobileNumber=scanner.next();
				emp.setPhoneNumber(newMobileNumber);
				System.out.println("Employee number modifies successfully");
				return;
				
			}
		}
		System.out.println("Employee ID not found so can't change the MoblieNumber");
	}
}
