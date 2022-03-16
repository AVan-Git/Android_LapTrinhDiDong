package com.example.ltandroid_th_b4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ltandroid_th_b4.bai1.SanPham;
import com.example.ltandroid_th_b4.bai1.SanPhamAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SanPham> dsSanPham;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnBack = findViewById(R.id.img_back);
        ImageButton btnCart = findViewById(R.id.imgCart);

        listview = findViewById(R.id.listview);
        dsSanPham = new ArrayList<>();

        dsSanPham.add(new SanPham(R.drawable.ca_nau_lau, "Ca nấu lẩu, nấu mì mini...", "Devang"));
        dsSanPham.add(new SanPham(R.drawable.ga_bo_toi, "1KG KHÔ GÀ BỎ TỎI...", "LTD Food"));
        dsSanPham.add(new SanPham(R.drawable.xa_can_cau, "Xe cần cẩu", "Thế giới đồ chơi"));
        dsSanPham.add(new SanPham(R.drawable.do_choi_dang_mo_hinh, "Đồ chơi đa năng", "Thế giới đồ chơi"));
        dsSanPham.add(new SanPham(R.drawable.lanh_dao_gian_don, "Lãnh đạo giản đơn", "Minh Long book"));
//        dsSanPham.add(new SanPham(R.drawable.trump_1, "Donal Trump Thiên tài lãnh đạo", "Hoàng book"));
        dsSanPham.add(new SanPham(R.drawable.hieu_long_con_tre, "Hiểu lòng con trẻ", "Minh Long book"));

        SanPhamAdapter adapter = new SanPhamAdapter(MainActivity.this, dsSanPham);

        listview.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Thêm sản phẩm.", Toast.LENGTH_SHORT).show();
            }
        });
    }


}