CREATE SCHEMA IF NOT EXISTS test;

DROP TABLE IF EXISTS employees;
CREATE TABLE employees(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), surname VARCHAR(100), course_name VARCHAR(100));

INSERT INTO employees(name, surname, course_name) VALUES ('QWE', 'QWE', 'QWE');

