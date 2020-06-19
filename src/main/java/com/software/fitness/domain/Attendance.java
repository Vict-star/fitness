package com.software.fitness.domain;

import java.sql.Date;

public class Attendance {
    private int course_ID;
    private int member_ID;
    //确定和数据库date对应？？？
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

    //等等，这个还没把date加入

    @Override
    public String toString() {
        return "Attendance{" +
                "course_ID=" + course_ID +
                ", member_ID=" + member_ID +
                ", date=" + date +
                '}';
    }
}
