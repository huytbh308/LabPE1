/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    final String usersPath = "\\data\\Users.txt";

    public UserRepository() {
    }

    public void readFile(ArrayList<User> users) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + usersPath));
            while((line = input.readLine())!= null){
                String[] attributes = line.split(",");
                User user = new User(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4]);
                users.add(user);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void writeToFile(ArrayList<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(srcPath + usersPath))) {
            for (User user : users) {
                writer.write(user.getUserID() + ";" + user.getEmpID() + ";" + user.getUserName() + ";" + user.getPassword() + ";" + user.getLevel());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}