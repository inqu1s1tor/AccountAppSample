package com.erminesoft.my_account.myacount.net;

import android.util.Log;

import com.backendless.Backendless;
import com.backendless.DataPermission;
import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.model.Category;

/**
 * Created by Aleks on 21.04.2016.
 */
final class BoltsManager {

    private DBbridge dbBridge;

    BoltsManager(DBbridge dbBridge) {
        this.dbBridge = dbBridge;
    }

    Category addNewCategory(Category category) {
        try {
            category = Backendless.Persistence.save(category);
            if (category != null) {
                DataPermission.FIND.grantForAllRoles(category);
//                dbBridge.saveEvent(category);
                return category;
            } else {
                return null;
            }
        } catch (RuntimeException e) {
            Log.d("addNewCategory", "!RuntimeException = " + e.getMessage());
            return null;
        }
    }
}
