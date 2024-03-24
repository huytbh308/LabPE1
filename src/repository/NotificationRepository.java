/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.Notification;
import Model.Study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;

public class NotificationRepository {

    private final String srcPath = new File("src").getAbsolutePath();
    final String notiPath = "\\data\\Notification.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    final String HOUR_FORMAT = "HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//    SimpleDateFormat hourFormat = new SimpleDateFormat(HOUR_FORMAT);

    public NotificationRepository() {
    }

    public void readFile(ArrayList<Notification> notis) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + notiPath));
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(",");
                Notification noti = new Notification(attributes[0], attributes[1], attributes[2], attributes[3]);
                notis.add(noti);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
