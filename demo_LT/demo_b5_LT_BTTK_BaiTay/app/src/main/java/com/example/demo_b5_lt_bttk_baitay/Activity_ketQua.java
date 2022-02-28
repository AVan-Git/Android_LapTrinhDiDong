package com.example.demo_b5_lt_bttk_baitay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_ketQua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);
        TextView txtKQ = findViewById(R.id.txtKQ1);


        Intent intent = getIntent();
        ArrayList<Integer> dsKQ = intent.getIntegerArrayListExtra("dsKQ");

//        txtKQ.setText(""+ dsKQ.size());
//        int [] dsKQ = intent.getIntArrayExtra("dsKQ");

        int a = 0;
        String str="";
//        int i =1;
//        for (Integer q : dsKQ ) {
//            a = (int)q;
//            str = "Ván "+i+": ";
//            if (a == 0){
//                str += "Hòa";
//            }else if (a >0){
//                str += "player 1 wins!";
//            }
//            else {
//                str += "player 2 wins!";
//            }
//            txtKQ.setText(str+"\n");
//        }

        for (int i = 1; i <= dsKQ.size(); i++) {
            str += "\nVán "+i+": ";
            if (dsKQ.get(i-1).intValue() == 0){
                str += "Hòa";
            }else if (dsKQ.get(i-1).intValue()<0){
                str += "player 1 wins!";
            }
            else {
                str += "player 2 wins!";
            }

        }
        txtKQ.setText(str);
    }
}