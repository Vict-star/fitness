package com.software.fitness.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {
    private int id;
    private String name;
    private int coach_id;
    private int time_slot_id;
    private int capacity = -1;
    private int number_of_member = -1;
    private String room_number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_date;
    private String state;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public int getNumber_of_member() {
        return number_of_member;
    }

    public void setNumber_of_member(int number_of_member) {
        this.number_of_member = number_of_member;
    }

    public int getTime_slot_id() {
        return time_slot_id;
    }

    public void setTime_slot_id(int time_slot_id) {
        this.time_slot_id = time_slot_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getState() {
        return state;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coach_id=" + coach_id +
                ", time_slot_id=" + time_slot_id +
                ", capacity=" + capacity +
                ", number_of_member=" + number_of_member +
                ", room_number='" + room_number + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", state='" + state + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
