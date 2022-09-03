package com.example.a1950891_nguyenvanhoang_ktth.entity;

public class Bussines {
    private int id;
    private String name;
    private int soNgay;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public Bussines() {
    }

    public Bussines(int id, String name, int soNgay) {
        this.id = id;
        this.name = name;
        this.soNgay = soNgay;
    }

    @Override
    public String toString() {
        return "Bussines{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", soNgay=" + soNgay +
                '}';
    }
}
