package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;

import com.erminesoft.my_account.myacount.model.Category;
import com.erminesoft.my_account.myacount.model.Cost;
import com.erminesoft.my_account.myacount.model.Income;

import java.util.List;
import java.util.Observer;


public interface DBbridge {
    Cursor loadCosts();

    Cursor loadIncome();

    Cursor calculateSumCosts();

    Cursor calulateSumIncome();

    Cursor loadCostsCategories();

    Cursor loadIncomeCategories();

    void saveCostsToDb(int Categoiries, String fieldNameCosts, int sumCost, boolean isSent);

    void saveIncomeToDb(int Categories, String fieldNameIncome, int sumIncome, boolean isSent);

    void saveCategoriesCostsToDb(String categoryName, boolean isSent);

    void saveCategoriesIncomeToDb(String categoryName, boolean isSent);

    Cursor getUnsentCategories();

    Cursor getUnsentCosts();

    Cursor getUnsentIncomes();

    void saveCategoriesToDb(List<Category> categories);

    void saveCostsToDb(List<Cost> costs);

    void saveIncomesToDb(List<Income> incomes);

    void saveCategoryToDb(Category category);

    void saveCostToDb(Cost cost);

    void saveIncomeToDb(Income income);

    void addNewObserver(Observer observer);

    void removeObserver(Observer observer);

    void clearAllData();




}
