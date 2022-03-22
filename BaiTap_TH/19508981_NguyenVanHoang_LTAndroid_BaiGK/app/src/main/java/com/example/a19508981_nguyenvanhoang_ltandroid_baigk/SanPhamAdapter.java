package com.example.a19508981_nguyenvanhoang_ltandroid_baigk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<SanPham> dsSanPham;
    private LayoutInflater layoutInflater;

    public SanPhamAdapter(Context context, ArrayList<SanPham> dsSanPham) {
        this.context = context;
        this.dsSanPham = dsSanPham;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dsSanPham.size();
    }

    @Override
    public Object getItem(int i) {
        return dsSanPham.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_sanpham, null);
        }

        ImageView img = view.findViewById(R.id.imgAnh_ac2);

        TextView txtName = view.findViewById(R.id.txtName_ac2);
        TextView txtGia2 = view.findViewById(R.id.txtGia1);
        TextView txtGia1 = view.findViewById(R.id.txtGia2);


        SanPham a = dsSanPham.get(i);
        img.setImageResource(a.getMaID());
        txtGia1.setText("$ "+ a.getGia1());
        txtGia2.setText("$ "+ a.getGia2());
        txtName.setText(a.getName());


        return view;
    }
}
