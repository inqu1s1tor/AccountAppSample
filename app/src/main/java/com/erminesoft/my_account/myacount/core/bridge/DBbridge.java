package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;

import com.erminesoft.my_account.myacount.model.Category;

import java.util.List;
import java.util.Observer;


public interface DBbridge {
    Cursor loadCosts();

    Cursor loadIncome();

    Cursor calculateSumCosts();

    Cursor calulateSumIncome();

    Cursor loadCostsCategories();

    Cursor loadIncomeCategories();

    void saveCostsToDb(int Categoiries, String fieldNameCosts, int sumCost);

    void saveIncomeToDb(int Categories, String fieldNameIncome, int sumIncome);

    void saveCategoriesCostsToDb(String categoryName, boolean isSent);

    void saveCategoriesIncomeToDb(String categoryName, boolean isSent);

    Cursor getUnsentCategories();

    void saveCategoriesToDb(List<Category> categories);

    void saveCategoryToDb(Category category);

    void addNewObserver(Observer observer);

    void removeObserver(Observer observer);




}
