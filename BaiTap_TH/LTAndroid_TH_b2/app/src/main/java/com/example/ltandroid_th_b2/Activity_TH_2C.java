package com.example.ltandroid_th_b2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_TH_2C extends AppCompatActivity {

    int soCheck = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th2_c);

        TextView txtView = findViewById(R.id.txtView);
        EditText edPass = findViewById(R.id.ed_Pass);
        Button btnGenerate = findViewById(R.id.btnGenerate);
        CheckBox cb1 = findViewById(R.id.checkBox);
        CheckBox cb2 = findViewById(R.id.checkBox2);
        CheckBox cb3 = findViewById(R.id.checkBox3);
        CheckBox cb4 = findViewById(R.id.checkBox4);

        //
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(compoundButton.getContext(),
                        compoundButton.getText()+ " | " + b, Toast.LENGTH_SHORT).show();
            }
        });
        //
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(compoundButton.getContext(),
                        compoundButton.getText()+ " | " + b, Toast.LENGTH_SHORT).show();
            }
        });
        //
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(compoundButton.getContext(),
                        compoundButton.getText()+ " | " + b, Toast.LENGTH_SHORT).show();
            }
        });
        //
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(compoundButton.getContext(),
                        compoundButton.getText()+ " | " + b, Toast.LENGTH_LONG).show();
            }
        });
        //
        edPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                txtView.setText(""+edPass.getText().length());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cb1.isChecked()) soCheck ++;
                if (cb2.isChecked()) soCheck ++;
                if (cb3.isChecked()) soCheck ++;
                if (cb4.isChecked()) soCheck ++;

                Toast.makeText( Activity_TH_2C.this, edPass.getText() + " - " + soCheck, Toast.LENGTH_SHORT).show();
                soCheck = 0;
            }
        });




    }
}