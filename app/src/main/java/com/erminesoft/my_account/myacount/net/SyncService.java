package com.erminesoft.my_account.myacount.net;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.erminesoft.my_account.myacount.core.AAplication;
import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.core.bridge.NetBridge;

public final class SyncService extends IntentService {

    private final static String SERVICE_NAME = "synchronius";
    private boolean isWork;
    private DBbridge dbBridge;
    private NetBridge netBridge;


    public SyncService() {
        super(SERVICE_NAME);
        isWork = false;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, SyncService.class);
        context.startService(intent);
    }

    private void initModules() {
        AAplication application = (AAplication) getApplicationContext();
        dbBridge = application.getDbManager();
        netBridge = application.getNetBridge();
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        if (isWork) {
            Log.w(SERVICE_NAME, "Service already running");
            return;
        }

        isWork = true;
        initModules();
    }
}
