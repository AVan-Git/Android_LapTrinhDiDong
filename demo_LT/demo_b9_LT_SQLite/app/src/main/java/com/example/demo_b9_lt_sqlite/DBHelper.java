package com.example.demo_b9_lt_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors(id integer primary key, name text, address text, email text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        onCreate(sqLiteDatabase);
    }

    //  thêm xóa sửa - truy vấn author
    public ArrayList<Author> getAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM Authors";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);// tra KQ về consol
        if (cursor != null) {
            cursor.moveToFirst();// Đưa con trỏ về chỗ ban đầu dong cursor
            while (!cursor.isAfterLast()) {
                authors.add(new Author(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3)));

                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return authors;
    }
    //
    public int ínsertAuthor(Author a) {//tra veef  số đòng thay đổi

        SQLiteDatabase db = getWritableDatabase();// mở data để viết
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", a.getId() + ""); // id :tên cột trong table
        contentValues.put("name", a.getName());
        contentValues.put("address", a.getAddress());
        contentValues.put("email", a.getEmail());
        int res = (int) db.insert("Authors", null, contentValues);
        db.close(); // đóng cửa giao tiếp lại;
        return res;
    }

    /**
     * conf sai
     * @param id
     * @return
     */
    //
    public Author getAuthor(int id) {
        Author a = null;

        String sql = "SELECT * FROM Authors WHERE id like '" + id + "'";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            a  = new Author();
            cursor.moveToFirst();

            a.setId(cursor.getInt(0));
            a.setName(cursor.getString(1));
            a.setAddress(cursor.getString(2));
            a.setEmail(cursor.getString(3));

            cursor.close();
            db.close();
        }
        return a;
    }

    //
    public int updateAuthor(Author a) {
        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL("UPDATE product SET name=?, address = ?, email = ? where id = ?",
//                new String[]{a.getName(), a.getAddress() , a.getEmail(), a.getId()+""});

        ContentValues contentValues = new ContentValues();
//        contentValues.put("id", a.getId() + ""); // id :tên cột trong table
        contentValues.put("name", a.getName());
        contentValues.put("address", a.getAddress());
        contentValues.put("email", a.getEmail());
        int res = (int) db.update("Authors", contentValues, "id = "+ a.getId(), null);
        return res;

    }


}
