/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Model.Department;
import repository.DepartmentRepository;
import view.Validation;

import java.util.ArrayList;
/**
 *
 * @author TRINHHUY
 */
public class DepartmentService {
    ArrayList<Department> departmentList = new ArrayList<>();
    DepartmentRepository dr = new DepartmentRepository();
    Validation val;

    public DepartmentService(){
        val = new Validation();
        dr.readFile(departmentList);
    }

    public void addNewDepartment(){
        String depID = val.getAndValidString("Enter new DepartmentID: ");
        String depName = val.getAndValidString("Enter new department name: ");
        Department department = new Department(depID, depName);
        departmentList.add(department);
    }


    //find by ID
    public Department findDepartmentByID(String depID){
        for(Department department: departmentList){
            if(department.getDepartmentID().equalsIgnoreCase(depID)){
                System.out.println(department);
                return department;
            }
        }
        System.out.println("Can not find that department");
        return null;
    }

    //delete department
    public void deleteDepartment(Department department){
        departmentList.remove(department);
        System.out.println("Delete Successfully");
    }
    public void viewDepartment() {
        for (Department department : departmentList) {
            System.out.println(department);
        }
    }

    //update department
    public void updateDepartment(Department department){
        String departmentID = val.getAndValidString("Enter new department ID");
        String departmentName = val.getAndValidString("Enter new department name");
        department.setDepartmentID(departmentID);
        department.setDepartmentName(departmentName);
        System.out.println("Update successfully");
    }
}
