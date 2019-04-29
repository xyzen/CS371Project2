DROP TABLE IF EXISTS Advertisements;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Statuses;
DROP TABLE IF EXISTS Moderators;

CREATE TABLE IF NOT EXISTS Categories
(Category_ID varchar(3) not null,
CatName varchar(20) not null,
constraint pk_categories primary key (Category_ID)
);

CREATE TABLE IF NOT EXISTS Statuses
(Status_ID varchar(2) not null,
Status_Name varchar(20) not null,
constraint pk_statuses primary key(Status_ID)
);