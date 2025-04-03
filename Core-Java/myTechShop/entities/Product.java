package hexawareTraining.myTechShop.entities;

import java.math.BigDecimal;
import java.util.Scanner;

//
//Products Class:
//Attributes:
//• ProductID (int)
//• ProductName (string)
//• Description (string)
//• Price (decimal)
//Methods:
//• GetProductDetails(): Retrieves and displays detailed information about the product.
//• UpdateProductInfo(): Allows updates to product details (e.g., price, description).
//• IsProductInStock(): Checks if the product is currently in stock.

public class Product {
	
 	private	int productId;
 	private	String productName,description;
 	private	BigDecimal price;
 	Scanner scanner = new Scanner(System.in);
	
	public Product(int productId, String productName, String description, BigDecimal price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
	}
	
	
	public String getProductDetails() {
		
		return "----Product Details----\n PRODUCT ID : "+productId+"| PRODUCT NAME : "+productName+"| DESCRIPTION : "+description+"| PRICE : "+price;
	}
	
	public void updateProductInfo() {
		System.out.println("ENTER THE PRODUCT ID : ");
		int inputID=scanner.nextInt();
		scanner.nextLine();
		
		if(inputID==productId) {
			mainLoop:
				while(true) {
					System.out.println("----UPDATING PRODUCT INFORMATION----");
					System.out.println("EDIT OPTIONS :\n1.ID\n2.PRODUCT NAME\n3.DESCRIPTION\n4.PRICE\nEXIT EDITING WINDOW\n>>>");
					int option=scanner.nextInt();
					scanner.nextLine();
					
					switch (option) {
					case 1: {
						
						System.out.println("ENTER NEW PRODUCT ID : ");
						int newID=scanner.nextInt();
						scanner.nextLine();
						productId=newID;
					
						System.out.println("PROCUT ID IS UPDATED SUCCESSFULLY");
						break;
					}
					
					case 2 :{
						System.out.println("ENTER NEW PRODUCT NAME : ");
						String newProductName=scanner.nextLine();
						//scanner.nextLine();
						productName=newProductName;
						System.out.println("PRODUCT NAME IS UPDATED SUCCESSFULLY");
						break;
						
					}
					
					case 3 :{
						System.out.println("ENTER NEW PRODUCT DESCRIPTION : ");
						String newDescription=scanner.nextLine();
						//scanner.nextLine();
						description=newDescription;
						System.out.println("PRODUCT DESCRIPTION IS UPDATED SUCCESSFULLY");
						break;
						
					}
					
					case 4 :{
						System.out.println("ENTER NEW PRODUCT PRICE : ");
						BigDecimal newPrice=scanner.nextBigDecimal();
						//scanner.nextLine();
						price=newPrice;
						System.out.println("PRODUCT PRICE IS UPDATED SUCCESSFULLY");
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
	
	public boolean isProductInStock() {
		return true;// not sure about the implementations maybe need db
	}

}
