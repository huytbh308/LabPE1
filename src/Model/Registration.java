/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TRINHHUY
 */
public abstract class Registration {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private String empID;
    private String regisID;
    private String regisType;
    private Date regisDate;
    private Date startDate;
    private Date endDate;
    private String info;
    private String location;

    public Registration(String regisID, Date regisDate,  Date startDate, Date endDate, String info) {
        this.regisID = regisID;
        this.regisDate = regisDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.info = info;
    }

    public Registration(String regisID, Date regisDate,  Date startDate, Date endDate, String info, String location) {
        this.regisID = regisID;
        this.regisDate = regisDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.info = info;
        this.location = location;
    }

    public Registration(String empID, String regisID, Date regisDate,  Date startDate, Date endDate, String info, String location) {
        this.empID = empID;
        this.regisID = regisID;
        this.regisDate = regisDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.info = info;
        this.location = location;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getRegisID() {
        return regisID;
    }

    public void setRegisID(String regisID) {
        this.regisID = regisID;
    }

    public String getRegisType() {
        return regisType;
    }

    public void setRegisType(String regisType) {
        this.regisType = regisType;
    }

    public Date getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return  " Regis ID: " + regisID +
                ", Regis Date: " + sdf.format(regisDate)  +
                ", Start Date: " + sdf.format(startDate) +
                ", End Date: " + sdf.format(startDate) +
                ", Info: " + info +
                ", Location: " + location;
    }
    public abstract void showMe();
}
