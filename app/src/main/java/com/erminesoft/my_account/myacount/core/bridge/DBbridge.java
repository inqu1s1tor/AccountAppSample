package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;

import com.erminesoft.my_account.myacount.db.UsersData;

/**
 * Created by Sane4ek on 04.02.2016.
 */
public interface DBbridge {
    Cursor loadCosts();
    Cursor loadIncome();
    void save(UsersData usersData);
}
