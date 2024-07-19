CREATE DATABASE calculator;

USE calculator;

CREATE TABLE calculations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    operation VARCHAR(20) NOT NULL,
    num1 DECIMAL(10, 2) NOT NULL,
    num2 DECIMAL(10, 2) NOT NULL,
    result DECIMAL(10, 2) NOT NULL
);
