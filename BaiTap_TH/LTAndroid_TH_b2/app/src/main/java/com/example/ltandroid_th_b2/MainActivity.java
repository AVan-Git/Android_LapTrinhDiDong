package com.example.ltandroid_th_b2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtUser = findViewById(R.id.txtUser);
        TextView txtPass = findViewById(R.id.txtPass);
        Button btnClick = findViewById(R.id.btnClick);



        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                text = txtUser.getText().toString() + "-" + txtPass.getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });


    }
}