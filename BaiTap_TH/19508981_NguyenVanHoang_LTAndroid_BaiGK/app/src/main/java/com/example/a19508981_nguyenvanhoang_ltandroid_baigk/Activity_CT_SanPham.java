package com.example.a19508981_nguyenvanhoang_ltandroid_baigk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_CT_SanPham extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_san_pham);

        Button btn = findViewById(R.id.btnAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_CT_SanPham.this, "đang cập nhật.", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView img = findViewById(R.id.imgAnh_ac3);
        TextView txtName = findViewById(R.id.txtName_ac3);
        TextView txtGia2 = findViewById(R.id.txtGia1_ac3);// gia truoc khi giam
        TextView txtGia1 = findViewById(R.id.txtGia2_ac3);// gia đc giam


        SanPham a = (SanPham) getIntent().getSerializableExtra("sp");
        img.setImageResource(a.getMaID());
        txtName.setText(a.getName());
        txtGia2.setText("10% OFF| "+a.getGia2()+"$");
        txtGia1.setText(""+a.getGia1()+"$");


    }
}