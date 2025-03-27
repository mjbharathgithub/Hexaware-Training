-- 1. Write an SQL query to find out which customers have not placed any orders.
select c.customerid, c.firstname, c.lastname, c.email
from customers c
where c.customerid not in (select distinct customerid from orders);

-- 2. Write an SQL query to find the total number of products available for sale. 
select count(productid) "Total items Available for Sale" 
from products 
where productid in (select productid from inventory where quantityInStock >0);

-- 3. Write an SQL query to calculate the total revenue generated by TechShop. 
select sum(totalamount) as total_revenue from orders;

-- 4. Write an SQL query to calculate the average quantity ordered for products in a specific category. Allow users to input the category name as a parameter.
select avg(od.quantity) as average_quantity
from orderdetails od
join products p on od.productid = p.productid
where p.description ='Latest smartphone model';

-- 5. Write an SQL query to calculate the total revenue generated by a specific customer. Allow users to input the customer ID as a parameter.
select sum(totalamount) as customer_revenue
from orders
where customerid = 1;

-- 6. Write an SQL query to find the customers who have placed the most orders. List their names and the number of orders they've placed.
select c.CustomerID, c.FirstName, c.LastName, count(o.OrderID) as order_count
from Customers c 
join Orders o on c.CustomerID = o.CustomerID
group by c.CustomerID, c.FirstName, c.LastName
order by order_count desc
limit 1;

-- 7. Write an SQL query to find the most popular product category, which is the one with the highest total quantity ordered across all orders.
select p.description as category, sum(od.quantity) as total_quantity
from orderdetails od
join products p on od.productid = p.productid
group by p.description
order by total_quantity desc
limit 1;

-- 8. Write an SQL query to find the customer who has spent the most money (highest total revenue) on electronic gadgets. List their name and total spending.
select c.firstname, c.lastname, sum(o.totalamount) as total_spent
from customers c
join orders o on c.customerID= o.customerID
group by c.customerID
having sum(o.totalamount) 
=( select max(total_spent) from (
        			select sum(totalamount) as total_spent  from orders group by customerid) as sub
);

-- 9. Write an SQL query to calculate the average order value (total revenue divided by the number of orders) for all customers.
select concat(c.firstname, ' ', c.lastname) as name, avg(o.totalamount) / count(o.orderid) as average_value
from customers c
join orders o on c.customerid=o.customerid
group by c.customerid;

-- 10. Write an SQL query to find the total number of orders placed by each customer and list their names along with the order count.
select concat(c.firstname,' ', c.lastname) Name, count(o.orderid) as order_count
from customers c
left join orders o on c.customerid = o.customerid
group by c.customerid;

