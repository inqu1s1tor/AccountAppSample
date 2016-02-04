package com.erminesoft.my_account.myacount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.erminesoft.my_account.myacount.core.bridge.DBbridge;


public final class DbManager implements DBbridge {

    private final String LOG_TAG = "myLog";
    private final DataBaseHelper baseHelper;

    public DbManager(Context context) {
        baseHelper = new DataBaseHelper(context);
    }

    @Override
    public void save(UsersData usersData) {

        ContentValues cv = Mapper.convertUserData(usersData);

        long numcolumm = baseHelper.getWritableDatabase().insert(DataBaseHelper.TABLE_USERS, null, cv);
        Log.d(LOG_TAG, "row inserted, ID = " + numcolumm);

    }

    public void delete(int id) {
        baseHelper.getReadableDatabase().delete(DataBaseHelper.TABLE_USERS, DataBaseHelper.USERS_ID + "=?",
                new String[]{String.valueOf(id)});
    }

    public void unloadingDataBase(UsersData usersData){

        Cursor c = baseHelper.getReadableDatabase().query(DataBaseHelper.TABLE_USERS, null, null, null, null, null, null);

        if (c.moveToFirst()) {

            int idIndex = c.getColumnIndex(DataBaseHelper.USERS_ID);
            int fusername = c.getColumnIndex(DataBaseHelper.USER_NAME);
            int fpassword = c.getColumnIndex(DataBaseHelper.USER_PASSWORD);

            do {
                usersData.setUserLogin(c.getString(fusername));
                usersData.setUserPassword(c.getString(fpassword));

                Log.d(LOG_TAG, "LoginInDataBase" + "  " + c.getString(fusername));
                Log.d(LOG_TAG, "PasswordInDataBase" + "  " + c.getString(fpassword));
            } while (c.moveToNext());
            c.close();
        }
    }

    @Override
    public Cursor loadCosts() {
        return baseHelper.getReadableDatabase().query(DataBaseHelper.TABLE_USERS, null, null, null, null, null, null);
    }
}


