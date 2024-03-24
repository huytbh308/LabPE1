/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class Work extends Registration{
    private String workID;
    private String vehicle;

    public Work(String empID, String regisID, Date regisDate, Date startDate, Date endDate, String info, String location, String workID, String vehicle) {
        super(empID, regisID, regisDate, startDate, endDate, info, location);
        this.workID = workID;
        this.vehicle = vehicle;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Work: " +
                "workID: " + workID+
                ", vehicle: " + vehicle;
    }

    @Override
    public void showMe() {
        System.out.println(super.toString() + ", Work ID: " + workID +
                "Vehicle:  " + vehicle);
    }
}