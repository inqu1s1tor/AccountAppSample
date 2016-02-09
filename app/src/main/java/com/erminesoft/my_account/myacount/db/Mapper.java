package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;


final class Mapper {

    /*public static ContentValues convertUserData(UsersData usersData){

        ContentValues cv = new ContentValues();

        cv.put(DataBaseHelper.USER_NAME, usersData.getUserLogin());
        cv.put(DataBaseHelper.USER_PASSWORD, usersData.getUserPassword());
        return cv;
    }
    */

    public static ContentValues convertUserData(String categoryText, String nameText) {
        ContentValues cv = new ContentValues();

        cv.put(DataBaseHelper.COSTS_CATEGORIES, categoryText);
        cv.put(DataBaseHelper.COSTS_NAME, nameText);

        cv.put(DataBaseHelper.INCOME_CATEGORIES, categoryText);
        cv.put(DataBaseHelper.INCOME_NAME, nameText);

        return cv;
    }
}
