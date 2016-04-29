package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.util.Log;

import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.model.Category;
import com.erminesoft.my_account.myacount.model.Cost;
import com.erminesoft.my_account.myacount.model.Income;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public final class DbManager extends Observable implements DBbridge {

    private static final int COST_CATEGORIES_TYPE = 0;
    private static final int INCOME_CATEGORIES_TYPE = 1;

    private final String LOG_TAG = "myLog";
    private final DataBaseHelper baseHelper;

    public DbManager(Context context) {
        Log.d(LOG_TAG, "create db manager");
        baseHelper = new DataBaseHelper(context);
    }

    @Override
    public void saveCostsToDb(int category, String nameText, int sumCost, boolean isSent) {
        ContentValues cv = Mapper.convertCosts(nameText, category, sumCost, isSent);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_COSTS, null, cv);
    }

    @Override
    public void saveIncomeToDb(int category, String nameText, int sumIncome, boolean isSent) {
        ContentValues cv = Mapper.convertIncome(nameText, category, sumIncome, isSent);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_INCOME, null, cv);
    }

    @Override
    public void saveCategoriesCostsToDb(String categoryName, boolean isSent) {
        ContentValues cv = Mapper.convertCategory(categoryName, COST_CATEGORIES_TYPE, isSent);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_CATEGORIES, null, cv);
        notifyObserversProcedure();
    }

    @Override
    public void saveCategoriesIncomeToDb(String categoryName, boolean isSent) {
        ContentValues cv = Mapper.convertCategory(categoryName, INCOME_CATEGORIES_TYPE, isSent);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_CATEGORIES, null, cv);
        notifyObserversProcedure();
    }

    @Override
    public Cursor getUnsentCategories() {
        return baseHelper.getReadableDatabase().rawQuery(RequestsFactory.SELECT_UNSENT_CATEGORIES, new String[0]);
    }

    @Override
    public Cursor getUnsentCosts() {
        return baseHelper.getReadableDatabase().rawQuery(RequestsFactory.SELECT_UNSENT_COSTS, new String[0]);
    }

    @Override
    public Cursor getUnsentIncomes() {
        return baseHelper.getReadableDatabase().rawQuery(RequestsFactory.SELECT_UNSENT_INCOMES, new String[0]);
    }

    @Override
    public void saveCategoriesToDb(List<Category> categories) {
        for (int i = 0; i < categories.size(); i++) {
            saveCategoryToDb(categories.get(i));
        }
    }

    @Override
    public void saveCostsToDb(List<Cost> costs) {
        for (int i = 0; i < costs.size(); i++) {
            saveCostToDb(costs.get(i));
        }
    }

    @Override
    public void saveIncomesToDb(List<Income> incomes) {
        for (int i = 0; i < incomes.size(); i++) {
            saveIncomeToDb(incomes.get(i));
        }
    }

    @Override
    public void saveCategoryToDb(Category category) {
        ContentValues contentValues = Mapper.convertCategory(category);
        baseHelper.getWritableDatabase()
                .insertWithOnConflict(DataBaseHelper.TABLE_CATEGORIES,null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
    }

    @Override
    public void saveCostToDb(Cost cost) {
        ContentValues contentValues = Mapper.convertCosts(cost);
        baseHelper.getWritableDatabase()
                .insertWithOnConflict(DataBaseHelper.TABLE_COSTS,null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
    }

    @Override
    public void saveIncomeToDb(Income income) {
        ContentValues contentValues = Mapper.convertIncomes(income);
        baseHelper.getWritableDatabase()
                .insertWithOnConflict(DataBaseHelper.TABLE_INCOME,null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
    }

    @Override
    public void addNewObserver(Observer observer) {
        super.addObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        super.deleteObserver(observer);
    }

    @Override
    public void clearAllData() {
        baseHelper.getWritableDatabase().delete(DataBaseHelper.TABLE_COSTS, null, null);
        baseHelper.getWritableDatabase().delete(DataBaseHelper.TABLE_INCOME, null, null);
        baseHelper.getWritableDatabase().delete(DataBaseHelper.TABLE_CATEGORIES, null, null);
    }

    private void notifyObserversProcedure() {
        setChanged();
        notifyObservers();
    }

    @Override
    public Cursor loadCosts() {
        return baseHelper.getReadableDatabase().rawQuery(RequestsFactory.SELECT_COSTS_WITH_CATEGORIES, new String[0]);
    }

    @Override
    public Cursor loadIncome() {
        return baseHelper.getReadableDatabase().rawQuery(RequestsFactory.SELECT_INCOMES_WITH_CATEGORIES, new String[0]);
    }

    @Override
    public Cursor loadCostsCategories() {
        String selection = new StringBuilder(DataBaseHelper.CATEGORY_TYPE).append("= ?").toString();
        String[] args = new String[]{String.valueOf(COST_CATEGORIES_TYPE)};
        return baseHelper.getReadableDatabase().query(DataBaseHelper.TABLE_CATEGORIES, null, selection, args, null, null, null);
    }

    @Override
    public Cursor loadIncomeCategories() {
        String selection = new StringBuilder(DataBaseHelper.CATEGORY_TYPE).append("= ?").toString();
        String[] args = new String[]{String.valueOf(INCOME_CATEGORIES_TYPE)};
        return baseHelper.getReadableDatabase().query(DataBaseHelper.TABLE_CATEGORIES, null, selection, args, null, null, null);
    }

    public Cursor calculateSumCosts() {
        return baseHelper.getReadableDatabase().rawQuery(RequestsFactory.SELECT_GENERAL_COSTS_SUM, new String[0]);
    }

    public Cursor calulateSumIncome() {
        return baseHelper.getReadableDatabase().rawQuery(RequestsFactory.SELECT_GENERAL_INCOME_SUM, new String[0]);
    }
}


