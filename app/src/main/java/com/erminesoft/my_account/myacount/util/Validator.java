package com.erminesoft.my_account.myacount.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;

import com.erminesoft.my_account.myacount.R;


public final class Validator {

    private final String WRONG_LOGIN = "Login false";
    private final String WRONG_PASSWORD = "password false";
    private final String ENTER = "enter";
    private final String REGISTRATION_ACTIVETED = "stopRegistration";
    private final String REGISTRATION_STARTED = "startRegistration";

    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 8;
    private Context context;


    final String LOG_TAG = "myLog";


    public static String checkEmptyState(Editable userName, Editable userPassword, Resources resources) {

        if(TextUtils.isEmpty(userName)){
            return resources.getString(R.string.name_empty);
        }

        if(TextUtils.isEmpty(userPassword)){
            return resources.getString(R.string.password_empty);
        }

        return "";
    }

    /*public  String check(numberButton) {
        userNames = userName.getText().toString();
        userPasswords = password.getText().toString();
        DataBaseConnect dataBaseConnect = new DataBaseConnect(context);
        UsersData usersData = new UsersData();
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
                Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return ENTER;
            } else if (userNames.equals(userName) == true && userPasswords.equals(userPassword) == true
                    && numberButton == 1) {
                return ENTER;
            }


        }
        return REGISTRATION_ACTIVETED;

    }*/

}
