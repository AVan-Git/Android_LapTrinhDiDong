package com.example.a19508981_nguyenvanhoang_ltandroid_baigk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Activity_Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnTrending = findViewById(R.id.btnTrending);
        Button btnPopular = findViewById(R.id.btnPopular);
        Button btnRecom = findViewById(R.id.btnRecom);


        ListView listView = findViewById(R.id.listview);
        ArrayList<SanPham> dsSanPham = new ArrayList<>();
        dsSanPham.add(new SanPham(R.drawable.bione_removebg_preview, "Red Bull One", 350));
        dsSanPham.add(new SanPham(R.drawable.bifour__removebg_preview, "Blue One", 950));


        SanPhamAdapter adapter = new SanPhamAdapter(Activity_Second.this, dsSanPham);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Activity_Second.this, Activity_CT_SanPham.class);
                intent.putExtra("sp", dsSanPham.get(i));

                startActivity(intent);

            }
        });

        btnRecom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SanPhamAdapter adapter = new SanPhamAdapter(Activity_Second.this, dsSanPham);

                listView.setAdapter(adapter);
            }
        });
        btnTrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<SanPham> list = new ArrayList<>();

                for (SanPham a:
                     dsSanPham) {
                    if (a.getGia1() >= 500)
                    list.add(a);
                }
                SanPhamAdapter adapter = new SanPhamAdapter(Activity_Second.this, list);

                listView.setAdapter(adapter);
            }
        });
        btnPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<SanPham> list = new ArrayList<>();

                for (SanPham a:
                        dsSanPham) {
                    if (a.getGia1() < 500)
                        list.add(a);
                }
                SanPhamAdapter adapter = new SanPhamAdapter(Activity_Second.this, list);

                listView.setAdapter(adapter);
            }
        });



    }
}