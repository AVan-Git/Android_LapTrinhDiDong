package com.example.ltandroid_th_b8_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtRegister_ac2 = findViewById(R.id.txtRegister_ac2);
        Button btnSignIn_ac2 = findViewById(R.id.btnSignIn_ac2);

        txtRegister_ac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(ActivitySecond.this, "Đang cập nhật...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ActivitySecond.this, ActivityThree.class);
                startActivity(intent);
            }
        });
        //
        btnSignIn_ac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivitySecond.this, ActivityFour.class);
                startActivity(intent);
            }
        });


    }
}