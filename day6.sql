create database testingdb;

create database testingdb;

use testingdb;

 create table members (
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

select * from committees;

insert into committees(name) values ('Jevaa'),('John'),('Pranesh'),('Joseph');

drop table committees;
select m.*,c.*
from members m
cross join committees c
on m.name=c.name;


create table employees(
    employee_id int auto_increment primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    department varchar(100),
    salary decimal(10, 2),
    hire_date date
);

insert into employees (first_name, last_name, department, salary, hire_date) values
('john', 'doe', 'sales', 50000.00, '2020-01-15'),
('jane', 'smith', 'marketing', 60000.00, '2019-08-20'),
('david', 'lee', 'engineering', 75000.00, '2021-03-10'),
('sarah', 'jones', 'hr', 55000.00, '2020-11-05'),
('michael', 'brown', 'finance', 70000.00, '2018-06-25'),
('emily', 'davis', 'sales', 52000.00, '2022-02-01'),
('kevin', 'wilson', 'marketing', 62000.00, '2021-09-18'),
('jessica', 'garcia', 'engineering', 80000.00, '2019-12-03'),
('brian', 'rodriguez', 'hr', 58000.00, '2020-07-12'),
('ashley', 'martinez', 'finance', 72000.00, '2018-10-30');
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

