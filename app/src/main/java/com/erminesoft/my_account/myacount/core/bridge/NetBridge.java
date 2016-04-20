package com.erminesoft.my_account.myacount.core.bridge;

import com.backendless.BackendlessUser;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;

public interface NetBridge {

    void registrationUser(String login, String password, MainCallback mainCallback);

    void logInUser(String login, String password, MainCallback mainCallback);

    void autoLogin(MainCallback mainCallback);

    void updateCost(int cost, MainCallback mainCallback);
}
