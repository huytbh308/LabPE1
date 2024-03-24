/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Model.Registration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class Validation {
    final String DATE_FORMAT = "yyyy-MM-dd";
    final String stringRegex = "[a-zA-Z]+";
    private final String intRegex = ".*\\d+.*";
    ArrayList<Registration> schedules = new ArrayList<>();
    private final Map<String, Boolean> validQualification = new HashMap<>();

    public Validation() {
        validQualification.put("Meeting", true);
        validQualification.put("Work", true);
        validQualification.put("Study", true);
        validQualification.put("Vacation", true);
    }

    public String getValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine().trim();
    }

    public void warnIfOverlap(String empID, Date startDate) {
        for (int i = 0; i < schedules.size(); i++) {
            Registration currentSchedule = schedules.get(i);
            if (currentSchedule.getEmpID().equalsIgnoreCase(empID)) {
                if (isOverlap(currentSchedule, startDate)) {
                    System.out.println("Warning: Schedule overlap detected!");
                }
            }
        }
    }

    private boolean isOverlap(Registration schedule1, Date startDate) {
        return !schedule1.getEndDate().before(startDate)
                && !startDate.before(schedule1.getStartDate());
    }

    public String getAndValidRegisType(String msg) {
        while (true) {
            String input = getValue(msg);
            if (!validQualification.containsKey(input) || !validQualification.get(input)) {
                System.out.println("Invalid qualification, please type again");
                continue;
            }
            return input;
        }
    }

    public String getAndValidString(String msg) {
        while (true) {
            String input = getValue(msg);
            if (!(input.matches(stringRegex) || input.matches(intRegex))) {
                System.out.println("Invalid input, please type again!");
                continue;
            }
            return input;
        }
    }

    public int getAndValidInt(String msg) {
        while (true) {
            String input = getValue(msg);
            if (!input.matches(intRegex)) {
                System.out.println("Invalid input, please type again!");
                continue;
            }
            return Integer.parseInt(input);
        }
    }

    public Date getAndCheckDate(String msg, Date startDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);

        while (true) {
            try {
                String input = getValue(msg);
                Date endDate = sdf.parse(input);

                // Check if the end date is after the start date
                if (endDate.before(startDate)) {
                    System.out.println("End date must be after start date, please enter again.");
                    continue;
                }

                // Additional validation if needed
                if (!validateDateAndMonth(endDate)) {
                    System.out.println("Invalid date, please enter again.");
                    continue;
                }

                return endDate;
            } catch (ParseException e) {
                System.out.println("Invalid date format, please enter again.");
            }
        }
    }

    public boolean validateDateAndMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return (month >= 1 && month <= 12) && (day >= 1 && day <= cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    public LocalTime getTimeValue(String msg) {
        while (true) {
            try {
                String input = getValue(msg);
                LocalTime time = LocalTime.parse(input);
                return time;
            } catch (Exception e) {
                System.out.println("Invalid time format, please try again (HH:mm:ss)");
            }
        }
    }
}