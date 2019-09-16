DROP DATABASE IF EXISTS Student;

CREATE DATABASE Student;
USE Student;

CREATE TABLE Student (
studentId INT NOT NULL AUTO_INCREMENT,
firstName VARCHAR(30),
lastName VARCHAR(30),
fatherName VARCHAR(30),
emailId VARCHAR(30) UNIQUE,
studentClass INT,
age INT,
PRIMARY KEY(studentId)
);

select * from student;

