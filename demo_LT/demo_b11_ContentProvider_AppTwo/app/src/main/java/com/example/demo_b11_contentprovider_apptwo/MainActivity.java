package com.example.demo_b11_contentprovider_apptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edID;
    static final String AUTHOURITY = "com.example.demo";
    static final String CONTENT_PROVIDER = "contentprovider";
    static final String URL = "content://" + AUTHOURITY + "/" + CONTENT_PROVIDER;
    static final Uri CONTENT_URI = Uri.parse(URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView_ac2);

        edID = findViewById(R.id.ed_ID_ac2);
        EditText edName = findViewById(R.id.ed_Name_ac2);
        EditText ed_Madein_ac2 = findViewById(R.id.ed_Madein_ac2);
        EditText ed_unit_ac2 = findViewById(R.id.ed_unit_ac2);

        Button btnSelect = findViewById(R.id.btnSelect_Ac2);
        Button btnSave = findViewById(R.id.btnSave_Ac2);
        Button btnUpdate = findViewById(R.id.btnUpdate_Ac2);
        Button btnDelete = findViewById(R.id.btnDelete_Ac2);


//
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> listString = new ArrayList<>();

//                Uri productURI = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(CONTENT_URI, null,null, null, "name");
                cursor.moveToFirst();
                if (!cursor.isAfterLast())
                {
                    do {
                        listString.add(cursor.getInt(0) + "");
                        listString.add(cursor.getString(1));
                        listString.add(cursor.getString(2));
                        listString.add(cursor.getString(3));
                    }while (cursor.moveToNext());
                    ArrayAdapter<String > adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listString);
                    gridView.setAdapter(adapter);

                }else{
                    Toast.makeText(MainActivity.this, "Không có kết quả.", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });
    }
}