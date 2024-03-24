/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.User;
import Model.Work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class WorkRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    final String workPath = "\\data\\work.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public WorkRepository() {
    }

    public void readFile(ArrayList<Work> works) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + workPath));
            while((line = input.readLine())!= null){
                String[] attributes = line.split(";");
                Work work = new Work(attributes[0], attributes[1], sdf.parse(attributes[2]), sdf.parse(attributes[3]), sdf.parse(attributes[4]),
                                    attributes[5], attributes[6], attributes[7], attributes[8]);
                works.add(work);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
