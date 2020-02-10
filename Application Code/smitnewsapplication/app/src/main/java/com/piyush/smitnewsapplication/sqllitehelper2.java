package com.piyush.smitnewsapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sqllitehelper2 extends SQLiteOpenHelper {
    public static final String dbname1 = "news.db";
    public static final String tablename1= "news_table";
    public static final String col1 = "news";
    public static final String col2 = "username11";


    public sqllitehelper2(@Nullable Context context) {
        super(context, dbname1, null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tablename1 + "(news text,username11 text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tablename1);
        onCreate(db);
    }

    public boolean insertdata11(String news,String username11) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col1,news);
        contentValues.put(col2,username11);
        long result=db.insert(tablename1,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getalldata(){

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+tablename1,null);
        return res;


    }
}


