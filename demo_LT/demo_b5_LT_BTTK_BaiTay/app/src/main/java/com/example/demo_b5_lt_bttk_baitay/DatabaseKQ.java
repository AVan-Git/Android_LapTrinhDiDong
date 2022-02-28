package com.example.demo_b5_lt_bttk_baitay;

import java.util.ArrayList;

public class DatabaseKQ {

    ArrayList<Integer> dsKQ;
    public DatabaseKQ(){
        dsKQ = new ArrayList<>();
    }

    public boolean addKQ(int a){
        return dsKQ.add(a);
    }
    public ArrayList<Integer> getKQ(){
        return dsKQ;
    }

    public int getSize(){ return dsKQ.size();}
    //
    public void deleteDS(){
        dsKQ.clear();
    }



}
