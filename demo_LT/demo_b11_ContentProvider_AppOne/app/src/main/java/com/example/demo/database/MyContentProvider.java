package com.example.demo.database;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;

public class MyContentProvider extends ContentProvider {

    private static final String TAG = "MyContentProvider +++++++++++";
    //
    static final String AUTHOURITY = "com.example.demo";
    static final String CONTENT_PROVIDER = "contentprovider";
    static final String URL = "content://" + AUTHOURITY + "/" + CONTENT_PROVIDER;
    static final Uri CONTENT_URI = Uri.parse(URL);
    static final String PRODUCT_TABLE = "Products";

    private SQLiteDatabase database;

    static final int ONE = 1;
    static final int ALL = 2;
    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHOURITY, PRODUCT_TABLE, ONE);
        uriMatcher.addURI(AUTHOURITY, PRODUCT_TABLE + "/#", ALL);
    }

    public static HashMap<String, String> PROJECTION_MAP;

    public MyContentProvider() {
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DBHelper dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        if (database != null)
            return true;
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection,
                        @Nullable String selection,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(PRODUCT_TABLE);
        switch (uriMatcher.match(uri)) {
            case ALL: {
                queryBuilder.setProjectionMap(PROJECTION_MAP);
                break;
            }
            case ONE: {
                queryBuilder.appendWhere("id=" + uri.getPathSegments().get(0));
                break;
            }
        }

        Cursor cursor = queryBuilder.query(database, projection,
                selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        throw  new UnsupportedOperationException("Not yet implemented");
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Long numberRow = database.insert(PRODUCT_TABLE, "", contentValues);
        if (numberRow > 0)
        {
            Uri uri1 = ContentUris.withAppendedId(CONTENT_URI, numberRow);
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        }
        Log.e(TAG, "insert: Failed to add a record into " + uri, null);
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int res = 0 ;
        res = database.delete(PRODUCT_TABLE, selection, null);
        return res;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        int a =  database.update(PRODUCT_TABLE, contentValues, s, null);
        if (a > 0)
            return a;
        return 0;
    }
}