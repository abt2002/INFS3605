package com.example.infs3605.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class HistoryDatabaseSQLite extends SQLiteOpenHelper {

    public HistoryDatabaseSQLite(Context context) {
        super(context, "history.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table history(username TEXT , msg TEXT, sendtime TEXT, sendfrom TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists history");
    }


    public Boolean insertData(String username, String msg, String sendtime, String sendfrom){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("msg", msg);
        values.put("sendtime", sendtime);
        values.put("sendfrom", sendfrom);

        long result= db.insert("history", null, values);
        if(result==-1) return false;
        else
            return true;
    }


    public List<HistoryMsg> selectHistoryByUsername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from history where username=?", new String[]{username});
        List<HistoryMsg> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            String msg = cursor.getString(1);
            String sendtime = cursor.getString(2);
            String sendfrom = cursor.getString(3);
            result.add(new HistoryMsg(username, msg, sendtime, sendfrom));
        }
        return result;
    }

}
