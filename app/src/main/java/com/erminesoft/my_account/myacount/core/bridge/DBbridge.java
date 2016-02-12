package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;


public interface DBbridge {
    Cursor loadCosts();
    Cursor loadIncome();
    Cursor loadCategories();
    void saveCostsToDb(int Categoiries,String fieldNameCosts);
    void saveIncomeToDb(String Categories, String fieldNameIncome);
    void saveCategoriesToDb(String categories);

}
