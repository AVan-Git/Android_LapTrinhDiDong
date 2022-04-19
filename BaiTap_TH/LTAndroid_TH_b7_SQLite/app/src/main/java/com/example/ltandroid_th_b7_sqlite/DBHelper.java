package com.example.ltandroid_th_b7_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE persons(id integer primary key, name text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS persons");
        onCreate(sqLiteDatabase);
    }

    // truy vấn
    public ArrayList<Person> getPersons() {
        ArrayList<Person> list = new ArrayList<>();
        String sql = "SELECT * FROM persons";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                list.add(new Person(cursor.getInt(0), cursor.getString(1)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }

        return list;
    }

    //
    public int maxID() {
        int max = 0;
        String sql = "SELECT MAX(id) FROM persons";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
            max = cursor.getInt(0);

            cursor.close();
            db.close();

        }

        return max + 1;
    }
    //
    public int addName(Person a) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", a.getId() + "");
        contentValues.put("name", a.getName());
        int res = (int) db.insert("persons", null, contentValues);
        db.close();
        return res;
    }
    //
    public void del_MaID(int maXoa) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete("persons", "id=?", new String[]{"" + maXoa});
        db.close();
    }

    //
    public void del_Name(String nameXoa) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "DELETE FROM persons WHERE name='" + nameXoa + "'";
        db.rawQuery(sql, null);

//        db.delete("persons", "name=?", new String[]{nameXoa});
        db.close();
    }


}
