package hexawareTraining.myTechShop.entities;
//OrderDetails Class:
//Attributes:
//• OrderDetailID (int)
//• Order (Order) - Use composition to reference the Order to which this detail belongs.
//• Product (Product) - Use composition to reference the Product included in the order detail.
//• Quantity (int)
//Methods:
//• CalculateSubtotal() - Calculate the subtotal for this order detail.
//• GetOrderDetailInfo(): Retrieves and displays information about this order detail.
//• UpdateQuantity(): Allows updating the quantity of the product in this order detail.
//• AddDiscount(): Applies a discount to this order detail.

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OrderDetails {
	
	private	int orderDetailId;
	private	Order order;
	private	Product product;
	private	int quantity;
	public OrderDetails(int orderDetailId, Order order, Product product, int quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public void calculateSubTotal() {
		
		
	}
	
	public String getOrdersDetailInfo() {
		return "----ORDER DETAILS INFORMATION----\n ORDER DETAIL ID : "+orderDetailId+"\n ORDER DETAILS : "+order.getOrderDetails()+
				"\n\n PRODUCT DETAILS : "+product.getProductDetails()+
				"\n Quantity : "+quantity;
	}
	
	public void updateQuantity() {
		System.out.println("ENTER THE ORDER ID : ");
		int inputID=scanner.nextInt();
		scanner.nextLine();
		
		if(inputID==orderDetailId) {
			
			System.out.println("ENTER THE NEW QUANTITY : ");
			int newQuantity=scanner.nextInt();
			quantity=newQuantity;
			
			System.out.println("QUANTITY HAVE BEEN UPDATED SUCCESSFULLY");
			
		}
		else {
			System.out.println("PRODUCT ID NOT FOUND RETRY WITH PROPER CREDENTIALS");
		}
		
	}
	
	
	
	
	

}
