package com.example.a19508981_nguyenvanhoang_ltandroid_baigk;

import android.widget.TextView;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int maID;
    private String name;
    private int gia1;// gia đc giam
    private int gia2;// gia truoc khi giam
    //


    public SanPham(int maID, String name, int gia1) {
        this.maID = maID;
        this.name = name;
        this.gia1 = gia1;
        this.gia2 = (gia1*90/100);
    }

    public int getMaID() {
        return maID;
    }

    public void setMaID(int maID) {
        this.maID = maID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGia1() {
        return gia1;
    }

    public void setGia1(int gia1) {
        this.gia1 = gia1;
        this.gia2 = (gia1*90/100);
    }

    public int getGia2() {
        return gia2;
    }



    public SanPham() {

        this.gia1 = 0;
        this.gia2 = 0;
    }
}
