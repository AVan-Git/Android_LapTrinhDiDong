package com.example.demo_b5_lt_bttk_baitay;

import static com.example.demo_b5_lt_bttk_baitay.R.drawable.b1fv;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/*
10: ba lá tây
0-9: tường tự vs số điểm;
 */
/*
0: hòa
-1 : a thắng
1 : b thắng
 */

public class Activity_BT1 extends AppCompatActivity {

    //gans giá trị của bộ bài vào 1 mảng;
    int manghinhbai[] = {
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
            R.drawable.cj, R.drawable.cq, R.drawable.ck,
            R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5,
            R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10,
            R.drawable.dj, R.drawable.dq, R.drawable.dk,
            R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5,
            R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
            R.drawable.hj, R.drawable.hq, R.drawable.hk,
            R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5,
            R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.sj, R.drawable.sq, R.drawable.sk};
    //

    Button btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt1);
//
        Button btnClick = findViewById(R.id.btnClick);
        Button btnHistory = (Button) findViewById(R.id.btnHistory);
        Button btnRefresh = (Button) findViewById(R.id.btnRefresh);

        ImageView img1 = findViewById(R.id.img1);
        ImageView img2 = findViewById(R.id.img2);
        ImageView img3 = findViewById(R.id.img3);
        ImageView img4 = findViewById(R.id.img4);
        ImageView img5 = findViewById(R.id.img5);
        ImageView img6 = findViewById(R.id.img6);

        TextView txtTieuDe = findViewById(R.id.txtTieuDe);
        TextView txtKQ = findViewById(R.id.txtKQ);
        TextView txtTB1 = findViewById(R.id.txtTB1);
        TextView txtTB2 = findViewById(R.id.txtTB2);

        DatabaseKQ dsKQ = new DatabaseKQ();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dsKQ.addKQ(ketQua());
                txtTieuDe.setText("Ván "+ dsKQ.getSize());
            }

            // hàm chọn bài
            public int ketQua() {
                int[] chonBai = laySauSoNgauNhien(0, 51);

                int[] arr1 = {chonBai[0], chonBai[2], chonBai[4]};
                int[] arr2 = {chonBai[1], chonBai[3], chonBai[5]};

                img1.setImageResource(manghinhbai[arr1[0]]);
                img2.setImageResource(manghinhbai[arr1[1]]);
                img3.setImageResource(manghinhbai[arr1[2]]);

                img4.setImageResource(manghinhbai[arr2[0]]);
                img5.setImageResource(manghinhbai[arr2[1]]);
                img6.setImageResource(manghinhbai[arr2[2]]);

                String[] kq_play1 = tinhKQ(arr1);
                String[] kq_play2 = tinhKQ(arr2);

                txtTB1.setText(kq_play1[1]);
                txtTB2.setText(kq_play2[1]);

                String kq = "";
                int x = 0;
                int a = Integer.parseInt(kq_play1[0]);// a lưu thông tin của người chơi 1
                int b = Integer.parseInt(kq_play2[0]);// b lưu thông tin của người chơi 2

                if (a == b) {
                    kq = "Hòa";
                } else if (a > b) {
                    x = -1;
                    kq = "player 1 wins!";
                } else {
                    x = 1;
                    kq = "player 2 wins!";
                }

                txtKQ.setText(kq );

                return x;
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dsKQ.getSize() > 0){
                    Intent i = new Intent(Activity_BT1.this, Activity_ketQua.class);
                    i.putIntegerArrayListExtra("dsKQ", (ArrayList<Integer>) dsKQ.getKQ());
                    startActivity(i);
                }
                else{
//                    AlertDialog.Builder myDialog = new AlertDialog.Builder(Activity_BT1.this);
//                    myDialog.setTitle("Trò chơi chưa được bắt đầu.!");
//
//                    AlertDialog dialog =myDialog.create();
//                    dialog.show();
                    Toast.makeText(Activity_BT1.this,"Trò chơi chưa được bắt đầu!",  Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsKQ.deleteDS();
                txtTieuDe.setText("PLAY CARDS");
                txtKQ.setText("Kết quả");
                txtTB1.setText("Kết quả");
                txtTB2.setText("Kết quả");

                img1.setImageResource(b1fv);
                img2.setImageResource(b1fv);
                img3.setImageResource(b1fv);
                img4.setImageResource(b1fv);
                img5.setImageResource(b1fv);
                img6.setImageResource(b1fv);
            }
        });

    }

    //tinhs ket  qua
    private String[] tinhKQ(int[] arr) {
        String[] kq = new String[2];
        int k = tinhSoTay(arr);
        if (k == 3) {
            kq[0] = "10";
            kq[1] = "Kết quả 3 con tây.";
        } else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 13 < 10) {
                    tong += ((arr[i] % 13) + 1);
                }
            }
            if (tong % 10 == 0) {
                kq[1] = "Kết quả bù, số lá tây: " + tinhSoTay(arr);
            } else {

                kq[1] = "Kết quả: " + (tong % 10) + " - Số lá tây là: " + tinhSoTay(arr);
            }
            kq[0] = "" + (tong % 10);
        }
        return kq;
    }


    // tính số lá tây

    private int tinhSoTay(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] % 13 >= 10 && arr[i] < 10)
            if (arr[i] % 13 >= 10)
                k++;
        }
        return k;
    }

    // lay 3 so ngau nhien trong doan min- max
    private int[] laySauSoNgauNhien(int min, int max) {
        int[] baSo = new int[6];
        int i = 0;
        baSo[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (!kiemTraTrung(k, baSo))
                baSo[i++] = k;

        } while (i < 6);

        return baSo;
    }

    //========================
    // kiểm tra trùng lá bài
    private boolean kiemTraTrung(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return true;
        }
        return false;
    }

    //
    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}