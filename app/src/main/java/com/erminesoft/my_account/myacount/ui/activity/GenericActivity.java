package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.erminesoft.my_account.myacount.core.AAplication;

public abstract class GenericActivity extends Activity {

    protected AAplication application;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = (AAplication) getApplication();
    }

    protected void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);

        }

        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    protected void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    protected void showShortToast(int resId) {
        showShortToast(getString(resId));
    }

    protected void showShortToast(String contentString) {
        Toast.makeText(this, contentString, Toast.LENGTH_SHORT).show();
    }
}
