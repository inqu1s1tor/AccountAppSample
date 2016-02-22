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
                        + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORY_NAME + " , "
                        + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORY_ID
                        + " FROM " + DataBaseHelper.TABLE_CATEGORIES + "," + DataBaseHelper.TABLE_INCOME
                        + " WHERE "
                        + DataBaseHelper.TABLE_INCOME + "." + DataBaseHelper.INCOME_CATEGORIES + " = "
                        + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORY_ID;


        static final String SELECT_GENERAL_COSTS_SUM =
                "SELECT "
                        + "sum(" + DataBaseHelper.COSTS_SUM + ") "
                        + "FROM " + DataBaseHelper.TABLE_COSTS;

        static final String SELECT_GENERAL_INCOME_SUM =
                "SELECT "
                        + "sum(" + DataBaseHelper.INCOME_SUM + ") "
                        + "FROM " + DataBaseHelper.TABLE_INCOME;

}