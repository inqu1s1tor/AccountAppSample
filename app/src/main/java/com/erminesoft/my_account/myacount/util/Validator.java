package com.erminesoft.my_account.myacount.util;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Toast;

import com.erminesoft.my_account.myacount.R;

public final class Validator {

    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 8;

    public static String checkEmptyState(Editable userName, Editable userPassword, Resources resources) {

        if(TextUtils.isEmpty(userName)){
            return resources.getString(R.string.name_empty);
        }

        if(TextUtils.isEmpty(userPassword)){
            return resources.getString(R.string.password_empty);
        }

        return "";
    }

}
