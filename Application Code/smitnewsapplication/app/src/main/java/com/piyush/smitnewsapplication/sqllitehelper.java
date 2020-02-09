package com.piyush.smitnewsapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sqllitehelper extends SQLiteOpenHelper {
    public static final String dbname = "student.db";
    public static final String tablename = "student_table";
    public static final String col1 = "emailid";
    public static final String col2 = "phno";
    public static final String col3 = "name";
    public static final String col4 = "pass";

    public sqllitehelper(@Nullable Context context) {
        super(context, dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tablename + "(phno text primary key  ,emailid text,name text,pass text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tablename);
        onCreate(db);
    }

    public boolean insertdata(String name,String emailid,String phno,String pass) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col3,name);
        contentValues.put(col1,emailid);
        contentValues.put(col4,pass);
        contentValues.put(col2,phno);
        long result=db.insert(tablename,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}
