package com.example.ltandroid_th_b5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DonutAdapter  extends BaseAdapter {

    private Context context;
    private ArrayList<com.example.ltandroid_th_b5.Donut> donuts;
    private LayoutInflater layoutInflater;

    public DonutAdapter(Context context, ArrayList<com.example.ltandroid_th_b5.Donut> donuts) {
        this.context = context;
        this.donuts = donuts;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return donuts.size();
    }

    @Override
    public Object getItem(int position) {
        return donuts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null )
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.listview_donut, null);
        }

        ImageView imgAnh = view.findViewById(R.id.imageView);
        TextView txtGia = view.findViewById(R.id.txtGia);
        TextView txtName = view.findViewById(R.id.txtName);

        com.example.ltandroid_th_b5.Donut a = donuts.get(position);
        imgAnh.setImageResource(a.getMaID());
        txtName.setText(""+ a.getTenSP());
        txtGia.setText("$ "+ a.getGiaSP());

        return view;
    }
}
