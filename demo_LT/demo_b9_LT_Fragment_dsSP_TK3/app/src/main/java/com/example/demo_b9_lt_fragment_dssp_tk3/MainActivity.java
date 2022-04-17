package com.example.demo_b9_lt_fragment_dssp_tk3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Display display;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    int z1 = 0, z2 = 0;
    Fragment_CT_SPham fragment_ct_sPham;
    ArrayList<SanPham> dsSanPham = new ArrayList<>();
    private SanPham a = new SanPham();

    TextView txtName, txtGia, txtXuatXu, txtCongDung, txtThanhPhan;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TAG - a:", a.toString());

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        InfoScreen(); // set màn hình đang ở trang thái nào(đứng || nằm)

        GridView gridView = findViewById(R.id.gridView);

        dsSanPham.add(new SanPham(R.drawable.sua_tuoi_dalat_milk_thanh_trung_khong_duong_447031, "Sữa Dalat Milk", "Ireland (Dairy Master )", 6000, 200, "100% sữa bò tươi,...", "Cung cấp chất dinh dưỡng có trong sữa bò tươi như: Chất đạm, chất béo, các vitamin và khoáng chất"));
        dsSanPham.add(new SanPham(R.drawable.sua_oc_cho_hanh_nhan_dau_den_han_quoc_213642, "Sữa Óc Chó  ", "Hàn Quốc", 9000, 195, "Sữa đậu nành đen 90%, quả óc chó 0.4%, đậu nành đen 0.2% Hàn Quốc, v.v", "Giúp đường tiêu hóa tốt hơn, ăn ngon hơn, cơ thể khỏe mạnh hơn, da đẹp hơn, đầu óc minh mẫn hơn"));
        dsSanPham.add(new SanPham(R.drawable.sua_dau_nanh_fami, "Sữa đậu nành", "Việt Nam (Vinasoy)", 8500, 200, "Nước, dịch trích từ đậu nành hạt, đường kính trắng, chất điều chỉnh độ pH,...", "Hỗ trợ loại bỏ tế bào chết và tăng độ đàn hồi cho da, giúp da luôn sáng khoẻ."));
        dsSanPham.add(new SanPham(R.drawable.milo, "Sữa Nestle MILO", "Úc", 8000, 180, "Nước, đường, sữa bột tách kem, Protomalt được chiết xuất từ những hạt mầm lúa mạch, sirô glucose, dầu bơ và thực vật,…", "- Cung cấp năng lượng cho hoạt động hằng ngày.\n" +
                "- Giúp tăng cường sức khỏe, tạo độ dẻo dai.\n"));
        dsSanPham.add(new SanPham(R.drawable.th_true_milk, "TH true milk", "Việt Nam (TH)", 9000, 180, "Sữa tươi, vitamin A, D, B1, B2, khoáng chất, collagen, canxi, phytosterol, chất xơ, cacbohydrate..", "Cung cấp các dưỡng chất thiết yếu cho sự phát triển trí lực và thể chất của cả gia đình."));
        dsSanPham.add(new SanPham(R.drawable.moc_chau_milk, "Sữa Mộc Châu", "Thụy Điển(Etra Pak)", 5000, 110, "Sữa bò tươi nguyên chất, đường kính trắng, canxi, chất béo, protein, vitamin và một số khoáng chất", "Đảm bảo cung cấp các loại vitamin và khoáng chất cần thiết cho quá trình tăng trưởng của con người,"));
        dsSanPham.add(new SanPham(R.drawable.co_gai_ha_lan, "Sữa Dutch Lady", "Hà Lan (Dutch Lady)", 10000, 200, "Bột sữa gầy (11%), sữa tươi (10%), đường, chất béo sữa,...", "Sản phẩm dồi dào protein, loại đạm sữa chất lượng cao dinh dưỡng, an toàn."));
        dsSanPham.add(new SanPham(R.drawable.sua_ba_vi, "Sữa tươi Ba Vì", "Việt Nam", 9000, 180, "Sữa (100% sữa bò tươi), đường tinh luyện, chất ổn định (E471, E407), hương liệu tổng hợp dùng cho thực phẩm…", "Sữa tươi tiệt trùng Ba Vì có đường dùng mỗi ngày có thể cải thiện sức đề kháng, chiều cao và giúp bạn khỏe mạnh hơn."));
        dsSanPham.add(new SanPham(R.drawable.nuoc_yen_sao_khanh_hoa_190ml_202001161022050124, "Nước yến sào", "Việt Nam", 9000, 200, "Được chế biến từ nguồn Yến sào đảo thiên nhiên và giữ nguyên tính năng của Yến", ""));
        dsSanPham.add(new SanPham(R.drawable.sua_tuoi_dalat_milk_thanh_trung_khong_duong_447031, "", "", 9000, 200, "", ""));
        dsSanPham.add(new SanPham(R.drawable.sua_tuoi_dalat_milk_thanh_trung_khong_duong_447031, "", "", 9000, 200, "", ""));


        gridView.setAdapter(new SanPhamAdapter(MainActivity.this, dsSanPham));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                a = dsSanPham.get(i);
                if (z1 > 0) {
                    Intent intent = new Intent(MainActivity.this, Activity_CT_SanPham.class);

                    Log.d("TAG - a ( gridView.setOnItemClickListener ):", a.toString());
                    intent.putExtra("sp", dsSanPham.get(i));
                    startActivityForResult(intent, 999);
                } else {

                    fragment_ct_sPham = (Fragment_CT_SPham) getFragmentManager().findFragmentById(R.id.fragment_ct_spham);

//                    fragment_ct_sPham.setUpdate(a);

                    txtName = (TextView) findViewById(R.id.textname);
                    txtGia = (TextView) findViewById(R.id.txtGia_acland);
                    txtXuatXu = (TextView) findViewById(R.id.txtXuatXu_acland);
                    txtCongDung = (TextView) findViewById(R.id.txtCongDung_acland);
                    txtThanhPhan = (TextView) findViewById(R.id.txtThanhPhan_acland);
                    //
                    txtName.setText(a.getTen());
                    txtXuatXu.setText(a.getXuatxu());
                    txtThanhPhan.setText("Thành phần: " + a.getThanhPhan());
                    txtCongDung.setText("Công dụng: " + a.getCongDung());
                    txtGia.setText("" + a.getGia() + " VND/Hộp( " + a.getDungTich() + "ml )");

//                    fragment_ct_sPham.txtName.setText(a.getTen());
//                    fragment_ct_sPham.txtXuatXu.setText(a.getXuatxu());
//                    fragment_ct_sPham.txtThanhPhan.setText("Thành phần: " + a.getThanhPhan());
//                    fragment_ct_sPham.txtCongDung.setText("Công dụng: " + a.getCongDung());
//                    fragment_ct_sPham.txtGia.setText(""+a.getGia()+" VND/Hộp( "+ a.getDungTich()+"ml )");

                }

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

    /**
     * Xác định màn hình PORTRAIT, LANDSCAPE
     */
    void InfoScreen() {
//        SanPham a = (SanPham) getIntent().getSerializableExtra("sp");
        Log.d("TAG - a:", "InfoScreen: " + a.toString());
        if (a.getMaID() == 0) {
            a = new SanPham(R.drawable.sua_tuoi_dalat_milk_thanh_trung_khong_duong_447031, "Sữa Dalat Milk", "Ireland (Dairy Master )", 6000, 200, "100% sữa bò tươi,...", "Cung cấp chất dinh dưỡng có trong sữa bò tươi như: Chất đạm, chất béo, các vitamin và khoáng chất");
        }
        z1 = 1;
        display =
                ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
                        .getDefaultDisplay();

        switch (display.getRotation()) {
            case Surface.ROTATION_0: {
//                txtHuong.setText("Màn hình LAYOUT đứng: 0°");
                break;
            }

            case Surface.ROTATION_90: {
//                txtHuong.setText("Màn hình LAYOUT ngang: 90°");
                manHinhNgang(a);
                break;
            }
            case Surface.ROTATION_180:
//                txtHuong.setText("Màn hình LAYOUT ngang: 180°");
                break;

            case Surface.ROTATION_270: {
//                txtHuong.setText("Màn hình LAYOUT đứng: 270°");
                manHinhNgang(a);
                break;
            }
        }
    }

    public void manHinhNgang(SanPham a) {

        Fragment_CT_SPham fragment_ct_sPham = new Fragment_CT_SPham(a);

        transaction.replace(R.id.frameContext, fragment_ct_sPham);

        transaction.commit();
        z1 = -1;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 999 && resultCode == RESULT_OK) {
            a = (SanPham) data.getSerializableExtra("sp");
            
            Log.d("TAG - a( onActivityResult ):", z2 + a.toString());


            if (z1 < 0) {
                txtName = (TextView) findViewById(R.id.textname);
                txtGia = (TextView) findViewById(R.id.txtGia_acland);
                txtXuatXu = (TextView) findViewById(R.id.txtXuatXu_acland);
                txtCongDung = (TextView) findViewById(R.id.txtCongDung_acland);
                txtThanhPhan = (TextView) findViewById(R.id.txtThanhPhan_acland);
                //
                txtName.setText(a.getTen());
                txtXuatXu.setText(a.getXuatxu());
                txtThanhPhan.setText("Thành phần: " + a.getThanhPhan());
                txtCongDung.setText("Công dụng: " + a.getCongDung());
                txtGia.setText("" + a.getGia() + " VND/Hộp( " + a.getDungTich() + "ml )");
            }
        }
    }


}