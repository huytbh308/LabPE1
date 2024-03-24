/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;

public class RegisterRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    final String regisPath = "\\data\\Registration.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public RegisterRepository() {
    }

    public void readFile(ArrayList<Registration> regises) {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + regisPath));
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(",");
                for (int i = 0; i < attributes.length; i++) {
                    attributes[i] = attributes[i].trim();
                }
                // Kiểm tra loại đăng ký và khởi tạo đối tượng tương ứng
                Registration regis;
                String regisType = attributes[2].trim();
                switch (regisType) {
                    case "Meeting":
                        regis = new Meetings(attributes[1], sdf.parse(attributes[3]), sdf.parse(attributes[4]),
                                sdf.parse(attributes[5]), attributes[6], attributes[8], LocalTime.parse(attributes[9]), LocalTime.parse(attributes[10]));
                        break;
                    case "Work":
                        regis = new Work(attributes[0], attributes[1], sdf.parse(attributes[3]), sdf.parse(attributes[4]),
                                sdf.parse(attributes[5]), attributes[6], attributes[7], attributes[8], attributes[9]);
                        break;
                    case "Study":
                        regis = new Study(attributes[0], attributes[1], sdf.parse(attributes[3]), sdf.parse(attributes[4]),
                                sdf.parse(attributes[5]), attributes[6], attributes[7], attributes[8], LocalTime.parse(attributes[9]), LocalTime.parse(attributes[10]));
                        break;
                    case "Vacation":
                        regis = new Vacation(attributes[0], attributes[1], sdf.parse(attributes[3]), sdf.parse(attributes[4]),
                                sdf.parse(attributes[5]), attributes[6], attributes[7], Integer.parseInt(attributes[8]), attributes[9]);
                        break;
                    default:
                        // Loại đăng ký không hợp lệ
                        System.out.println("Invalid registration type: " + regisType);
                        continue;
                }
                regises.add(regis);

            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
