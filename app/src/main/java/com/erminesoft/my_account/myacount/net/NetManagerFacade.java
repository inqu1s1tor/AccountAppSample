package com.erminesoft.my_account.myacount.net;

import android.content.Context;

import com.backendless.Backendless;
import com.erminesoft.my_account.myacount.BuildConfig;
import com.erminesoft.my_account.myacount.core.SharedHelper;
import com.erminesoft.my_account.myacount.core.bridge.NetBridge;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;

public final class NetManagerFacade implements NetBridge {

    private final DebugNetManager debugNetManager;

    public NetManagerFacade(Context context, SharedHelper sharedHelper) {
        initBackendLess(context);
        debugNetManager = new DebugNetManager(sharedHelper);
    }

    private void initBackendLess(Context context) {
        Backendless.initApp(context, BuildConfig.BACKENDLESS_APP_ID, BuildConfig.BACKENDLESS_KEY, "v1");
    }

    @Override
    public void doLogin(String login, String password, MainCallback callback) {
        debugNetManager.doLogin(login, password, callback);
    }

    @Override
    public void doRegistration(String login, String password, MainCallback callback) {
        debugNetManager.doLogin(login, password, callback);
    }

    @Override
    public void updateCost(int cost, MainCallback mainCallback) {

    }
}
