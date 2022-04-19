package com.example.ltandroid_th_b8_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        Button btnFinish_ac4 = findViewById(R.id.btnFinish_ac4);


        btnFinish_ac4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
                Intent intent = new Intent(ActivityFour.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}