/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.Department;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author TRINHHUY
 */
public class DepartmentRepository {

    private final String srcPath = new File("src").getAbsolutePath();
    final String departmentPath = "\\data\\Department.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public DepartmentRepository() {
    }

    public void readFile(ArrayList<Department> departs) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + departmentPath));
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(",");
                Department depart = new Department(attributes[0], attributes[1]);
                departs.add(depart);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
