package com.software.fitness.domain;

import java.sql.Date;

public class Member {
    private int ID;
    private String password;
    private String name;
    private String gender;
    private Date date_of_birth;
    private String phone_number;
    private Date validity;
    private int number_of_courses;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGender() {
        return gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public Date getValidity() {
        return validity;
    }

    public int getNumber_of_courses() {
        return number_of_courses;
    }

    public String getPassword() {
        return password;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setNumber_of_courses(int number_of_courses) {
        this.number_of_courses = number_of_courses;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    @Override
    public String toString() {
        return "Member{" +
                "ID=" + ID +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", phone_number='" + phone_number + '\'' +
                ", validity=" + validity +
                ", number_of_courses=" + number_of_courses +
                '}';
    }
}
