package com.example.demo_b9_lt_sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AuthorAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Author> authors;
    private LayoutInflater layoutInflater;

    @Override
    public int getCount() {
        return authors.size();
    }

    @Override
    public Object getItem(int i) {
        return authors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_gridview, null);

        }

        Author a = authors.get(i);

        TextView txtName = view.findViewById(R.id.txtTen_ac_listGV);


        return null;
    }
}
