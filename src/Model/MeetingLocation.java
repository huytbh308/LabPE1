/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TRINHHUY
 */
public class MeetingLocation {
    private String locateID;
    private String location;

    public MeetingLocation(String locateID, String location) {
        this.locateID = locateID;
        this.location = location;
    }

    public String getLocateID() {
        return locateID;
    }

    public void setLocateID(String locateID) {
        this.locateID = locateID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "MeetingLocation.txt{" +
                "locateID='" + locateID + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
