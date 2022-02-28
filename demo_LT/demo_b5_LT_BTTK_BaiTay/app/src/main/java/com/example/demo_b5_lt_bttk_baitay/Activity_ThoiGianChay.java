package com.example.demo_b5_lt_bttk_baitay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_ThoiGianChay extends AppCompatActivity {

    int x = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoi_gian_chay);
        Button btnOK = findViewById(R.id.btnOK);

        RadioButton rdGiay = findViewById(R.id.rdSS);
        RadioButton rdPhut = findViewById(R.id.rdMS);
        RadioButton rdMM = findViewById(R.id.rdMM);

        TextView txtTB3 = findViewById(R.id.txtTB3);
        TextView txtTB4 = findViewById(R.id.txtTB4);

        EditText edChay = findViewById(R.id.edTGChay);
        EditText edNhay = findViewById(R.id.edTGNhay);

        rdGiay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(Activity_ThoiGianChay.this, compoundButton.getText(), Toast.LENGTH_SHORT).show();
                    x = 1;
                    txtTB3.setText("Nhập số thời gian chạy(s):");
                    txtTB4.setText("Nhập số thời gian cho 1 bước nhảy(s):");
                }
            }
        });
        rdPhut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(Activity_ThoiGianChay.this, compoundButton.getText(), Toast.LENGTH_SHORT).show();
                    x = 0;
                    txtTB3.setText("Nhập số thời gian chạy(m):");
                    txtTB4.setText("Nhập số thời gian cho 1 bước nhảy(s):");
                }
            }
        });
        rdMM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(Activity_ThoiGianChay.this, compoundButton.getText(), Toast.LENGTH_SHORT).show();
                    x = -1;
                    txtTB3.setText("Nhập số thời gian chạy(m):");
                    txtTB4.setText("Nhập số thời gian cho 1 bước nhảy(m):");
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(rdGiay.isChecked() || rdPhut.isChecked() || rdMM.isChecked())) {
                    return;
                }
                if (!checkEdText()) {
                    Toast.makeText(Activity_ThoiGianChay.this, "Chưa nhập thời gian." , Toast.LENGTH_SHORT).show();
                    return;
                }
                int TGChay = Integer.parseInt(edChay.getText().toString());
                int TGNhay = Integer.parseInt(edNhay.getText().toString());
                if (x < 0) {
                    TGChay = TGChay * 60;
                    TGNhay *= 60;
                } else if (x == 0) {
                    TGChay = TGChay * 60;
                }
                if (TGChay < TGNhay)
                {
                    Toast.makeText(Activity_ThoiGianChay.this, "Thời gian nhập không hợp lệ." , Toast.LENGTH_SHORT).show();
                    return;
                }

//                Toast.makeText(Activity_ThoiGianChay.this, ""+TGChay+"-"+TGNhay , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Activity_ThoiGianChay.this, Activity_BT2.class);

                intent.putExtra("TGChay", TGChay);
                intent.putExtra("TGNhay", TGNhay);

                startActivity(intent);
            }

            private boolean checkEdText() {
                String tgChay = edChay.getText().toString();
                String tgNhay = edNhay.getText().toString();
                if (tgChay.equals("") || tgNhay.equals("")) {
                    return false;
                }
                return true;
            }
        });
    }
}