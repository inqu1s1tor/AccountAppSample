package com.erminesoft.my_account.myacount.util;

import android.database.Cursor;

import com.erminesoft.my_account.myacount.db.DataBaseHelper;
import com.erminesoft.my_account.myacount.model.Category;
import com.erminesoft.my_account.myacount.model.Cost;
import com.erminesoft.my_account.myacount.model.Income;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ModelsMapper {

    public static Queue<Category> cursorToCategories(Cursor cursor) {
        Queue<Category> categories = new ArrayDeque<>(cursor.getCount());

        while (cursor.moveToNext()) {
                categories.add(cursorToCategory(cursor));
        }

        return categories;
    }

    public static Category cursorToCategory(Cursor cursor) {

        int nameIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_NAME);
        int typeIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_TYPE);
        int isSentIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_IS_SYNC);
        int uuidIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_ID);

        Category category = new Category();
        category.setCategoryName(cursor.getString(nameIndex));
        category.setCategoryType(cursor.getInt(typeIndex));
        category.setSent(cursor.getInt(isSentIndex) == 1);
        category.setUuid(String.valueOf(cursor.getInt(uuidIndex)));

        return category;
    }


    public static Queue<Cost> cursorToCosts(Cursor cursor) {
        Queue<Cost> costs = new ArrayDeque<>(cursor.getCount());

        while (cursor.moveToNext()) {
            costs.add(cursorToCost(cursor));
        }

        return costs;
    }

    public static Cost cursorToCost(Cursor cursor) {

        int categoryCostIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_CATEGORIES);
        int nameCostIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_NAME);
        int sum = cursor.getColumnIndex(DataBaseHelper.COSTS_SUM);
        int isSentIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_IS_SYNC);
        int uuidIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_ID);


        Cost cost = new Cost();
        cost.setCostCategory(cursor.getString(categoryCostIndex));
        cost.setCostName(cursor.getString(nameCostIndex));
        cost.setSumCostId(cursor.getInt(sum));
        cost.setSent(cursor.getInt(isSentIndex) == 1);
        cost.setUuid(String.valueOf(cursor.getInt(uuidIndex)));

        return cost;
    }

    public static Queue<Income> cursorToIncomes(Cursor cursor) {
        Queue<Income> incomes = new ArrayDeque<>(cursor.getCount());

        while (cursor.moveToNext()) {
            incomes.add(cursorToIncome(cursor));
        }

        return incomes;
    }

    public static Income cursorToIncome(Cursor cursor) {

        int categoryIncomeIndex = cursor.getColumnIndex(DataBaseHelper.INCOME_CATEGORIES);
        int nameIncomeIndex = cursor.getColumnIndex(DataBaseHelper.INCOME_NAME);
        int sum = cursor.getColumnIndex(DataBaseHelper.INCOME_SUM);
        int isSentIndex = cursor.getColumnIndex(DataBaseHelper.INCOME_IS_SYNC);
        int uuidIndex = cursor.getColumnIndex(DataBaseHelper.INCOME_ID);


        Income income = new Income();
        income.setIncomeCategory(cursor.getString(categoryIncomeIndex));
        income.setIncomeName(cursor.getString(nameIncomeIndex));
        income.setSumIncomeId(cursor.getInt(sum));
        income.setSent(cursor.getInt(isSentIndex) == 1);
        income.setUuid(String.valueOf(cursor.getInt(uuidIndex)));

        return income;
    }
}
