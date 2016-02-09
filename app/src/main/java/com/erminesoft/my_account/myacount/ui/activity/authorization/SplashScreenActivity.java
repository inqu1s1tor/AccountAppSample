package com.erminesoft.my_account.myacount.ui.activity.authorization;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.core.SharedHelper;
import com.erminesoft.my_account.myacount.core.callback.SimpleMainCallback;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;

public class SplashScreenActivity extends GenericActivity {

    private final int workTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                moveToNextScreen();
            }
        }, workTime);
    }

    private void moveToNextScreen() {

        SharedHelper sharedHelper = application.getSharedHelper();
        String login = sharedHelper.getLogin();
        String password = sharedHelper.getUserPassword();
        if (TextUtils.isEmpty(login)) {
            AuthActivity.start(SplashScreenActivity.this);
            finish();
        } else {
            application.getNetBridge().doLogin(login, password, new NetListener());
            //show progress dialog
        }
    }

    private final class NetListener extends SimpleMainCallback {
        @Override
        public void onSuccess() {
            AuthActivity.start(SplashScreenActivity.this);
            finish();
            // dismiss progress dialog
            // move to next screen (main)
        }

        @Override
        public void onError(String error) {

        }
    }
}