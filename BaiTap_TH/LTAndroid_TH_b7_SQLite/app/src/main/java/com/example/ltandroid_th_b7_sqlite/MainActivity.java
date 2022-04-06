package com.example.ltandroid_th_b7_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edName = findViewById(R.id.edName);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnRemove = findViewById(R.id.btnRemove);
        Button btnCancel = findViewById(R.id.btnCancel);
        //



    }
}