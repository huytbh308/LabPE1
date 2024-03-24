/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.Meetings;
import Model.Notification;

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
public class MeetingRepository {
     private final String srcPath = new File("src").getAbsolutePath();
    final String meetingPath = "\\data\\Meetings.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    final String HOUR_FORMAT = "HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//    SimpleDateFormat hourFormat = new SimpleDateFormat(HOUR_FORMAT);

    public MeetingRepository() {
    }

    public void readFile(ArrayList<Meetings> meetings) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + meetingPath));
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(",");
                Meetings meeting = new Meetings(attributes[0], sdf.parse(attributes[1]), sdf.parse(attributes[2]), sdf.parse(attributes[3]),
                        attributes[4], attributes[5], LocalTime.parse(attributes[6]), LocalTime.parse(attributes[7]));
                meetings.add(meeting);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
