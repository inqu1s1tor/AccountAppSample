package com.erminesoft.my_account.myacount.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseConnect {

    private DbManager DbManager;
    private DataBaseHelper dbHelper;
    private SQLiteDatabase database;

    public DataBaseConnect(Context context) {

        dbHelper = new DataBaseHelper(context);
        database = dbHelper.getWritableDatabase();
        DbManager = new DbManager(database);

    }
    public DbManager getUsersRepository() {
        return DbManager;
    }
}