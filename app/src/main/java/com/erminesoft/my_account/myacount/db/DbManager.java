package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.erminesoft.my_account.myacount.core.bridge.DBbridge;


public final class DbManager implements DBbridge {

    private static final int COST_CATEGORIES_TYPE = 0;
    private static final int INCOME_CATEGORIES_TYPE = 1;

    private final String LOG_TAG = "myLog";
    private final DataBaseHelper baseHelper;

    public DbManager(Context context) {
        Log.d(LOG_TAG, "create db manager");
        baseHelper = new DataBaseHelper(context);
    }

    @Override
     public void saveCostsToDb(int category, String nameText, int sumCost) {
        ContentValues cv = Mapper.convertCosts(nameText, category, sumCost);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_COSTS, null, cv);
    }

    @Override
    public void saveIncomeToDb(int category, String nameText, int sumIncome) {
        ContentValues cv = Mapper.convertIncome(nameText, category, sumIncome);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_INCOME, null, cv);
    }

    @Override
    public void saveCategoriesCostsToDb(String categoryName) {
        ContentValues cv = Mapper.convertCategory(categoryName, COST_CATEGORIES_TYPE);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_CATEGORIES, null, cv);
    }

    @Override
    public void saveCategoriesIncomeToDb(String categoryName) {
        ContentValues cv = Mapper.convertCategory(categoryName, INCOME_CATEGORIES_TYPE);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_CATEGORIES, null, cv);
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

    public Cursor calculateSumCosts () {
        return baseHelper.getReadableDatabase().rawQuery(RequestsFactory.SELECT_GENERAL_COSTS_SUM, new String[0]);
    }


}


