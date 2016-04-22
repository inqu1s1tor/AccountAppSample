package com.erminesoft.my_account.myacount.core.bridge;

import com.backendless.BackendlessUser;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;
import com.erminesoft.my_account.myacount.model.Category;
import com.erminesoft.my_account.myacount.model.Cost;
import com.erminesoft.my_account.myacount.model.Income;

public interface NetBridge {

    void registrationUser(String login, String password, MainCallback mainCallback);

    void logInUser(String login, String password, MainCallback mainCallback);

    void autoLogin(MainCallback mainCallback);

    Category addNewCategory(Category category);

    Cost addNewCost(Cost cost);

    Income addNewIncome(Income income);

    void updateCost(int cost, MainCallback mainCallback);
}
