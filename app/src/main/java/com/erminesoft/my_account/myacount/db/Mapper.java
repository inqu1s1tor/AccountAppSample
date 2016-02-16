package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;


final class Mapper {

    public static ContentValues convertCosts(String nameText, int category) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COSTS_CATEGORIES, category);
        cv.put(DataBaseHelper.COSTS_NAME, nameText);
        return cv;
    }

    public static ContentValues convertIncome(String nameText, int category) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.INCOME_CATEGORIES, category);
        cv.put(DataBaseHelper.INCOME_NAME, nameText);
        return cv;
    }

    public static ContentValues convertCategoriesCosts(String categoriesCosts) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.CATEGORIES_NAME, categoriesCosts);
        return cv;
    }

    public static ContentValues convertCategoriesIncome(String categoriesIncome) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.CATEGORIES_NAME_INCOME, categoriesIncome);
        return cv;
    }
}

