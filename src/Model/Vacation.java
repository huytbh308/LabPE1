/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class Vacation extends Registration {
    private String vacationID;
    private int bound;

    public Vacation(String empID, String regisID, Date regisDate, Date startDate, Date endDate, String info, String vacationID, int bound, String location) {
        super(empID, regisID, regisDate, startDate, endDate, info, location);
        this.vacationID = vacationID;
        this.bound = bound;
    }

    public String getVacationID() {
        return vacationID;
    }

    public void setVacationID(String vacationID) {
        this.vacationID = vacationID;
    }

    public int getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", Vacation: " +
                "vacationID: " + vacationID +
                ", bound: " + bound;
    }

    @Override
    public void showMe() {
        System.out.println(super.toString() + ", Vacation ID: " + vacationID +
                "Bound: " + bound);
    }
}
