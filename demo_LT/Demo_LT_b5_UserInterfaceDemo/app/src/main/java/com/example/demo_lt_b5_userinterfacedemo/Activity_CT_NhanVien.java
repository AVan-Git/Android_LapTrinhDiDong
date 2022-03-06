package com.example.demo_lt_b5_userinterfacedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_CT_NhanVien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_nhan_vien);

        ImageView imgAnh = findViewById(R.id.imageView);

        Button btnExit = findViewById(R.id.btnExit2);

        TextView txtHoten = findViewById(R.id.txtName);
        TextView txtGioiTinh = findViewById(R.id.txtGioiTinh);
        TextView txtDonvi = findViewById(R.id.txtDonvi);

        txtHoten.setText(getIntent().getExtras().getString("hoten"));
        txtGioiTinh.setText(getIntent().getExtras().getString("gioiTinh"));
        txtDonvi.setText(getIntent().getExtras().getString("donVi"));
        imgAnh.setImageURI(Uri.parse(getIntent().getExtras().getString("soAnh")));

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}