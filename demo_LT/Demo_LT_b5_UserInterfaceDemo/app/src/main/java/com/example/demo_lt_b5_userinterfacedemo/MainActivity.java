package com.example.demo_lt_b5_userinterfacedemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Chọn anh
 * Sửa giao điện
 */
public class MainActivity extends AppCompatActivity {

    int z1 = 1;
    String dsDonvi[];
    ArrayList<NhanVien> nhanViens = new ArrayList<>();
    String donvi, maAnh;
    ListView listView_Donvi;
    ImageView imgAnh;
    TextView txtKQ;
    String fileName ;


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
        Button btnXoa = findViewById(R.id.btnXoa);
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
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int maID;
                try {
                    maID = Integer.parseInt(edID.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Hãy chọn một nhân viên cần xóa.", Toast.LENGTH_SHORT).show();
                    return;
                }


                for (NhanVien a :
                        nhanViens) {
                    if (a.getMaSo() == maID) {

                        AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                        myDialog.setTitle("Bạn có muốn xóa nhân viên có mã " + maID + " không?");
                        myDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                nhanViens.remove(a);
                                getList_NhanVien();
                                Toast.makeText(MainActivity.this, "Xóa thành công.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        });
                        myDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Toast.makeText(MainActivity.this, "Bạn đã chọn nút NO.", Toast.LENGTH_SHORT).show();
                            }
                        });

                        AlertDialog dialog = myDialog.create();
                        dialog.show();
                        return;

                    }
                }

                Toast.makeText(MainActivity.this, "Mã nhân viên " + maID + " không tìm thấy?", Toast.LENGTH_SHORT).show();

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
                int maID;
                try {
                    maID = Integer.parseInt(edID.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Hãy chọn một nhân viên cần xóa.", Toast.LENGTH_SHORT).show();
                    return;
                }

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
                if (checkData()) {
                    return;
                }
                int maID = Integer.parseInt(edID.getText().toString());
                String hoten = edHoten.getText().toString();

                String gioiTinh = ((RadioButton) findViewById(rdg.getCheckedRadioButtonId())).getText().toString();

                NhanVien nv = new NhanVien(maID, hoten, gioiTinh, donvi, maAnh);


                for (NhanVien a : nhanViens) {
                    if (a.getMaSo() == maID) {
                        Toast.makeText(MainActivity.this, "Trùng mã nhân viên.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                nhanViens.add(nv);

                z1 = 1;
                getList_NhanVien();
            }

            private boolean checkData() {
                int maID;
                try {
                    maID = Integer.parseInt(edID.getText().toString());
                    if (maID <= 0) {
                        Toast.makeText(MainActivity.this, "Mã nhân viên nhập sai.", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                } catch (Exception e) {
                    return true;
                }
                String hoten = edHoten.getText().toString();
                if (hoten.equals("")) {
                    Toast.makeText(MainActivity.this, "Họ tên nhân viên không có.", Toast.LENGTH_SHORT).show();
                    return true;
                }

                String gioiTinh;
                try {
                    gioiTinh = ((RadioButton) findViewById(rdg.getCheckedRadioButtonId())).getText().toString();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Hãy chọn giới tính.", Toast.LENGTH_SHORT).show();
                    return true;
                }

                if (donvi.equals("")) {
                    Toast.makeText(MainActivity.this, "Hãy chọn đơn vị làm việc.", Toast.LENGTH_SHORT).show();
                    return true;
                }

                if (maAnh.equals("")) {
                    Toast.makeText(MainActivity.this, "Chưa chọn ảnh.", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
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
                z1 = 0;

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

                if (z1 == 0){
                    z1++;
                    edHoten.setText("");
                    edID.setText("");
                    rdoNam.setChecked(true);
                    donvi = dsDonvi[0];
                }
                else{
                    finish();
                }
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
    //


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        fileName = "dsSinhVien.txt";
        switch (item.getItemId()){
            case R.id.mnDocfile:{
                Toast.makeText(MainActivity.this, "Doc ds từ file", Toast.LENGTH_SHORT).show();
                try {
//                    luuDSNhanVien(fileName);

//                    getDir(fileName, MODE_PRIVATE);
                    String data = "Wellcome to our class";

                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(data.getBytes());

                    outputStream.close();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                return true;
            }
            case R.id.mnLuuds:{
                Toast.makeText(MainActivity.this, "Luu ds vào file", Toast.LENGTH_SHORT).show();
                try {
//                    docDsNhanVien(fileName);
                    String data = ""; int c;
                    FileInputStream inputStream = openFileInput(fileName);
                    while((c = inputStream.read()) != -1){
                        data += Character.toString((char) c);
                    }

                    txtKQ.setText(""+data);
                    inputStream.close();

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                return true;
            }
            case R.id.mnXoafile:{
                Toast.makeText(MainActivity.this, "Xoa file", Toast.LENGTH_SHORT).show();
                try {
//                    deleteFile(fileName);
//                    txtKQ.setText("del");
                    txtKQ.setText("" + getFilesDir().toString());
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void luuDSNhanVien(String fileName) throws IOException {
//        getDir(fileName, MODE_PRIVATE);
//        String data = "Wellcome to our class";
//
//        FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
//        outputStream.write(data.getBytes());
//
//        outputStream.close();

    }
    //
    private void docDsNhanVien(String fileName) throws IOException {
//        String data = ""; int c;
//        FileInputStream inputStream = openFileInput(fileName);
//        while((c = inputStream.read()) != -1){
//            data += Character.toString((char) c);
//        }
//
//        txtKQ.setText(""+data);
//        inputStream.close();
    }






}