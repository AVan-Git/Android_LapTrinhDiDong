package com.example.ltandroid_th_demo_realtime_db;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String email;
    private String pass;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(int id, String email, String pass, String name) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
