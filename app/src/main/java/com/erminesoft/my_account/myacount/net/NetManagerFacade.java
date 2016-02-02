package com.erminesoft.my_account.myacount.net;

import com.erminesoft.my_account.myacount.core.bridge.NetBridge;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;

public final class NetManagerFacade implements NetBridge {

    private final DebugNetManager debugNetManager;

    public NetManagerFacade() {
        debugNetManager = new DebugNetManager();
    }

    @Override
    public void doLogin(String login, String password, MainCallback callback) {
        debugNetManager.doLogin(login, password, callback);
    }

    @Override
    public void doRegistration(String login, String password, MainCallback callback) {
        debugNetManager.doLogin(login,  password, callback);
    }

    @Override
    public void updateCost(int cost, MainCallback mainCallback) {

    }
}
