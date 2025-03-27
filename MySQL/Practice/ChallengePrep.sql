create schema practice;
use practice;

select * from information_schema.schemata; -- used to find schema details

select * from information_schema.tables where table_schema='practice'; -- find the table details in a specific db/schema

select * from information_schema.columns where table_schema='practice' and table_name='';  -- used to find column details in a schema->table

CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT,
    major VARCHAR(50)
);

create table library(
    student_id int,
    num_of_books int);

-- creating a table with existing one

drop table studentscopy;
create table studentsCopy as select concat(first_name,' ',last_name) full_name,age,major from students;

select * from studentscopy,students;

INSERT INTO students (first_name, last_name, age, major) VALUES
('Emily', 'Davis', 19, 'Biology'),
('Michael', 'Brown', 23, 'History'),
('Sophia', 'Wilson', 20, 'Chemistry'),
('Daniel', 'Garcia', 21, 'Economics'),
('Olivia', 'Rodriguez', 22, 'Psychology'),
('Matthew', 'Martinez', 18, 'Art'),
('Ava', 'Anderson', 24, 'Sociology'),
('Christopher', 'Thomas', 20, 'Music'),
('Isabella', 'Jackson', 23, 'Political Science'),
('Andrew', 'White', 19, 'English Literature'),
('Mia', 'Harris', 21, 'Environmental Science'),
('Joseph', 'Martin', 22, 'Philosophy'),
('Charlotte', 'Thompson', 18, 'Graphic Design'),
('David', 'Moore', 24, 'Civil Engineering'),
('Amelia', 'Young', 20, 'Marketing'),
('James', 'Allen', 23, 'Finance'),
('Abigail', 'King', 19, 'Journalism'),
('Benjamin', 'Wright', 21, 'Architecture'),
('Elizabeth', 'Scott', 22, 'Linguistics'),
('William', 'Green', 18, 'Theater');



-- alter 

desc students;
alter table students
add sample int;
select * from students;
alter table students
modify column sample varchar(255);

alter table students
rename column something to sample;

ALTER TABLE students
MODIFY COLUMN first_name VARCHAR(255)  NOT NULL;

ALTER TABLE students DROP Primary key;

alter table library
add constraint fk foreign key(student_id) references students(student_id);

alter table library
drop constraint fk;


-- Build in funcitons in mysql
select first_name,substring(first_name from 10 for 100) from students;

-- String functions in mysql
select length('sdfs***'),char_length('sdfs***');

select concat_ws(' space ','one','two','three');

select replace ('I am Bharath','Bharath','Batman'); -- the replace string and new string must be same i.e its case sensitive

select position('bharath' in 'I am Bharath'); -- no case sensitve based on 0 index

select locate('bharath','I am Bharath'); -- same as position

-- FORMAT(number, decimal_places, locale); important

SELECT FORMAT(1234567.89234324, 4, 'en_US'),FORMAT(1234567.89234324, 4, 'de_DE'), FORMAT(1234567.89234324, 4, 'fr_FR'),FORMAT(1234567.89234324, 4, 'en_IN');


-- math functions 

select round(234234.53934,2);

select truncate(234234.53934,3); -- used to remvoe decimals in this case 3 decimals

select mod(25,4);

select greatest(2,3,54,4,456,34) ,least(34,54,34,236,65);

select ceil(rand()*10); -- random range 1 - 10

select month(now());

select replace(date_format(current_timestamp(),'%W,%M' '%D ,%Y'),'',' ');

select adddate(date(now()) ,interval 10 day) , subdate(date(now()), interval 10 day) , datediff('2025-04-06', '2025-03-17') ;

select timestampdiff(month, '2024-01-01', '2025-03-27') as months_difference; -- important : TIMESTAMPDIFF(unit, datetime_expr1, datetime_expr2);

-- Control Functions
select first_name,if(age>=18,'Major','Minor') status from students;

select ifnull("string",'true') ,nullif('string','diff');

select * from students;
-- simple case

select first_name,age,
case  major
	when 'biology' then 'bio'
    when 'history' then 'His'
    else 'doNo'
 end as major_Status from students;
-- searched case


select first_name,age,
case  
	when age>=21 then 'major'
    when age<21 then 'minor'
    else 'doNo'
 end as status from students;

select coalesce(null,null,34,'afds');-- returns the first non null value output 34

select cast('-123' as signed),cast('-123' as unsigned), cast(434 as char); -- used to convert datatype


-- Window functions
select *,row_number() over(partition by major order by(age) desc) rowNum from students;
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    department VARCHAR(50),
    salary DECIMAL(10, 2),
    hire_date DATE
);

