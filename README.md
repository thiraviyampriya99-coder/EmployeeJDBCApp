# EmployeeJDBCApp

A simple Java JDBC application to manage employees with **Add, View, Update, Delete** functionality using MySQL.

---

## 🔹 Project Structure

EmployeeJDBCApp/
├── src/
│ └── EmployeeCrud/
│ └── EmployeeCRUD.java
├── lib/
│ └── mysql-connector-j-8.0.33.jar
├── database/
│ └── employee_db.sql
├── images/
│ └── output1.jpg




- `src/` → Java source files  
- `lib/` → MySQL JDBC driver  
- `database/employee_db.sql` → SQL setup file  
- `images/` → Console / SQL output screenshots  

---

## 🔹 Database Setup

1. Open MySQL Workbench / CLI
2. Run the SQL commands from `database/employee_db.sql`:

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    salary DOUBLE,
    department VARCHAR(100)
);
This will create the database and table needed for the app.

🔹 How to Run
1️⃣ Using Eclipse
Create a new Java project → EmployeeJDBCApp

Add src/ and lib/mysql-connector-j-8.0.33.jar to Build Path

Right click project → Build Path → Configure Build Path → Libraries → Add External JAR

Make sure folder structure matches package:

src/EmployeeCrud/EmployeeCRUD.java
Right click EmployeeCRUD.java → Run As → Java Application

2️⃣ Using CMD

javac -cp ".;lib/mysql-connector-j-8.0.33.jar" src/EmployeeCrud/EmployeeCRUD.java
java -cp ".;lib/mysql-connector-j-8.0.33.jar;src" EmployeeCrud.EmployeeCRUD
For Linux / Mac, replace ; with : in classpath

🔹 Menu Options

====== Employee DB App ======
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Choose Option:
Enter number to perform respective operation

🔹 Sample Output

Shows list of employees after running Add / View / Update / Delete

🔹 Notes
Make sure MySQL server is running before executing the program

Add / Update / Delete operations affect the employees table

All JDBC exceptions are handled with try-catch blocks in the code

🔹 Technologies Used
Java 21

Eclipse IDE 2025

MySQL 8.x

JDBC API

arduino
Copy code
