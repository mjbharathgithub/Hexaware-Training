
-- FORENOON SESSION
create database employee;
use employee;
 
create table employee(id int , name varchar(30));
insert into employee values(1,'niti');
 
show databases;
 
use classicmodels;
 
show tables;
 
-- Aggregate functions used to perform  a calculation on multiple values and returns a single value 
-- the aggregate functions commonly used with Group By clause 

select avg(buyPrice) as AvgPrice from products;
select * from products;
select productline, avg(buyPrice) from products group by productline order by productline; 
-- scenario basis  count of products with their avg price
select productline , count(*)  , avg(buyprice) from products group by productline order by productline; 
-- COUNT (*) Counts all rows of a table, regardless of whether nulls or duplicate values occur
select count(*) as total_products from products;
-- scenario2  to get the total order value in descending order for each product (You may take product code or produ
select  productcode , sum(priceeach * quantityordered) total from orderdetails group by productcode order by total desc;
-- joins -   inner join ( which is common or matching records from both the tables , 
-- left join   -  all records from left table and matching records from the right table
-- right join  -- all records from right table and matching records from the left table
-- self join --   use to compare the records from the same table 
select  orderdetails.productcode , products.productname ,sum(priceeach * quantityordered) total 
from orderdetails 
inner join products 
using(productcode)
group by productcode 
order by total;
-- scenario3 -  To get the highest buy price from the products table:
select Max(buyPrice) highestprice from products;
-- scenario4 - To get the highest price as per  the productline
select productline, max(buyprice) as  maxbuyingprice from products group by  productline order by maxbuyingprice desc limit 1 ;
  select productline, max(buyprice) as  maxbuyingprice from products group by  productline order by Max(buyPrice) desc limit 1;
  select productline, max(buyprice) as  maxbuyingprice from products group by  productline having maxbuyingprice >86;


--Afternoon session

create database employee;
use employee;
 
create table employee(id int , name varchar(30));
insert into employee values(1,'niti');
 
show databases;
 
use classicmodels;
 
show tables;
 
-- Aggregate functions used to perform  a calculation on multiple values and returns a single value 
-- the aggregate functions commonly used with Group By clause 

select avg(buyPrice) as AvgPrice from products;
select * from products;
select productline, avg(buyPrice) from products group by productline order by productline; 
-- scenario basis  count of products with their avg price
select productline , count(*)  , avg(buyprice) from products group by productline order by productline; 
-- COUNT (*) Counts all rows of a table, regardless of whether nulls or duplicate values occur
select count(*) as total_products from products;
-- scenario2  to get the total order value in descending order for each product (You may take product code or produ
select  productcode , sum(priceeach * quantityordered) total from orderdetails group by productcode order by total desc;
-- joins -   inner join ( which is common or matching records from both the tables , 
-- left join   -  all records from left table and matching records from the right table
-- right join  -- all records from right table and matching records from the left table
-- self join --   use to compare the records from the same table 
select  orderdetails.productcode , products.productname ,sum(priceeach * quantityordered) total 
from orderdetails 
inner join products 
using(productcode)
group by productcode 
order by total;
-- scenario3 -  To get the highest buy price from the products table:
select Max(buyPrice) highestprice from products;
-- scenario4 - To get the highest price as per  the productline
select productline, max(buyprice) as  maxbuyingprice from products group by  productline order by maxbuyingprice desc limit 1 ;
  select productline, max(buyprice) as  maxbuyingprice from products group by  productline order by Max(buyPrice) desc limit 1;
  select productline, max(buyprice) as  maxbuyingprice from products group by  productline having maxbuyingprice >86;
 
-- String functions 
select concat("Niti" , ' ' , "Dwivedi") as fullname;
 
-- we can use if function
 
select * from products;
 
-- productline, qtyinstock
select productline,quantityinstock ,
concat(productline, if(quantityinstock is null," ", " ,"),
ifnull(quantityinstock , '0')) as product_qty from products;
 
select upper("NITI dwivedi");
select length("Niti Dwivedi");
 
 
-- string("string" , position) 
-- string("string" from position)
select substring("Niti Dwivedi" , -5);
-- string("string" position , length) 
-- string("string" from position for length) 
select substring("Niti Dwivedi" from -5 for 4);
 
select  format(12345.678 , 2);
 
-- scenario5 format the decimal places  and place , in and prefix as dollar
select productname, quantityinstock*buyprice stock_value from products;
Select productname, concat('$',format(quantityinstock * buyprice, 2 , 'de_DE')) 
as stock_value from products order by quantityinstock * buyprice;
 
update products set productname = replace(productname ,'Yamaha' , 'yama');
 
SET SQL_SAFE_UPDATES = 0;  -- it will restrict to update and delete the data
 

-- Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column. 
--  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.
 
-- Trim , ltrim and rtrim --  it will remove the spaces of a string -- if there is a space towards left and right
 
select rtrim('   Niti Dwivedi   ') word;
 
 
select productName from products where locate("skylights" , productdescription)>0;
 
select * from products;
-- sql is a language
-- locate() -- is used to finds the position of a substring within a string
 
select locate('sql' , "Hi all we all are learning sql which is a database",1);
 
select ascii('a');
 
select reverse("Niti DWivedi");
 
-- control flow functions -- a) CASE  b)  IF  
-- c) IFNULL  - return the first argument if it is not null , other wise returns the second argument
-- d) NULLIF - return null if the first argument is equal to the second argument otherwise returns the first argument
 
