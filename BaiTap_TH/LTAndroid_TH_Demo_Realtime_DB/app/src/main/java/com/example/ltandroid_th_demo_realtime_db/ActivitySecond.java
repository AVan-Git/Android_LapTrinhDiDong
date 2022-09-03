package com.example.ltandroid_th_demo_realtime_db;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;

public class ActivitySecond extends AppCompatActivity {

    private static final String NAME_TABLE = "persons";
    private static final String TAG = "ActivitySecond   -" ;
    private FirebaseDatabase db;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        db = FirebaseDatabase.getInstance();
        reference = db.getReference();

        TextView txtRegister_ac2 = findViewById(R.id.txtRegister_ac2);
        Button btnSignIn_ac2 = findViewById(R.id.btnSignIn_ac2);

        EditText edEmail = findViewById(R.id.edEmail);
        EditText edPass = findViewById(R.id.edPass);
        //
//        edEmail.setText("user@gmail.com ");
//        edPass.setText("123456");

        //
        btnSignIn_ac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edEmail.getText().toString();
                String pass = edPass.getText().toString();


                reference.child("persons").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        int z1 = 0;

                        for (DataSnapshot snap :
                                snapshot.getChildren()) {
                            Person a = snap.getValue(Person.class);
                            if (email.equals(a.getEmail()))
                            {
                                z1 = 1;
                                if (pass.equals(a.getPass()))
                                {
                                    z1 =2;
                                    Intent intent = new Intent(ActivitySecond.this, ActivityThree.class);
                                    intent.putExtra("person",  a);
                                    startActivity(intent);
                                }
                            }
                        }
                        if (z1 == 0)
                        {
                            Toast.makeText(ActivitySecond.this, "Không có email trên.", Toast.LENGTH_SHORT).show();
                        }
                        else if (z1 == 1){
                            Toast.makeText(ActivitySecond.this, "Sai pass.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });
        //
        txtRegister_ac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivitySecond.this, MainActivity.class));
            }
        });



    }
}