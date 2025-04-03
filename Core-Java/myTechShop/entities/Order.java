package hexawareTraining.myTechShop.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//Orders Class:
//Attributes:
//• OrderID (int)
//• Customer (Customer) - Use composition to reference the Customer who placed the order.
//• OrderDate (DateTime)
//• TotalAmount (decimal)
//Methods:
//© Hexaware Technologies Limited. All rights www.hexaware.com
//• CalculateTotalAmount() - Calculate the total amount of the order.
//• GetOrderDetails(): Retrieves and displays the details of the order (e.g., product list and
//quantities).
//• UpdateOrderStatus(): Allows updating the status of the order (e.g., processing, shipped).
//• CancelOrder(): Cancels the order and adjusts stock levels for products.


public class Order {
	
  	private	int orderId;
  	
  	private	Customer customer;
  	
  	private LocalDate orderDate;
	
  	private	BigDecimal totalAmount;

	public Order(int orderId, Customer customer, LocalDate orderDate, BigDecimal totalAmount) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}
  	Scanner scanner = new Scanner(System.in);
  	
	public void calculateTotalAmount() {
		
	}
	
	public String getOrderDetails() {
			
			return "----ORDER DETAILS----\n ORDER ID : "+orderId+"\n CUSTOMER DETAILS : "+customer.getCustomerDetails()+"\n\n ORDER DATE : "+orderDate+
					"| Toatal Amount : "+totalAmount;
		}
	
	public void updateOrderDetails() {
		System.out.println("ENTER THE ORDER ID : ");
		int inputID=scanner.nextInt();
		scanner.nextLine();
		
		if(inputID==orderId) {
			mainLoop:
				while(true) {
					System.out.println("----UPDATING ORDER INFORMATION----");
					System.out.println("EDIT OPTIONS :\n1.ID\n2.CUSTOMER  DETAILS\n3.ORDER DATE\n4.TOTAL PRICE\nEXIT EDITING WINDOW\n>>>");
					int option=scanner.nextInt();
					scanner.nextLine();
					
					switch (option) {
					case 1: {
						
						System.out.println("ENTER NEW ORDER ID : ");
						int newID=scanner.nextInt();
						scanner.nextLine();
						orderId=newID;
					
						System.out.println("ORDER ID IS UPDATED SUCCESSFULLY");
						break;
					}
					
					case 2 :{
						customer.updateCustomerInfo();
						break;
						
					}
					
					case 3 :{
						System.out.println("ENTER NEW ORDER DATE (yyyy-MM-dd): ");
						String newDate=scanner.nextLine();
						//scanner.nextLine();
						orderDate=LocalDate.parse(newDate,  DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						System.out.println("ORDER DATE IS UPDATED SUCCESSFULLY");
						break;
						
					}
					
					case 4 :{
						System.out.println("ENTER NEW TOTAL AMOUNT : ");
						BigDecimal newTotalAmount=scanner.nextBigDecimal();
						//scanner.nextLine();
						totalAmount=newTotalAmount;
						System.out.println("TOTAL AMOUNT IS UPDATED SUCCESSFULLY");
						break;
						
					}
					
					default:
						break mainLoop;
					}
				}
		}
		
		else {
			System.out.println("PRODUCT ID NOT FOUND RETRY WITH PROPER CREDENTIALS");
		}
		
	
	}
	
	void cancelOrder() {
		// not sure about the implementation need to ask to niti
	}

}
