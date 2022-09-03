package com.example.a1950891_nguyenvanhoang_ktth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a1950891_nguyenvanhoang_ktth.entity.Bussines;

import java.util.ArrayList;

public class BussinesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Bussines> list;
    private LayoutInflater layoutInflater;

    public BussinesAdapter(Context context, ArrayList<Bussines> list) {
        this.context = context;
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
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
            view = layoutInflater.inflate(R.layout.listview_cv, null);
        }

        TextView txtID = view.findViewById(R.id.txtID);
        TextView txtTenCV = view.findViewById(R.id.txtTenCV);
        TextView txtNgay = view.findViewById(R.id.txtNgay);

        Bussines a = list.get(i);

        txtID.setText(""+a.getId());
        txtTenCV.setText(a.getName());
        txtNgay.setText(""+a.getSoNgay());


        return view;
    }
}
