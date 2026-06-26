package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.employee.model.Employee;
import com.employee.util.DBConnection;

public class EmployeeDAO {

    // Add Employee
    public void addEmployee(Employee emp) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "insert into employee values(?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, emp.getEmpId());
            ps.setString(2, emp.getEmpName());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getEmail());
            ps.setString(5, emp.getMobile());
            ps.setString(6, emp.getDepartment());
            ps.setString(7, emp.getDesignation());

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Employees
    public void viewEmployees() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select * from employee";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("\n---------------------------");

                System.out.println("ID : "
                        + rs.getInt("emp_id"));

                System.out.println("Name : "
                        + rs.getString("emp_name"));

                System.out.println("Salary : "
                        + rs.getDouble("salary"));

                System.out.println("Email : "
                        + rs.getString("email"));

                System.out.println("Mobile : "
                        + rs.getString("mobile"));

                System.out.println("Department : "
                        + rs.getString("department"));

                System.out.println("Designation : "
                        + rs.getString("designation"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Employee By ID
    public void searchEmployee(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "select * from employee where emp_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Employee Found");

                System.out.println("ID : "
                        + rs.getInt("emp_id"));

                System.out.println("Name : "
                        + rs.getString("emp_name"));

                System.out.println("Salary : "
                        + rs.getDouble("salary"));

            } else {

                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "delete from employee where emp_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Deleted Successfully");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}