Drop table if exists orderDetails, materials, orders, user;

Create table user (
userID int primary key AUTO_INCREMENT,
email varchar(60) unique not null,
firstName varchar(60) not null,
lastName varchar(60) not null,
password varchar(255) not null,
phone int not null,
admin boolean default false,
salt blob not null
);

CREATE TABLE orders (
    orderID INT(11) primary key,
    userID INT(11) not null,
    orderDate DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    orderTitle VARCHAR(100) not null,
    width int(11) not null,
    length int(11) not null,
    hasCalled bool,
    customerConfirmed bool,
    FOREIGN KEY (userID) REFERENCES user(userID)
);

CREATE TABLE materials (
	materialID int primary key,
    materialName varchar(60) not null
);

CREATE TABLE orderDetails (
	orderID int not null,
    materialID int not null,
    amount int not null,
    FOREIGN KEY (orderID) REFERENCES orders(orderID),
    FOREIGN KEY (materialID) REFERENCES materials(materialID)
);

