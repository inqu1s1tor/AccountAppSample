package com.erminesoft.my_account.myacount.ui.activity.authorization;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.core.callback.SimpleMainCallback;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;
import com.erminesoft.my_account.myacount.ui.activity.MainActivity;
import com.erminesoft.my_account.myacount.util.Validator;


public class AuthActivity extends GenericActivity {

    private EditText password;
    private EditText userName;
    private TextInputLayout mLoginWrap;
    private TextInputLayout mPasswordWrap;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, AuthActivity.class));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorizatoin_layout);

        userName = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);

        mLoginWrap = (TextInputLayout) findViewById(R.id.login_wrap);
        mPasswordWrap = (TextInputLayout) findViewById(R.id.password_wrap);

        View.OnClickListener listener = new Clicker();

        findViewById(R.id.buttonSignIn).setOnClickListener(listener);
        findViewById(R.id.buttonSignUp).setOnClickListener(listener);
    }

    public void signIn() {
        String userLoginEntered = String.valueOf(userName.getText());
        String userPasswordEntered = String.valueOf(password.getText());
        if(Validator.validationFiels(userLoginEntered, userPasswordEntered, mLoginWrap, mPasswordWrap)){
            application.getNetBridge().doLogin(userLoginEntered,
                    userPasswordEntered, new NetListener());
        }

    }

    public void signUp() {
        String userLoginEntered = String.valueOf(userName.getText());
        String userPasswordEntered = String.valueOf(password.getText());
        if (Validator.validationFiels(userLoginEntered, userPasswordEntered,mLoginWrap, mPasswordWrap)){
            application.getNetBridge().doRegistration(userLoginEntered,
                    userPasswordEntered, new NetListener());
        }

    }

    private final class NetListener extends SimpleMainCallback {
        @Override
        public void onSuccess() {
            MainActivity.start(AuthActivity.this);
            finish();
        }

        @Override
        public void onError(String error) {
        }
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonSignIn:
                    signIn();
                    break;
                case R.id.buttonSignUp:
                    signUp();
                    break;
            }
        }
    }



}