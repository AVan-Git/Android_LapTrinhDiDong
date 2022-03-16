package com.example.ltandroid_th_b4.bai2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ltandroid_th_b4.R;

import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<SanPham> dsSanPham;

    public SanPhamAdapter(Context context, ArrayList<SanPham> dsSanPham) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.dsSanPham = dsSanPham;
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
            view = layoutInflater.inflate(R.layout.grid_view_sp, null);
        }

        ImageView imgView = view.findViewById(R.id.imgView);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtGia = view.findViewById(R.id.txtGia);
        TextView txtSoNgDanhGia = view.findViewById(R.id.txtSoNguoiDanhGia);

        SanPham a =  dsSanPham.get(i);

        imgView.setImageResource(a.getMaSP());
        txtName.setText(a.getTenSP());
        txtGia.setText(""+a.getGiaSP()+ " đ");
        txtSoNgDanhGia.setText("( " + a.getSoDGia()+ " )");
        return view;
    }
}
