package com.example.demo_b9_lt_sqlite;
// k hoan thành

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        GridView gridView = findViewById(R.id.gridView_ac2);

        EditText edID = findViewById(R.id.ed_ID_ac2);
        EditText edName = findViewById(R.id.ed_Name_ac2);
        EditText edAddress = findViewById(R.id.ed_Address_ac2);
        EditText edEmail = findViewById(R.id.ed_Email_ac2);

        Button btnSelect = findViewById(R.id.btnSelect_Ac2);
        Button btnSave = findViewById(R.id.btnSave_Ac2);
        Button btnUpdate = findViewById(R.id.btnUpdate_Ac2);
        Button btnDelete = findViewById(R.id.btnDelete_Ac2);

//        SQLiteDatabase sqLiteDatabase= openOrCreateDatabase("QLAuthor", MODE_PRIVATE, null);
        DBHelper dbHelper = new DBHelper(this);

        //
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        //
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edID.getText().toString());

                //
                int z1 = 0;
                ArrayList<Author> authors = dbHelper.getAuthors();
                for (Author author :
                        authors) {
                    if (id == author.getId()) {
                        z1 = 1;
                    }
                }
                if (z1 == 1) {
                    AlertDialog.Builder myDialog = new AlertDialog.Builder(AuthorActivity.this);
                    myDialog.setTitle("Thông báo!");
                    myDialog.setMessage("Bạn có muốn xóa mã "+ id +" không? ");

                    myDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dbHelper.delAuthor(id);
                            Toast.makeText(getApplicationContext(), "Xóa thành công.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    myDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AlertDialog dialog =myDialog.create();
                    dialog.show();

    //                    dbHelper.delAuthor(id);
    //                    Toast.makeText(getApplicationContext(), "Xóa thành công.", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Không có mã " + id + " trong danh sách.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edID.getText().toString());
                String name = edName.getText().toString();
                String address = edAddress.getText().toString();
                String email = edEmail.getText().toString();
                //
                int z1 = 0;
                ArrayList<Author> authors = dbHelper.getAuthors();
                for (Author author :
                        authors) {
                    if (id == author.getId()) {
                        z1 = 1;
                    }
                }
                if (z1 == 1) {
                    Author a = new Author(id, name, address, email);
                    if (dbHelper.updateAuthor(a) < 0) {
                        Toast.makeText(getApplicationContext(), "Cập nhật không thành công!", Toast.LENGTH_SHORT).show();
                        Log.e("Lỗi updateAuthor()", "onClick: UPdate- Error");
                    } else {
                        Toast.makeText(getApplicationContext(), "Bạn cập nhật thành công!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Không có mã " + id + " trong danh sách.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edID.getText().toString());
                String name = edName.getText().toString();
                String address = edAddress.getText().toString();
                String email = edEmail.getText().toString();
                //
                ArrayList<Author> authors = dbHelper.getAuthors();
                for (Author author :
                        authors) {
                    if (id == author.getId()) {
                        Toast.makeText(getApplicationContext(), "Mã " + id + " đã có trong danh sách.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                Author a = new Author(id, name, address, email);

                if (dbHelper.ínsertAuthor(a) <= 0) {
                    Toast.makeText(getApplicationContext(), "Bạn lưu không thành công!", Toast.LENGTH_SHORT).show();
                    Log.e("Lỗi Insert Author", "onClick: Add- Error");
                } else {
                    Toast.makeText(getApplicationContext(), "Bạn lưu thành công!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        //
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Author> authors = dbHelper.getAuthors();
                ArrayList<Author> list = new ArrayList<>();
                ArrayList<String> listString = new ArrayList<>();

                if (!edID.getText().toString().equals("")) {
//                    Author z1 = dbHelper.getAuthor(Integer.parseInt(edID.getText().toString()));
//                    if (z1 == null) {
//                        Toast.makeText(AuthorActivity.this, "Không tìm thấy!", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    authors.add(z1);

                    int id = Integer.parseInt(edID.getText().toString());

                    for (Author a :
                            authors) {
                        if (a.getId() == id) {
                            list.add(a);
                        }

                    }

                } else {
                    list = dbHelper.getAuthors();
                }
                for (Author a :
                        list) {
                    listString.add(a.getId() + "");
                    listString.add(a.getName());
                    listString.add(a.getAddress());
                    listString.add(a.getEmail());

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this
                        , android.R.layout.simple_list_item_1, listString);

                gridView.setAdapter(adapter);
            }
        });


        ///
        findViewById(R.id.btnExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}