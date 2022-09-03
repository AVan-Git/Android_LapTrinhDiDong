package com.example.a1950891_nguyenvanhoang_ktth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1950891_nguyenvanhoang_ktth.entity.Bussines;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityThemCV extends AppCompatActivity {

    private static final String TAG = "ActivityThemCV +++++";
    private FirebaseDatabase db;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_cv);
        db = FirebaseDatabase.getInstance("https://nguyenvanhoang-ktth-default-rtdb.firebaseio.com/");
        reference = db.getReference();

        TextView txtID = findViewById(R.id.txtId_ac4);
        TextView txtName = findViewById(R.id.txtName_ac4);
        TextView txtNgay = findViewById(R.id.txtSongay_ac4);

        Button btnAdd = findViewById(R.id.btnAdd_ac4);
        Button btnExit = findViewById(R.id.btnExit_ac4);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = txtID.getText().toString().trim();
                String name = txtName.getText().toString();
                String soNgay = txtNgay.getText().toString().trim();

                Bussines a = new Bussines(Integer.parseInt(id), name, Integer.parseInt(soNgay));

                Log.e(TAG, "Bussines: " + a.toString(), null );
                reference.child("bussines").child(String.valueOf(a.getId())).setValue(a);

                Toast.makeText(ActivityThemCV.this, "Thêm thành công.", Toast.LENGTH_SHORT).show();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityThemCV.this, ActivityFour.class);
                startActivity(intent);
            }
        });


    }
}