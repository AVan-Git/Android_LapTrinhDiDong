package com.example.demo_b7_lt_file;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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