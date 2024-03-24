/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TRINHHUY
 */
public class Notification {
    private String notiID;
    private String personNoticeID;
    private String personNoticedID;
    private String info;

    public Notification(String notiID, String personNoticeID, String personNoticedID, String info) {
        this.notiID = notiID;
        this.personNoticeID = personNoticeID;
        this.personNoticedID = personNoticedID;
        this.info = info;
    }

    public String getNotiID() {
        return notiID;
    }

    public void setNotiID(String notiID) {
        this.notiID = notiID;
    }

    public String getPersonNoticeID() {
        return personNoticeID;
    }

    public void setPersonNoticeID(String personNoticeID) {
        this.personNoticeID = personNoticeID;
    }

    public String getPersonNoticedID() {
        return personNoticedID;
    }

    public void setPersonNoticedID(String personNoticedID) {
        this.personNoticedID = personNoticedID;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return  "notiID: " + notiID +
                ", personNoticeID: " + personNoticeID +
                ", personNoticedID: " + personNoticedID +
                ", info: " + info;
    }
}
