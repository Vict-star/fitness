package com.software.fitness.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

public class Record {
    private int record_id;
    private int staff_ID;
    private int member_ID;
    //TODO 需要确认
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String operation;

    public int getMember_ID() {
        return member_ID;
    }

    public void setMember_ID(int member_ID) {
        this.member_ID = member_ID;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getStaff_ID() {
        return staff_ID;
    }

    public void setStaff_ID(int staff_ID) {
        this.staff_ID = staff_ID;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Record{" +
                "record_id=" + record_id +
                ", staff_ID=" + staff_ID +
                ", member_ID=" + member_ID +
                ", time=" + time +
                ", operation='" + operation + '\'' +
                '}';
    }
}
