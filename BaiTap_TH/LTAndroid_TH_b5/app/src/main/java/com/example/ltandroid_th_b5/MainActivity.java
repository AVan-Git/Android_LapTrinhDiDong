package com.example.ltandroid_th_b5;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Donut> donuts = new ArrayList<>();
    DonutAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edSearch = findViewById(R.id.edSearch);
        Button btn_Donut = findViewById(R.id.btn_Donut);
        Button btn_Floating = findViewById(R.id.btn_Floating);
        Button btn_PinkDonut = findViewById(R.id.btn_PinkDonut);

        ListView listView = findViewById(R.id.listview);

        donuts.add(new Donut(R.drawable.donut_red_1, "Strawberry Donut", 50));
        donuts.add(new Donut(R.drawable.donut_yellow_1, "Tasty Donut", 10));
        donuts.add(new Donut(R.drawable.tasty_donut_1, "Pink Donut", 20));
        donuts.add(new Donut(R.drawable.green_donut_1, "Floating Donut", 30));
        donuts.add(new Donut(R.drawable.tom_donut, "Floating Tom", 60));

        adapter = new DonutAdapter(MainActivity.this, donuts);

        listView.setAdapter(adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, Activity_CT_Donut.class);

                intent.putExtra("donut", (Donut)adapter.getItem(i));

                startActivity(intent);

                return true;
            }
        });
        //
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter = new DonutAdapter(MainActivity.this, getSearch(edSearch.getText().toString()));

                listView.setAdapter(adapter);
            }
        });
        //
        btn_Donut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edSearch.setText("");
                adapter = new DonutAdapter(MainActivity.this, donuts);

                listView.setAdapter(adapter);
            }
        });
        //
        btn_Floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edSearch.setText("");
                adapter = new DonutAdapter(MainActivity.this, getSearch("Floating"));

                listView.setAdapter(adapter);
            }
        });
        //
        btn_PinkDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edSearch.setText("");
                adapter = new DonutAdapter(MainActivity.this, getSearch("Pink Donut"));

                listView.setAdapter(adapter);
            }
        });

    }
    public ArrayList<Donut> getSearch(String str){
        ArrayList<Donut> list = new ArrayList<>();
        for (Donut a :
                donuts) {
            if(a.getTenSP().substring(0, str.length()).equalsIgnoreCase(str)){
                list .add(a);
            }
        }
        return list;
    }
}