DELIMITER //
create procedure query1()
begin
Select productname, concat('$',format(quantityinstock * buyprice, 2 , 'de_DE')) 
  as stock_value from products order by quantityinstock * buyprice;
end //
DELIMITER ;
select * from customers;

-- scenario7 -  to sort the customers by state if the state is not null , or sort the country in case the state is null
select customername, state , country from customers 
order by (case when state is null then country else state end);
-- scenario8 -- display the sum where status wise as shipped , on hold , in process , resolved
select * from orders;
-- shipped  on hold    in process    resolved     cancelled   total 
select customernumber , customername , IF(state is NULL,'N/A' , state) state , country from customers;
SELECT 
    CASE WHEN status IS NULL THEN 'Total' ELSE status END AS status, 
    COUNT(*) AS total_count
FROM orders
GROUP BY status WITH ROLLUP;
 
select sum(case when status='Shipped' then 1 else 0 end)as shipped,
sum(case when status='On Hold' then 1 else 0 end)as hold,
sum(case when status='In Process' then 1 else 0 end)as process,
sum(case when status='cancelled' then 1 else 0 end)as cancel,
count(*) as totalorder
FROM Orders;
-- regular expressions 
-- to check wether a string contains digit or not
select "sql 4.0" regexp '\\d+';
  select "sql 4" regexp '\\d\.\\d';
  select productName from products where productname regexp '193\\d';
  select regexp_like("sql 4.0" , "\\d+\\.\\d+");
  select productName from products where  regexp_like(productname , '^\\d{4}');
  create table contacts (email varchar(20) , constraint email_validation 
  check(regexp_like(email,"^\\s+@\\s+\\.\\s+$")=1));
  -- \d - digit , \w -  word character , \s - whitespace includes space , a tab a new line ^ - beg of string $ end of the string
  select month(now()) as currentdate;
  select curdate() as cdate;
  select sysdate();
  select datediff('2025-03-20' , '1972-10-10') days;
  select extract(day from '2025-03-20')day;



create table sales(sales_employee varchar(50) not null ,
	fiscal_year int not null,
    sale decimal(14,2) not null);
drop table sales;
insert into sales(sales_employee, fiscal_year ,sale)values('a',2016 , 100),
('b',2017 , 100),
('c',2018 , 150),
('d',2019 , 110),
('e',2020 , 130),
('f',2021 , 140),
('a',2016 , 100),
('b',2017 , 100),
('c',2018 , 150),
('d',2019 , 110),
('e',2020 , 130),
('f',2021 , 140);
select * from sales;
select sum(sale) from sales;
select fiscal_year,sum(sale) from sales group by fiscal_year;

 
select fiscal_year , sales_employee, sale , sum(sale)  over(partition by fiscal_year) total_sales from sales;
select row_number() over(
order by productname) row_num, productname, msrp from products order by productname;
 
-- Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'over(order by productname) row_num, productname, msrp from products order by pro' at line 1
