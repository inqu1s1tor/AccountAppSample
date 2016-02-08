package com.erminesoft.my_account.myacount.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public final class DataBaseHelper extends SQLiteOpenHelper {


    final String LOG_TAG = "myLog";

    public static final String DATABASE_NAME = "Account";
    public static final int DATABASE_VERSION = 1;

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

    public StringBuilder builderUsers;
    public StringBuilder builderIncome;
    public StringBuilder builderCosts;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(LOG_TAG, "DB_START");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");


        builderIncome = new StringBuilder("create table if not exists ")
                .append(TABLE_INCOME)
                .append(" (")
                .append(INCOME_ID).append(" integer primary key autoincrement, ")
                .append(INCOME_CATEGORIES).append(" text not null), ")
                .append(INCOME_NAME).append(" text not null);");

        Log.e(LOG_TAG, "Creating table income " + builderIncome.toString());



        builderCosts = new StringBuilder("create table if not exists ")
                .append(TABLE_COSTS)
                .append(" (")
                .append(COSTS_ID).append(" integer primary key autoincrement, ")
                .append(COSTS_NAME).append(" text not null), ")
                .append(COSTS_CATEGORIES).append(" text not null);");

        Log.e(LOG_TAG, "Creating table Costs " + builderCosts.toString());

        db.beginTransaction();
        db.execSQL(builderUsers.toString());
        db.execSQL(builderIncome.toString());
        db.execSQL(builderCosts.toString());
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}