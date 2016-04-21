package com.erminesoft.my_account.myacount.net;

import android.content.Context;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.erminesoft.my_account.myacount.BuildConfig;
import com.erminesoft.my_account.myacount.core.SharedHelper;
import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.core.bridge.NetBridge;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;
import com.erminesoft.my_account.myacount.model.Category;

public final class NetManagerFacade implements NetBridge {

    private final AuthManager authManager;
    private BoltsManager boltsManager;

    public NetManagerFacade(Context context, SharedHelper sharedHelper, DBbridge dBbridge) {
        initBackendLess(context);
        authManager = new AuthManager(sharedHelper, dBbridge);
        boltsManager = new BoltsManager(dBbridge);
    }

    private void initBackendLess(Context context) {
        Backendless.initApp(context, BuildConfig.BACKENDLESS_APP_ID, BuildConfig.BACKENDLESS_KEY, "v1");
    }


    @Override
    public void registrationUser(String login, String password, MainCallback mainCallback) {
        BackendlessUser user = buildUser(login, password);
        authManager.registrationUser(user, mainCallback);
    }

    @Override
    public void logInUser(String login, String password, MainCallback mainCallback) {
        authManager.logInUser(login, password, mainCallback);
    }

    @Override
    public void autoLogin(MainCallback mainCallback) {
        authManager.autoLogin(mainCallback);
    }

    @Override
    public Category addNewCategory(Category category) {
        return null;
    }

    @Override
    public void updateCost(int cost, MainCallback mainCallback) {

    }

    private BackendlessUser buildUser(String login, String password) {
        BackendlessUser user = new BackendlessUser();
        user.setProperty("name", login);
        user.setPassword(password);
        return user;
    }
}
