package com.erminesoft.my_account.myacount.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.erminesoft.my_account.myacount.db.Tables.*;

final class DataBaseHelper extends SQLiteOpenHelper {


    final String LOG_TAG = "myLog";

    private static final String DATABASE_NAME = "Account";
    private static final int DATABASE_VERSION = 1;

    private StringBuilder builder;
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(LOG_TAG, "DB_START");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");

        builder = new StringBuilder("create table if not exists ")
                .append(Users.TABLE_USERS)
                .append(" (")
                .append(Users.USERS_ID).append(" integer primary key autoincrement, ")
                .append(Users.USER_NAME).append(" text not null, ")
                .append(Users.USER_PASSWORD).append(" text not null);");
        db.execSQL(builder.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}