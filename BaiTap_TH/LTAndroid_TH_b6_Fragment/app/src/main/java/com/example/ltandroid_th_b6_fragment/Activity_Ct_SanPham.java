package com.example.ltandroid_th_b6_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ltandroid_th_b6_fragment.entity.SanPham;

public class Activity_Ct_SanPham extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_san_pham);

        SanPham a = (SanPham) getIntent().getSerializableExtra("sp");

        ImageView imageView = findViewById(R.id.imageView_ac_CTSanpham);
        TextView txtName = findViewById(R.id.txtName_Ac_CTSanpham);
        TextView txtDiscount = findViewById(R.id.txtDiscount_ac_CTSanpham);

        imageView.setImageResource(a.getId());
        txtDiscount.setText("Discount: "+a.getDiscount()+" %");
        txtName.setText("Name: " + a.getName());

    }
}