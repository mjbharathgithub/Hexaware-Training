create database testingdb;
 
use testingdb;
create  table members(
member_id int auto_increment,
name varchar(100),
primary key (member_id)
);
 
create table committees
(
committee_id int auto_increment,
name varchar(100),
primary key (committee_id)
);
 
insert into members(name) values('John'),('Jane'),('Mary'),('David'),('Amelia');
 
insert into committees(name) values('John'),('Mary'),('Amelia'),('Joe');
 
select * from members;
select * from committees;
 
-- select <column name from both the tables> from <table 1> inner/left/right join  table 2 on join_condition
 
select 
m.member_id,
m.name,
c.committee_id,
c.name
from 
members m
right join 
committees c on m.member_id = c.committee_id;

use firstdb;
drop table employees;
create table employees(
    employee_id int  primary key,
    employee_name varchar(255),
    department_id int,
    salary decimal(10, 2)
);

create table departments(
    department_id int  primary key,
    department_name varchar(100)
);
select employee_name, salary from employees
where salary > ( select max(salary) from employees
	where department_id = (select department_id from departments where department_name = 'HR')
);

SELECT employee_id, employee_name, salary
FROM employees
WHERE salary > ANY (
    SELECT salary FROM employees WHERE department_id = 3
);

select * from employees;

select * from employees where department_di in(select department_id from departments where department_name='HR' or department_name='Sales');

select * from employees
where department_id in ( select department_id from departments where department_name in ('Sales', 'HR') );

insert into employees (employee_id, employee_name, department_id, salary)
 values (1, 'John', 1,5000),
(2, 'Jane', 2,5000),
(3, 'Aliya', 1,5000),
(4, 'Preeti' ,1,5000),

(5, 'Shubham', 1,5000);

select * from employees;
select * from departments;
insert into departments
 values (1,'Sales'),(2,'Engineering'),(3,'HR'),(4,'Sales'),(5,'HR');
 
SELECT employee_name, salary 
FROM employees e
WHERE salary > (
    SELECT AVG(salary) 
    FROM employees 
    WHERE department_id = e.department_id
);
 
SELECT e.employee_name, e.salary, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
WHERE e.salary > (
    SELECT AVG(e2.salary)
    FROM employees e2
    WHERE e2.department_id = e.department_id
);


use firstdb;

select * from employees;
select * from departments;
update employees
set salary =11000 
where employee_id=3;


-- subquery in Mysql
select *  from employees where salary>(select avg(salary) from employees);

select * from employees e 
join (select avg(salary)  sal from employees) avg_salary
on e.salary>avg_salary.sal;

select d.department_name ,max(e.salary) "Max Salary"
from employees e
join departments d
on e.department_id=d.department_id
group by d.department_name;

select * from employees;
use firstdb;

select * from employees limit 5 offset 3;

desc employees;


alter table employees
add column department_name varchar(10);
select * from employees;

update employees
set department_name ='IT'
where employee_id=5;


-- multiple column multiple row type 
select employee_name as "Employee with maximum Salary", salary,department_name from employees
 where (department_name,salary) in (select department_name,max(salary) from employees group by(department_name));
 -- insert into employees(employee_id,department_name)
--  values (6,'Admin');
 
-- SELECT CONSTRAINT_NAME
-- FROM information_schema.TABLE_CONSTRAINTS
-- WHERE TABLE_SCHEMA = 'firstdb'
--   AND TABLE_NAME = 'employees'
--   AND CONSTRAINT_TYPE = 'PRIMARY KEY';
  
  
 
 -- delete   from employees where employee_id=6;
 
 -- single column multiple row type 
 
 
 
 select department_name from employees
 where department_name
 not in
    (select department_name from employees group by (department_name) having count(employee_name)>0);
 
-- co-related Subquery
select * from employees e1
where e1.salary> (select avg(salary) from employees e2 where e1.department_name=e2.department_name);

select department_name from employees
where (select count(employee_name))=0;
select 5 from employees where department_name = 'asdf';
