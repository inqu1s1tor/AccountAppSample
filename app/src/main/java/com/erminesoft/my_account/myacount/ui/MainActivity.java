package com.erminesoft.my_account.myacount.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.erminesoft.my_account.myacount.R;
//import com.erminesoft.my_account.myacount.dialog.DialogNew;
import com.erminesoft.my_account.myacount.db.DataBaseConnect;
import com.erminesoft.my_account.myacount.db.UsersData;
import com.erminesoft.my_account.myacount.ui.dialog.RegistrationDialog;


public class MainActivity extends GenericActivity {

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


    private final String WRONG_LOGIN = "Login false";
    private final String WRONG_PASSWORD = "password false";
    private final String ENTER = "enter";
    private final String REGISTRATION_ACTIVETED = "stopRegistration";
    private final String REGISTRATION_STARTED = "startRegistration";

    private SharedPreferences sPref;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form);



        password = (EditText) findViewById(R.id.editText2);
        userName = (EditText) findViewById(R.id.editText);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCheckBox = true;
                Shared(saveCheckBox);
            }

        });

        if (loadText()) {

            Intent intent = new Intent(MainActivity.this, MenuForChoiceTask.class);
            startActivity(intent);
            finish();
            return;
        }

        View.OnClickListener listener = new Clicker();

        findViewById(R.id.button3).setOnClickListener(listener);
        findViewById(R.id.button).setOnClickListener(listener);



//            @Override
//            public void onClick(View v) {
//                Log.d(LOG_TAG, "methodStart");
//                String state = Validator.checkEmptyState(userName.getText(), password.getText(), getResources());
//                if (TextUtils.isEmpty(state)) {
//                    usersNotInDBEnter(0);
//                } else {
//                    Toast.makeText(MainActivity.this, state, Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });


//                new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String state = Validator.checkEmptyState(userName.getText(), password.getText(), getResources());
//                if (TextUtils.isEmpty(state)) {
//                    write(1);
//                } else {
//                    Toast.makeText(MainActivity.this, state, Toast.LENGTH_SHORT).show();
//                }
//            }
//
//        });
    }



    public void Shared(boolean saveCheckBox) {
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
    }


    public String check(int numberButton) {
        userNames = userName.getText().toString();
        userPasswords = password.getText().toString();
        dataBaseConnect = new DataBaseConnect(this);
        usersData = new UsersData();
        dataBaseConnect.getUsersRepository().unloadingDataBase(usersData);

        Log.d(LOG_TAG, "  " + usersData.getUsersLogins().size());

        if (usersData.getUsersLogins().size() == 0) {
            Log.d(LOG_TAG, "Array");
            Log.d(LOG_TAG, "registration");
            return REGISTRATION_ACTIVETED;
        }
        int i;
        for (i = 0; i < usersData.getUsersLogins().size(); i++) {
            String userName = usersData.getUsersLogins().get(i);
            String userPassword = usersData.getUsersPasswords().get(i);
            Log.d(LOG_TAG, " 333 " + userName);
            Log.d(LOG_TAG, " 333 " + userNames);
            Log.d(LOG_TAG, " 333 " + userPasswords);
            Log.d(LOG_TAG, " 333 " + userName.equals(userNames));
            Log.d(LOG_TAG, " 333 " + userPasswords.equals(userPassword));
            Log.d(LOG_TAG, " 333 " + numberButton);
            if (userName.equals(userNames) == false && userPassword.equals(userPasswords) == true) {
                Log.d(LOG_TAG, "Login false");
                Toast.makeText(this, R.string.wrong_login, Toast.LENGTH_SHORT).show();
                return WRONG_LOGIN;

            } else if (userName.equals(userNames) == true && userPasswords.equals(userPassword) == false
                    && numberButton == 0) {
                Toast.makeText(this, R.string.wrong_password, Toast.LENGTH_SHORT).show();
                return WRONG_PASSWORD;
            } else if (userName.equals(userNames) == true && userPasswords.equals(userPassword) == false
                    && numberButton == 1) {
                Toast.makeText(this, R.string.login_is, Toast.LENGTH_SHORT).show();
                return ENTER;
            } else if (userNames.equals(userName) == true && userPasswords.equals(userPassword) == true
                    && numberButton == 0) {
                Log.d(LOG_TAG, "enter");
                Intent intent = new Intent(MainActivity.this, MenuForChoiceTask.class);
                startActivity(intent);
                finish();
                return ENTER;
            } else if (userNames.equals(userName) == true && userPasswords.equals(userPassword) == true
                    && numberButton == 1) {
                return ENTER;
            }


        }
        return REGISTRATION_ACTIVETED;

    }

    public void write(int numberButton) {
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


    }

    public boolean usersNotInDBWrite(int numberButton) {
        if (check(numberButton).equals(ENTER) && numberButton == 1) {
            return true;
        }
        return false;
    }

    public boolean usersNotInDBEnter(int numberButton) {
        if (check(numberButton).equals(REGISTRATION_ACTIVETED) && numberButton == 0) {
            registrationDialog = new RegistrationDialog();
            registrationDialog.show(getFragmentManager(), "Dialog show");
            return true;
        }
        return false;
    }

    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

            }

        }
    }

}