INSERT INTO employees VALUES
(1, 'Sales', 5000.00, '2022-01-15'),
(2, 'Sales', 6000.00, '2022-03-01'),
(3, 'Marketing', 5500.00, '2022-02-10'),
(4, 'Marketing', 7000.00, '2022-04-05'),
(5, 'HR', 4800.00, '2022-01-20'),
(6, 'HR', 6500.00, '2022-03-15'),
(7, 'Sales', 5200.00, '2022-05-01');

with EmployeesRank as (
select employee_id,
row_number() over (partition by department order by salary desc) "Rank in Each DEP"
 from employees
 )


select * from EmployeesRank;

-- indexes in mysql
show index from students;

create index sample on students(first_name);

alter table students
drop index sample;

-- un updatable view since concat function is used
create view full_name as (select concat(first_name,' ',last_name) name from students);


UPDATE full_name
SET name = 'Elza'
WHERE name = 'Elizabeth Scott';
select * from full_name,students;


-- transactions

start transaction;
update students
set age=20 where student_id=1;
savepoint age20;
update students
set age=100 where student_id=1;
savepoint ages;
-- rollback to savepoint age20;
rollback to savepoint ages;
delete from student where student_id=1;
rollback to savepoint age20;
commit;

select * from students;

select * from students;

-- stored procedures

delimiter $$

create procedure getIdReturnName(in id int,out name varchar(2550))
begin 
	select concat(first_name,' ',last_name) into name from students where student_id=id;
end$$
delimiter ;    
show procedure status where db='practice';
call getIdReturnName(5,@name);
select @name;


-- tasks revision from techShop


select o.orderId,concat(c.firstName,' ',c.lastName) Name,o.orderDate
from orders o
inner join customers c
on c.customerid=o.customerid;

select * from customers;

select * from products;

update products
set price=price-price/10;

use electronic_gadgets_shop;

-- 5
delete from orders where orderid=1;
delete from orderdetails where orderid=1;
insert into orders(customerid,orderdate,totalamount) values(2,now(),40000);
select * from orders;

select * from customers;
select * from products;
update customers
set phone='91-9876543654' ,address='12, GM Road, Chennai, Tamil Nadu'
where customerId=1;


update orders o
join (
    select od.OrderID, SUM(od.Quantity * p.Price) as total
    from orderdetails od
    join products p on od.ProductID = p.ProductID
    group by od.OrderID
) as calculated_total
on o.OrderID = calculated_total.OrderID
set o.TotalAmount = calculated_total.total;

update orders o
join 
( 	select od.orderid,sum(od.quantity*p.price) total from orderdetails od inner join products p on od.productid=p.productid group by od.orderid) as total_sum
on o.orderid=total_sum.orderid
set o.totalamout=total_sum.total;

select * from orderdetails;
select * from orders;
select od.OrderID, SUM(od.Quantity * p.Price) as total
    from orderdetails od
    join products p on od.ProductID = p.ProductID
    group by od.OrderID;
    
    select * from customers;
    
    alter table customers
    add column orderCount int default 0;
    
    update customers ct
    join(	select c.customerid,count(c.customerid) tot from customers c group by customerid) as customer_count
    on ct.customerid=customer_count.customerid
    set ct.orderCount=customer_count.tot;
    
    select concat(c.firstname,c.lastname) Name, o.* from customers c join orders o on c.CustomerID=o.CustomerID;
    
select concat(c.firstname,' ',c.lastname) Name, c.Email,c.Phone,c.Address,if(cGrp.count>0,'Purchased','Not Purchased') "Purchase status" 
from customers c
join (select count(customerid) count,customerid from orders group by customerid having count(customerid)>0) cGrp
on c.customerid=cGrp.customerid;

-- doubt to ask
with prd_count as
	(select od.productid prd_id,sum(od.quantity) sum_count from orderdetails od group by od.ProductID)
    
select p.productname name,prd_count.sum_count maxcount from products p
join prd_count
on p.productid=prd_count.prd_id
where prd_count.sum_count=(select max(sum_count) from prd_count );

select * from prd_count;

select concat(c.firstname,' ',c.lastname) Name, c.Email,c.Phone,c.Address,order_value.avg_order_value "Average Order value" from customers c
join (select  o.customerid cus_id,avg(TotalAmount) avg_order_value from orders o group by customerid) order_value
on c.customerid=order_value.cus_id;

select concat(c.firstname,' ',c.lastname) "Customer not ordered" from customers c
where c.customerid not in(select customerid from orders);
select * from customers;

select sum(quantity) "total items" from orderdetails;

select count(productid) "Total items Available for Sale" 
from products 
where productid in (select productid from inventory where quantityInStock >0);


