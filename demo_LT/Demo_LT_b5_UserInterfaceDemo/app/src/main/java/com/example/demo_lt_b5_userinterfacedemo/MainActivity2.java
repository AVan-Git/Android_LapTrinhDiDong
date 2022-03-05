package com.example.demo_lt_b5_userinterfacedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    int[] img = {R.drawable.avatar0, R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4
            , R.drawable.avatar5, R.drawable.avatar6, R.drawable.avatar7};
    int z1 = 0;
    String z3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnExit = findViewById(R.id.btnExit);
        Button btnChonAnh = findViewById(R.id.btnChonAnh);

        ImageView imgAnh = findViewById(R.id.imgNV);

        TextView textView = findViewById(R.id.txtA);

        btnChonAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = (int) (Math.random()*6);
                while (x == z1){
                    x = (int) (Math.random()*6);
                }
                z1 = x;

                z3 += x;
                textView.setText(z3);


                imgAnh.setImageResource(img[x]);

//                File imgFile = new File("/img/avatar1.jpg");
//
//                if (imgFile.exists()) {
//
//                    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//
//                    imgAnh.setImageBitmap(myBitmap);
//
//                }
            }
        });

    }

    private int randdom(int min, int max){

        return (int) ((Math.random())*((max - min) + 1)+ min);
    }

}