/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.Vacation;
import Model.Work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VacationRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    final String vacationPath = "\\data\\Vacation.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public VacationRepository() {
    }

    public void readFile(ArrayList<Vacation> vacations) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + vacationPath));
            while((line = input.readLine())!= null){
                String[] attributes = line.split(";");
                Vacation vacation = new Vacation(attributes[0], attributes[1], sdf.parse(attributes[2]), sdf.parse(attributes[3]), sdf.parse(attributes[4]),
                        attributes[5], attributes[6], Integer.parseInt(attributes[7]), attributes[8]);
                vacations.add(vacation);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}