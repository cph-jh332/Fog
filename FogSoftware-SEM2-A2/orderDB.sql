#SELECT * FROM FogDB.orders;

DROP TABLE orders;

CREATE TABLE orders (
    orderID INT(11) primary key,
    userID INT(11),
    orderDate DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    orderTitle VARCHAR(100),
    width int(11),
    length int(11),
    FOREIGN KEY (userID) REFERENCES user(userID)
);