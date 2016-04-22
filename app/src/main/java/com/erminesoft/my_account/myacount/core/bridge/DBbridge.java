package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;

import com.erminesoft.my_account.myacount.model.Category;

import java.util.List;


public interface DBbridge {
    Cursor loadCosts();

    Cursor loadIncome();

    Cursor calculateSumCosts();

    Cursor calulateSumIncome();

    Cursor loadCostsCategories();

    Cursor loadIncomeCategories();

    void saveCostsToDb(int Categoiries, String fieldNameCosts, int sumCost);

    void saveIncomeToDb(int Categories, String fieldNameIncome, int sumIncome);

    void saveCategoriesCostsToDb(String categoryName);

    void saveCategoriesIncomeToDb(String categoryName);

    void saveCategoriesToDb(List<Category> categories);

    void saveCategoryToDb(Category category);
}
