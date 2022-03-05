package com.example.demo_lt_b5_userinterfacedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Chọn anh
 * Sửa giao điện
 * 
 */
public class MainActivity extends AppCompatActivity {

    String dsDonvi[];
    ArrayList<NhanVien> nhanViens = new ArrayList<>();
    String donvi;
    ListView listView_Donvi;

    int[] img = {R.drawable.avatar0, R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4
            , R.drawable.avatar5, R.drawable.avatar6, R.drawable.avatar7};
    int z1 = -1; // vị trí tấm ảnh

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgAnh = findViewById(R.id.imgNV);

        EditText edID = findViewById(R.id.edMa);
        EditText edHoten = findViewById(R.id.edHoten);

        TextView txtKQ = findViewById(R.id.txtKQ);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnUpdate = findViewById(R.id.btnUpdate);
        Button btnTruyVan = findViewById(R.id.btnTruyVan);
        Button btnExit = findViewById(R.id.btnExit);
        Button btnChonAnh = findViewById(R.id.btnChonAnh);

        RadioButton rdoNam = findViewById(R.id.rdoNam);
        RadioButton rdoNu = findViewById(R.id.rdoNu);
        RadioGroup rdg = findViewById(R.id.rdg);

        listView_Donvi = findViewById(R.id.listview_Donvi);

        Spinner sp_Donvi = findViewById(R.id.spinner_Donvi);
        dsDonvi = getResources().getStringArray(R.array.donvi_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dsDonvi);


        sp_Donvi.setAdapter(adapter);

        sp_Donvi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dsDonvi[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //
        btnChonAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x;
                if (rdoNam.isChecked())
                {
                    x = randdom(4, 7);
                }else if (rdoNu.isChecked())
                {
                    x = randdom(0, 3);
                }else{
                    x = (int) (Math.random()*8);
                }
                while (x == z1){
                    if (rdoNam.isChecked())
                    {
                        x = randdom(4, 7);
                    }else if (rdoNu.isChecked())
                    {
                        x = randdom(0, 3);
                    }else{
                        x = (int) (Math.random()*8);
                    }
                }

                z1 = x;

                imgAnh.setImageResource(img[x]);


            }
        });
        //
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maID;

                try {
                    maID  = Integer.parseInt(edID.getText().toString());

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Sai mã!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String hoten = edHoten.getText().toString();

                String gioiTinh = ((RadioButton) findViewById(rdg.getCheckedRadioButtonId())).getText().toString();

                for (NhanVien a :  nhanViens) {
                    if (a.getMaSo() == maID) {
                        a.setDonvi(donvi);
                        a.setGioitinh(gioiTinh);
                        a.setHoten(hoten);
                        getList_NhanVien(nhanViens);
                        Toast.makeText(MainActivity.this, "Bạn đã sửa thông tin nhân viên "+ a.getHoten()+ ".", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(MainActivity.this, "Mã nhân viên không có.", Toast.LENGTH_SHORT).show();

            }
        });

        //
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maID = Integer.parseInt(edID.getText().toString());
                String hoten = edHoten.getText().toString();

                String gioiTinh = ((RadioButton) findViewById(rdg.getCheckedRadioButtonId())).getText().toString();
                NhanVien nv = new NhanVien(maID, hoten, gioiTinh, donvi, img[z1]);

                for (NhanVien a :
                        nhanViens) {
                    if (a.getMaSo() == maID)  {
                        Toast.makeText(MainActivity.this, "Trùng mã nhân viên.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                nhanViens.add(nv);

                getList_NhanVien(nhanViens);
            }
        });

        listView_Donvi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                NhanVien a = nhanViens.get(i);

                edHoten.setText(a.getHoten());
                edID.setText("" + a.getMaSo());

                imgAnh.setImageResource(a.getSoAnh());

                if (a.getGioitinh().equals("Nam")) {
                    rdoNam.setChecked(true);
                } else {
                    rdoNu.setChecked(true);
                }

                for (i = 0; i < dsDonvi.length; i++) {
                    if (dsDonvi[i].equals(a.getDonvi())) {
                        sp_Donvi.setSelection(i);
                    }
                }
//                txtKQ.setText("" +listView_Donvi.isSelected());
            }
        });


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private  void getList_NhanVien(ArrayList<NhanVien> dsNV){
//        ArrayList<String> listItems = new ArrayList<>();
//
//        for (NhanVien a : nhanViens) {
//            listItems.add(a.toString());
//
//            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,
//                    android.R.id.text1, listItems);
//            listView_Donvi.setAdapter(adapter1);
//
//        }
        listView_Donvi.setAdapter(new NhanVienListAdapter(MainActivity.this, nhanViens));
    }
    //

    private int randdom(int min, int max){

        return (int) ((Math.random())*((max - min) + 1)+ min);
    }


}