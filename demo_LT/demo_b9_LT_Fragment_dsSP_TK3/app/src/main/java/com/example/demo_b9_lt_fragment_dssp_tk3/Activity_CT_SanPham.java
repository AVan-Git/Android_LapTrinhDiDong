package com.example.demo_b9_lt_fragment_dssp_tk3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_CT_SanPham extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_san_pham);


        ImageView imgAnh = findViewById(R.id.img_Ac3);
        TextView txtName = findViewById(R.id.txtName_ac3);
        TextView txtGia = findViewById(R.id.txtGia_ac3);
        TextView txtXuatXu = findViewById(R.id.txtXuatXu_ac3);
        TextView txtCongDung = findViewById(R.id.txtCongDung_ac3);
        TextView txtThanhPhan = findViewById(R.id.txtThanhPhan_ac3);

        SanPham a = (SanPham) getIntent().getSerializableExtra("sp");

        imgAnh.setImageResource(a.getMaID());
        txtName.setText(a.getTen());
        txtXuatXu.setText(a.getXuatxu());
        txtThanhPhan.setText("Thành phần: " + a.getThanhPhan());
        txtCongDung.setText("Công dụng: " + a.getCongDung());
        txtGia.setText(""+a.getGia()+" VND/Hộp( "+ a.getDungTich()+"ml )");




        ImageView imgAdd = findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_CT_SanPham.this, "đang cập nhật.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}