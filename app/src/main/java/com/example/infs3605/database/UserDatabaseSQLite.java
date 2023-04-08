package com.example.infs3605.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class UserDatabaseSQLite extends SQLiteOpenHelper{
    public static final String DBNAME="login.db";
    public UserDatabaseSQLite(Context context) {
        super(context, "login.db", null, 1);
    }
    //create database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key, password TEXT, firstname TEXT, lastname TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }
    //update database
    public Boolean insertData(String username, String password, String firstname, String lastname, String email){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("firstname", firstname);
        values.put("lastname", lastname);
        values.put("email", email);

        long result= db.insert("users", null, values);
        if(result==-1) return false;
        else
            return true;
    }
    //check username
    public Boolean checkusername(String username){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    //check password
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username=? and password=?", new String[]{username, password});
        if(cursor.getCount()>0)
            return true;
        else return false;
    }
    //select data usersinfo
    public Users selectData(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[]{username});
        if (cursor.moveToNext()) {
            String usernam = cursor.getString(0);
            String password = cursor.getString(1);
            String firstname = cursor.getString(2);
            String lastname = cursor.getString(3);
            String email = cursor.getString(4);

            return new Users(usernam, password, firstname, lastname, email);
        }
        return null;
    }

}
