package com.example.ltandroid_th_b8_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Button btnSignIn_ac3 = findViewById(R.id.btnSignIn_ac3);

        btnSignIn_ac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityThree.this, ActivitySecond.class);
                startActivity(intent);
            }

        });
    }
}