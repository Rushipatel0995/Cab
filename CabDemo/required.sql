CREATE TABLE cab (cabid NUMBER PRIMARY KEY, name VARCHAR2 (20), pincode VARCHAR2(6));

INSERT INTO cab VALUES(1001,'Tata Indica','600157');
INSERT INTO cab VALUES(1002,'Mahindra','621312');
INSERT INTO cab VALUES(1003,'Sumo','612157');


//TO DO – INSERT few more mobile details.
CREATE TABLE cabcustomer(customerid NUMBER, name VARCHAR2(20), address VARCHAR2(30),phoneno VARCHAR2(12), regdate DATE, pin VARCHAR2(6));

CREATE SEQUENCE customer_sequence
START WITH 1;