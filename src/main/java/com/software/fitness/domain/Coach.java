package com.software.fitness.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Coach {
    private int id;
    private String name;
    private boolean gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;
    private String phone;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", date_of_birth=" + date_of_birth +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
