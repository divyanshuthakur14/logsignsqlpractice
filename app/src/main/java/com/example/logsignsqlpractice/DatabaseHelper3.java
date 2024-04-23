package com.example.logsignsqlpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper3 extends SQLiteOpenHelper {

    public static final String databaseName = "personal.db";

    public DatabaseHelper3(@Nullable Context context) {
        super(context, "personal.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table users3(name TEXT primary key,age TEXT, phonenumber TEXT,address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users3");
    }

    public Boolean insertData(String name, String age,String phonenumber,String address){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("phonenumber", phonenumber);
        contentValues.put("address", address);


        long result = MyDatabase.insert("users2", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checknameage(String name, String age,String phonenumber,String address){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where name = ? and age = ? and phonenumber = ? and address = ?   ", new String[]{name, age, phonenumber, address});

        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

}