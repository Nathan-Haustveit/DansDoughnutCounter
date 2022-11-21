DROP DATABASE IF EXISTS doughnut_counter_db;
CREATE DATABASE IF NOT EXISTS doughnut_counter_db;

USE doughnut_counter_db;

CREATE TABLE IF NOT EXISTS employees (
                                     id INT UNSIGNED AUTO_INCREMENT NOT NULL,
                                     name VARCHAR(50) NOT NULL,
                                     username VARCHAR(50) NOT NULL,
                                     password VARCHAR(255) NOT NULL,
                                     PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS types (
                                          id INT UNSIGNED AUTO_INCREMENT NOT NULL,
                                          type VARCHAR(50) NOT NULL,
                                          PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS productions (
                                   id INT UNSIGNED AUTO_INCREMENT NOT NULL,
                                   employee_id INT UNSIGNED NOT NULL,
                                   type_id INT UNSIGNED NOT NULL,
                                   amount INT,
                                   production_date DATE,
                                   PRIMARY KEY (id),
                                   FOREIGN KEY (employee_id) REFERENCES employees(id),
                                   FOREIGN KEY (type_id) REFERENCES types(id)
);