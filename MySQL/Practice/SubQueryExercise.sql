
-- Subquery Exercises
-- 1. Find the names of employees who work in the same department as "John Doe".
select employee_name 
from employees 
where department_id = (
    select department_id 
    from employees 
    where employee_name = 'john doe'
);


-- 2. Find the average salary of employees who work in the HR department.
select avg(salary) 
from employees 
where department_id = (
    select department_id 
    from departments 
    where department_name = 'hr'
);

-- 3. List all customers who have placed more than 5 orders.
select customer_name 
from customers 
where customer_id in (
    select customer_id 
    from orders 
    group by customer_id 
    having count(order_id) > 5
);


-- 4. Retrieve the product name and price of the most expensive product.
select product_name, price 
from products 
where price = (select max(price) from products);


-- 5. Find employees who earn more than the average salary in their department.
select employee_name 
from employees e
where salary > (
    select avg(salary) 
    from employees 
    where department_id = e.department_id
);

-- 6. Get the names of customers who have never placed an order.
select customer_name 
from customers 
where customer_id not in (select customer_id from orders);

-- 7. List all employees who were hired after the average hire date of all employees.
select employee_name 
from employees 
where hire_date > (select avg(hire_date) from  employees);


-- 8. Find the total sales for each customer, using a subquery to get sales per order.
select customer_id, 
       (select sum(total_amount) from orders o where o.customer_id = c.customer_id) as total_sales
from customers c;


-- 9. Get the name of the supplier who provides the most expensive product.
select supplier_id 
from products 
where price = (select max(price) from products);

-- 10. Find departments where the maximum salary is greater than $50,000.
select department_id 
from employees 
group by department_id 
having max(salary) > 50000;



-- Correlated Subquery Exercises
-- 1. List all employees who earn more than the average salary in their department.
select employee_name 
from employees e
where salary > (
    select avg(salary) 
    from employees 
    where department_id = e.department_id
);

-- 2. Retrieve the product names that cost more than the average price of their product line.
select product_name 
from products p1
where price > (
    select avg(price) 
    from products p2 
    where p1.category_id = p2.category_id
);


-- 3. List customers who placed an order in the last 30 days.
select distinct customer_name 
from customers c
where exists (
    select 1 
    from orders o 
    where o.customer_id = c.customer_id 
      and o.order_date >= date_sub(current_date(), interval 30 day)
);

-- 4. Find employees who have more sales than the average sales of their department.


-- 5. List departments that have more than 3 employees.
select department_id 
from employees 
group by department_id 
having count(employee_id) > 3;

-- 6. Retrieve the customer names where the total amount of their orders exceeds $10,000.
select customer_name 
from customers c
where (select sum(total_amount) from orders o where o.customer_id = c.customer_id) > 10000;

-- 7. Find products where the price is higher than the average price of products in the same category.
select product_name 
from products p1
where price > (
    select avg(price) 
    from products p2 
    where p1.category_id = p2.category_id
);


-- 8. List suppliers that provide more than 3 products.
select supplier_id 
from products 
group by supplier_id 
having count(product_id) > 3;

-- 9. Find employees who have been hired after all other employees in their department.
select employee_name 
from employees e1
where hire_date > all (
    select hire_date 
    from employees e2 
    where e1.department_id = e2.department_id 
      and e1.employee_id != e2.employee_id
);

-- 10. List customers who have placed more orders than the average number of orders placed by all customers.
select customer_name 
from customers c
where (
    select count(*) 
    from orders o 
    where o.customer_id = c.customer_id
) > (
    select avg(order_count) 
    from (
        select count(*) as order_count 
        from orders 
        group by customer_id
    ) as subquery
);


-- Exercises Using IN, ANY, ALL, and EXISTS
-- 1. List all customers who have placed at least one order.
select customer_name 
from customers 
where customer_id in (select customer_id from orders);

-- 2. Find employees who earn more than any employee in the HR department.
select employee_name 
from employees 
where salary > any (
    select salary 
    from employees 
    where department_id = (select department_id from departments where department_name = 'hr')
);


-- 3. List products where the price is less than all prices of products in the "Electronics" category.
select product_name 
from products 
where price < all (
    select price 
    from products 
    where category_id = (select category_id from products where product_name = 'electronics')
);

-- 4. Retrieve employees who work in departments that are in "New York" or "Chicago".
select employee_name 
from employees 
where department_id in (
    select department_id 
    from departments 
    where location in ('new york', 'chicago')
);

-- 5. Find employees who earn more than all employees in the Sales department.
select employee_name 
from employees 
where salary > all (
    select salary 
    from employees 
    where department_id = (select department_id from departments where department_name = 'sales')
);

-- 6. List all products that have been ordered by at least one customer.
select product_name 
from products 
where product_id in (select product_id from order_details);
