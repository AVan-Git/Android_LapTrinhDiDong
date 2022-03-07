package com.example.ltandroid_th_b4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SanPham> dssanPham;
    private LayoutInflater layoutInflater;


    public SanPhamAdapter(Context context,ArrayList<SanPham> dssanPham) {
        this.context = context;
        this.dssanPham = dssanPham;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (dssanPham.size() != 0 && !dssanPham.isEmpty())
        {
            return dssanPham.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return dssanPham.get(i);
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
            view  = layoutInflater.inflate(R.layout.list_view_sp, null);
        }

        ImageView imgAnh  = view.findViewById(R.id.imageView);

        TextView txtName = view.findViewById(R.id.txtNameSP);
        TextView txtShop = view.findViewById(R.id.txtShop);

        Button btnChat = view.findViewById(R.id.btnChat);

        SanPham a  =dssanPham.get(i);
        imgAnh.setImageResource(a.getId());
        txtName.setText(a.getName());
        txtShop.setText(a.getShop());

        return view;
    }
}
