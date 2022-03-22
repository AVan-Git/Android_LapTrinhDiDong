package com.example.demo_b5_lt_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnExit = findViewById(R.id.btnExit);

        //Grid view
        GridView gv_traicay = findViewById(R.id.gridView_traicay);
        listItems = getResources().getStringArray(R.array.traicay_array);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        gv_traicay.setAdapter(adapter);
        gv_traicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, listItems[i], Toast.LENGTH_SHORT).show();
            }
        });


//
//        ListView listView = findViewById(R.id.listview_traicay);
//        //lấy danh sách item trong string.xml
//        listItems = getResources().getStringArray(R.array.traicay_array);
//// sử dung adaptẻ để đưa danh sách item vào listview
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
//                android.R.id.text1, listItems);
//
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String st = listItems[i];
//                Toast.makeText(MainActivity.this, st, Toast.LENGTH_SHORT).show();
//            }
//        });

        //Spiner
//        Spinner spinner = findViewById(R.id.spinner_traicay);
//        listItems = getResources().getStringArray(R.array.traicay_array);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, listItems);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String str = listItems[i];
//                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}