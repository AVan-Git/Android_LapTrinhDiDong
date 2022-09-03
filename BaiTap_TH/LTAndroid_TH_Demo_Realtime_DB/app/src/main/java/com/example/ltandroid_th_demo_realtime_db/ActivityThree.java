package com.example.ltandroid_th_demo_realtime_db;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityThree extends AppCompatActivity {

    private static final String TAG = "ActivityThree +++++";
    private FirebaseDatabase db;
    private DatabaseReference reference;
    ListView listView;
    TextView txtID_ac3;
    int maID;
    //
    ArrayList<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        db = FirebaseDatabase.getInstance();
        reference = db.getReference();
        list = getListData();

        Button btnXoa = findViewById(R.id.btnXoa);
        listView = findViewById(R.id.listview_ac3);

        txtID_ac3 = findViewById(R.id.txtID_ac3);
        TextView txtview = findViewById(R.id.txtview);

        Person a = (Person) getIntent().getSerializableExtra("person");
        txtID_ac3.setText("Mã ID: " + a.getId());
        //

        txtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onCreate: list.size() = " + list.size(), null);
                setListView(list);
                getOnListener();
            }
        });
        //
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child("persons").child(""+maID).removeValue();
                Toast.makeText(ActivityThree.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
            }
        });




    }

    private ArrayList<Person> getListData() {
        Log.e(TAG, "getListData: ", null);

        ArrayList<Person> listPerson = new ArrayList<Person>();

        reference.child("persons").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listPerson.clear();
                for (DataSnapshot snap :
                        snapshot.getChildren()) {
                    Person a = snap.getValue(Person.class);
                    listPerson.add(a);
                    Log.e(TAG, "onDataChange: "+ a.toString(), null );
                }

                Log.e(TAG, "listPerson: " + listPerson.size(), null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Log.e(TAG, "listPerson2: " + listPerson.size(), null);
        return listPerson;
    }

    private void setListView(ArrayList<Person> listPerson) {
        Log.e(TAG, "getListData: ", null);

        ArrayList<String> listString = new ArrayList<>();
        for (Person p :
                listPerson) {

            Log.e(TAG, "setListView(): " + p.toString(), null);
            listString.add(p.getId() + " -- " + p.getName() + " -- " + p.getEmail());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ActivityThree.this, android.R.layout.simple_list_item_1, listString);
        listView.setAdapter(adapter);

    }

    private void getOnListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Person person = list.get(i);
                maID =  person.getId();
                txtID_ac3.setText("Mã ID: " + maID);
            }
        });

    }
}