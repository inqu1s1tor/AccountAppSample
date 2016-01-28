package com.erminesoft.my_account.myacount.ui;

import android.app.Activity;
import android.content.Context;

import com.erminesoft.my_account.myacount.ui.dialog.CustomDialog;

public class DialogLauncher {


    public static void launchConfirmDialog(Activity activity){
        CustomDialog dialog = new CustomDialog(activity);
        dialog.show();
    }



}
