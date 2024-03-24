/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalTime;
import java.util.Date;

public class Study extends Registration{
    private String studyID;
    private LocalTime startStudyTime;
    private LocalTime endStudyTime;

    public Study(String empID, String regisID, Date regisDate, Date startDate, Date endDate, String info, String location, String studyID, LocalTime startStudyTime, LocalTime endStudyTime) {
        super(empID, regisID, regisDate, startDate, endDate, info, location);
        this.studyID = studyID;
        this.startStudyTime = startStudyTime;
        this.endStudyTime = endStudyTime;
    }

    public String getStudyID() {
        return studyID;
    }

    public void setStudyID(String studyID) {
        this.studyID = studyID;
    }

    public LocalTime getStartStudyTime() {
        return startStudyTime;
    }

    public void setStartStudyTime(LocalTime startStudyTime) {
        this.startStudyTime = startStudyTime;
    }

    public LocalTime getEndStudyTime() {
        return endStudyTime;
    }

    public void setEndStudyTime(LocalTime endStudyTime) {
        this.endStudyTime = endStudyTime;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Study: " +
                "studyID: " + studyID  +
                ", Start Time: " + startStudyTime +
                ", End Time: " + endStudyTime;
    }

    @Override
    public void showMe() {
        System.out.println(super.toString() + ", Study ID: " + studyID +
                "Start Time: " + startStudyTime +
                "End Time: " + endStudyTime);
    }
}
