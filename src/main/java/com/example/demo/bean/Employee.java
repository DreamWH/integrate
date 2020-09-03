package com.example.demo.bean;

import java.io.Serializable;

public class Employee implements Serializable {

    private final static long serialVersionUID = 1L;

    private int id;
    private String lastName;
    private String email;
    private int gender;
    private int did;

    public Employee() {

    }

    public Employee(int id, String lastName, String email, int gender, int did) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.did = did;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", did=" + did +
                '}';
    }
}
