-- 1. Write an SQL query to retrieve the names and emails of all customers.
select concat(FirstName,' ',LastName) name ,Email from Customers;

-- 2. Write an SQL query to list all orders with their order dates and corresponding customer names.
SELECT t1.OrderID, t1.OrderDate,  concat(t2.FirstName,' ',t2.LastName)
from Orders t1
join Customers t2
on t1.CustomerID= t2.CustomerID;

-- 3. Write an SQL query to insert a new customer record into the "Customers" table. Include customer information such as name, email, and address.
insert into Customers (FirstName, LastName, Email, Phone, Address) 
 values ('Arun', 'Kumar', 'arun.kumar@example.com', '91-9876543210', '12, MG Road, Chennai, Tamil Nadu'),

-- 4. Write an SQL query to update the prices of all electronic gadgets in the "Products" table by increasing them by 10%.
update  Products set Price=Price+Price/10;

-- 5.Write an SQL query to delete a specific order and its associated order details from the "Orders" and "OrderDetails" tables. Allow users to input the order ID as a parameter.
select @@foreign_key_checks;
set foreign_key_checks= 0;
delete from orders where OrderID= @orderID;
delete from orderdetails where OrderID= @orderID;

-- 6. Write an SQL query to insert a new order into the "Orders" table. Include the customer ID, order date, and any other necessary information.
insert into Orders (CustomerID, TotalAmount) values (1, 92000.00);


7-- . Write an SQL query to update the contact information (e.g., email and address) of a specific customer in the "Customers" table. Allow users to input the customer ID and new contact.
update customers set Phone = '91-9426406429' where CustomerID=2;

-- 8. Write an SQL query to recalculate and update the total cost of each order in the "Orders" table based on the prices and quantities in the "OrderDetails" table.
update orders o
join (
    select od.OrderID, SUM(od.Quantity * p.Price) as total
    from orderdetails od
    join products p on od.ProductID = p.ProductID
    group by od.OrderID
) as calculated_total
on o.OrderID = calculated_total.OrderID
set o.TotalAmount = calculated_total.total;

-- 9. Write an SQL query to delete all orders and their associated order details for a specific
customer from the "Orders" and "OrderDetails" tables. Allow users to input the customer ID
as a parameter.
delete od
from orderdetails od
join orders o on od.OrderID = o.OrderID
where o.CustomerID = ?;

delete from orders where CustomerID = ?;

-- 10. Write an SQL query to insert a new electronic gadget product into the "Products" table,
including product name, category, price, and any other relevant details.
insert into products (ProductName, Description, Price) values (?, ?, ?);

-- 11. Write an SQL query to update the status of a specific order in the "Orders" table (e.g., from
"Pending" to "Shipped"). Allow users to input the order ID and the new status.
alter table orders add column status enum('pending', 'shipped');
update orders set Status = ? where OrderID = ?;


-- 12. Write an SQL query to calculate and update the number of orders placed by each customer
in the "Customers" table based on the data in the "Orders" table.
-- First, make sure Customers table has an OrderCount column
alter table customers add column OrderCount int default 0;

update customers c
join (
    select CustomerID, count(*) as OrderCount
    from orders
    group by CustomerID
) o on c.CustomerID = o.CustomerID
set c.OrderCount = o.OrderCount;
