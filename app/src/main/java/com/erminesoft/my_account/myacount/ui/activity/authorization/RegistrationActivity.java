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
import com.erminesoft.my_account.myacount.ui.FragmentLauncher;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;
import com.erminesoft.my_account.myacount.ui.activity.MainActivity;
import com.erminesoft.my_account.myacount.util.Validator;

/**
 * Created by Aleks on 20.04.2016.
 */
public class RegistrationActivity extends GenericActivity {
    private TextInputLayout mLoginWrap;
    private TextInputLayout mPasswordWrap;

    private EditText signInloginEt;
    private FragmentLauncher fragmentLauncher = new FragmentLauncher(getSupportFragmentManager());

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, RegistrationActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);

        mLoginWrap = (TextInputLayout) findViewById(R.id.registration_login_wrap);
        mPasswordWrap = (TextInputLayout) findViewById(R.id.registration_password_wrap);

        findViewById(R.id.buttonSignUp).setOnClickListener(new Clicker());
    }


    public void buttonSignUpPressed() {

        String userLoginEntered = String.valueOf(mLoginWrap.getEditText().getText());
        String userPasswordEntered = String.valueOf(mPasswordWrap.getEditText().getText());

        if (Validator.validationFiels(userLoginEntered, userPasswordEntered, mLoginWrap, mPasswordWrap)) {
            showProgressDialog();
            application.getNetBridge().registrationUser(userLoginEntered, userPasswordEntered, new NetListener());
        }else {
            showShortToast("Invalid data");
        }

    }

    public void buttonLoginPressed() {



    }


    private final class NetListener extends SimpleMainCallback {
        @Override
        public void onSuccess() {
            Log.d("MyLog", "Success registration");
            dismissProgressDialog();
            MainActivity.start(RegistrationActivity.this);
            finish();
        }

        @Override
        public void onError(String error) {
            Log.d("Mylog", "error registration");
            dismissProgressDialog();
            showShortToast(getString(R.string.registration_failed_error));
        }
    }


    private final class Clicker implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonSignUp:
                    buttonSignUpPressed();
                    break;
                case R.id.buttonTransferSignUp:
                    buttonLoginPressed();
                    break;
            }
        }
    }
}



