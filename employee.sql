Drop DATABASE IF EXISTS Employee;

CREATE DATABASE Employee;
USE Employee;

CREATE TABLE employeeDetails (
empId int NOT NULL AUTO_INCREMENT,
fullName varchar(30),
gender varchar(30) CHECK(gender IN('Male', 'Female', 'Other')),
emailId varchar(30) UNIQUE,
password varchar(30),
contactNo varchar(15),
organization varchar(30),
PRIMARY KEY(empId)
);

SELECT LAST_INSERT_ID() from employeeDetails;

select * from employeeDetails;
 
CREATE TABLE Vehicle (
empId int not null,
name varchar(30),
type varchar(30),
vehicle_number varchar(30),
identification varchar(100),
foreign key (empId) references employeeDetails(empId)
);

alter table Vehicle
Add index vehicleType(type);

select * from Vehicle;

create table pass (
vehicle_type varchar(20),
daily double,
monthly double,
yearly double
);


alter table employeeDetails
add imageUrl BLOB;

Insert into pass values('Cycle', 0.070, 1.39, 6.97),
('Bike', 0.14, 2.79, 13.95),
('Four_Wheeler', 0.28, 6.97, 48.81);


select * from employeeDetails where emailId = 'khushi@gmail.com';

Create table image (
imageUrl varchar(40),
emailId varchar(40)
);

select * from image;