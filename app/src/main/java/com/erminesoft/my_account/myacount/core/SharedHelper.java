package com.erminesoft.my_account.myacount.core;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedHelper {

    private static final String NAME = "my_account";

    private static final String USER_LOGIN = "user_login";
    private static final String USER_PASSWORD = "user_password";

    private final SharedPreferences preferences;

    public SharedHelper(Context context) {
        preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    public void setLogin(String login) {
        preferences.edit().putString(USER_LOGIN, login).apply();
    }

    public void setPassword(String password) {
        preferences.edit().putString(USER_PASSWORD, password).apply();
    }

    public String getLogin() {
        return preferences.getString(USER_LOGIN, "");
    }

    public String getUserPassword() {
        return preferences.getString(USER_PASSWORD, "");
    }

    public void sharedHelperClear() {
        preferences.edit().clear().apply();
    }

}
