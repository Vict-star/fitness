package com.software.fitness.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Time_slot {
    //TODO time_slot
    private int time_slot_id;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date start_time;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date end_time;
    private String day;

    public void setDay(String day) {
        this.day = day;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setTime_slot_id(int time_slot_id) {
        this.time_slot_id = time_slot_id;
    }

    public int getTime_slot_id() {
        return time_slot_id;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Time_slot{" +
                "time_slot_id=" + time_slot_id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", day='" + day + '\'' +
                '}';
    }
}
