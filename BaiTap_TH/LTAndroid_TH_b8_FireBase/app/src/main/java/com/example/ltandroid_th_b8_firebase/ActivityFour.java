package com.example.ltandroid_th_b8_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityFour extends AppCompatActivity {

    public final String TAG = "ActivityFour";
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        mUser = FirebaseAuth.getInstance().getCurrentUser();
        Button btnFinish_ac4 = findViewById(R.id.btnFinish_ac4);

        TextView txtKQ = findViewById(R.id.txtKQ);
        txtKQ.setText("Kết quả: " + mUser.getEmail() + " - " + mUser.getTenantId());


        btnFinish_ac4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(ActivityFour.this, "out User.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ActivityFour.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}