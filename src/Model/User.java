/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TRINHHUY
 */
public class User {
    private String userID;
    private String empID;
    private String userName;
    private String password;
    private String level;

    public User(String userID, String empID, String userName, String password, String level) {
        this.userID = userID;
        this.empID = empID;
        this.userName = userName;
        this.password = password;
        this.level = level;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", empID='" + empID + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
