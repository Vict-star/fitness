package com.software.fitness.domain;

public class Staff {
    private int ID;
    private String password;
    private String name;
    private String phone_number;
    private String address;
    private String state;
    private String is_admin;

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public String getState() {
        return state;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ID=" + ID +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", is_admin='" + is_admin + '\'' +
                '}';
    }
}
