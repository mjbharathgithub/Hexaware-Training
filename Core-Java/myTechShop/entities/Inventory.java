package hexawareTraining.myTechShop.entities;
//
//InventoryID(int)
//• Product (Composition): The product associated with the inventory item.
//• QuantityInStock: The quantity of the product currently in stock.
//• LastStockUpdate

import java.time.LocalDateTime;

//GetProduct(): A method to retrieve the product associated with this inventory item.
//• GetQuantityInStock(): A method to get the current quantity of the product in stock.
//• AddToInventory(int quantity): A method to add a specified quantity of the product to the
//inventory.
//• RemoveFromInventory(int quantity): A method to remove a specified quantity of the product
//from the inventory.
//• UpdateStockQuantity(int newQuantity): A method to update the stock quantity to a new value.
//• IsProductAvailable(int quantityToCheck): A method to check if a specified quantity of the
//product is available in the inventory.
//• GetInventoryValue(): A method to calculate the total value of the products in the inventory
//based on their prices and quantities.
//• ListLowStockProducts(int threshold): A method to list products with quantities below a specified
//threshold, indicating low stock.
//• ListOutOfStockProducts(): A method to list products that are out of stock.
//© Hexaware Technologies Limited. All rights www.hexaware.com
//• ListAllProducts(): A method to list all products in the inventory, along with their quantities.


public class Inventory {
	
	private	int inventoryId, quantityInStock;
	private	Product product;
	
	private	LocalDateTime lastStockUpDateTime;
	

	public Inventory(int inventoryId, int quantityInStock, Product product, LocalDateTime lastStockUpDateTime) {
		super();
		this.inventoryId = inventoryId;
		this.quantityInStock = quantityInStock;
		this.product = product;
		this.lastStockUpDateTime = lastStockUpDateTime;
		
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int getQuantityInStock() {
		return quantityInStock;
	}
	
	public void addToInventory(int quantity) {
		
		quantityInStock+=quantity;
//		lastStockUpDateTime=LocalDateTime.now();
		System.out.println("Quantity Added to Inventory Successfully");
	}
	
	public void removeFromInventory(int quantity) {
			
			quantityInStock-=quantity;
//			lastStockUpDateTime=LocalDateTime.now();
			System.out.println("Quantity Removed from Inventory Successfully");
		}
	
	public void updateStockQuantity(int newQuantity) {
		quantityInStock+=newQuantity;
		lastStockUpDateTime=LocalDateTime.now();
		System.out.println("Stock is Updated Successfully");
	}
	
	public boolean isProductAvailable(int quantityToCheck) {
		if(quantityToCheck>quantityInStock) return false;
		
		return true;
	}
	
	public double getInventoryValue() {
		return 0; //may need db
	}
	//• GetInventoryValue(): A method to calculate the total value of the products in the inventory
	//based on their prices and quantities.
	
	public void listLowStockProducts(int threshold) {
		// need db
	}
	
//	ListLowStockProducts(int threshold): A method to list products with quantities below a specified
	//threshold, indicating low stock.
	
	public void listOutOfStockProducts() {
		// need db
	}
	
	
	public void listAllProducts() {
		// need db
	}
	
	

	

}
