/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Model.Employee;
import repository.EmployeeRepository;
import view.Validation;

import java.util.ArrayList;

/**
 *
 * @author TRINHHUY
 */
public class EmployeeService {

    ArrayList<Employee> employeeList = new ArrayList<>();
    Validation val;
    EmployeeRepository er = new EmployeeRepository();

    public EmployeeService() {
        val = new Validation();
        er.readFile(employeeList);
    }

    public void addNewEmployee() {
        String empID = val.getAndValidString("Enter new Emplyee ID: ");
        String departmentID = val.getAndValidString("Enter department ID: ");
        String empName = val.getAndValidString("Enter employee name: ");
        Employee newEmp = new Employee(empID, departmentID, empName);
        employeeList.add(newEmp);
        System.out.println("Add successfully");
    }

    //find by ID
    public Employee findByID(String empID) {
        for (Employee emp : employeeList) {
            if (emp.getEmpID().equalsIgnoreCase(empID)) {
                System.out.println(emp);
                return emp;
            }
        }
        System.out.println("Can not find that Employee");
        return null;
    }

    //delete employee
    public void deleteEmployee(Employee employee) {
        employeeList.remove(employee);
        System.out.println("Delete successfully");
    }
    public void viewEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    //update employee
    public void updateEmployee(Employee employee) {
        String empID = val.getAndValidString("Enter new employee ID ");
        String departmentID = val.getAndValidString("Enter new department ID: ");
        String empName = val.getAndValidString("Enter employee name: ");
        employee.setEmpID(empID);
        employee.setDepartmentID(departmentID);
        employee.setEmpName(empName);
        System.out.println("Update successfully");
    }
}
