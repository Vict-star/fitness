package com.software.fitness.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Attendance {
    private int course_ID;
    private int member_ID;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date_of_attendance;

    public int getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    public int getMember_ID() {
        return member_ID;
    }

    public void setMember_ID(int member_ID) {
        this.member_ID = member_ID;
    }

    public Date getDate_of_attendance() {
        return date_of_attendance;
    }

    public void setDate_of_attendance(Date date_of_attendance) {
        this.date_of_attendance = date_of_attendance;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "course_ID=" + course_ID +
                ", member_ID=" + member_ID +
                ", date=" + date_of_attendance +
                '}';
    }
}
