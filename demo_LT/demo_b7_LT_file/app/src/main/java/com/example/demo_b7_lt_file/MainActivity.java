package com.example.demo_b7_lt_file;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLuu = findViewById(R.id.btnLuu);
        Button btnDoc = findViewById(R.id.btnDocFile);
        Button btnXoa = findViewById(R.id.btnXoa);

        TextView txtKQ = findViewById(R.id.txtKQ);
        TextView txtKQ2 = findViewById(R.id.txtKQ2);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = "text1.txt";
                String data = "Wellcome to my project.";
                NhanVien a = new NhanVien(2022, "String hoten", "Nam", "String donvi");

                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream(fileName));

//                    outputStream.write(data.getBytes());
                    outputStream.writeObject(a);

                    txtKQ2.setText("1" + getFilesDir());
                    outputStream.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = "text1.txt";
                String data = "";
                int c;
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));

                    while((c = inputStream.read()) != -1)
                    {
                        data += ((NhanVien)inputStream.readObject()).toString();
                    }
                    txtKQ.setText(data);
                    inputStream.close();

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
        //
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                deleteFile("text1.txt");
                txtKQ2.setText("2");
            }
        });



    }
    //


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.mymenu, menu);

        return true;
    }
    //

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnXemDsSinhVien: {
                Toast.makeText(MainActivity.this, "Click DS Sinh vieen", Toast.LENGTH_SHORT).show();

                break;
            }
            case R.id.mnXemDsLopHoc: {
                Toast.makeText(MainActivity.this, "Click DS Lớp học", Toast.LENGTH_SHORT).show();

                break;
            }
            case R.id.mnSuaLopHoc: {
                Toast.makeText(MainActivity.this, "Click Sửa", Toast.LENGTH_SHORT).show();

                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}