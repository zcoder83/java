package com.example.clock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {
    // set local time
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    LocalDateTime now = LocalDateTime.now();

    public CurrentTime(){}
    public String currentTime(){
        return dtf.format(now);
    }
}
