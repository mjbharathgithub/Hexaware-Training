package hexawareTraining.myTechShop.entities;

import java.util.Scanner;

//
//Customers Class:
//Attributes:
//• CustomerID (int)
//• FirstName (string)
//• LastName (string)
//• Email (string)
//• Phone (string)
//• Address (string)
//Methods:
//• CalculateTotalOrders(): Calculates the total number of orders placed by this customer.
//• GetCustomerDetails(): Retrieves and displays detailed information about the customer.
//• UpdateCustomerInfo(): Allows the customer to update their information (e.g., email, phone, or
//address).


public class Customer {
	
	private int customerId;
	private String firstName, lastName, email, phone, adress;
	public Customer(int customerId, String firstName, String lastName, String email, String phone, String adress) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
	}
	Scanner scanner = new Scanner(System.in);
	
	
	public String getCustomerDetails() {
//		System.out.println("Enter the Customer ID : ");
//		int inputID=scanner.nextInt();
//		scanner.nextLine();
//		
//		for()
		
		return "----Customer Details----\nCustomer ID : "+customerId+"| First Name : "+firstName+"| Last Name : "+lastName+"| Email : "+email
				+"| Phone : "+phone+"| Adress : "+adress;
		
	}
	
	public int calculateTotalOrders() {
		return 0;// should implement think need to connect with db
	}
	
	
	public void updateCustomerInfo() {
		System.out.println("Enter the Customer ID : ");
		int inputID=scanner.nextInt();
		scanner.nextLine();
		
		if(inputID==customerId) {
			mainLoop:
				while(true) {
					System.out.println("----Updating Customer Information----");
					System.out.println("EDIT OPTIONS :\n1.ID\n2.FIRST NAME\n3.LAST NAME\n4.EMAIL\n5.PHONE NUMBER\n6.ADRESS\n7.EXIT EDITING WINDOW\n>>>");
					int option=scanner.nextInt();
					scanner.nextLine();
					
					switch (option) {
					case 1: {
						
						System.out.println("ENTER NEW CUSTOMER ID : ");
						int newID=scanner.nextInt();
						scanner.nextLine();
						customerId=newID;
					
						System.out.println("CUSTOMER ID IS UPDATED SUCCESSFULLY");
						break;
					}
					
					case 2 :{
						System.out.println("ENTER NEW CUSTOMER FIRST NAME : ");
						String newFirstName=scanner.nextLine();
						//scanner.nextLine();
						firstName=newFirstName;
						System.out.println("CUSTOMER FIRST NAME IS UPDATED SUCCESSFULLY");
						break;
						
					}
					
					case 3 :{
						System.out.println("ENTER NEW CUSTOMER LAST NAME : ");
						String newLastName=scanner.nextLine();
						//scanner.nextLine();
						lastName=newLastName;
						System.out.println("CUSTOMER LAST NAME IS UPDATED SUCCESSFULLY");
						break;
						
					}
					
					case 4 :{
						System.out.println("ENTER NEW CUSTOMER EMAIL : ");
						String newEmail=scanner.nextLine();
						//scanner.nextLine();
						email=newEmail;
						System.out.println("CUSTOMER  EMAIL IS UPDATED SUCCESSFULLY");
						break;
						
					}
					
					case 5 :{
						System.out.println("ENTER NEW CUSTOMER PHONE : ");
						String newPhone=scanner.nextLine();
						//scanner.nextLine();
						phone=newPhone;
						System.out.println("CUSTOMER  PHONE NUMBER IS UPDATED SUCCESSFULLY");
						break;
						
					}
					
					case 6 :{
						System.out.println("ENTER NEW CUSTOMER ADRESS  : ");
						String newAdress=scanner.nextLine();
						//scanner.nextLine();
						adress=newAdress;
						System.out.println("CUSTOMER  ADRESS IS UPDATED SUCCESSFULLY");
						break;
						
					}
					default:
						break mainLoop;
					}
				}
		}
		
		else {
			System.out.println("CUSTOMER ID NOT FOUND RETRY WITH PROPER CREDENTIALS");
		}
		
	
	}

}
