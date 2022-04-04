package com.example.ltandroid_th_b6_fragment.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ltandroid_th_b6_fragment.R;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<SanPham> dsSanPham;
    private LayoutInflater layoutInflater;

    public SanPhamAdapter(Context context, ArrayList<SanPham> dsSanPham) {
        this.context = context;
        this.dsSanPham = dsSanPham;
        layoutInflater = LayoutInflater.from(context);
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

        if (view == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.listview_sanpham, null);
        }

        ImageView imageView =  view.findViewById(R.id.imgid);
        TextView txtName = view.findViewById(R.id.txtName_acListView);
        TextView txtDiscout = view.findViewById(R.id.txtDiscout_acListview);

        SanPham a = dsSanPham.get(i);

        imageView.setImageResource(a.getId());
        txtDiscout.setText(""+a.getDiscount()+"%");
        txtName.setText(a.getName());


        return view;
    }
}
