--1.Create the database named "TechShop"
   create database TechShop;

--2. Define the schema for the Customers, Products, Orders, OrderDetails and Inventory tables
based on the provided schema.

create table Customers(
  CustomerID int auto_increment primary key,
  FirstName varchar(300) not null,
  LastName varchar(300) not null,
  Email varchar(300) not null,
  Phone varchar(20) not null,
  Address varchar(300) not null
  ); 
  create table Products(
    ProductId int auto_increment primary key,
    ProductName varchar(300) not null,
    Description text not null,
    Price decimal(10,2) not null
    );
create table Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    TotalAmount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

create table OrderDetails (
    OrderDetailID int auto_increment primary key,
    OrderID int not null,
    ProductID int not null,
    Quantity int not null,
    foreign key (OrderID) references Orders(OrderID),
    foreign key (ProductID) references Products(ProductID)
);
create table Inventory (
    InventoryID int auto_increment primary key,
    ProductID int not null,
    QuantityInStock int not null,
    LastStockUpdate datetime default current_timestamp on update current_timestamp,
    foreign key (ProductID) references products(ProductID));

--3. Create an ERD (Entity Relationship Diagram) for the database.


--4. Insert at least 10 sample records into each of the following tables.Customers, Products, Orders, OrderDetails and Inventory.
insert into Customers (FirstName, LastName, Email, Phone, Address) values
('Arun', 'Kumar', 'arun.kumar@example.com', '91-9876543210', '12, MG Road, Chennai, Tamil Nadu'),
('Priya', 'Sundar', 'priya.sundar@example.com', '91-9988776655', '45, Anna Salai, Madurai, Tamil Nadu'),
('Vikram', 'Ramesh', 'vikram.ramesh@example.com', '91-9765432109', '78, Cross Street, Coimbatore, Tamil Nadu'),
('Deepa', 'Gopal', 'deepa.gopal@example.com', '91-9898989898', '101, Beach Road, Kanyakumari, Tamil Nadu'),
('Suresh', 'Nair', 'suresh.nair@example.com', '91-9654321098', '202, Temple Road, Thanjavur, Tamil Nadu'),
('Meena', 'Ravi', 'meena.ravi@example.com', '91-9543210987', '303, Market Street, Tiruchirappalli, Tamil Nadu'),
('Rajesh', 'Menon', 'rajesh.menon@example.com', '91-9432109876', '404, Lake View, Ooty, Tamil Nadu'),
('Anitha', 'Krishnan', 'anitha.krishnan@example.com', '91-9321098765', '505, Hill Top, Yercaud, Tamil Nadu'),
('Ganesh', 'Pillai', 'ganesh.pillai@example.com', '91-9210987654', '606, River Bank, Vellore, Tamil Nadu'),
('Shanthi', 'Murugan', 'shanthi.murugan@example.com', '91-9109876543', '707, Fort View, Dindigul, Tamil Nadu');

insert into Products (ProductName, Description, Price) values
('Laptop', 'High-performance laptop', 80000.00), 
('Smartphone', 'Latest smartphone model', 60000.00),
('Tablet', '10-inch tablet', 25000.00), 
('Headphones', 'Noise-canceling headphones', 12000.00), 
('Smartwatch', 'Fitness tracking smartwatch', 15000.00), 
('Camera', 'Digital camera', 40000.00),
('Printer', 'Wireless printer', 20000.00), 
('Monitor', '27-inch monitor', 28000.00),
('Keyboard', 'Mechanical keyboard', 8000.00),
('Mouse', 'Wireless mouse', 4000.00);

insert into Orders (CustomerID, TotalAmount) values
(1, 92000.00),
(2, 60000.00),
(3, 25000.00),
(4, 20000.00),
(5, 40000.00),
(6, 80000.00),
(7, 28000.00),
(8, 15000.00),
(9, 60000.00),
(10, 4000.00);

insert into OrderDetails (OrderID, ProductID, Quantity) values
(1, 1, 1),
(1, 4, 2),
(2, 2, 1),
(3, 3, 1),
(4, 7, 1),
(5, 6, 1),
(6, 1, 1),
(7, 8, 1),
(8, 5, 1),
(9, 2, 1);

insert into Inventory (ProductID, QuantityInStock) values
(1, 50),
(2, 100),
(3, 200),
(4, 150),
(5, 80),
(6, 60), (7, 120), (8, 90), (9, 250), (10, 300);
