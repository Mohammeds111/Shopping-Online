CREATE TABLE category (
	id  number(10)  NOT NULL,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active char(1));

ALTER TABLE category ADD (
  CONSTRAINT Category_pk PRIMARY KEY (ID));


CREATE SEQUENCE category_seq START WITH 1;


CREATE OR REPLACE TRIGGER category_add 
BEFORE INSERT ON category 
FOR EACH ROW
BEGIN
  SELECT category_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;