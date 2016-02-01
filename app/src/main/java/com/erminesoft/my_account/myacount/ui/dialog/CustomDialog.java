package com.erminesoft.my_account.myacount.ui.dialog;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by remi on 28.01.16.
 */
public class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

}
