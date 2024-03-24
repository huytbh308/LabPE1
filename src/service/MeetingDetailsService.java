/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Model.MeetingDetails;
import repository.MeetingDetailsRepository;
import repository.MeetingLocationRepository;
import view.Validation;

import java.util.ArrayList;
/**
 *
 * @author TRINHHUY
 */
public class MeetingDetailsService {
    ArrayList<MeetingDetails> meetingDetailList = new ArrayList<>();
    Validation val;
    MeetingDetailsRepository mdr = new MeetingDetailsRepository();

    private MeetingDetailsService(){
        val = new Validation();
        mdr.readFile(meetingDetailList);
    }

    public void addNewMeetingDetails(){
        String meetingDetailsID = val.getAndValidString("Enter meeting details ID: ");
        String meetingID = val.getAndValidString("Enter meeting ID: ");
        String empID = val.getAndValidString("Enter employee ID: ");
        String readOn = val.getAndValidString("Enter Date: ");
        MeetingDetails newMeetingDetail = new MeetingDetails(meetingDetailsID, meetingID, empID, readOn);
        meetingDetailList.add(newMeetingDetail);
        System.out.println("Add successfully");
    }

    public MeetingDetails findByID(String id){
        for(MeetingDetails meetingDetail: meetingDetailList){
            if(meetingDetail.getMeetingDetailsID().equalsIgnoreCase(id)){
                System.out.println(meetingDetail);
                return meetingDetail;
            }
        }
        System.out.println("Can not find that room");
        return null;
    }
}