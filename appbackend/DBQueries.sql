create table category(
id IDENTITY,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active BOOLEAN,

constraint pk_category_id primary key(id)
);

insert into category (name,description,image_url,is_active) values ('Television','Description for Television','CAT_1.png',true);
insert into category (name,description,image_url,is_active) values ('Laptop','Description for Laptop','CAT_2.png',true);
insert into category (name,description,image_url,is_active) values ('Mobile','Description for Mobile','CAT_3.png',true);

create table user_detail(
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(50),
email VARCHAR(100),
contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY(id),
);


INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('Mohammed','sadam','ADMIN',true,'admin','ms@gmail.com','8888888888');
INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('Ragupathi','Mathiyalagan','SUPPLIER',true,'supplier','rm@gmail.com','9888888888');
INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('Mohammed','Barreth','SUPPLIER',true,'1234','mb@gmail.com','1888888888');

CREATE TABLE product(
id IDENTITY,
code VARCHAR(20),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(255),
unit_price DECIMAL(10,2),
quantity INT,
is_active BOOLEAN,
category_id INT,
supplier_id INT,
purchases INT DEFAULT 0,
views INT DEFAULT 0,
CONSTRAINT pk_product_id PRIMARY KEY(id),
CONSTRAINT fk_category_id FOREIGN KEY(category_id) REFERENCES category(id),
CONSTRAINT fk_supplier_id FOREIGN KEY(supplier_id) REFERENCES user_detail(id)

);

INSERT INTO product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PRODM123455','Iphone 7','Appele','Best Phone of Apple',32000,2,true,3,3);
INSERT INTO product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('PRODM123466','G-580','Lenovo','Best Laptop of Lenovo',36000,3,true,2,2);


















































