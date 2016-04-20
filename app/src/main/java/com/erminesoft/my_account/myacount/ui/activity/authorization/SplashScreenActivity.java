package com.erminesoft.my_account.myacount.ui.activity.authorization;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.core.SharedHelper;
import com.erminesoft.my_account.myacount.core.callback.SimpleMainCallback;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;

public class SplashScreenActivity extends GenericActivity {

    private static final int WORK_TIME = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                moveToNextScreen();
            }
        }, WORK_TIME);
    }

    private void moveToNextScreen() {

        SharedHelper sharedHelper = application.getSharedHelper();
        String login = sharedHelper.getLogin();

        if (TextUtils.isEmpty(login)) {
            AuthActivity.start(SplashScreenActivity.this);
            finish();
        } else {
            String password = sharedHelper.getUserPassword();
            application.getNetBridge().logInUser(login, password, new NetListener());
            showProgressDialog();
        }
    }

    private final class NetListener extends SimpleMainCallback {
        @Override
        public void onSuccess() {
            AuthActivity.start(SplashScreenActivity.this);
            finish();
            dismissProgressDialog();
        }

        @Override
        public void onError(String error) {
            dismissProgressDialog();
            showSrotToast(error);
        }
    }
}