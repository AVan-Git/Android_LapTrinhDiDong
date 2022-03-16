package com.example.ltandroid_th_b5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_CT_Donut extends AppCompatActivity {

    int soluong = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_donut);

        ImageView img_donut = findViewById(R.id.img_donut);
        ImageView btnTru = findViewById(R.id.btnTru);
        ImageView btnCong = findViewById(R.id.btnCong);
        Button btnAdd = findViewById(R.id.btnAdd);

        TextView txtName = findViewById(R.id.txtName_ct_donut);
        TextView txtGia_ct_donut = findViewById(R.id.txtGia_ct_donut);
        TextView txtTime = findViewById(R.id.txtTime);
        TextView txtSoLuong = findViewById(R.id.txtSoLuong);


        Donut donut = (Donut) getIntent().getSerializableExtra("donut");
        img_donut.setImageResource(donut.getMaID());
        txtName.setText(donut.getTenSP());
        txtGia_ct_donut.setText("$"+donut.getGiaSP());

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soluong > 1){
                    soluong--;
                    Double gia = donut.getGiaSP()*soluong;

                    txtGia_ct_donut.setText("$"+ gia);
                    txtSoLuong.setText(""+ soluong);
                    txtTime.setText(setTime(soluong));
                }
            }
        });
        //
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soluong++;
                Double gia = donut.getGiaSP()*soluong;

                txtGia_ct_donut.setText("$"+ gia);
                txtSoLuong.setText(""+ soluong);
                txtTime.setText(setTime(soluong));
            }
        });
        //
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_CT_Donut.this, "Đang cập nhật!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    //
    public String setTime(int sl){
        int time = 30+ ( sl - 1 )*5;
        if (time >= 60){
            return time/60 + ":" + time % 60+" h";
        }
        return time + " m";
    }


}