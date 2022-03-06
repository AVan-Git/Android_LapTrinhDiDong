package com.example.demo_lt_b5_userinterfacedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.net.URL;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    int[] img = {R.drawable.avatar0, R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4
            , R.drawable.avatar5, R.drawable.avatar6, R.drawable.avatar7};
    int z1 = 0;
    String z3 = "";
    ImageView imgAnh;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnExit = findViewById(R.id.btnExit);
        Button btnChonAnh = findViewById(R.id.btnChonAnh);

        imgAnh = findViewById(R.id.imgNV2);

        textView = findViewById(R.id.txtA);

        btnChonAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Intent intent  =  new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 999);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 999 && data != null)
        {
            Uri selectdImage = data.getData();
            ImageView imgAnh = findViewById(R.id.imgNV2);

            imgAnh.setImageURI(selectdImage);

        }
    }

    private int randdom(int min, int max){

        return (int) ((Math.random())*((max - min) + 1)+ min);
    }

}