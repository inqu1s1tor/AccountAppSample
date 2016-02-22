package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;


final class Mapper {

    public static ContentValues convertCosts(String nameText, int category, double sumCost) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COSTS_CATEGORIES, category);
        cv.put(DataBaseHelper.COSTS_NAME, nameText);
        cv.put(DataBaseHelper.COSTS_SUM, sumCost);
        return cv;
    }

    public static ContentValues convertIncome(String nameText, int category, double sumIncome) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.INCOME_CATEGORIES, category);
        cv.put(DataBaseHelper.INCOME_NAME, nameText);
        cv.put(DataBaseHelper.INCOME_SUM, sumIncome);
        return cv;
    }

    public static ContentValues convertCategory(String categoryName, int categoryType) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.CATEGORY_NAME, categoryName);
        cv.put(DataBaseHelper.CATEGORY_TYPE, categoryType);
        return cv;
    }
}

