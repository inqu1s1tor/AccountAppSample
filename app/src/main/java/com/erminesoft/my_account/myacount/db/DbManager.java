package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import static com.erminesoft.my_account.myacount.db.Tables.Users;


public final class DbManager {

    private final String LOG_TAG = "myLog";
    private final DataBaseHelper baseHelper;

    public DbManager(Context context) {
        baseHelper = new DataBaseHelper(context);
    }

    public void save(UsersData usersData) {

        ContentValues values = Mapper.convertExpensesToCV();

        ContentValues cv = new ContentValues();
        cv.put(Users.USER_NAME, usersData.getUserLogin());
        cv.put(Users.USER_PASSWORD, usersData.getUserPassword());

        long numcolumm = baseHelper.getWritableDatabase().insert(Users.TABLE_USERS, null, cv);
        Log.d(LOG_TAG, "row inserted, ID = " + numcolumm);

    }

    public void delete(int id) {
        baseHelper.getReadableDatabase().delete(Users.TABLE_USERS, Users.USERS_ID + "=?",
                new String[]{String.valueOf(id)});
    }

    public void unloadingDataBase(UsersData usersData){

        Cursor c = baseHelper.getReadableDatabase().query(Users.TABLE_USERS, null, null, null, null, null, null);

        if (c.moveToFirst()) {

            int idIndex = c.getColumnIndex(Users.USERS_ID);
            int fusername = c.getColumnIndex(Users.USER_NAME);
            int fpassword = c.getColumnIndex(Users.USER_PASSWORD);

            do {
                usersData.setUserLogin(c.getString(fusername));
                usersData.setUserPassword(c.getString(fpassword));

                Log.d(LOG_TAG, "LoginInDataBase" + "  " + c.getString(fusername));
                Log.d(LOG_TAG, "PasswordInDataBase" + "  " + c.getString(fpassword));
            } while (c.moveToNext());
            c.close();
        }
    }

}


