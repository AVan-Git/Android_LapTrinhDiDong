package com.example.ltandroid_th_b4;

public class SanPham {
    private int id;
    private String name;//ten sp
    private String shop;// ten shop

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

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public SanPham(int id, String name, String shop) {
        this.id = id;
        this.name = name;
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shop='" + shop + '\'' +
                '}';
    }
}
