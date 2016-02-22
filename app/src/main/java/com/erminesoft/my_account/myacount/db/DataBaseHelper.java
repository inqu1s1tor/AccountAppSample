package com.erminesoft.my_account.myacount.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public final class DataBaseHelper extends SQLiteOpenHelper {

    final String LOG_TAG = "myLog";

    public static final String DATABASE_NAME = "Account";
    public static final int DATABASE_VERSION = 2;

    //table income
    public static  final String TABLE_INCOME = "income";
    public static final String INCOME_ID = "_id";
    public static final String INCOME_NAME = "income_name";
    public static final String INCOME_CATEGORIES = "income_categories";
    public static final String INCOME_SUM = "income_sum";


    //table costs
    public static  final String TABLE_COSTS = "costs";
    public static final String COSTS_ID = "_id";
    public static final String COSTS_NAME = "costs_name";
    public static final String COSTS_CATEGORIES = "costs_categories";
    public static final String COSTS_SUM = "costs_sum";

    //table categories
    public static final String TABLE_CATEGORIES = "categories";
    public static final String CATEGORY_ID = "_id";
    public static final String CATEGORY_TYPE = "categories_name";
    public static final String CATEGORY_NAME = "categories_name_income";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(LOG_TAG, "DB_START");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "OnCreate");

        db.execSQL(buildCosts());
        db.execSQL(buildIncomes());
        db.execSQL(buildCategories());
    }

    private String buildIncomes(){
        return "CREATE TABLE " + TABLE_INCOME + " ( "
                + INCOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + INCOME_NAME + " text, "
                + INCOME_SUM + " REAL, "
                + INCOME_CATEGORIES + " INTEGER " + " )";
    }

    private String buildCosts(){
        return "CREATE TABLE " + TABLE_COSTS + " ( "
                + COSTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COSTS_NAME + " text, "
                + COSTS_SUM + " REAL, "
                + COSTS_CATEGORIES + " INTEGER " + " )";
    }

    private String buildCategories(){
        return "CREATE TABLE " + TABLE_CATEGORIES + " ( "
                + CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CATEGORY_NAME + " text, "
                + CATEGORY_TYPE + " INTEGER " + " )";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(LOG_TAG, "OnUpgrade");
    }
}