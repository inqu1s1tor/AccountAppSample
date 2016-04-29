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

import java.util.List;

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
            return category;
        }else{
            return null;}
    }

    Cost addNewCost(Cost cost) {
        cost = Backendless.Persistence.save(cost);

        if (cost != null) {
            DataPermission.FIND.grantForAllRoles(cost);
            return cost;
        }else{
            return null;}
    }

    Income addNewIncome(Income income) {
        income = Backendless.Persistence.save(income);

        if (income != null) {
            DataPermission.FIND.grantForAllRoles(income);
            return income;
        }else{
            return null;}
    }

}
