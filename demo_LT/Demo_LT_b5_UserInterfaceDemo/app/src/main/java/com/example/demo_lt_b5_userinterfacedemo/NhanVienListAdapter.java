package com.example.demo_lt_b5_userinterfacedemo;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NhanVienListAdapter extends BaseAdapter {

    private ArrayList<NhanVien> dsNhanvien;
    private LayoutInflater layoutInflater;
    private Context context;

    public NhanVienListAdapter(Context context,ArrayList<NhanVien> dsNhanvien) {
        this.context = context;
        this.dsNhanvien = dsNhanvien;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return dsNhanvien.size();
    }

    @Override
    public Object getItem(int i) {
        return dsNhanvien.get(i);
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
            view = layoutInflater.inflate(R.layout.list_item_layout, null);

        }

        ImageView imgAnh = view.findViewById(R.id.imageView_flag);

        TextView txtName = view.findViewById(R.id.textView_Name);
        TextView textView = view.findViewById(R.id.textView_population);

        NhanVien a = dsNhanvien.get(i);
        imgAnh.setImageURI(Uri.parse(a.getSoAnh()));

        txtName.setText(""+ a.getHoten()+ "( "+ a.getGioitinh() + " )");
        textView.setText(a.getDonvi());

        return view;
    }
}
