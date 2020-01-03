package com.pracainzynierska.inzynierka;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeruser";
    public static final String SCORE_NAME= "scoreuser";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="username";
    public static final String COL_3 ="mail_address";
    public static final String COL_4 ="password";
    public static final String COL_5 = "rank";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT, mail_address TEXT, password TEXT, rank TEXT DEFAULT 'Sahelanthropus')");
        db.execSQL("CREATE TABLE scoreuser (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, score INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SCORE_NAME);
        onCreate(db);
    }

    public long addUser(String user, String password, String mail_address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);
        contentValues.put("mail_address", mail_address);
        long res = db.insert("registeruser", null, contentValues);
        db.close();
        return res;
    }

    public long saveScore(String user, int score)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("score", score);
        long res = db.insert("scoreuser",null, contentValues);
        db.close();
        return res;
    }


        public boolean checkUser(String username, String password)
        {
            String[] columns = {COL_1};
            SQLiteDatabase db = getReadableDatabase();
            String selection = COL_2 + "=?" + " and " + COL_4 + "=?";
            String[] selectionArgs = {username, password};
            Cursor cursor = db.query(TABLE_NAME, columns,selection,selectionArgs,null,null,null);
            int count = cursor.getCount();
            cursor.close();
            db.close();

            return count > 0;
        }

        public boolean checkPassword(String password)
        {
            String[] columns = {COL_1};
            SQLiteDatabase db = getReadableDatabase();
            String selection = COL_4 + "=?";
            String[] selectionArgs = {password};
            Cursor cursor = db.query(TABLE_NAME, columns,selection,selectionArgs,null,null,null);
            int count = cursor.getCount();
            cursor.close();
            db.close();

            return count > 0;
        }

        public long updatePassword(String password)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("password", password);
            long res = db.update("registeruser",contentValues,"username="+COL_2,null);
            db.close();
            return res;
        }


    }

