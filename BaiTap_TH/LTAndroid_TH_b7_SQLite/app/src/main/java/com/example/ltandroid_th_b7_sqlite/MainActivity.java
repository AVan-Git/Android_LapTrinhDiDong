package com.example.ltandroid_th_b7_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> listString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edName = findViewById(R.id.edName);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnRemove = findViewById(R.id.btnRemove);
        Button btnCancel = findViewById(R.id.btnCancel);

        listView = findViewById(R.id.listView);
        //

        DBHelper dbHelper = new DBHelper(this);
        getListName(dbHelper.getPersons());
        //

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = listString.get(i);
                edName.setText(str);

//                ArrayList<Person> persons = dbHelper.getPersons(); // ds person
//                String maID = str.substring(0, 1);// trùng vs i - stt suất hiển của chuỗi trong list view
//                Person a = persons.get(Integer.parseInt(maID) -1);
//                Log.d("TAG", "onItemClick_person: "+ a.toString());
            }
        });
        //
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Person> persons = dbHelper.getPersons();
                String str = edName.getText().toString().trim();

                if (str.equals("")) {
                    Toast.makeText(MainActivity.this, "Hãy chọn tên cần xóa.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String maID = str.substring(0, 1); // mã id trong chuỗi listString
                if (maID.matches("[0-9]")) {
                    // xóa theo mã
                    Person a = persons.get(Integer.parseInt(maID) -1);
                    int id = a.getId();
                    dbHelper.del_MaID(id);
                    Toast.makeText(MainActivity.this, "Xóa thành công.", Toast.LENGTH_SHORT).show();

                } else {
                    // xóa theo tên
                    for (Person a :
                            persons) {
                        if (a.getName().toLowerCase(Locale.ROOT).indexOf(str) != -1) {
                            dbHelper.del_MaID(a.getId());
                        }
                    }
//                    dbHelper.del_Name(str);

                    Toast.makeText(MainActivity.this, "Xóa thành công - 2.", Toast.LENGTH_SHORT).show();
                }
                getListName(dbHelper.getPersons());
                edName.setText("");

            }
        });
        //
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString().trim();
                if (name.equals("")) {
                    Toast.makeText(MainActivity.this, "Hãy nhập tên.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (name.matches("[0-9].*")){
                    Toast.makeText(MainActivity.this, "Nhập tên không được có chứ số đứng đầu.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Person a = new Person(dbHelper.maxID(), name);
                if (dbHelper.addName(a) < 0) {
                    Toast.makeText(MainActivity.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                } else {
                    getListName(dbHelper.getPersons());
                    edName.setText("");
                }
            }
        });
        //
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Đang cập nhật.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //
    private void getListName(ArrayList<Person> list) {

        Person a;
        listString = new ArrayList<>();

//        for (Person a :
//                list) {
//            listString.add(a.getId() + ". " + a.getName());
//        }

        for (int i = 1; i <= list.size(); i++) {
            a = (Person) list.get(i - 1);
//            listString.add(i + ". " + a.getName() + " - " + a.getId());
            listString.add(i + ". " + a.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listString);

        listView.setAdapter(adapter);
    }


}