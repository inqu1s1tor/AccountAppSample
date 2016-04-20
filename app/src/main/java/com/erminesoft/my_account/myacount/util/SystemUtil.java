package com.erminesoft.my_account.myacount.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Aleks on 20.04.2016.
 */
public final class SystemUtil {

    public static boolean isNetworkConnected(Context pContext) {

        ConnectivityManager connectivityManager = (ConnectivityManager) pContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if(activeNetwork !=null) {
            Toast.makeText(pContext, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
            return true;
        }else {
            return false;
        }

        /*NetworkInfo wifi = connectivityManager.getActiveNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


        if (wifi == null && mobile == null && bluetooth == null
                && wimax == null) {
            return false;
        }

        if (wifi != null && wifi.isConnected()) {
            return true;
        }

        if (mobile != null && mobile.isConnected()) {
            return true;
        }
*/

//        return false;
    }

}
