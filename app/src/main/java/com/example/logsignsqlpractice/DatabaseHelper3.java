package com.example.logsignsqlpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper3 extends SQLiteOpenHelper {

    public DatabaseHelper3( Context context) {
        super(context, "userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(name TEXT primary key,age TEXT,phonenumber TEXT,address1 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
    DB.execSQL("drop table if exists Userdetails");
    }
    public Boolean insertuserdata(String  name, String age, String phonenumber, String address1){
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("age",age);
        contentValues.put("phonenumber",phonenumber);
        contentValues.put("address1",address1);
        long result=DB.insert("Userdetails",null,contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }

    }




    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?", null);
       return cursor;
        }
    }


