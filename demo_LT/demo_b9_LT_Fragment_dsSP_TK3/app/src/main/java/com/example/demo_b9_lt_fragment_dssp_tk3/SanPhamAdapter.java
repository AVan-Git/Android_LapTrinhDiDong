package com.example.demo_b9_lt_fragment_dssp_tk3;

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
            view = layoutInflater.inflate(R.layout.gridview_listsua, null);
        }

        ImageView imgAnh = view.findViewById(R.id.img_ac_list);
        TextView txtName_AcList = view.findViewById(R.id.txtName_AcList);
        TextView txtGia_AcList = view.findViewById(R.id.txtGia_AcList);


        SanPham a = dsSanPham.get(i);

        imgAnh.setImageResource(a.getMaID());
        txtGia_AcList.setText(""+a.getGia()+" VND/Hộp( "+ a.getDungTich()+"ml )");
        txtName_AcList.setText(a.getTen());


        return view;
    }
}
