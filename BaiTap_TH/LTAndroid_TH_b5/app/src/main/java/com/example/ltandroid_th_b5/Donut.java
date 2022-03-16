package com.example.ltandroid_th_b5;

public class Donut {
    private int maID;
    private String tenSP;
    private double giaSP;

    @Override
    public String toString() {
        return "Donut{" +
                "maID=" + maID +
                ", tenSP='" + tenSP + '\'' +
                ", giaSP=" + giaSP +
                '}';
    }

    public Donut() {
    }

    public int getMaID() {
        return maID;
    }

    public void setMaID(int maID) {
        this.maID = maID;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    public Donut(int maID, String tenSP, double giaSP) {
        this.maID = maID;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
    }
}
