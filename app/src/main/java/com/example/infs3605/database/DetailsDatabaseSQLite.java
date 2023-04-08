package com.example.infs3605.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DetailsDatabaseSQLite extends SQLiteOpenHelper {

    public DetailsDatabaseSQLite(Context context) {
        super(context, "history.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table details(username TEXT , fullname TEXT, faculty TEXT, coursea TEXT, courseb TEXT, coursec TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists details");
    }

    public Boolean insertData(String username, String fullname, String faculty, String coursea, String courseb, String coursec){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("fullname", fullname);
        values.put("faculty", faculty);
        values.put("coursea", coursea);
        values.put("courseb", courseb);
        values.put("coursec", coursec);

        long result= db.insert("details", null, values);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean updateData(String username, String faculty, String coursea, String courseb, String coursec){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("faculty", faculty);
        values.put("coursea", coursea);
        values.put("courseb", courseb);
        values.put("coursec", coursec);

       String where = "username=?";
       String[] whereArgs = new String[] {String.valueOf(username)};

       long result = db.update("Details", values, where, whereArgs);
        if(result==-1) return false;
        else
            return true;
    };

    public Details selectDetails(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from history where username=?", new String[]{username});
        if (cursor.moveToNext()) {
            String usernam = cursor.getString(0);
            String faculty = cursor.getString(1);
            String coursea = cursor.getString(2);
            String courseb = cursor.getString(3);
            String coursec = cursor.getString(4);

            return new Details(usernam, faculty, coursea, courseb, coursec);
        }
        return null;
    }

}
