package com.example.ltandroid_th_b8_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityThree extends AppCompatActivity {

    private static final String TAG = "ActivityThree ++++";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        mAuth = FirebaseAuth.getInstance();

        Button btnSignIn_ac3 = findViewById(R.id.btnSignIn_ac3);

        EditText txtEmail_ac3 = findViewById(R.id.txtEmail_ac3);
        EditText txtName_ac3 = findViewById(R.id.txtName_ac3);
        EditText txtPass1_ac3 = findViewById(R.id.txtPass1_ac3);
        EditText txtPass2_ac3 = findViewById(R.id.txtPass2_ac3);

        btnSignIn_ac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txtEmail_ac3.getText().toString().trim();
                String pass = txtPass1_ac3.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(ActivityThree.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(ActivityThree.this, ActivitySecond.class);
                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(ActivityThree.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }

        });
    }
}