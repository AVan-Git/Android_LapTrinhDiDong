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
        TextView KQ1 = findViewById(R.id.KQ1);
        TextView KQ2 = findViewById(R.id.KQ2);
        TextView KQ3 = findViewById(R.id.KQ3);

        TextView TL1 = findViewById(R.id.TL1);
        TextView TL2 = findViewById(R.id.TL2);
        TextView TL3 = findViewById(R.id.TL3);


        Intent intent = getIntent();
        ArrayList<Integer> dsKQ = intent.getIntegerArrayListExtra("dsKQ");

//        txtKQ.setText(""+ dsKQ.size());
//        int [] dsKQ = intent.getIntArrayExtra("dsKQ");

        int a = 0;
        String str="";
        int t1 = 0; // 1 thang
        int t2 = 0; // 2 thang
        int t = 0; // hoa

        for (int i = 1; i <= dsKQ.size(); i++) {
            str += "\nVán "+i+": ";
            if (dsKQ.get(i-1).intValue() == 0){
                t++;
                str += "Hòa";
            }else if (dsKQ.get(i-1).intValue()<0){
                str += "player 1 wins!";
                t1++;
            }
            else {
                t2++;
                str += "player 2 wins!";
            }

        }
        int sl = dsKQ.size();
        txtKQ.setText(str);
        KQ1.setText("" + t1);
        KQ2.setText("" + t2);
        KQ3.setText("" + t);
        TL1.setText("" + ((t1*100)/sl) + " %");
        TL2.setText("" + ((t2*100)/sl) + " %");
        TL3.setText("" + ((t*100)/sl) + " %");
    }
}