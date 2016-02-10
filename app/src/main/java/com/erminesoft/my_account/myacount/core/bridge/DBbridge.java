package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;


public interface DBbridge {
    Cursor loadCosts();
    Cursor loadIncome();
    Cursor loadCategories();
    void saveCostsToDb(String fieldCategoryCosts, String fieldNameCosts);
    void saveIncomeToDb(String fieldCategoryIncome, String fieldNameIncome);
    void saveCategoriesToDb(String categories);

}
