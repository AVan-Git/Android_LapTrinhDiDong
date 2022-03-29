package com.example.demo_b9_lt_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        GridView gridView = findViewById(R.id.gridView_ac2);

        EditText edID = findViewById(R.id.ed_ID_ac2);
        EditText edName = findViewById(R.id.ed_Name_ac2);
        EditText edAddress = findViewById(R.id.ed_Address_ac2);
        EditText edEmail = findViewById(R.id.ed_Email_ac2);

        Button btnSelect = findViewById(R.id.btnSelect_Ac2);
        Button btnSave = findViewById(R.id.btnSave_Ac2);
        Button btnUpdate = findViewById(R.id.btnUpdate_Ac2);
        Button btnDelete = findViewById(R.id.btnDelete_Ac2);

        SQLiteDatabase sqLiteDatabase= openOrCreateDatabase("QLAuthor", MODE_PRIVATE, null);

        //
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edID.getText().toString());
                String name = edName.getText().toString();
                String address = edAddress.getText().toString();
                String email = edEmail.getText().toString();
            }
        });
        //
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        ///
        findViewById(R.id.btnExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}