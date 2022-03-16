package com.example.ltandroid_th_b4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ltandroid_th_b4.bai2.SanPham;
import com.example.ltandroid_th_b4.bai2.SanPhamAdapter;

import java.util.ArrayList;

public class ActivitySecondGridview extends AppCompatActivity {

    ArrayList<SanPham> dsSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_gridview);

        GridView gridView = findViewById(R.id.gridView);
        dsSanPham = new ArrayList<>();
        dsSanPham.add(new SanPham(R.drawable.giacchuyen_1, "Cáp chuyển từ Cổng USB sang PS2...", 50, 50000));
        dsSanPham.add(new SanPham(R.drawable.daynguon_1, "Cáp chuyển từ Cổng USB sang PS2...", 50, 50000));
        dsSanPham.add(new SanPham(R.drawable.dauchuyendoipsps2_1, "Cáp chuyển từ Cổng USB sang PS2...", 50, 50000));
        dsSanPham.add(new SanPham(R.drawable.dauchuyendoi_1, "Cáp chuyển từ Cổng USB sang PS2...", 50, 50000));
        dsSanPham.add(new SanPham(R.drawable.carbusbtops2_1, "Cáp chuyển từ Cổng USB sang PS2...", 50, 50000));
        dsSanPham.add(new SanPham(R.drawable.daucam_1, "Cáp chuyển từ Cổng USB sang PS2...", 50, 50000));

        SanPhamAdapter adapter = new SanPhamAdapter(ActivitySecondGridview.this, dsSanPham);
        gridView.setAdapter(adapter);

        ImageButton btnBack = findViewById(R.id.imgBack);
        ImageButton btnCart = findViewById(R.id.imgCart2);
        Button btnMenu = findViewById(R.id.btnMenu);
        EditText edSearch = findViewById(R.id.edSearch);

        //
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivitySecondGridview.this, "Đang cập nhật.", Toast.LENGTH_SHORT).show();
            }
        });
        //
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivitySecondGridview.this, "Đang cập nhật.", Toast.LENGTH_SHORT).show();
            }
        });
        //
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}