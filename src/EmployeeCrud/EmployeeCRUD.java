package EmployeeCrud;

import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD{

    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "priya@1126"; // MySQL password

    
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

   
    public static void addEmployee() {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO employees(name, salary, department) VALUES (?, ?, ?)")) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, dept);

            ps.executeUpdate();
            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public static void viewEmployees() {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM employees");
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("salary") + " | " +
                        rs.getString("department")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void updateEmployee() {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE employees SET name=?, salary=?, department=? WHERE id=?")) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Employee ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter New Department: ");
            String dept = sc.nextLine();

            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, dept);
            ps.setInt(4, id);

            ps.executeUpdate();
            System.out.println("Employee Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void deleteEmployee() {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE id=?")) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Employee ID to Delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Employee Deleted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n====== Employee DB App ======");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: updateEmployee(); break;
                case 4: deleteEmployee(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid Option!");
            }
        }
    }
}
