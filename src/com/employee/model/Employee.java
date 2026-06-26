package com.employee.model;

public class Employee {

    private int empId;
    private String empName;
    private double salary;
    private String email;
    private String mobile;
    private String department;
    private String designation;

    public Employee(int empId, String empName, double salary,
                    String email, String mobile,
                    String department, String designation) {

        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.email = email;
        this.mobile = mobile;
        this.department = department;
        this.designation = designation;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }
}