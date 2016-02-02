package com.erminesoft.my_account.myacount.core;

import android.app.Application;
import android.content.Context;

import com.erminesoft.my_account.myacount.core.bridge.NetBridge;
import com.erminesoft.my_account.myacount.db.DbManager;
import com.erminesoft.my_account.myacount.net.NetManagerFacade;

public final class AAplication extends Application {

    private SharedHelper sharedHelper;
    private DbManager dbManager;
    private NetBridge netBridge;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedHelper = new SharedHelper(this);
        netBridge = new NetManagerFacade();
    }

    public SharedHelper getSharedHelper() {
        return sharedHelper;
    }

    public DbManager getDbManager() {
        return dbManager;
    }

    public NetBridge getNetBridge() {
        return netBridge;
    }
}
