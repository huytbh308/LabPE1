/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Department;
import Model.Employee;
import Model.MeetingLocation;
import Model.User;
import service.*;
import view.Menu;
import view.Validation;

import java.util.Date;

/**
 *
 * @author TRINHHUY
 */
public class Main extends Menu<String> {
    private static final String MENU_TITLE = "MENU";
    private static final String[] STAFF_MENU_OPTIONS = { "Registerschedule", " Display all notifications", "Display all schedules", "Edit information", " View", "Log out" };
    private Validation val = new Validation();
    private RegisterService rs = new RegisterService();
    private NotificationService ns = new NotificationService();
    private UserService us = new UserService();
    private DepartmentService ds = new DepartmentService();
    private MeetingRoomService mrs = new MeetingRoomService();
    private EmployeeService es = new EmployeeService();

    public Main() {
        super(MENU_TITLE, STAFF_MENU_OPTIONS);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                rs.addNewRegister();
                break;
            case 2:
                ns.viewNotifications();
                break;
            case 3:
                rs.viewRegister();
                break;
            case 4:
                manageInfoMenu();
                break;
            case 5:
                ViewInfo();
                break;
            case 6:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
        }
    }
     public void ViewInfo() {
        final String MANAGE_MENU_TITLE = "MENU";
        final String[] OPTIONS = { "View Users", "View Departments", "View meeting rooms", "View Employee", "Back" };
        Menu manageView = new Menu(MANAGE_MENU_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:                       
                        us.viewUser();
                        break;
                    case 2:
                        ds.viewDepartment();
                        break;
                    case 3:
                        mrs.viewMeeting();
                        break;
                    case 4:
                        es.viewEmployee();
                        break;
                    case 5:
                        System.out.println("Good Bye");
                        break;
                }
            }
        };
        manageView.run();
    }

    public void manageInfoMenu() {
        final String MANAGE_MENU_TITLE = "MENU";
        final String[] OPTIONS = { "Manage Users", "Manage Departments", "Manage meeting rooms", "Manage personnel", "Back" };
        Menu manageInfoMenu = new Menu(MANAGE_MENU_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        
                        userMenu();
                        break;
                    case 2:
                        departmentMenu();
                        break;
                    case 3:
                        meetingRoomMenu();
                        break;
                    case 4:
                        employeeMenu();
                        break;
                    case 5:
                        System.out.println("Good Bye");
                        break;
                }
            }
        };
        manageInfoMenu.run();
    }

    private void userMenu() {
        final String MANAGE_MENU_TITLE = "USER MENU";
        final String[] OPTIONS = { "Add new user", "Delete", "Update", "Back" };
        Menu manageUserMenu = new Menu(MANAGE_MENU_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        us.addNewUser();
                        break;
                    case 2:
                        String foundDeleteID = val.getAndValidString("Enter id want to delete:");
                        User deleteUser = us.findByUserID(foundDeleteID);
                        us.deleteUser(deleteUser);
                        break;
                    case 3:
                        String foundUpdateID = val.getAndValidString("Enter ID want to update: ");
                        User updateUser = us.findByUserID(foundUpdateID);
                        us.updateUser(updateUser);
                        break;
                    case 4:
                        System.out.println("Thank You");
                        break;
                }
            }
        };
        manageUserMenu.run();
    }

    private void departmentMenu() {
        final String MANAGE_DEPARTMENT_TITLE = "DEPARTMENT MENU";
        final String[] OPTIONS = { "Add new department", "Delete", "Update", "Back" };
        Menu manageDepartmentMenu = new Menu(MANAGE_DEPARTMENT_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        ds.addNewDepartment();
                        break;
                    case 2:
                        String foundDeleteID = val.getAndValidString("Enter ID need to delete");
                        Department foundDepartment = ds.findDepartmentByID(foundDeleteID);
                        ds.deleteDepartment(foundDepartment);
                        break;
                    case 3:
                        String foundUpdateID = val.getAndValidString("Enter ID need to update");
                        Department foundUpdateDepartment = ds.findDepartmentByID(foundUpdateID);
                        ds.updateDepartment(foundUpdateDepartment);
                        break;
                    case 4:
                        System.out.println("Thank you");
                        break;
                }
            }
        };
        manageDepartmentMenu.run();
    }

    private void meetingRoomMenu() {
        final String MANAGE_MEETING_ROOM_TITLE = "MEETING ROOM";
        final String[] OPTIONS = { "Add new meeting room", "Delete", "Update", "Back" };
        Menu manageMeetingRoomMenu = new Menu(MANAGE_MEETING_ROOM_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        mrs.addNewRoom();
                        break;
                    case 2:
                        String roomID = val.getAndValidString("Enter room ID ");
                        MeetingLocation foundRoom = mrs.findByID(roomID);
                        mrs.deleteMeetingLocation(foundRoom);
                        break;
                    case 3:
                        String roomUpdateID = val.getAndValidString("Enter room ID ");
                        MeetingLocation foundUpdateRoom = mrs.findByID(roomUpdateID);
                        mrs.updateMeetingLocation(foundUpdateRoom);
                        break;
                    case 4:
                        System.out.println("Thank you");
                        break;
                }
            }
        };
        manageMeetingRoomMenu.run();
    }

    private void employeeMenu() {
        final String MANAGE_EMPLOYEE_TITLE = "EMPLOYEE";
        final String[] OPTIONS = { "Add new employee", "Delete", "Update ", "Back" };
        Menu manageEmployeeMenu = new Menu(MANAGE_EMPLOYEE_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        es.addNewEmployee();
                        break;
                    case 2:
                        String empID = val.getAndValidString("Enter employee ID ");
                        Employee foundEmployee = es.findByID(empID);
                        es.deleteEmployee(foundEmployee);
                        break;
                    case 3:
                        String empUpdateID = val.getAndValidString("Enter employee ID ");
                        Employee foundUpdateEmployee = es.findByID(empUpdateID);
                        es.updateEmployee(foundUpdateEmployee);
                        break;
                    case 4:
                        System.out.println("Thank you");
                        break;
                }
            }
        };
        manageEmployeeMenu.run();
    }
}