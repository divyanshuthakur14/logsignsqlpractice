package com.example.logsignsqlpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    public static final String databaseName = "SignLog.db";

    public DatabaseHelper2(@Nullable Context context) {
        super(context, "space.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table users2(address TEXT primary key,space TEXT, preference TEXT,duration TEXT,timing TEXT,amount TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users2");
    }

    public Boolean insertData(String address, String space,String preference,String duration,String timing,String amount){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", address);
        contentValues.put("space", space);
        contentValues.put("preference", preference);
        contentValues.put("duration", duration);
        contentValues.put("timing", timing);
        contentValues.put("amount", amount);

        long result = MyDatabase.insert("users2", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkaddress(String address){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where address = ?", new String[]{address});

        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkaddressspace(String address, String space){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where email = ? and password = ?", new String[]{address, space});

        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkaddresspreference(String address, String preference){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where address = ? and preference = ?", new String[]{address, preference});

        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkaddressduration(String address, String duration){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where address = ? and duration = ?", new String[]{address, duration});

        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkaddresstiming(String address, String timing){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where address = ? and timing = ?", new String[]{address, timing});

        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkaddressamount(String address, String amount){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where address = ? and amount = ?", new String[]{address, amount});

        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
}