package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;


public interface DBbridge {
    Cursor loadCosts();
    Cursor loadIncome();
    void saveCostsToDb(String fieldCategoryCosts, String fieldNameCosts);
    void saveIncomeToDb(String fieldCategoryIncome, String fieldNameIncome);

}
