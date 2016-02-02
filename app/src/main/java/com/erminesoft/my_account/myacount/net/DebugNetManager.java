package com.erminesoft.my_account.myacount.net;

import android.os.Handler;

import com.erminesoft.my_account.myacount.core.callback.MainCallback;

final class DebugNetManager {

    void doLogin(String login, String password, final MainCallback callback){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess();
            }
        }, 3000L);
    }

}
