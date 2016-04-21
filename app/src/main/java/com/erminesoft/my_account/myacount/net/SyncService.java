package com.erminesoft.my_account.myacount.net;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import com.erminesoft.my_account.myacount.core.AAplication;
import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.core.bridge.NetBridge;
import com.erminesoft.my_account.myacount.model.Category;
import com.erminesoft.my_account.myacount.util.CategoryMapper;

import java.util.List;

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

    @Override
    protected void onHandleIntent(Intent intent) {


        if (isWork) {
            Log.w(SERVICE_NAME, "Service already running");
            return;
        }

        isWork = true;
        initModules();
    }

    private void initModules() {
        AAplication application = (AAplication) getApplicationContext();
        dbBridge = application.getDbManager();
        netBridge = application.getNetBridge();
    }

    private void repackModels(){
        Cursor cursor = dbBridge.loadCostsCategories();
        List<Category> categories = CategoryMapper.cursorToCategories(cursor);

        sendToServer(categories);
    }

    private void sendToServer(List<Category> categories){
    }
}
