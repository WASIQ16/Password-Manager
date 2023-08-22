package com.example.password;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name="Donation.db";
    public static final String Table_Name="Manager";
    public static final String c1="ID";
    public static final String c2="Email";
    public static final String c3="Password";
    public DatabaseHelper(Context context) {super(context, Database_Name, null, 1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+Table_Name+"("+c1+" TEXT PRIMARY KEY, "+ c2+" TEXT,"+c3+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String ID, String Email, String Password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.c1,ID);
        contentValues.put(DatabaseHelper.c2,Email);
        contentValues.put(DatabaseHelper.c3,Password);
        long res = db.insert(Table_Name, null, contentValues);

        if (res == -1)
            return false;
        else
            return true;
    }

    public boolean Update(String ID, String Email, String Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.c1,ID);
        contentValues.put(DatabaseHelper.c2,Email);
        contentValues.put(DatabaseHelper.c3,Password);

        db.update(Table_Name, contentValues, "ID = ?", new String[]{ID});
        return true;
    }

    public  boolean Delete (String ID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_Name, "ID = ?", new String[]{ID});
        return true;
    }

    public Cursor getData()
    {
        SQLiteDatabase sql = this.getWritableDatabase();
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Table_Name, null);
        return cursor;
    }

}