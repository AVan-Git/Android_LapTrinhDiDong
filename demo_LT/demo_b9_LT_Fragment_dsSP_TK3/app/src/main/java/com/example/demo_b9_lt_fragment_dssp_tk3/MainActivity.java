package com.example.demo_b9_lt_fragment_dssp_tk3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView gridView = findViewById(R.id.gridView);

        ArrayList<SanPham> dsSanPham = new ArrayList<>();

        dsSanPham.add(new SanPham(R.drawable.sua_tuoi_dalat_milk_thanh_trung_khong_duong_447031, "Sữa Dalat Milk","Ireland (Dairy Master )", 6000, 200, "100% sữa bò tươi,...", "Cung cấp chất dinh dưỡng có trong sữa bò tươi như: Chất đạm, chất béo, các vitamin và khoáng chất" ));
        dsSanPham.add(new SanPham(R.drawable.sua_oc_cho_hanh_nhan_dau_den_han_quoc_213642, "Sữa Óc Chó  ","Hàn Quốc", 9000, 195, "Sữa đậu nành đen 90%, quả óc chó 0.4%, đậu nành đen 0.2% Hàn Quốc, v.v", "Giúp đường tiêu hóa tốt hơn, ăn ngon hơn, cơ thể khỏe mạnh hơn, da đẹp hơn, đầu óc minh mẫn hơn" ));
        dsSanPham.add(new SanPham(R.drawable.sua_dau_nanh_fami, "Sữa đậu nành","Việt Nam (Vinasoy)", 8500, 200, "Nước, dịch trích từ đậu nành hạt, đường kính trắng, chất điều chỉnh độ pH,...", "Hỗ trợ loại bỏ tế bào chết và tăng độ đàn hồi cho da, giúp da luôn sáng khoẻ." ));
        dsSanPham.add(new SanPham(R.drawable.milo, "Sữa Nestle MILO","Úc", 8000, 180, "Nước, đường, sữa bột tách kem, Protomalt được chiết xuất từ những hạt mầm lúa mạch, sirô glucose, dầu bơ và thực vật,…", "- Cung cấp năng lượng cho hoạt động hằng ngày.\n" +
                "- Giúp tăng cường sức khỏe, tạo độ dẻo dai.\n" ));
        dsSanPham.add(new SanPham(R.drawable.th_true_milk, "TH true milk","Việt Nam (TH)", 9000, 180, "Sữa tươi, vitamin A, D, B1, B2, khoáng chất, collagen, canxi, phytosterol, chất xơ, cacbohydrate..", "Cung cấp các dưỡng chất thiết yếu cho sự phát triển trí lực và thể chất của cả gia đình." ));
        dsSanPham.add(new SanPham(R.drawable.moc_chau_milk, "Sữa Mộc Châu","Thụy Điển(Etra Pak)", 5000, 110, "Sữa bò tươi nguyên chất, đường kính trắng, canxi, chất béo, protein, vitamin và một số khoáng chất", "Đảm bảo cung cấp các loại vitamin và khoáng chất cần thiết cho quá trình tăng trưởng của con người," ));
        dsSanPham.add(new SanPham(R.drawable.co_gai_ha_lan, "Sữa Dutch Lady","Hà Lan (Dutch Lady)", 10000, 200, "Bột sữa gầy (11%), sữa tươi (10%), đường, chất béo sữa,...", "Sản phẩm dồi dào protein, loại đạm sữa chất lượng cao dinh dưỡng, an toàn." ));
        dsSanPham.add(new SanPham(R.drawable.sua_ba_vi, "Sữa tươi Ba Vì","Việt Nam", 9000, 180, "Sữa (100% sữa bò tươi), đường tinh luyện, chất ổn định (E471, E407), hương liệu tổng hợp dùng cho thực phẩm…", "Sữa tươi tiệt trùng Ba Vì có đường dùng mỗi ngày có thể cải thiện sức đề kháng, chiều cao và giúp bạn khỏe mạnh hơn." ));
        dsSanPham.add(new SanPham(R.drawable.nuoc_yen_sao_khanh_hoa_190ml_202001161022050124, "Nước yến sào","Việt Nam", 9000, 200, "Được chế biến từ nguồn Yến sào đảo thiên nhiên và giữ nguyên tính năng của Yến", "" ));
        dsSanPham.add(new SanPham(R.drawable.sua_tuoi_dalat_milk_thanh_trung_khong_duong_447031, "","", 9000, 200, "", "" ));
        dsSanPham.add(new SanPham(R.drawable.sua_tuoi_dalat_milk_thanh_trung_khong_duong_447031, "","", 9000, 200, "", "" ));

        gridView.setAdapter(new SanPhamAdapter(MainActivity.this, dsSanPham));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(MainActivity.this, .class);
//                intent.putExtra("sp", dsSanPham.get(i));
//                startActivity(intent);

            }
        });


        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}