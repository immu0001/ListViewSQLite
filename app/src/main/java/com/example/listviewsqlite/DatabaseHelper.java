package com.example.listviewsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "mylist.db";
    private static final String TABLE_NAME = "table1";
    private static final String COL1 = "ID";
    public static final String COL2 = "DATA";

    private static final String create_table =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);

        Log.d("database created", "onCreate: table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean adddata(String item1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }}

        public Cursor getListContents()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    }
