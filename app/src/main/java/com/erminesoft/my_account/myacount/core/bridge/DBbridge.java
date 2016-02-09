package com.erminesoft.my_account.myacount.core.bridge;

import android.database.Cursor;




public interface DBbridge {
    Cursor loadCosts();
    Cursor loadIncome();
    void saveCostsToDb(String fieldCategory , String fieldName);
    void saveIncomeToDb(String fieldCategory , String fieldName);

}
