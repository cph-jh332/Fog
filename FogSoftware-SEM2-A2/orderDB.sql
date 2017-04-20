DROP TABLE orders;

CREATE TABLE orders (
    orderID INT(11),
    userID INT(11),
    orderDate DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    orderTitle VARCHAR(100),
    PRIMARY KEY (orderID)
    #FOREIGN KEY (userID) REFERENCES user(userID)
);