-- Create database and use it
CREATE DATABASE CompanySchema;
USE CompanySchema;

-- Create tables for the company database

-- Employee Table
-- Create the 'department' table
CREATE TABLE department (
    dept_name VARCHAR(20) PRIMARY KEY,
    budget DECIMAL(12, 2) CHECK (budget > 0)
);

-- Create the 'employee' table
CREATE TABLE employee (
    emp_id INT NOT NULL PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    dept_name VARCHAR(20),
    salary DECIMAL(10, 2) CHECK (salary >= 30000),
    hire_date DATE,
    FOREIGN KEY (dept_name) REFERENCES department(dept_name) ON DELETE SET NULL
);

-- Project Table
CREATE TABLE project (
    proj_id INT NOT NULL PRIMARY KEY,
    proj_name VARCHAR(50),
    dept_name VARCHAR(20),
    budget DECIMAL(12, 2) CHECK (budget >= 10000),
    FOREIGN KEY (dept_name) REFERENCES department(dept_name)
);

-- Works On Table (Many-to-many relationship between Employee and Project)
CREATE TABLE works_on (
    emp_id INT,
    proj_id INT,
    hours_worked DECIMAL(5, 2) CHECK (hours_worked >= 0),
    PRIMARY KEY (emp_id, proj_id),
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
    FOREIGN KEY (proj_id) REFERENCES project(proj_id)
);

-- Insert sample data into Department
INSERT INTO department VALUES ('HR', 500000);
INSERT INTO department VALUES ('Finance', 1000000);
INSERT INTO department VALUES ('Engineering', 3000000);
INSERT INTO department VALUES ('Marketing', 700000);

-- Insert sample data into Employee
INSERT INTO employee VALUES (101, 'John Doe', 'Engineering', 120000, '2015-06-20');
INSERT INTO employee VALUES (102, 'Jane Smith', 'HR', 85000, '2018-02-15');
INSERT INTO employee VALUES (103, 'Alice Brown', 'Marketing', 95000, '2020-05-10');
INSERT INTO employee VALUES (104, 'Bob White', 'Finance', 105000, '2017-11-23');
INSERT INTO employee VALUES (105, 'Charlie Green', 'Engineering', 110000, '2016-03-12');

-- Insert sample data into Project
INSERT INTO project VALUES (1, 'Employee Management System', 'Engineering', 150000);
INSERT INTO project VALUES (2, 'Payroll System', 'Finance', 80000);
INSERT INTO project VALUES (3, 'Website Revamp', 'Marketing', 50000);
INSERT INTO project VALUES (4, 'HR Portal', 'HR', 60000);

-- Insert sample data into Works On
INSERT INTO works_on VALUES (101, 1, 40);
INSERT INTO works_on VALUES (102, 4, 30);
INSERT INTO works_on VALUES (103, 3, 35);
INSERT INTO works_on VALUES (104, 2, 50);
INSERT INTO works_on VALUES (105, 1, 45);

-- List the distinct departments in which employees work
SELECT DISTINCT dept_name
FROM employee;

-- List all employees ordered by their salary in descending order
SELECT * 
FROM employee
ORDER BY salary DESC;

-- Update the salary of employees in the "Engineering" department by 15%
UPDATE employee
SET salary = salary * 1.15
WHERE dept_name = 'Engineering';

-- Retrieve a list of employees along with their department budgets
SELECT employee.emp_name, employee.dept_name, department.budget 
FROM employee
INNER JOIN department
ON employee.dept_name = department.dept_name;

-- List all employees and the projects they work on, including those who are not assigned to any project
SELECT employee.emp_name, works_on.proj_id, works_on.hours_worked
FROM employee
LEFT JOIN works_on 
ON employee.emp_id = works_on.emp_id;

-- Create a view to display employees and their respective projects
CREATE VIEW employee_projects AS
SELECT employee.emp_name, project.proj_name, works_on.hours_worked
FROM employee
INNER JOIN works_on 
ON employee.emp_id = works_on.emp_id
INNER JOIN project
ON works_on.proj_id = project.proj_id;

-- Select all records from the employee_projects view
SELECT * FROM employee_projects;

-- Retrieve departments with a total budget greater than 1000000
SELECT dept_name, SUM(budget) AS total_budget
FROM department
GROUP BY dept_name
HAVING SUM(budget) > 1000000;

-- Drop a table
DROP TABLE employee_projects;

-- List employees who work more than 40 hours on any project
SELECT employee.emp_name, works_on.hours_worked, project.proj_name
FROM employee
JOIN works_on
ON employee.emp_id = works_on.emp_id
JOIN project
ON works_on.proj_id = project.proj_id
WHERE works_on.hours_worked > 40;

-- List all employees along with the name of the department they work in
SELECT employee.emp_name, employee.dept_name
FROM employee;

-- Retrieve employees who are working on a project with a budget greater than 50000
SELECT employee.emp_name, project.proj_name
FROM employee
INNER JOIN works_on 
ON employee.emp_id = works_on.emp_id
INNER JOIN project
ON works_on.proj_id = project.proj_id
WHERE project.budget > 50000;

-- Retrieve total hours worked by each employee on all projects
SELECT employee.emp_name, SUM(works_on.hours_worked) AS total_hours
FROM employee
INNER JOIN works_on
ON employee.emp_id = works_on.emp_id
GROUP BY employee.emp_name;
