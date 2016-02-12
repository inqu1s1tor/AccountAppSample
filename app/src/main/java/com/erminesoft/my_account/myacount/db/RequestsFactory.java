package com.erminesoft.my_account.myacount.db;

public final class RequestsFactory {

    public static final String SELECT_COSTS_WITH_CATEGORIES =
            "SELECT "
                    + DataBaseHelper.TABLE_COSTS + "." + DataBaseHelper.COSTS_NAME + " , "
                    + DataBaseHelper.TABLE_COSTS + "." + DataBaseHelper.COSTS_CATEGORIES + " , "
                    + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORIES_NAME  + " , "
                    + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORIES_ID
                    + " FROM " + DataBaseHelper.TABLE_CATEGORIES + "," + DataBaseHelper.TABLE_COSTS
                    + " WHERE "
                    + DataBaseHelper.TABLE_COSTS + "." + DataBaseHelper.COSTS_CATEGORIES + " = "
                    + DataBaseHelper.TABLE_CATEGORIES + "." + DataBaseHelper.CATEGORIES_ID;
//                    + " AND "
//                    + DataBaseHelper.TABLE_COSTS + "." + DataBaseHelper.COSTS_CATEGORIES + "=?";


}
