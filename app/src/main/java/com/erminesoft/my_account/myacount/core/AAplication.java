package com.erminesoft.my_account.myacount.core;

import android.app.Application;

import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.core.bridge.NetBridge;
import com.erminesoft.my_account.myacount.db.DbManager;
import com.erminesoft.my_account.myacount.net.NetManagerFacade;

public final class AAplication extends Application {

    private SharedHelper sharedHelper;
    private NetBridge netBridge;
    private DBbridge dBbridge;


    @Override
    public void onCreate() {
        super.onCreate();
        sharedHelper = new SharedHelper(this);
        dBbridge = new DbManager(this);
        netBridge = new NetManagerFacade(this, sharedHelper,dBbridge);
    }

    public SharedHelper getSharedHelper() {
        return sharedHelper;
    }

    public DBbridge getDbManager() {
        return dBbridge;
    }

    public NetBridge getNetBridge() {
        return netBridge;
    }

    public DBbridge getdBbridge() {
        return dBbridge;
    }
}




