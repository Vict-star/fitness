package com.software.fitness.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Time {
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date time;
    private String day;

    public Time(Date t, String d) {
        time = t;
        day = d;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Time{" +
                "time=" + time +
                ", day='" + day + '\'' +
                '}';
    }
}
