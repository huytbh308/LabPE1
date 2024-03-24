/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Model.*;
import view.Validation;
import repository.RegisterRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

/**
 *
 * @author TRINHHUY
 */
public class RegisterService {

    ArrayList<Registration> regisList = new ArrayList<>();
    Validation val;
    RegisterRepository rr = new RegisterRepository();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public RegisterService() {
        val = new Validation();
        rr.readFile(regisList);
    }

    public void viewRegister() {
        for (Registration regis : regisList) {
            System.out.println(regis);
        }
    }

    public void addNewRegister() {
    Registration regis = null;
    String empID = val.getAndValidString("Enter employee ID: ");
    String regisID = val.getAndValidString("Enter regis ID: ");
    String regisType = val.getAndValidRegisType("Input Registration Type (Meeting/Work/Study/Vacation):");

    Date regisDate = val.getAndCheckDate("Enter Regis Date", new Date()); // Assuming registration date can't be in the past
    Date startDate = val.getAndCheckDate("Enter start date: ", regisDate); // Pass registration date as start date
    Date endDate = val.getAndCheckDate("Enter end date: ", startDate); // Pass start date as end date
    String info = val.getAndValidString("Enter info: ");
    val.warnIfOverlap(empID, startDate);

    // Process based on registration type
    switch (regisType.toLowerCase()) {
        case "vacation":
            String vacationID = val.getAndValidString("Enter vacation ID: ");
            int bound = val.getAndValidInt("Enter bound: ");
            String locationVacation = val.getAndValidString("Enter location: ");
            regis = new Vacation(empID, regisID, regisDate, startDate, endDate, info, vacationID, bound, locationVacation);
            break;
        case "work":
            String workID = val.getAndValidString("Enter Work ID: ");
            String locationWork = val.getAndValidString("Enter location: ");
            String vehicle = val.getAndValidString("Enter vehicle: ");
            regis = new Work(empID, regisID, regisDate, startDate, endDate, info, locationWork, workID, vehicle);
            break;
        case "study":
            String studyID = val.getAndValidString("Enter study ID: ");
            String locationStudy = val.getAndValidString("Enter location: ");
            LocalTime startStudyTime = val.getTimeValue("Enter Start Study Time: ");
            LocalTime endStudyTime = val.getTimeValue("Enter End Study Time: ");
            regis = new Study(empID, regisID, regisDate, startDate, endDate, info, locationStudy, studyID, startStudyTime, endStudyTime);
            break;
        case "meeting":
            String meetingID = val.getAndValidString("Enter Meeting ID: ");
            LocalTime startMeetingTime = val.getTimeValue("Enter Start Meeting Time: ");
            LocalTime endMeetingTime = val.getTimeValue("Enter End Meeting Time: ");
            regis = new Meetings(regisID, regisDate, startDate, endDate, info, meetingID, startMeetingTime, endMeetingTime);
            break;
        default:
            System.out.println("Invalid registration type.");
            return; // Exit method if registration type is invalid
    }

    regisList.add(regis);
    System.out.println("Add successfully");
}

   

    public void viewByTime(Date startTime, Date endTime) {
        ArrayList<Registration> scheduleInRange = statisticScheduleByTime(startTime, endTime);
        System.out.println("Schedule In Range: ");
        for (Registration schedule : scheduleInRange) {
            System.out.println(schedule);
        }

    }

    private ArrayList<Registration> statisticScheduleByTime(Date startDate, Date endDate) {
        ArrayList<Registration> statisticSchedule = new ArrayList<>();
        for (Registration schedule : regisList) {
            Date scheduleStartDate = schedule.getStartDate();
            Date scheduleEndDate = schedule.getEndDate();
            if ((scheduleStartDate.after(startDate) && scheduleStartDate.before(endDate))
                    || (scheduleEndDate.after(startDate) && scheduleEndDate.before(endDate))) {
                statisticSchedule.add(schedule);
            }
        }

        Collections.sort(statisticSchedule, Comparator.comparing(Registration::getStartDate));
        return statisticSchedule;
    }  
}
