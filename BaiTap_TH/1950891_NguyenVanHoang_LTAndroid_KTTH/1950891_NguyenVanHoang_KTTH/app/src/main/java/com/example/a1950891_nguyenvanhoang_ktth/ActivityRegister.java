package com.example.a1950891_nguyenvanhoang_ktth;

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

public class ActivityRegister extends AppCompatActivity {


    private static final String TAG = "ActivityRegister +++++";
    private FirebaseAuth mAuth;
    EditText txtEmail_ac3, txtPass1_ac3, txtPass2_ac3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        Button btnSignIn_ac3 = findViewById(R.id.btnAdd_ac4);

        txtEmail_ac3 = findViewById(R.id.txtId_ac4);
        txtPass1_ac3 = findViewById(R.id.txtName_ac4);
        txtPass2_ac3 = findViewById(R.id.txtSongay_ac4);

        btnSignIn_ac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!check_data()) {
                    return;
                }
                String email = txtEmail_ac3.getText().toString().trim();
                String pass1 = txtPass1_ac3.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(email, pass1)
                        .addOnCompleteListener(ActivityRegister.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(ActivityRegister.this, "Tạo thành công.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(ActivityRegister.this, ActivitySignIn.class);
                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(ActivityRegister.this, "email trên đã được sử dụng.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }

        });
    }

    private boolean check_data() {

        String email = txtEmail_ac3.getText().toString().trim();
        String pass1 = txtPass1_ac3.getText().toString().trim();
        String pass2 = txtPass2_ac3.getText().toString().trim();


        if (email.equals("")) {
            txtEmail_ac3.setError("Sai email!");
            txtEmail_ac3.setFocusable(true);
            Toast.makeText(ActivityRegister.this, "Hãy nhập email.", Toast.LENGTH_SHORT).show();
            return false;
        }
        String pass = txtPass1_ac3.getText().toString().trim();
        if (pass.equals("")) {
            txtPass1_ac3.setFocusable(true);
            Toast.makeText(ActivityRegister.this, "Hãy nhập mật khẩu.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (pass.length() < 6) {
            txtPass1_ac3.setError("Mật khẩu phải trên 6 ký tự.");
            txtPass1_ac3.setFocusable(true);
            return false;
        }
        if (!pass2.equals(pass1)) {
            txtPass2_ac3.setError("Mật khẩu không trùng.");
            return false;
        }
        return true;

    }
}