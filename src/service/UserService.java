/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Model.Notification;
import Model.Registration;
import Model.User;
import repository.UserRepository;
import view.Validation;

import java.util.ArrayList;

/**
 *
 * @author TRINHHUY
 */
public class UserService {

    ArrayList<User> userList = new ArrayList<>();
    UserRepository ur = new UserRepository();
    Validation val;

    public UserService() {
        val = new Validation();
        ur.readFile(userList);
    }

    public void printUserList() {
        System.out.println("User List:");
        for (User user : userList) {
            System.out.println(user); 
        }
    }

    public void addNewUser() {
        User user = null;
        String userID = val.getAndValidString("Enter your user ID: ");
        String empID = val.getAndValidString("Enter your empID: ");
        String userName = val.getAndValidString("Enter user name: ");
        String password = val.getAndValidString("Enter password: ");
        String level = val.getAndValidString("Enter your level: ");
        user = new User(userID, empID, userName, password, level);
        userList.add(user);
        System.out.println("Add successfully");
        printUserList();
        ur.writeToFile(userList);

    }

    //Find user by ID
    public User findByUserID(String userID) {
        for (User user : userList) {
            if (user.getUserID().equalsIgnoreCase(userID)) {
                System.out.println(user);
                return user;
            }
        }
        System.out.println("Can not find that user ID!");
        return null;
    }

    //delete user
    public void deleteUser(User deleteUser) {
        userList.remove(deleteUser);
        System.out.println("Delete successfully");
    }
    //display
    public void viewUser() {
        for (User user : userList) {
            System.out.println(user);
        }
    }
    //update user
    public void updateUser(User updateUser) {
        String userID = val.getAndValidString("Enter your user ID: ");
        String empID = val.getAndValidString("Enter your empID: ");
        String userName = val.getAndValidString("Enter user name: ");
        String password = val.getAndValidString("Enter password: ");
        String level = val.getAndValidString("Enter your level: ");
        updateUser.setUserID(userID);
        updateUser.setEmpID(empID);
        updateUser.setUserName(userName);
        updateUser.setPassword(password);
        updateUser.setLevel(level);
        System.out.println("Update successfully");
    }
}
