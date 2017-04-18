Drop table if exists user;

Create table user (
userID int primary key AUTO_INCREMENT,
email varchar(60),
firstName varchar(60),
lastName varchar(60),
password varchar(60),
phone int,
admin boolean default false,
salt blob
);
