package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;

import com.erminesoft.my_account.myacount.db.UsersData;
import com.erminesoft.my_account.myacount.ui.activities.ChoiceContentActivity;



public interface DBbridge {
    Cursor loadCosts();
    Cursor loadIncome();
    void save(String fieldCategory , String fieldName);
}
