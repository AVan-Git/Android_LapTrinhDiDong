package com.example.demo_b9_lt_fragment_dssp_tk3;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int maID;
    private String ten;
    private String Xuatxu;
    private int gia;
    private int dungTich;
    private String thanhPhan;
    private String congDung;

    public int getMaID() {
        return maID;
    }

    public void setMaID(int maID) {
        this.maID = maID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getXuatxu() {
        return Xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        Xuatxu = xuatxu;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    public String getThanhPhan() {
        return thanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }

    public String getCongDung() {
        return congDung;
    }

    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }

    public SanPham() {
    }

    public SanPham(int maID, String ten, String xuatxu, int gia, int dungTich, String thanhPhan, String congDung) {
        this.maID = maID;
        this.ten = ten;
        Xuatxu = xuatxu;
        this.gia = gia;
        this.dungTich = dungTich;
        this.thanhPhan = thanhPhan;
        this.congDung = congDung;
    }
    //

    @Override
    public String toString() {
        return "SanPham{" +
                "maID=" + maID +
                ", ten='" + ten + '\'' +
                ", Xuatxu='" + Xuatxu + '\'' +
                ", gia=" + gia +
                ", dungTich=" + dungTich +
                ", thanhPhan='" + thanhPhan + '\'' +
                ", congDung='" + congDung + '\'' +
                '}';
    }
}
