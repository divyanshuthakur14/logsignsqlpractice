package com.example.logsignsqlpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    public DatabaseHelper2( Context context) {
        super(context, "rentit.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DaB) {
        DaB.execSQL("create Table rentdetails(address TEXT primary key,space TEXT,vehiclepreference TEXT,dates TEXT, timingofavail TEXT, amount TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DaB, int oldVersion, int newVersion) {
        DaB.execSQL("drop table if exists rentdetails");
    }
    public Boolean insertuserdata(String  address, String space, String vehiclepreference, String dates ,String timingofavail ,String amount ){
        SQLiteDatabase DaB= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("address",address);
        contentValues.put("space",space);
        contentValues.put("vehiclepreference",vehiclepreference);
        contentValues.put("dates ",dates );
        contentValues.put("timingofavail",timingofavail);
        contentValues.put("amount",amount);

        long result=DaB.insert("rentdetails",null,contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }

    }





    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM rentdetails", null);
        return cursor;
    }

}


