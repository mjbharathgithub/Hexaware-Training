package hexawareTraining;

import java.util.Arrays;
import java.util.Scanner;

import javax.net.ssl.SSLContext;

class Employee{
	String name;
	int employeeId;
	long salary;
	String allowance[];
	
	public Employee(String name,int employeeId,long salary) {
		// TODO Auto-generated constructor stub
		
		this.name=name;
		this.employeeId=employeeId;
		this.salary=salary;
		
		
	}
}


class SalaryProcessing{
	Employee[] employees;
	Scanner scanner = new Scanner(System.in);
	
	void addEmployee() {
		
		System.out.println("Enter The count of Employee");
		String name;
		int employeeId,numOfEmployees;
		long salary;
		
		numOfEmployees=scanner.nextInt();
		scanner.nextLine();
		employees = new Employee[numOfEmployees];
		
		for(int i=0;i<numOfEmployees;i++) {
			System.out.println("Enter the name of the Employee : ");
			name=scanner.nextLine();
			System.out.println("Enter the Employee ID : ");
			employeeId= scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Enter the Salary of Employeee");
			
			salary=	scanner.nextLong();
			
			employees[i]=new Employee(name, employeeId, salary);
			
		}
		System.out.println("The Employees Have been added to the management Successfully");
	}
	
	
	void viewEmployees() {
		
		System.out.println("Employees int the Management :");
		for(Employee emp: employees) {
			System.out.println(emp.employeeId+" "+ emp.name+" "+emp.salary);
		}
	}
	
	void viewEmployeeByID() {
			System.out.println("Enter the Employee ID to view : ");
			int empID=scanner.nextInt();
			for(Employee emp:employees) {
				if(emp.employeeId==empID) {
					System.out.println("Empoyee Details");
					System.out.println(emp.employeeId+" "+ emp.name+" "+emp.salary);
					return;
				}
			}
			System.out.println("Employee Not found try again with proper employee ID");
		}
		
	void updateEmployeeSalary() {
		
		System.out.println("Enter the Employee ID to Update Salary : ");
		int empID=scanner.nextInt();
		for(Employee emp:employees) {
			if(emp.employeeId==empID) {
				System.out.println("Enter new Salary for employee : "+emp.employeeId+" "+emp.name);
				long newSalary=scanner.nextLong();
				
				emp.salary=newSalary;
				System.out.println("Employee Detail updated Successfully");
				return;
			}
		}
		System.out.println("Employee Not found try again with proper employee ID");
	}
	
		void deleteEmployee() {
				
				System.out.println("Enter the Employee ID to Delete Salary : ");
				int empID=scanner.nextInt();
				for(Employee emp:employees) {
					if(emp.employeeId==empID) {
		//				System.out.println("Enter new Salary for employee : "+emp.employeeId+" "+emp.name);
						//long newSalary=scanner.nextLong();
						
						//emp.salary=newSalary;
						emp=null;
						System.out.println("Employee is deleted  Successfully");
						return;
					}
				}
				System.out.println("Employee Not found try again with proper employee ID");
			}
}

public class OOPsTraining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		SalaryProcessing company = new SalaryProcessing();
		int choiceString;
		mainLoop:
			while(true) {
				System.out.println("Enter your Option:\n1.AddEmployees\n2.View Employees\n3.View Employee by id\n4.Update Employee salary Structure\n5.Delete employee\n6.Exit");
				choiceString=scanner.nextInt();
				
				switch (choiceString) {
				case 1:
				{
					
					company.addEmployee();
					break;
				}
				case 2:{
					company.viewEmployees();
					break;
				}
				case 3:{
					company.viewEmployeeByID();
					break;
				}
				
				case 4:{
					company.updateEmployeeSalary();
					break;
				}
				
				case 5:{
					company.deleteEmployee();
					break;
				}
			
				default:
					break mainLoop;
					
					
				}
			}

			}
	}

