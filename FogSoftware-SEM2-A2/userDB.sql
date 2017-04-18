Drop table if exists user;

Create table user (
userID int primary key AUTO_INCREMENT,
email varchar(60) unique,
firstName varchar(60),
lastName varchar(60),
password varchar(255),
phone int not null,
admin boolean default false,
salt blob
);

insert into user (email, password, firstName, lastName, phone, salt) values ('test@test.dk','test','test','test',2210, null);