package com.example.ltandroid_th_b6_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ltandroid_th_b6_fragment.entity.SanPham;
import com.example.ltandroid_th_b6_fragment.entity.SanPhamAdapter;

import java.util.ArrayList;

public class DsSanPham extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_san_pham);
        ListView listView = findViewById(R.id.listItem_Acds);

        ArrayList<SanPham> dsSanPham = new ArrayList<>();

        dsSanPham.add(new SanPham(R.drawable.shoes_rm_preview_b, "Nike shoes-discount ", 50));
        dsSanPham.add(new SanPham(R.drawable.shoes_rm_preview_a, "Adidas shoes-discount ", 80));
        dsSanPham.add(new SanPham(R.drawable.shoes_rm_purple, "Nike Bicycle-discount ", 30));
        dsSanPham.add(new SanPham(R.drawable.shoes_rm_preview, "Yonex shoes-discount ", 50));
        dsSanPham.add(new SanPham(R.drawable.shoes_rm_yellow, "Victor shoes-discount ", 50));
        dsSanPham.add(new SanPham(R.drawable.shoes_white_removebg_preview, "Lining shoes-discount ", 50));
        dsSanPham.add(new SanPham(R.drawable.color_removebg_preview, "Binh Minh shoes-discount ", 90));
        dsSanPham.add(new SanPham(R.drawable.shoes_rm_preview_b, "Nike shoes-discount ", 20));

        SanPhamAdapter adapter = new SanPhamAdapter(DsSanPham.this, dsSanPham);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DsSanPham.this, Activity_Ct_SanPham.class);
                intent.putExtra("sp" , dsSanPham.get(i));
                startActivity(intent);
            }
        });

    }
}