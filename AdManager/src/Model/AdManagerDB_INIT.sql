/* Author: Ny Tran */

DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Statuses;
DROP TABLE IF EXISTS Moderators;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Advertisements;

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

CREATE TABLE IF NOT EXISTS Users
(User_ID smallint unsigned not null auto_increment,
UsrFirst_Name varchar(20) not null,
UsrLast_Name varchar(20) not null,
constraint pk_users primary key(User_ID)
);

CREATE TABLE IF NOT EXISTS Moderators
(User_ID smallint unsigned not null,
constraint pk_moderators primary key (User_ID),
constraint fk_moderators_users foreign key (User_ID)
references Users (User_ID) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS Advertisements
(Advertisement_ID smallint unsigned not null auto_increment,
AdvTitle tinytext not null,
AdvDetails tinytext not null,
AdvDateTime DATETIME not null default now(),
Price decimal(15,2) not null,
User_ID smallint unsigned not null,
Moderator_ID smallint unsigned,
Category_ID varchar(3) not null,
Status_ID varchar(2) not null,
constraint pk_advertisements primary key(Advertisement_ID),
constraint fk_advertisements_users foreign key(User_ID)
references Users (User_ID) ON DELETE CASCADE,
constraint fk_advertisements_moderators foreign key(Moderator_ID)
references Moderators(User_ID) ON DELETE SET NULL,
constraint fk_advertisements_categories foreign key(Category_ID)
references Categories(Category_ID) ON DELETE RESTRICT,
constraint fk_advertisements_statuses foreign key(Status_ID)
references Statuses(Status_ID) ON DELETE RESTRICT
);

/* Data Population */


insert into Statuses(Status_ID,Status_Name)
values ('PN','Pending'),('AC','Active'),('DI','Disapproved');

insert into Categories(Category_ID, CatName)
values ('CAT', 'Cars and Trucks'), ('HOU', 'Housing'),
('ELC', 'Electronics'), ('CCA', 'Child Care');

insert into Users(User_ID, UsrFirst_Name,UsrLast_Name)
values (1, 'John','Smith'),(2, 'Ann','Jackson'),(3, 'Rania','Kale'),(4, 'Samir','Ali');

insert into Moderators(User_ID)
values (1),(2);

insert into Advertisements(AdvTitle, AdvDetails, AdvDateTime, Price, Category_ID, User_ID, Moderator_ID, Status_ID)
values ('2010 Sedan Subaru', '2010 sedan car in great shape for sale', '2017-02-10', 6000, 'CAT', 3, 1, 'AC'),
('Nice Office Desk', 'Nice office desk for sale', '2017-02-15', 50.25, 'HOU', 4, 2, 'AC'),
('Smart LG TV for $200 ONLY','Smart LG TV 52 inches! Really cheap!', '2017-03-15', 200, 'ELC', 3, NULL, 'PN'),
('HD Tablet for $25 only','Amazon Fire Tablet HD', '2017-03-20', 25, 'ELC', 4, NULL, 'PN');
