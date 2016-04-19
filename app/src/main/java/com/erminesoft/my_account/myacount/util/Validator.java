package com.erminesoft.my_account.myacount.util;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;

import com.erminesoft.my_account.myacount.R;


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
