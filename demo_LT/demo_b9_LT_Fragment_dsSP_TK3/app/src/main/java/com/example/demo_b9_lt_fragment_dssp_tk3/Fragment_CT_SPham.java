package com.example.demo_b9_lt_fragment_dssp_tk3;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Fragment_CT_SPham extends Fragment {

    SanPham a;
    TextView txtName, txtGia, txtXuatXu, txtCongDung, txtThanhPhan;

    @SuppressLint("ValidFragment")
    public Fragment_CT_SPham(SanPham a) {
        this.a = a;
    }

    public Fragment_CT_SPham() {
        a = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ct_spham, container, false);

        txtName = (TextView) view.findViewById(R.id.textname);
        txtGia = (TextView) view.findViewById(R.id.txtGia_acland);
        txtXuatXu = (TextView) view.findViewById(R.id.txtXuatXu_acland);
        txtCongDung = (TextView) view.findViewById(R.id.txtCongDung_acland);
        txtThanhPhan = (TextView) view.findViewById(R.id.txtThanhPhan_acland);

        if (a != null) {
            Log.d("SanPham: ", a.toString());
            txtName.setText(a.getTen());
            txtXuatXu.setText(a.getXuatxu());
            txtThanhPhan.setText("Thành phần: " + a.getThanhPhan());
            txtCongDung.setText("Công dụng: " + a.getCongDung());
            txtGia.setText("" + a.getGia() + " VND/Hộp( " + a.getDungTich() + "ml )");
        }

        ImageView imgAdd = view.findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "đang cập nhật.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
