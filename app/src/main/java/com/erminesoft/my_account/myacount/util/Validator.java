package com.erminesoft.my_account.myacount.util;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;



public final class Validator {


    public static boolean validationFiels(String userName, String userPassword, TextInputLayout mLoginWrap,
                                          TextInputLayout mPasswordWrap) {

        if(TextUtils.isEmpty(userName)){
            mLoginWrap.setError("Empty login");
            return false;
        }

        if(TextUtils.isEmpty(userPassword)){
            mPasswordWrap.setError("Empty password");
            return false;
        }

        mLoginWrap.setErrorEnabled(false);
        mPasswordWrap.setErrorEnabled(false);

        return true;
    }


}
