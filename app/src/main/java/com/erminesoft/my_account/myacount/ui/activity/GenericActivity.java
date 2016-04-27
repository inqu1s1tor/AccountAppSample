package com.erminesoft.my_account.myacount.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onHomeButtonPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onHomeButtonPressed() {
        finish();
    }

    protected final void setHomeAsUpEnabled(boolean enabled) {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(enabled);
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
