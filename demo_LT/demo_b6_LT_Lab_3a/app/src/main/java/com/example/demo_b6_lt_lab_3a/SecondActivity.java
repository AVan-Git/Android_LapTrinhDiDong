package com.example.demo_b6_lt_lab_3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int z1 = R.drawable.vs_red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnXong = findViewById(R.id.btnXong);

        ImageView imgAnh = findViewById(R.id.img_Anh2);
        ImageView imgBac = findViewById(R.id.img_bac);
        ImageView imgDo = findViewById(R.id.img_do);
        ImageView imgDen = findViewById(R.id.img_den);
        ImageView imgXanh = findViewById(R.id.img_xanh);

        TextView txtMau  =findViewById(R.id.txtMau);
        //
        imgBac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMau.setText("bạc");
                z1 = R.drawable.vs_bac;
                imgAnh.setImageResource(z1);
            }
        });

        //
        imgDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMau.setText("đen");
                z1 = R.drawable.vs_black;
                imgAnh.setImageResource(z1);
            }
        });

        //
        imgDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMau.setText("đỏ");
                z1 = R.drawable.vs_red;
                imgAnh.setImageResource(z1);
            }
        });

        //
        imgXanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                z1 = R.drawable.vs_xanh;
                txtMau.setText("xanh");
                imgAnh.setImageResource(z1);
            }
        });

        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.putExtra("index", z1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}