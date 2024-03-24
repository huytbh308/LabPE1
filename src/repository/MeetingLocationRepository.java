/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.MeetingLocation;
import Model.Meetings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author TRINHHUY
 */
public class MeetingLocationRepository {

    private final String srcPath = new File("src").getAbsolutePath();
    final String meetingLocatePath = "\\data\\MeetingLocation.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    final String HOUR_FORMAT = "HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public MeetingLocationRepository() {
    }

    public void readFile(ArrayList<MeetingLocation> meetingLocates) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + meetingLocatePath));
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(",");
                MeetingLocation meetingLocate = new MeetingLocation(attributes[0], attributes[1]);
                meetingLocates.add(meetingLocate);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
