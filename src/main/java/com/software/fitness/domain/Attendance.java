package com.software.fitness.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Attendance {
    private int course_id;
    private int member_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date_of_attendance;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
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
                "course_id=" + course_id +
                ", member_id=" + member_id +
                ", date_of_attendance=" + date_of_attendance +
                '}';
    }
}
