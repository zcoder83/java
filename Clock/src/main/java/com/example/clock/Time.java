package com.example.clock;

public class Time {
    private int hour;
    private int minute;
    private int second;

    // set time we want
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // set local current time
    public Time(String currentTime) {
        String[] time = currentTime.split(":");
        this.hour = Integer.parseInt(time[0]);
        this.minute = Integer.parseInt(time[1]);
        this.second = Integer.parseInt(time[2]);
    }

    public String getCurrentTime() {
        // add 0 when less than 10
        String showHour = hour < 10 ? "0" + hour : String.valueOf(hour);
        String showMin = minute < 10 ? "0" + minute : String.valueOf(minute);
        String showSecond = second < 10 ? "0" + second : String.valueOf(second);
        return showHour + ":" + showMin + ":" + showSecond;
   }

   // reset time as 0 when it meets 60
   public void oneSecondPassed() {
        second++;
        if (second == 60) {
            minute++;
            second = 0;
            if (minute == 60) {
                hour++;
                minute = 0;
                if (hour == 24) {
                    hour = 0;
                    System.out.println("Next day!");
                }
            }
        }
   }

}
