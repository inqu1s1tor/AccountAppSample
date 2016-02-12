package com.erminesoft.my_account.myacount.ui.activity.authorization;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.core.callback.SimpleMainCallback;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;
import com.erminesoft.my_account.myacount.ui.activity.MainActivity;


public class AuthActivity extends GenericActivity {

    private EditText password;
    private EditText userName;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, AuthActivity.class));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorizatoin_layout);

        userName = (EditText) findViewById(R.id.editTextLogin);
        password = (EditText) findViewById(R.id.editTextPassword);

        View.OnClickListener listener = new Clicker();

        findViewById(R.id.buttonSignIn).setOnClickListener(listener);
        findViewById(R.id.buttonSignUp).setOnClickListener(listener);
    }

    public void signIn() {
        application.getNetBridge().doLogin(password.getText().toString(),
                userName.getText().toString(), new NetListener());
    }

    public void signUp() {
        application.getNetBridge().doRegistration(password.getText().toString(),
                userName.getText().toString(), new NetListener());
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