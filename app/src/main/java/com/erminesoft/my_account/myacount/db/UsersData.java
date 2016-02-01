package com.erminesoft.my_account.myacount.db;

import java.util.ArrayList;

public class UsersData {

    private String UserLogin;
    private String UserPassword;
    private ArrayList<String> UsersLogins = new ArrayList<>();
    private ArrayList<String> UsersPasswords = new ArrayList<>();

    public ArrayList<String> getUsersLogins() {
        return UsersLogins;
    }

    public ArrayList<String> getUsersPasswords() {
        return UsersPasswords;
    }


    public String getUserLogin() {
        return UserLogin;
    }

    public void setUserLogin(String userLogin) {
        this.UserLogin = userLogin;
        UsersLogins.add(UserLogin);
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        this.UserPassword = userPassword;
        UsersPasswords.add(UserPassword);
    }
}