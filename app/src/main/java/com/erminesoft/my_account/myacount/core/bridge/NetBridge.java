package com.erminesoft.my_account.myacount.core.bridge;

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

    void getAllCosts(MainCallback mainCallback);

    void getAllIncomes(MainCallback mainCallback);

    void getAllCategories(MainCallback mainCallback);

    void updateCost(int cost, MainCallback mainCallback);
}
