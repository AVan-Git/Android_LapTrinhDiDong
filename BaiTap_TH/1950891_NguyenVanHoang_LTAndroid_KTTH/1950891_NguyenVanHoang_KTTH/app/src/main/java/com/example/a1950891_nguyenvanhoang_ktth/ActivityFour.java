package com.example.a1950891_nguyenvanhoang_ktth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a1950891_nguyenvanhoang_ktth.entity.Bussines;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityFour extends AppCompatActivity {
    private FirebaseDatabase db;
    private DatabaseReference reference;
    ArrayList<Bussines> list;
    BussinesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        db = FirebaseDatabase.getInstance();
        reference = db.getReference();
        list = getListData();

        Button btnLogout = findViewById(R.id.btnLogout);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnDS = findViewById(R.id.btnDS);

        ListView listView = findViewById(R.id.listview);
        //

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(ActivityFour.this, "Hẹn gặp lại.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ActivityFour.this, MainActivity.class);
                startActivity(intent);
            }
        });
//
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityFour.this, ActivityThemCV.class);
                startActivity(intent);
            }
        });

        btnDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new BussinesAdapter(ActivityFour.this, list);
                listView.setAdapter(adapter);
            }
        });

    }
    private ArrayList<Bussines> getListData() {

        ArrayList<Bussines> listBussines = new ArrayList<Bussines>();

        reference.child("bussines").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listBussines.clear();
                for (DataSnapshot snap :
                        snapshot.getChildren()) {
                    Bussines a = snap.getValue(Bussines.class);
                    listBussines.add(a);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return listBussines;
    }
}