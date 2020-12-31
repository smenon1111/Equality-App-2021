package com.example.informationapp2021;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static final String DATABASE_NAME="appusers.db";
    private static final int DATABASE_VERSION = 3;
    public static final String TABLE_NAME="T_Register";
    public static final String COL_1="ID";
    public static final String COL_2="Name";
    public static final String COL_3="Username";
    public static final String COL_4="Password";
    public static final String COL_5="Email";
    public static final String COL_6="Pronouns";
    public static final String COL_7="Age";
    public static final String COL_8="About";
    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_TABLE = "CREATE TABLE  " +
                TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT, " +
                COL_5 + " TEXT, " +
                COL_6 + " TEXT, " +
                COL_7 + " TEXT, " +
                COL_8 + " TEXT " + ")";

        Log.i("Insert", "create table");
        try {
            db.execSQL(CREATE_TABLE);
            Log.i("Processed", "create table");
        }
        catch (SQLException e) {
            Log.e("db", "create table", e);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //Drop older table if exists
        onCreate(db);
    }

}