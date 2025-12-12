CREATE DATABASE librarydb;
USE librarydb;

CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100),
  author VARCHAR(100),
  isIssued BOOLEAN DEFAULT FALSE
);

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE issues (
  issueId INT AUTO_INCREMENT PRIMARY KEY,
  bookId INT,
  userId INT,
  issueDate DATE,
  returnDate DATE,
  fine DOUBLE,
  FOREIGN KEY (bookId) REFERENCES books(id)
);
