package com.erminesoft.my_account.myacount.core.bridge;

import com.erminesoft.my_account.myacount.core.callback.MainCallback;

public interface NetBridge {

    void doLogin(String login, String password, MainCallback callback);
    void doRegistration(String login, String password, MainCallback callback);
    void updateCost(int cost, MainCallback mainCallback);
}