package com.example.demo_b10_lt_apptwo_provider;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
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

    //    static final String uri = "content://com.example.demo_b10_lt_apptwo_provider";
    EditText edID;

    //=====================  1
    static final String AUTHOURITY = "com.example.demo_b10_lt_appone_provider";
    static final String CONTENT_PROVIDER = "contentprovider";
    static final String URL = "content://" + AUTHOURITY + "/" + CONTENT_PROVIDER;// content://com.example.demo_b10_lt_appone_provider/contentprovider
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
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edID.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Nhập mã cần xóa.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int id = Integer.parseInt(edID.getText().toString().trim());

                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("Thông báo!");
                myDialog.setMessage("Bạn có muốn xóa mã " + id + " không?");

                myDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getContentResolver().delete(CONTENT_URI, "id = " + id, null);
                        Toast.makeText(getApplicationContext(), "Xóa thành công!", Toast.LENGTH_SHORT).show();
                    }
                });
                myDialog.setPositiveButton("No", null);


            }
        });
        //
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edID.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Nhập mã cần xóa.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int id = Integer.parseInt(edID.getText().toString().trim());
                String name = edName.getText().toString();
                String made = ed_Madein_ac2.getText().toString();
                String unit = ed_unit_ac2.getText().toString();

                ContentValues values = new ContentValues();
                values.put("id", id); ///////////
                values.put("name", name);
                values.put("unit", unit);
                values.put("madein", made);

                int update_Uri = getContentResolver().update(CONTENT_URI, values, "id = " + id, null);
                if (update_Uri > 0) {
                    Toast.makeText(getApplicationContext(), "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cập nhật không thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!check_data()) {
                    return;
                }

                int id = Integer.parseInt(edID.getText().toString().trim());
                String name = edName.getText().toString();
                String made = ed_Madein_ac2.getText().toString();
                String unit = ed_unit_ac2.getText().toString();

                ContentValues values = new ContentValues();
                values.put("id", id); ///////////
                values.put("name", name);
                values.put("unit", unit);
                values.put("madein", made);

                Uri insert_uri = getContentResolver().insert(CONTENT_URI, values);
                Toast.makeText(getApplicationContext(), "Lưu thành công!", Toast.LENGTH_SHORT).show();

            }
        });
//        //
//        btnSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ArrayList<String> listString = new ArrayList<>();
//                Cursor cursor = null;
//                cursor = getContentResolver().query(CONTENT_URI, null, null, null, "name");
//                cursor.moveToFirst();
//
//                if (!cursor.isAfterLast()) {
//                    do {
//                        listString.add(cursor.getString(0) + "");
//                        listString.add(cursor.getString(1));
//                        listString.add(cursor.getString(2));
//                        listString.add(cursor.getString(3));
//                    } while (cursor.moveToNext());
//                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listString);
//                    gridView.setAdapter(adapter);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Không có kết quả.", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

        //
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> listString = new ArrayList<>();

//                Uri product_uri = Uri.parse(uri);
                Cursor cursor  = getContentResolver().query(CONTENT_URI, null, null, null, "name");
                cursor.moveToFirst();

                if (!cursor.isAfterLast()) {
//                    cursor.moveToFirst();

                    do {
                        listString.add(cursor.getInt(0) + "");
                        listString.add(cursor.getString(1));
                        listString.add(cursor.getString(2));
                        listString.add(cursor.getString(3));
                    } while (cursor.moveToNext());

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listString);
                    gridView.setAdapter(adapter);
                } else {
                    Toast.makeText(getApplicationContext(), "Không có kết quả.", Toast.LENGTH_SHORT).show();
                }

            }
        });



        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public boolean check_data() {
        String ma_check = edID.getText().toString();
        if (ma_check.equals("")) {
            Toast.makeText(getApplicationContext(), "Hãy nhập mã id.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!ma_check.matches("^[0-9]*$")) {
            Toast.makeText(getApplicationContext(), "Mã id là những chữ số", Toast.LENGTH_SHORT).show();
            return false;
        }
        Uri product = CONTENT_URI;
        Cursor cursor = getContentResolver().query(product, null, null, null, "name");
        if (cursor != null) {
            cursor.moveToFirst();
            do {
                if (ma_check.equals(cursor.getString(0))) {
                    Toast.makeText(getApplicationContext(), "Trùng mã ID.", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } while (cursor.moveToNext());
        }
        return true;
    }
}