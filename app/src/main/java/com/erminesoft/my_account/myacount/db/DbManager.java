package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.erminesoft.my_account.myacount.core.bridge.DBbridge;


public final class DbManager implements DBbridge {

    private final String LOG_TAG = "myLog";
    private final DataBaseHelper baseHelper;

    public DbManager(Context context) {
        Log.d(LOG_TAG, "create db manager");
        baseHelper = new DataBaseHelper(context);
    }

    @Override
     public void saveCostsToDb(int category, String nameText) {
        ContentValues cv = Mapper.convertCosts(nameText,category);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_COSTS, null, cv);
    }

    @Override
    public void saveIncomeToDb(String category, String nameText) {
        ContentValues cv = Mapper.convertIncome(nameText, category);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_INCOME, null, cv);
    }

    @Override
    public void saveCategoriesToDb(String categories) {
        ContentValues cv = Mapper.convertCategories(categories);
        baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_CATEGORIES, null, cv);
    }

    @Override
    public Cursor loadCosts() {
        return baseHelper.getReadableDatabase().rawQuery(RequestsFactory.SELECT_COSTS_WITH_CATEGORIES, new String[0]);
    }

    @Override
    public Cursor loadIncome() {
        return baseHelper.getReadableDatabase().query(DataBaseHelper.TABLE_INCOME, null, null, null, null, null, null);
    }

    @Override
    public Cursor loadCategories() {
        return baseHelper.getReadableDatabase().query(DataBaseHelper.TABLE_CATEGORIES, null, null, null, null, null, null);

    }
}


