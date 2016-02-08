package com.erminesoft.my_account.myacount.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public final class DataBaseHelper extends SQLiteOpenHelper {


    final String LOG_TAG = "myLog";

    public static final String DATABASE_NAME = "Account";
    public static final int DATABASE_VERSION = 2;
    //table users
    public static final String TABLE_USERS = "users";
    public static final String USERS_ID = "id";
    public static final String USER_NAME = "username";
    public static final String USER_PASSWORD = "password";

    //table income
    public static  final String TABLE_INCOME = "income";
    public static final String INCOME_ID = "id";
    public static final String INCOME_NAME = "income name";
    public static final String INCOME_CATEGORIES = "income categories";

    //table costs
    public static  final String TABLE_COSTS = "costs";
    public static final String COSTS_ID = "id";
    public static final String COSTS_NAME = "costs name";
    public static final String COSTS_CATEGORIES = "costs categories";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(LOG_TAG, "DB_START");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d(LOG_TAG, "OnCreate");

        db.beginTransaction();
        db.execSQL(buildCosts());
        db.execSQL(buildIncoms());
        db.endTransaction();
    }

    private String buildIncoms(){
        return "CREATE TABLE " + TABLE_INCOME + " ( "
                + INCOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + INCOME_NAME + " text, "
                + INCOME_CATEGORIES + " text " + " )";
    }

    private String buildCosts(){
        return "CREATE TABLE " + TABLE_COSTS + " ( "
                + COSTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COSTS_NAME + " text, "
                + COSTS_CATEGORIES + " text " + " )";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(LOG_TAG, "OnUpgrade");
    }
}