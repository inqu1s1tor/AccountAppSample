package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;


public interface DBbridge {
    Cursor loadCosts();
    Cursor loadIncome();

    Cursor loadCostsCategories();
    Cursor loadIncomeCategories();

    void saveCostsToDb(int Categoiries,String fieldNameCosts);
    void saveIncomeToDb(int Categories, String fieldNameIncome);

    void saveCategoriesCostsToDb(String categoryName);
    void saveCategoriesIncomeToDb(String categoryName);
}
