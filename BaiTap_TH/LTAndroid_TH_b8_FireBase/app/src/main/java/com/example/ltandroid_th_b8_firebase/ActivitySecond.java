package com.example.ltandroid_th_b8_firebase;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivitySecond extends AppCompatActivity {

    public final String TAG = "ActivitySecond";
    int z1=0;
    private FirebaseAuth mAuth;
    TextView txt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        TextView txtRegister_ac2 = findViewById(R.id.txtRegister_ac2);
        Button btnSignIn_ac2 = findViewById(R.id.btnSignIn_ac2);

        EditText edEmail = findViewById(R.id.edEmail);
        EditText edPass = findViewById(R.id.edPass);

        txtRegister_ac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivitySecond.this, ActivityThree.class);
                startActivity(intent);
            }
        });
        //
        btnSignIn_ac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edEmail.getText().toString().trim();
                if (email.equals(""))
                {
                    edEmail.setError("Sai email!");
                    edEmail.setFocusable(true);
                    Toast.makeText(ActivitySecond.this, "Hãy nhập email.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pass = edPass.getText().toString().trim();
                if (pass.equals(""))
                {
                    Toast.makeText(ActivitySecond.this, "Hãy nhập pass.", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(ActivitySecond.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    Intent intent = new Intent(ActivitySecond.this, ActivityFour.class);

                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("TAG", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(ActivitySecond.this, "Đăng nhập không thành công.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            }

        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null)
        {
            Intent intent = new Intent(ActivitySecond.this, ActivityFour.class);

            startActivity(intent);
        }
    }

}