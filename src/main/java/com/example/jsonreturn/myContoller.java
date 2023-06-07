package com.example.jsonreturn;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.time.LocalDateTime;

@RestController
public class myContoller {
    @GetMapping("/dateAndTime")
    public String getDateAndTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        int year = currentDateTime.getYear();
        int month = currentDateTime.getMonthValue();
        int day = currentDateTime.getDayOfMonth();
        int hour = currentDateTime.getHour();
        int minute = currentDateTime.getMinute();
        int second = currentDateTime.getSecond();
        String date = String.valueOf(day)+'/'+String.valueOf(month)+'/'+String.valueOf(year);
        String time = String.valueOf(hour)+':'+String.valueOf(minute)+':'+String.valueOf(second);
        return date + " "+ time;
    }
    @GetMapping("/details")
    public Details getDetails(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        LocalDateTime currentDateTime = LocalDateTime.now();
        int year = currentDateTime.getYear();
        int month = currentDateTime.getMonthValue();
        int day = currentDateTime.getDayOfMonth();
        int hour = currentDateTime.getHour();
        int minute = currentDateTime.getMinute();
        int second = currentDateTime.getSecond();
        String date = String.valueOf(day)+'/'+String.valueOf(month)+'/'+String.valueOf(year);
        String time = String.valueOf(hour)+':'+String.valueOf(minute)+':'+String.valueOf(second);
        return new Details(date, time, ip);
    }
    @GetMapping("/image")
    public void getImage(HttpServletResponse response) throws IOException {
        File imageFile = new File("C:\\JavaProjects\\JSONreturn\\src\\main\\java\\com\\example\\jsonreturn\\blackPawn.png");
        FileInputStream fileInputStream = new FileInputStream(imageFile);
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // Close the output stream
        outputStream.close();
        fileInputStream.close();
    }
}
