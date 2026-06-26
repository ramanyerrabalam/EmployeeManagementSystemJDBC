package com.employee.main;

import java.util.Scanner;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        int choice;

        do {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {

            case 1:

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Mobile: ");
                String mobile = sc.nextLine();

                System.out.print("Enter Department: ");
                String department = sc.nextLine();

                System.out.print("Enter Designation: ");
                String designation = sc.nextLine();

                Employee emp = new Employee(
                        id,
                        name,
                        salary,
                        email,
                        mobile,
                        department,
                        designation);

                dao.addEmployee(emp);

                break;

            case 2:

                dao.viewEmployees();

                break;

            case 3:

                System.out.print("Enter Employee ID: ");
                int searchId = sc.nextInt();

                dao.searchEmployee(searchId);

                break;

            case 4:

                System.out.print("Enter Employee ID To Delete: ");
                int deleteId = sc.nextInt();

                dao.deleteEmployee(deleteId);

                break;

            case 5:

                System.out.println("Thank You!");

                break;

            default:

                System.out.println("Invalid Choice");
            }

        } while(choice != 5);

        sc.close();
    }
}