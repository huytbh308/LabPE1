/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Model.Notification;
import repository.NotificationRepository;
import view.Validation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author TRINHHUY
 */
public class NotificationService {

    ArrayList<Notification> notiList = new ArrayList<>();
    NotificationRepository nr = new NotificationRepository();
    Validation val;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public NotificationService() {
        nr.readFile(notiList);
    }

    public void viewNotifications() {
        for (Notification noti : notiList) {
            System.out.println(noti);
        }
    }

    public static void main(String[] args) {
        NotificationService ns = new NotificationService();
        ns.viewNotifications();
    }
}
