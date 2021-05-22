CREATE SCHEMA IF NOT EXISTS test;

DROP TABLE IF EXISTS employees;
CREATE TABLE employees(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), surname VARCHAR(100), middlename VARCHAR(100), age INT, position VARCHAR(100), specialization VARCHAR (100));

INSERT INTO employees(name, surname, middlename, age, position, specialization) VALUES ('NAME', 'SURNAME', 'MNAME', 30, 'DOCTOR', 'TERAPEVT');

