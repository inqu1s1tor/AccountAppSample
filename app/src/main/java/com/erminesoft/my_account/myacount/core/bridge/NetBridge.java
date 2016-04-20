package com.erminesoft.my_account.myacount.core.bridge;

import com.backendless.BackendlessUser;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;

public interface NetBridge {

   /* void doLogin(String login, String password, MainCallback callback);
    void doRegistration(String login, String password, MainCallback callback);*/

    void registrationUser(String login, String password, MainCallback mainCallback);
    void logInUser(String login, String password, MainCallback mainCallback);
    void updateCost(int cost, MainCallback mainCallback);
}
