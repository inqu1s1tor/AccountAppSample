package com.erminesoft.my_account.myacount.core;

import android.app.Application;
import android.content.Context;

import com.erminesoft.my_account.myacount.db.DbManager;

public class AAplication extends Application {

    private DbManager dbManager;
/*
    @Override
    public void onCreate() {
        super.onCreate();
        dbManager = new DbManager();
    }


    public DbManager getDbManager() {
        return dbManager;
    }*/
}
