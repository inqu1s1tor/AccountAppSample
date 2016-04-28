package com.erminesoft.my_account.myacount.net;

import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.DataPermission;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;
import com.erminesoft.my_account.myacount.model.Category;
import com.erminesoft.my_account.myacount.model.Cost;
import com.erminesoft.my_account.myacount.model.Income;

/**
 * Created by Aleks on 21.04.2016.
 */
final class BoltsManager {

    private DBbridge dbBridge;

    BoltsManager(DBbridge dbBridge) {
        this.dbBridge = dbBridge;
    }

    Category addNewCategory(Category category) {
        category = Backendless.Persistence.save(category);

        if (category != null) {
            DataPermission.FIND.grantForAllRoles(category);
//            dbBridge.saveCategoryToDb(category);
            return category;
        }else{
            return null;}
    }

    Cost addNewCost(Cost cost) {
        cost = Backendless.Persistence.save(cost);

        if (cost != null) {
            DataPermission.FIND.grantForAllRoles(cost);
//            dbBridge.saveCategoryToDb(category);
            return cost;
        }else{
            return null;}
    }

    Income addNewIncome(Income income) {
        income = Backendless.Persistence.save(income);

        if (income != null) {
            DataPermission.FIND.grantForAllRoles(income);
//            dbBridge.saveCategoryToDb(category);
            return income;
        }else{
            return null;}
    }

    void getAllCosts(final MainCallback callBack) {
        Backendless.Data.of(Cost.class).find(new AsyncCallback<BackendlessCollection<Cost>>() {
            @Override
            public void handleResponse(BackendlessCollection<Cost> response) {
                dbBridge.saveCostsToDb(response.getData());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("getAllCard", "fault = " + fault.toString());
                callBack.onError(fault.toString());
            }
        });
    }
}
