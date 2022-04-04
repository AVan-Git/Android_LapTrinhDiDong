package com.example.ltandroid_th_b6_fragment.entity;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int id;
    private String name;
    private int discount;

    public SanPham() {
    }

    public SanPham(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discount=" + discount +
                '}';
    }

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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
