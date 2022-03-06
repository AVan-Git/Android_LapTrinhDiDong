package com.example.demo_lt_b5_userinterfacedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
 */
public class MainActivity extends AppCompatActivity {

    String dsDonvi[];
    ArrayList<NhanVien> nhanViens = new ArrayList<>();
    String donvi, maAnh;
    ListView listView_Donvi;
    ImageView imgAnh;
    TextView txtKQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAnh = findViewById(R.id.imgNV);

        EditText edID = findViewById(R.id.edMa);
        EditText edHoten = findViewById(R.id.edHoten);

        txtKQ = findViewById(R.id.txtKQ);

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


        // data
//        nhanViens.add(new NhanVien(1, "Bá", "Nam", "Phòng kỹ thuật"
//                , "content://media/external_primary/images/media/3137"));
//        nhanViens.add(new NhanVien(2, "Hà", "Nữ", "Phòng tiếp thị"
//                , "content://media/external_primary/images/media/3142"));
//        getList_NhanVien();


//
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
                try {

                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 999);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maID = Integer.parseInt(edID.getText().toString());
                String hoten = edHoten.getText().toString();
                String gioiTinh = ((RadioButton) findViewById(rdg.getCheckedRadioButtonId())).getText().toString();


                for (NhanVien a : nhanViens) {
                    if (a.getMaSo() == maID) {
                        a.setDonvi(donvi);
                        a.setGioitinh(gioiTinh);
                        a.setHoten(hoten);
                        a.setSoAnh(maAnh);
                        getList_NhanVien();
                        Toast.makeText(MainActivity.this, "Bạn đã sửa thông tin nhân viên " + a.getHoten() + ".", Toast.LENGTH_SHORT).show();
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

                NhanVien nv = new NhanVien(maID, hoten, gioiTinh, donvi, maAnh);

                for (NhanVien a :
                        nhanViens) {
                    if (a.getMaSo() == maID) {
                        Toast.makeText(MainActivity.this, "Trùng mã nhân viên.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                nhanViens.add(nv);


                getList_NhanVien();
            }
        });

        listView_Donvi.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien a = nhanViens.get(i);
                Intent intent = new Intent(MainActivity.this, Activity_CT_NhanVien.class);
                intent.putExtra("maID", a.getMaSo());
                intent.putExtra("hoten", a.getHoten());
                intent.putExtra("gioiTinh", a.getGioitinh());
                intent.putExtra("donVi", a.getDonvi());
                intent.putExtra("soAnh", a.getSoAnh());

                startActivity(intent);
return false;

            }
        });

        listView_Donvi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                NhanVien a = nhanViens.get(i);

                edHoten.setText(a.getHoten());
                edID.setText("" + a.getMaSo());

                imgAnh.setImageURI(Uri.parse(a.getSoAnh()));
                maAnh = a.getSoAnh();

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
            }
        });


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 999 && data != null) {
            Uri selectdImage = data.getData();

            imgAnh.setImageURI(selectdImage);
            maAnh = "" + selectdImage;
        }
    }

    private void getList_NhanVien() {

        listView_Donvi.setAdapter(new NhanVienListAdapter(MainActivity.this, nhanViens));
    }


}