package com.software.fitness.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Attendance {
    private int course_ID;
    private int member_ID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "course_ID=" + course_ID +
                ", member_ID=" + member_ID +
                ", date=" + date +
                '}';
    }
}
