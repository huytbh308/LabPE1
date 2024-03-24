/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalTime;
import java.util.Date;

public class Meetings extends Registration {

    private String meetingID;
    private LocalTime startMeetingTime;
    private LocalTime endMeetingTime;
    private String locateID;

    public Meetings(String regisID, Date regisDate, Date startDate, Date endDate, String info, String meetingID, LocalTime startMeetingTime, LocalTime endMeetingTime) {
        super(regisID, regisDate, startDate, endDate, info);
        this.meetingID = meetingID;
        this.startMeetingTime = startMeetingTime;
        this.endMeetingTime = endMeetingTime;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
    }

    public LocalTime getStartMeetingTime() {
        return startMeetingTime;
    }

    public void setStartMeetingTime(LocalTime startMeetingTime) {
        this.startMeetingTime = startMeetingTime;
    }

    public LocalTime getEndMeetingTime() {
        return endMeetingTime;
    }

    public void setEndMeetingTime(LocalTime endMeetingTime) {
        this.endMeetingTime = endMeetingTime;
    }

    public String getLocateID() {
        return locateID;
    }

    public void setLocateID(String locateID) {
        this.locateID = locateID;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Meetings: "
                + "Meeting ID: " + meetingID
                + ", Start Time: " + startMeetingTime
                + ", End Time: " + endMeetingTime
                + ", locate ID: " + locateID;
    }

    @Override
    public void showMe() {
        System.out.println(super.toString() + ", Meeting ID: " + meetingID
                + "Start Time: " + startMeetingTime
                + "End Time: " + endMeetingTime);
    }
}
