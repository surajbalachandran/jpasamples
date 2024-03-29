DROP TABLE IF EXISTS BOOK_CATEGORY;
DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS CONTENT;
DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS LINE_ITEM;
DROP TABLE IF EXISTS PREFERRED_CUSTOMER;
DROP TABLE IF EXISTS GOLD_CUSTOMER;
DROP TABLE IF EXISTS CUSTOMER;
DROP TABLE IF EXISTS ADDRESS;

CREATE TABLE ADDRESS (
   ADDRESS_ID_PK INT,
   ADDRESS_1 VARCHAR(100),
   ADDRESS_2 VARCHAR(100),
   STATE VARCHAR(100),
   CITY VARCHAR(100),
   ZIP VARCHAR(10),
   VERSION INT,
   CREATE_USER VARCHAR(50),
   CREATE_TIME TIMESTAMP,
   UPDATE_USER VARCHAR(50),
   UPDATE_TIME TIMESTAMP
);

CREATE TABLE CUSTOMER (
   CUSTOMER_ID_PK INT,
   NAME VARCHAR(100),
   CUSTOMER_TYPE VARCHAR(100),
   PICTURE VARCHAR(100),
   ADDRESS_ID_FK INT,
   INCOME DECIMAL(12,2),
   BANK_NAME VARCHAR(100),
   ACCOUNT_NUMBER VARCHAR(100),
   ROUTING_NUMBER VARCHAR(100),
   VERSION INT,
   CREATE_USER VARCHAR(50),
   CREATE_TIME TIMESTAMP,
   UPDATE_USER VARCHAR(50),
   UPDATE_TIME TIMESTAMP,
   FOREIGN KEY (ADDRESS_ID_FK) REFERENCES ADDRESS(ADDRESS_ID_PK)
);

CREATE TABLE PREFERRED_CUSTOMER (
   CUSTOMER_ID_FPK INT,
   DISCOUNT_RATE DECIMAL(12,2),
   EXPIRATION_DATE TIMESTAMP,
   FOREIGN KEY (CUSTOMER_ID_FPK) REFERENCES CUSTOMER(CUSTOMER_ID_PK)
);

CREATE TABLE GOLD_CUSTOMER (
   CUSTOMER_ID_FPK INT,
   CARD_NUMBER VARCHAR(50),
   CREDIT_LIMIT DECIMAL(12,2),
   FOREIGN KEY (CUSTOMER_ID_FPK) REFERENCES CUSTOMER(CUSTOMER_ID_PK)
);

CREATE TABLE CATEGORY (
   CATEGORY_ID_PK INT,
   CATEGORY_NAME VARCHAR(50),
   PARENT_CATEGORY_FK INT,
   VERSION INT,
   CREATE_USER VARCHAR(50),
   CREATE_TIME TIMESTAMP,
   UPDATE_USER VARCHAR(50),
   UPDATE_TIME TIMESTAMP,
   FOREIGN KEY (PARENT_CATEGORY_FK) REFERENCES CATEGORY(CATEGORY_ID_PK)
);

CREATE TABLE BOOK (
   BOOK_ID_PK INT,
   ISBN VARCHAR(50),
   AUTHOR VARCHAR(50),
   TITLE VARCHAR(50),
   PRICE DECIMAL(12,2),
   RATING INT,
   VERSION INT,
   CREATE_USER VARCHAR(50),
   CREATE_TIME TIMESTAMP,
   UPDATE_USER VARCHAR(50),
   UPDATE_TIME TIMESTAMP
);

CREATE TABLE CONTENT (
   BOOK_ID_FPK INT,
   PDF BLOB,
   FOREIGN KEY (BOOK_ID_FPK) REFERENCES BOOK(BOOK_ID_PK)
);

CREATE TABLE BOOK_CATEGORY (
   BOOK_ID_FPK INT,
   CATEGORY_ID_FPK INT,
   FOREIGN KEY (BOOK_ID_FPK) REFERENCES BOOK(BOOK_ID_PK),
   FOREIGN KEY (CATEGORY_ID_FPK) REFERENCES CATEGORY(CATEGORY_ID_PK)
);

CREATE TABLE ORDERS (
   ORDER_ID_PK INT,
   CUSTOMER_ID_FK INT,
   PRICE DECIMAL(12,2),
   ORDER_TIME TIMESTAMP,
   STATUS VARCHAR(50),
   VERSION INT,
   CREATE_USER VARCHAR(50),
   CREATE_TIME TIMESTAMP,
   UPDATE_USER VARCHAR(50),
   UPDATE_TIME TIMESTAMP,
   FOREIGN KEY (CUSTOMER_ID_FK) REFERENCES CUSTOMER(CUSTOMER_ID_PK)
);

CREATE TABLE LINE_ITEM (
   LINE_ITEM_ID_PK INT,
   QUANTITY INT,
   PRICE DECIMAL(12,2),
   BOOK_ID_FK INT,
   ORDER_ID_FK INT,
   VERSION INT,
   CREATE_USER VARCHAR(50),
   CREATE_TIME TIMESTAMP,
   UPDATE_USER VARCHAR(50),
   UPDATE_TIME TIMESTAMP,
   FOREIGN KEY (ORDER_ID_FK) REFERENCES ORDERS(ORDER_ID_PK)
);
