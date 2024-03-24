/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TRINHHUY
 */
public class Employee {
     private String empID;
    private String departmentID;
    private String empName;

    public Employee(String empID, String departmentID, String empName) {
        this.empID = empID;
        this.departmentID = departmentID;
        this.empName = empName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID='" + empID + '\'' +
                ", departmentID='" + departmentID + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
