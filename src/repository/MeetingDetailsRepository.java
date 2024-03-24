/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.MeetingDetails;
import Model.MeetingLocation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author TRINHHUY
 */
public class MeetingDetailsRepository {

    private final String srcPath = new File("src").getAbsolutePath();
    final String meetingDetailsPath = "\\data\\MeetingDetails.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    final String HOUR_FORMAT = "HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//    SimpleDateFormat hourFormat = new SimpleDateFormat(HOUR_FORMAT);

    public MeetingDetailsRepository() {
    }

    public void readFile(ArrayList<MeetingDetails> meetingDetails) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath));
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(",");
                MeetingDetails meetingDetail = new MeetingDetails(attributes[0], attributes[1], attributes[2], attributes[3]);
                meetingDetails.add(meetingDetail);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
