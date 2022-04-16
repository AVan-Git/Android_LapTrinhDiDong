package com.example.demo_b9_lt_fragment_dssp_tk3;

import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_CT_SanPham extends AppCompatActivity {

    Display display;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    int z1 = 0;
    SanPham a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_san_pham);

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        InfoScreen(); // set màn hình đang ở trang thái nào(đứng || nằm)


        ImageView imgAnh = findViewById(R.id.img_Ac3);
        TextView txtName = findViewById(R.id.txtName_ac3);
        TextView txtGia = findViewById(R.id.txtGia_ac3);
        TextView txtXuatXu = findViewById(R.id.txtXuatXu_ac3);
        TextView txtCongDung = findViewById(R.id.txtCongDung_ac3);
        TextView txtThanhPhan = findViewById(R.id.txtThanhPhan_ac3);

        a = (SanPham) getIntent().getSerializableExtra("sp");

        imgAnh.setImageResource(a.getMaID());
        txtName.setText(a.getTen());
        txtXuatXu.setText(a.getXuatxu());
        txtThanhPhan.setText("Thành phần: " + a.getThanhPhan());
        txtCongDung.setText("Công dụng: " + a.getCongDung());
        txtGia.setText("" + a.getGia() + " VND/Hộp( " + a.getDungTich() + "ml )");


        ImageView imgAdd = findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_CT_SanPham.this, "đang cập nhật.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Xác định màn hình PORTRAIT, LANDSCAPE
     */
    void InfoScreen() {

        z1 = 1;
        display =
                ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
                        .getDefaultDisplay();

        switch (display.getRotation()) {
            case Surface.ROTATION_0: {
//                txtHuong.setText("Màn hình LAYOUT đứng: 0°");
                Log.e("TAG", "InfoScreen: AC_chi tiet san pham");
                break;
            }

            case Surface.ROTATION_90: {
//                txtHuong.setText("Màn hình LAYOUT ngang: 90°");
                manHinhNgang();
                break;
            }
            case Surface.ROTATION_180:
//                txtHuong.setText("Màn hình LAYOUT ngang: 180°");
                break;

            case Surface.ROTATION_270: {
//                txtHuong.setText("Màn hình LAYOUT đứng: 270°");
                manHinhNgang();
                break;
            }
        }
    }

    private void manHinhNgang() {
        a = (SanPham) getIntent().getSerializableExtra("sp");
//
//        Intent intent = new Intent(Activity_CT_SanPham.this, Activity.class);
//        intent.putExtra("sp", a);
//        startActivity(intent);

        Intent intent = new Intent();
        intent.putExtra("sp", a);
        setResult(RESULT_OK, intent);
        finish();
    }
}