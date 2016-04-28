package com.erminesoft.my_account.myacount.net;

import android.text.TextUtils;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.erminesoft.my_account.myacount.core.SharedHelper;
import com.erminesoft.my_account.myacount.core.bridge.DBbridge;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;

/**
 * Created by Aleks on 20.04.2016.
 */
final class AuthManager {
    private SharedHelper sharedHelper;
    private DBbridge dBbridge;

    AuthManager (SharedHelper sharedHelper, DBbridge dBbridge) {
        this.sharedHelper = sharedHelper;
        this.dBbridge = dBbridge;
    }

    void registrationUser(BackendlessUser user, final MainCallback mainCallback) {

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            public void handleResponse(BackendlessUser registeredUser) {

                String login = registeredUser.getProperty("name").toString();
                String password = registeredUser.getPassword();
                logInUser(login, password, mainCallback);
            }

            public void handleFault(BackendlessFault fault) {
                mainCallback.onError(fault.getMessage());
                Log.d("registryUser", "fault = " + fault.getMessage());
            }
        });
    }

    void logInUser(final String login, final String password, final MainCallback callback) {

        Backendless.UserService.login(login, password, new AsyncCallback<BackendlessUser>() {
            public void handleResponse(BackendlessUser registeredUser) {

                sharedHelper.setLogin(registeredUser.getProperty("name").toString());
                sharedHelper.setPassword(password);
                callback.onSuccess();
            }

            public void handleFault(BackendlessFault fault) {
                callback.onError(fault.getMessage());
                Log.d("logInUser", "fault = " + fault.toString());
            }
        });
    }

    void autoLogin(MainCallback callback){
        String login = sharedHelper.getLogin();
        String password = sharedHelper.getUserPassword();

        if(TextUtils.isEmpty(login) || TextUtils.isEmpty(password)){
            callback.onError("Empty Login and/or passwd ");
            return;
        }

        logInUser(login, password, callback);
    }

    void userLogout(){
        Backendless.UserService.logout(new AsyncCallback<Void>() {
            @Override
            public void handleResponse(Void response) {
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("userLogout", "fault = " + fault.toString());
            }
        });
    }
}
