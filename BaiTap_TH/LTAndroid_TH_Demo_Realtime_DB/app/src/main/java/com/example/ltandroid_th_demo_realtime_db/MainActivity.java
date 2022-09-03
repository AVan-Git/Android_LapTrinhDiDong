package com.example.ltandroid_th_demo_realtime_db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        //
        Button btnRegister_ac1 = findViewById(R.id.btnRegister_ac1);
        Button btnSignIn_ac1 = findViewById(R.id.btnSignIn_ac1);

        EditText edEmail_ac3 = findViewById(R.id.txtEmail_ac1);
        EditText edName_ac3 = findViewById(R.id.txtName_ac1);
        EditText edPass1_ac3 = findViewById(R.id.txtPass1_ac1);
        EditText edPass2_ac3 = findViewById(R.id.txtPass2_ac1);
        //
        btnRegister_ac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                reference.setValue(edEmail.getText().toString());

                String email = edEmail_ac3.getText().toString();
                String pass1 = edPass1_ac3.getText().toString();
                String pass2 = edPass2_ac3.getText().toString();
                if (!pass1.equals(pass2)) {
                    edPass2_ac3.setError("Pass không trùng.");
                    return;
                }
                String name = edName_ac3.getText().toString();

                Person person = new Person(3, email, pass1, name);

                reference.child("persons").child(String.valueOf(person.getId())).setValue(person);
                Toast.makeText(MainActivity.this, "Thêm thành công.", Toast.LENGTH_SHORT).show();

            }
        });
        //
        btnSignIn_ac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivitySecond.class));
            }
        });

//        btnGetData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DataSnapshot> task) {
//                        if (task.isSuccessful())
//                        {
//                            Object obj = task.getResult().getValue();
//                            Toast.makeText(MainActivity.this , obj.toString(), Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });
//            }
//        });
    }
}