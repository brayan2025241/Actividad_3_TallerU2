# Actividad_3_TallerU2
#Base de Datos

drop database if exists Store_db_in5bv;
create database Store_db_in5bv;
use Store_db_in5bv;

create table Customers (
    customer_id int auto_increment,
    first_name varchar(50),
    last_name varchar(50),
    address varchar(100),
    status_customer int,
    primary key PK_customer_id (customer_id)
);

create table Users (
    user_id int auto_increment,
    username varchar(45),
    password_user varchar(45),
    email varchar(60),
    role_user varchar(45),
    status_user int,
    primary key PK_user_id (user_id)
);

create table Sales (
    sale_id int auto_increment,
    sale_date date,
    total decimal(10,2),
    status_sale int,
    customers_customer_id int,
    users_user_id int,
    primary key PK_sale_id (sale_id),
    constraint FK_customer_id foreign key (customers_customer_id)
        references Customers (customer_id),
    constraint FK_user_id foreign key (users_user_id)
        references Users (user_id)
);

create table Products (
    product_id int auto_increment,
    product_name varchar(60),
    price decimal(10,2),
    stock int,
    status_product int,
    primary key PK_product_id (product_id)
);

create table sale_details (
    sale_detail_id int auto_increment,
    quantity int,
    unit_price decimal(10,2),
    subtotal decimal(10,2),
    products_product_id int,
    sales_sale_id int,
    primary key PK_sale_detail_id (sale_detail_id),
    constraint FK_product_id foreign key (products_product_id)
        references Products (product_id),
    constraint FK_sale_id foreign key (sales_sale_id)
        references Sales (sale_id)
);

--Registros

-- ------------------------------------------------------------
-- 1. Customers (5)
-- ------------------------------------------------------------
INSERT INTO Customers (first_name, last_name, address, status_customer) VALUES
('John',    'Smith',    '123 Main St, New York, NY',       1),
('Emily',   'Johnson',  '456 Oak Ave, Los Angeles, CA',    1),
('Michael', 'Williams', '789 Pine Rd, Chicago, IL',        1),
('Sarah',   'Brown',    '321 Elm St, Houston, TX',         0),
('David',   'Jones',    '654 Maple Dr, Phoenix, AZ',       1);

-- ------------------------------------------------------------
-- 2. Users (5)
-- ------------------------------------------------------------
INSERT INTO Users (username, password_user, email, role_user, status_user) VALUES
('admin',    'admin123', 'admin@store.com',   'admin',    1),
('jseller',  'sell2024', 'john@store.com',    'seller',   1),
('eseller',  'sell2025', 'emily@store.com',   'seller',   1),
('mmanager', 'mgr2024',  'manager@store.com', 'manager',  1),
('dsupport', 'sup2024',  'support@store.com', 'support',  0);

-- ------------------------------------------------------------
-- 3. Products (5)
-- ------------------------------------------------------------
INSERT INTO Products (product_name, price, stock, status_product) VALUES
('HP Laptop 15"',        1250.00, 20, 1),
('Wireless Mouse',         35.00, 80, 1),
('Mechanical Keyboard',   120.00, 45, 1),
('LG Monitor 24"',        450.00, 15, 1),
('Bluetooth Headphones',   95.00, 60, 1);

-- ------------------------------------------------------------
-- 4. Sales (5)
-- ------------------------------------------------------------
INSERT INTO Sales (sale_date, total, status_sale, customers_customer_id, users_user_id) VALUES
('2024-01-10', 1285.00, 1, 1, 2),
('2024-01-25',  155.00, 1, 2, 3),
('2024-02-08',  450.00, 1, 3, 2),
('2024-03-14',  215.00, 0, 4, 4),
('2024-04-02',   95.00, 1, 5, 3);

-- ------------------------------------------------------------
-- 5. Sale details (5)
-- ------------------------------------------------------------
INSERT INTO sale_details (quantity, unit_price, subtotal, products_product_id, sales_sale_id) VALUES
(1, 1250.00, 1250.00, 1, 1),
(1,   35.00,   35.00, 2, 2),
(1,  120.00,  120.00, 3, 2),
(1,  450.00,  450.00, 4, 3),
(1,   95.00,   95.00, 5, 5);