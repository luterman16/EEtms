CREATE SCHEMA IF NOT EXISTS test;  //создать схему если её нет

DROP TABLE IF EXISTS students;
CREATE TABLE students(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), surname VARCHAR(100), course_name VARCHAR(100));  //создать таблицу

INSERT INTO students(name, surname, course_name) VALUES ('QWE', 'QWE', 'QWE');
