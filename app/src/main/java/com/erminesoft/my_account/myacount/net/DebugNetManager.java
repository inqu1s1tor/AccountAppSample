package com.erminesoft.my_account.myacount.net;

import android.os.Handler;

import com.erminesoft.my_account.myacount.core.SharedHelper;
import com.erminesoft.my_account.myacount.core.callback.MainCallback;

final class DebugNetManager {

    private final SharedHelper sharedHelper;

    DebugNetManager(SharedHelper sharedHelper) {
        this.sharedHelper = sharedHelper;
    }

    void doLogin(final String login, final String password, final MainCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedHelper.setLogin(login);
                sharedHelper.setPassword(password);
                callback.onSuccess();
            }
        }, 3000L);
    }
}
