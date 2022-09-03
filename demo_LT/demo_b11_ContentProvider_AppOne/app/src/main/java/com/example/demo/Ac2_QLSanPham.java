package com.example.demo;

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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Ac2_QLSanPham extends AppCompatActivity {

    static final String uri = "content://com.example.demo";
    EditText edID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac2_qlsan_pham);

        GridView gridView = findViewById(R.id.gridView_ac2);

        edID = findViewById(R.id.ed_ID_ac2);
        EditText edName = findViewById(R.id.ed_Name_ac2);
        EditText ed_Madein_ac2 = findViewById(R.id.ed_Madein_ac2);
        EditText ed_unit_ac2 = findViewById(R.id.ed_unit_ac2);

        Button btnSelect = findViewById(R.id.btnSelect_Ac2);
        Button btnSave = findViewById(R.id.btnSave_Ac2);
        Button btnUpdate = findViewById(R.id.btnUpdate_Ac2);
        Button btnDelete = findViewById(R.id.btnDelete_Ac2);
        TextView txtExit = findViewById(R.id.txtExit_ac2);
        txtExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> listString = new ArrayList<>();

                Uri productURI = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(productURI, null,null, null, "name");
                cursor.moveToFirst();
                if (!cursor.isAfterLast())
                {
                    do {
                        listString.add(cursor.getInt(0) + "");
                        listString.add(cursor.getString(1));
                        listString.add(cursor.getString(2));
                        listString.add(cursor.getString(3));
                    }while (cursor.moveToNext());
                    ArrayAdapter<String > adapter = new ArrayAdapter<>(Ac2_QLSanPham.this, android.R.layout.simple_list_item_1, listString);
                    gridView.setAdapter(adapter);

                }else{
                    Toast.makeText(Ac2_QLSanPham.this, "Không có kết quả.", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });
        //
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (!check_data()) {
//                    return;
//                }

                int id = Integer.parseInt(edID.getText().toString().trim());
                String name = edName.getText().toString();
                String made = ed_Madein_ac2.getText().toString();
                String unit = ed_unit_ac2.getText().toString();

                ContentValues values = new ContentValues();
                values.put("id", id);
                values.put("name", name);
                values.put("unit", unit);
                values.put("madeIn", made);

                Uri productURI = Uri.parse(uri);
                Uri insertURI = getContentResolver().insert(productURI, values);

                if (insertURI == null)
                {
                    Toast.makeText(Ac2_QLSanPham.this, "Thêm không thành công.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Lưu thành công!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edID.getText().toString().length() == 0)
                {
                    Toast.makeText(Ac2_QLSanPham.this, "Nhập mã cần sửa.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int id = Integer.parseInt(edID.getText().toString());
                String name = edName.getText().toString().trim();
                String unit = ed_unit_ac2.getText().toString().trim();
                String madeIn = ed_Madein_ac2.getText().toString().trim();

                ContentValues values = new ContentValues();
                values.put("id", id);
                values.put("name", name);
                values.put("unit", unit);
                values.put("madein", madeIn);


                Uri productUri = Uri.parse(uri);

                int update_uri = getContentResolver().update(productUri, values, "id = "+ id, null);
                if (update_uri > 0) {
                    Toast.makeText(getApplicationContext(), "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cập nhật không thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edID.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Nhập mã cần xóa.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int id = Integer.parseInt(edID.getText().toString().trim());

                AlertDialog.Builder myDialog = new AlertDialog.Builder(Ac2_QLSanPham.this);
                myDialog.setTitle("Thông báo!");
                myDialog.setMessage("Bạn có muốn xóa mã " + id + " không?");

                myDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Uri product_uri = Uri.parse(uri);
                        getContentResolver().delete(product_uri, "id = " + id, null);
                        Toast.makeText(getApplicationContext(), "Xóa thành công!", Toast.LENGTH_SHORT).show();
                    }
                });
                myDialog.setNegativeButton("No", null);
                AlertDialog dialog =myDialog.create();
                dialog.show();
            }
        });

    }
}