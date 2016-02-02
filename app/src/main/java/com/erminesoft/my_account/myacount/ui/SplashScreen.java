package com.erminesoft.my_account.myacount.ui;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.core.SharedHelper;
import com.erminesoft.my_account.myacount.core.callback.SimpleMainCallback;

public class SplashScreen extends GenericActivity {

    private final int WORK_TIME = 5000;
    private Handler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        myHandler = new Handler();
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                moveToNextScreen();
            }
        }, WORK_TIME);

        application.getSharedHelper().
    }

    private void moveToNextScreen() {

        SharedHelper sharedHelper = application.getSharedHelper();
        String login = sharedHelper.getLogin();
        String password = sharedHelper.getUserPassword();

        if (TextUtils.isEmpty(login)) {
            //Move to registration activity
        } else {
            application.getNetBridge().doLogin(login, password, new NetListener());
            //show progress dialog
        }
    }

    private final class NetListener extends SimpleMainCallback {
        @Override
        public void onSuccess() {
            // dismiss progress dialog
            // move to next screen (main)
        }

        @Override
        public void onError(String error) {

        }
    }
}