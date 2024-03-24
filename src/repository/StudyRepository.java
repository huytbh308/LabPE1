/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.Study;
import Model.Vacation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;

public class StudyRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    final String studyPath = "\\data\\Study.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    final String HOUR_FORMAT = "HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//    SimpleDateFormat hourFormat = new SimpleDateFormat(HOUR_FORMAT);

    public StudyRepository() {
    }

    public void readFile(ArrayList<Study> studies) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + studyPath));
            while((line = input.readLine())!= null){
                String[] attributes = line.split(";");
                Study study = new Study(attributes[0], attributes[1], sdf.parse(attributes[2]), sdf.parse(attributes[3]), sdf.parse(attributes[4]),
                        attributes[5], attributes[6], attributes[7], LocalTime.parse(attributes[8]), LocalTime.parse(attributes[9]));
                studies.add(study);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
