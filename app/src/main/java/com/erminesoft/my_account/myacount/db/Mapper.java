package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;


final class Mapper {

    public static ContentValues convertCosts(String categoryText, String nameText) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COSTS_CATEGORIES, categoryText);
        cv.put(DataBaseHelper.COSTS_NAME, nameText);
        return cv;
    }

    public static ContentValues convertIncome(String categoryText, String nameText) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.INCOME_CATEGORIES, categoryText);
        cv.put(DataBaseHelper.INCOME_NAME, nameText);
        return cv;
    }

    public static ContentValues convertCategories(String categoryGeneral) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.CATEGORIES_NAME, categoryGeneral);
        return cv;
    }
}

