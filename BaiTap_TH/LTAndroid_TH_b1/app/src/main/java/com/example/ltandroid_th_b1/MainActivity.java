package com.example.ltandroid_th_b1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
            case R.id.mn1_a: {
                Toast.makeText(MainActivity.this, "Đang ở bài lab1_a.", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.mn1_b: {
                startActivity(new Intent(MainActivity.this, Activity_TH_B.class));
                break;
            }
            case R.id.mn1_c: {
                startActivity(new Intent(MainActivity.this, Activity_TH_C.class));
                break;
            }
            case R.id.mn1_d: {
                startActivity(new Intent(MainActivity.this, Activity_TH_D.class));
                break;
            }
            case R.id.mn1_e: {
                startActivity(new Intent(MainActivity.this, Activity_TH_E.class));
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}