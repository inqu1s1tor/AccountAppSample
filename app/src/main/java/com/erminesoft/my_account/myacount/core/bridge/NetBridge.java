package com.erminesoft.my_account.myacount.core.bridge;

import com.backendless.BackendlessUser;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;
import com.erminesoft.my_account.myacount.model.Category;

public interface NetBridge {

    void registrationUser(String login, String password, MainCallback mainCallback);

    void logInUser(String login, String password, MainCallback mainCallback);

    void autoLogin(MainCallback mainCallback);

    Category addNewCategory(Category category);

    void updateCost(int cost, MainCallback mainCallback);
}
