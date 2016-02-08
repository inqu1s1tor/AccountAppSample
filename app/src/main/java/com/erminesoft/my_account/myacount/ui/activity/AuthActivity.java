package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.core.callback.SimpleMainCallback;
import com.erminesoft.my_account.myacount.db.UsersData;
import com.erminesoft.my_account.myacount.ui.dialog.RegistrationDialog;


public class AuthActivity extends GenericActivity {

    private static final String SAVED_CONDITION = "saved";
    private EditText password;
    private EditText userName;
    private UsersData usersData;
    private RegistrationDialog registrationDialog;
    final String LOG_TAG = "myLog";
    private String userNames;
    private String userPasswords;
    private SharedPreferences sPref;

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

    private final class NetListener extends SimpleMainCallback {
        @Override
        public void onSuccess() {
            Log.d("AA", "result success");
            MainActivity.start(AuthActivity.this);
            finish();
        }

        @Override
        public void onError(String error) {
        }
    }

    /*public boolean usersNotInDBWrite(int numberButton) {
        if (check(numberButton).equals(ENTER) && numberButton == 1) {
            return true;
        }
        return false;
    }*/

   /* public boolean usersNotInDBEnter(int numberButton) {
        if (check(numberButton).equals(REGISTRATION_ACTIVETED) && numberButton == 0) {
            registrationDialog = new RegistrationDialog();
            registrationDialog.show(getFragmentManager(), "Dialog show");
            return true;
        }
        return false;
    }


   /* public void write(int numberButton) {
        if (usersNotInDBWrite(numberButton)) {
            Toast.makeText(this, R.string.user_is, Toast.LENGTH_SHORT).show();
            return;
        }
        userNames = userName.getText().toString();
        userPasswords = password.getText().toString();
        dataBaseConnect = new DataBaseConnect(this);
        usersData = new UsersData();
        usersData.setUserLogin(userNames);
        usersData.setUserPassword(userPasswords);
        dataBaseConnect.getUsersRepository().save(usersData);
        Toast.makeText(this, R.string.finish_registration, Toast.LENGTH_SHORT).show();


    }*/

}