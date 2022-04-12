CREATE DATABASE Products;
use Products;
CREATE TABLE Category
(
    Id   int not null primary key AUTO_INCREMENT,
    name nvarchar(255)
);
INSERT INTO Category (name)
values ('Ip5'),
       ('Ip6'),
       ('Ip7'),
       ('Ip8');
CREATE TABLE Product
(
    Id          int not null primary key AUTO_INCREMENT,
    name        nvarchar(255),
    price       double,
    quantity    int,
    color       nvarchar(255),
    describtion nvarchar(5000),
    idC         int,
    FOREIGN KEY (idC) references Category (Id)
);
INSERT INTO Product(name, price, quantity, color, describtion, idC)
VALUES ('Ip5s', 2000000, 50, 'đen', ' Ai Phôn đen 5s', 1),
       ('Ip6s', 6000000, 10, 'trắng', 'Ai phôn 6 sờ màu trắng ', 2);
SELECT *
FROM Product;
SELECT *
FROM Category;
SELECT P.Id          as 'Id',
       P.name        as 'name',
       P.price       as 'price',
       P.quantity    as 'quantity',
       P.color       as 'color',
       P.describtion as 'description',
       P.idC         as 'idC',
       C.name        as 'nameCategory'
FROM Product P
         join Category C on C.Id = P.idC;
SELECT * FROM Product where name =?;
# DROP DATABASE Products;