package com.example.demo_lt_b5_userinterfacedemo;

public class NhanVien {
    private int maSo;
    private String hoten;
    private String gioitinh;
    private String donvi;
    private int soAnh;

    public int getSoAnh() {
        return soAnh;
    }

    public void setSoAnh(int soAnh) {
        this.soAnh = soAnh;
    }
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }
    //

    public NhanVien(int maSo, String hoten, String gioitinh, String donvi) {
        this.maSo = maSo;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
    }
    public NhanVien( String hoten, String gioitinh, String donvi) {
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
    }

    public NhanVien(int maSo, String hoten, String gioitinh, String donvi, int soAnh) {
        this.maSo = maSo;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
        this.soAnh = soAnh;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return  maSo +
                " - " + hoten +
                " - " + gioitinh +
                " - " + donvi ;
    }
}
