package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.erminesoft.my_account.myacount.core.AAplication;
import com.erminesoft.my_account.myacount.core.bridge.ActivityBridge;

public abstract class GenericActivity extends AppCompatActivity {

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

    protected void showSrotToast(int resId) {
        showSrotToast(getString(resId));
    }

    protected void showSrotToast(String contentString) {
        Toast.makeText(this, contentString, Toast.LENGTH_SHORT).show();
    }
}
