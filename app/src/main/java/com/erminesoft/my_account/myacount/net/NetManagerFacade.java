package com.erminesoft.my_account.myacount.net;

import android.content.Context;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.erminesoft.my_account.myacount.BuildConfig;
import com.erminesoft.my_account.myacount.core.SharedHelper;
import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.core.bridge.NetBridge;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;

public final class NetManagerFacade implements NetBridge {

    private final DebugNetManager debugNetManager;
    private final AuthManager authManager;

    public NetManagerFacade(Context context, SharedHelper sharedHelper, DBbridge dBbridge) {
        initBackendLess(context);
        debugNetManager = new DebugNetManager(sharedHelper);
        authManager = new AuthManager(sharedHelper, dBbridge);
    }

    private void initBackendLess(Context context) {
        Backendless.initApp(context, BuildConfig.BACKENDLESS_APP_ID, BuildConfig.BACKENDLESS_KEY, "v1");
    }

  /*  @Override
    public void doLogin(String login, String password, MainCallback callback) {
        debugNetManager.doLogin(login, password, callback);
    }

    @Override
    public void doRegistration(String login, String password, MainCallback callback) {
        debugNetManager.doLogin(login, password, callback);
    }*/


    @Override
    public void registrationUser(BackendlessUser user, MainCallback mainCallback) {
        authManager.registrationUser(user, mainCallback);
    }

    @Override
    public void logInUser(String login, String password, MainCallback mainCallback) {
        authManager.logInUser(login, password, mainCallback);

    }

    @Override
    public void updateCost(int cost, MainCallback mainCallback) {

    }
}
