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
Price integer not null,
User_ID smallint unsigned not null,
Moderator_ID smallint unsigned not null,
Category_ID varchar(3) not null,
Status_ID varchar(2) not null,
constraint pk_advertisements primary key(User_ID),
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

insert into Users(UrsFirst_Name,UrsLast_Name)
values ('John','Smith'),('Ann','Jackson'),('Rania','Kale'),('Samir','Ali');

insert into Moderators(User_ID)
values ('0'),('1');


