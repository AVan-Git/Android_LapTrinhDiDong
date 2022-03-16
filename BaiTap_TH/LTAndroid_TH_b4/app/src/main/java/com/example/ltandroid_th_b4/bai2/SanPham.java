package com.example.ltandroid_th_b4.bai2;

public class SanPham {
    private int maSP;
    private String tenSP;
    private int soDGia;
    private double giaSP;

    public SanPham(int maSP, String tenSP, double giaSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.soDGia = 0;
    }

    public SanPham(int maSP, String tenSP, int soDGia, double giaSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soDGia = soDGia;
        this.giaSP = giaSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoDGia() {
        return soDGia;
    }

    public void setSoDGia(int soDGia) {
        this.soDGia = soDGia;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }
    //

    @Override
    public String toString() {
        return "SanPham{" +
                "maSP=" + maSP +
                ", tenSP='" + tenSP + '\'' +
                ", soDGia=" + soDGia +
                ", giaSP=" + giaSP +
                '}';
    }
}
