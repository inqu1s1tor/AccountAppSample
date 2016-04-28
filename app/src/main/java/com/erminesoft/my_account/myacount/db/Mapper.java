package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;

import com.erminesoft.my_account.myacount.model.Category;
import com.erminesoft.my_account.myacount.model.Cost;
import com.erminesoft.my_account.myacount.model.Income;


final class Mapper {

    public static ContentValues convertCosts(String nameText, int category, int sumCost, boolean isSent) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COSTS_CATEGORIES, category);
        cv.put(DataBaseHelper.COSTS_NAME, nameText);
        cv.put(DataBaseHelper.COSTS_SUM, sumCost);
        cv.put(DataBaseHelper.COSTS_IS_SYNC, isSent);
        return cv;
    }

    public static ContentValues convertIncome(String nameText, int category, int sumIncome, boolean isSent) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.INCOME_CATEGORIES, category);
        cv.put(DataBaseHelper.INCOME_NAME, nameText);
        cv.put(DataBaseHelper.INCOME_SUM, sumIncome);
        cv.put(DataBaseHelper.INCOME_IS_SYNC, isSent);
        return cv;
    }

    public static ContentValues convertCategory(String categoryName, int categoryType, boolean isSent) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.CATEGORY_NAME, categoryName);
        cv.put(DataBaseHelper.CATEGORY_TYPE, categoryType);
        cv.put(DataBaseHelper.CATEGORY_IS_SYNC, isSent);
        return cv;
    }

    public static ContentValues convertCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.CATEGORY_NAME, category.getCategoryName());
        cv.put(DataBaseHelper.CATEGORY_TYPE, category.getCategoryType());
        cv.put(DataBaseHelper.CATEGORY_IS_SYNC, category.isSent());
        cv.put(DataBaseHelper.CATEGORY_ID, category.getUuid());
        return cv;
    }

    public static ContentValues convertCosts(Cost cost) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COSTS_NAME, cost.getCostName());
        cv.put(DataBaseHelper.COSTS_CATEGORIES, cost.getCostCategory());
        cv.put(DataBaseHelper.COSTS_SUM, cost.getSumCostId());
        cv.put(DataBaseHelper.COSTS_ID, cost.getUuid());
        cv.put(DataBaseHelper.COSTS_IS_SYNC, cost.isSent());
        return cv;
    }

    public static ContentValues convertIncomes(Income income) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.INCOME_NAME, income.getIncomeName());
        cv.put(DataBaseHelper.INCOME_CATEGORIES, income.getIncomeCategory());
        cv.put(DataBaseHelper.INCOME_SUM, income.getSumIncomeId());
        cv.put(DataBaseHelper.INCOME_ID, income.getUuid());
        cv.put(DataBaseHelper.INCOME_IS_SYNC, income.isSent());
        return cv;
    }
}

