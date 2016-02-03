package com.erminesoft.my_account.myacount.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.erminesoft.my_account.myacount.R;
//import com.erminesoft.my_account.myacount.dialog.DialogNew;
import com.erminesoft.my_account.myacount.core.callback.SimpleMainCallback;
import com.erminesoft.my_account.myacount.db.DataBaseConnect;
import com.erminesoft.my_account.myacount.db.UsersData;
import com.erminesoft.my_account.myacount.ui.dialog.RegistrationDialog;


public class AuthActivity extends GenericActivity {

    private static final String SAVED_CONDITION = "saved";
    EditText password;
    EditText userName;
    CheckBox checkBox;
    UsersData usersData;
    DataBaseConnect dataBaseConnect;
    RegistrationDialog registrationDialog;
    private boolean saveCheckBox;
    final String LOG_TAG = "myLog";

    private String userNames;
    private String userPasswords;

    private SharedPreferences sPref;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorizatoin_layout);

        password = (EditText) findViewById(R.id.editText2);
        userName = (EditText) findViewById(R.id.editText);


        View.OnClickListener listener = new Clicker();

        findViewById(R.id.buttonSignIn).setOnClickListener(listener);
        findViewById(R.id.buttonSignUp).setOnClickListener(listener);


    }

    public void signIn() {
        application.getNetBridge().doLogin(password.getText().toString(), userName.getText().toString(), new NetListener());

    }

    public void signUp() {
        application.getNetBridge().doRegistration(password.getText().toString(), userName.getText().toString(), new NetListener());
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

    /*public void Shared(boolean saveCheckBox) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putBoolean(SAVED_CONDITION, saveCheckBox);
        ed.commit();
        // Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    public boolean loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        Boolean savedText = sPref.getBoolean(SAVED_CONDITION, saveCheckBox);
        checkBox.setChecked(saveCheckBox);
        // Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
        return savedText;
    }*/

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

 /*if (loadText()) {



            Intent intent = new Intent(AuthActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }*/


}