package com.erminesoft.my_account.myacount.net;

import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;
import com.erminesoft.my_account.myacount.model.Category;
import com.erminesoft.my_account.myacount.model.Cost;
import com.erminesoft.my_account.myacount.model.Income;

/**
 * Created by Aleks on 29.04.2016.
 */
final class DataManager {

    private DBbridge dbBridge;

    DataManager(DBbridge dBbridge){
        this.dbBridge = dBbridge;
    }


    void getAllCosts(final MainCallback callBack) {
        Backendless.Data.of(Cost.class).find(new AsyncCallback<BackendlessCollection<Cost>>() {
            @Override
            public void handleResponse(BackendlessCollection<Cost> response) {
                Log.d("getAllCosts", "getData().size() = " + response.getData().size());

                dbBridge.saveCostsToDb(response.getData());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("getAllCosts", "fault = " + fault.toString());
                callBack.onError(fault.toString());
            }
        });
    }

    void getAllIncomes(final MainCallback callBack) {
        Backendless.Data.of(Income.class).find(new AsyncCallback<BackendlessCollection<Income>>() {
            @Override
            public void handleResponse(BackendlessCollection<Income> response) {
                Log.d("getAllIncomes", "getData().size() = " + response.getData().size());

                dbBridge.saveIncomesToDb(response.getData());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("getAllIncomes", "fault = " + fault.toString());
                callBack.onError(fault.toString());
            }
        });
    }

    void getAllCategories(final MainCallback callBack) {
        Backendless.Data.of(Category.class).find(new AsyncCallback<BackendlessCollection<Category>>() {
            @Override
            public void handleResponse(BackendlessCollection<Category> response) {
                Log.d("getAllCategories", "getData().size() = " + response.getData().size());

                dbBridge.saveCategoriesToDb(response.getData());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("getAllCategories", "fault = " + fault.toString());
                callBack.onError(fault.toString());
            }
        });
    }

}
