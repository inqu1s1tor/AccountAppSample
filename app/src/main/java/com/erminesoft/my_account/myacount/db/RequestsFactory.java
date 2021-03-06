package com.erminesoft.my_account.myacount.db;

final class RequestsFactory {

    static final String SELECT_COSTS_WITH_CATEGORIES =
            "SELECT "
                    + DataBaseHelper.TABLE_COSTS + "." + DataBaseHelper.COSTS_NAME + " , "
                    + DataBaseHelper.TABLE_COSTS + "." + DataBaseHelper.COSTS_CATEGORIES + " , "
                    + DataBaseHelper.TABLE_COSTS + "." + DataBaseHelper.COSTS_SUM + " , "
                    + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORY_NAME + " , "
                    + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORY_ID
                    + " FROM " + DataBaseHelper.TABLE_CATEGORIES + "," + DataBaseHelper.TABLE_COSTS
                    + " WHERE "
                    + DataBaseHelper.TABLE_COSTS + "." + DataBaseHelper.COSTS_CATEGORIES + " = "
                    + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORY_ID;

    static final String SELECT_INCOMES_WITH_CATEGORIES =
            "SELECT "
                    + DataBaseHelper.TABLE_INCOME + "." + DataBaseHelper.INCOME_NAME + " , "
                    + DataBaseHelper.TABLE_INCOME + "." + DataBaseHelper.INCOME_CATEGORIES + " , "
                    + DataBaseHelper.TABLE_INCOME + "." + DataBaseHelper.INCOME_SUM + " , "
                    + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORY_NAME + " , "
                    + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORY_ID
                    + " FROM " + DataBaseHelper.TABLE_CATEGORIES + "," + DataBaseHelper.TABLE_INCOME
                    + " WHERE "
                    + DataBaseHelper.TABLE_INCOME + "." + DataBaseHelper.INCOME_CATEGORIES + " = "
                    + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORY_ID;


    static final String SELECT_GENERAL_COSTS_SUM =
            "SELECT "
                    + "SUM(" + DataBaseHelper.COSTS_SUM + ") AS " + DataBaseHelper.COSTS_SUM
                    + " FROM " + DataBaseHelper.TABLE_COSTS;

    static final String SELECT_GENERAL_INCOME_SUM =
            "SELECT "
                    + "SUM(" + DataBaseHelper.INCOME_SUM + ") AS " + DataBaseHelper.INCOME_SUM
                    + " FROM " + DataBaseHelper.TABLE_INCOME;

    static final String SELECT_UNSENT_CATEGORIES =
            "SELECT * "
                    + "FROM " + DataBaseHelper.TABLE_CATEGORIES
                    + " WHERE "
                    + DataBaseHelper.CATEGORY_IS_SYNC + " = 0";

    static final String SELECT_UNSENT_COSTS =
            "SELECT * "
                    + "FROM " + DataBaseHelper.TABLE_COSTS
                    + " WHERE "
                    + DataBaseHelper.COSTS_IS_SYNC + " = 0";

    static final String SELECT_UNSENT_INCOMES=
            "SELECT * "
                    + "FROM " + DataBaseHelper.TABLE_INCOME
                    + " WHERE "
                    + DataBaseHelper.INCOME_IS_SYNC + " = 0";


}