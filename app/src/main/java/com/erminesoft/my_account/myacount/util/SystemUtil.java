package com.erminesoft.my_account.myacount.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Aleks on 20.04.2016.
 */
public final class SystemUtil {

    public static boolean isNetworkConnected(Context pContext) {

        ConnectivityManager connectivityManager = (ConnectivityManager) pContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if(activeNetwork != null) {
            return true;
        }else {
            return false;
        }

    }

}
