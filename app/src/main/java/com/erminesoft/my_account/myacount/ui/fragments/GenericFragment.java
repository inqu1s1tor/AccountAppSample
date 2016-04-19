package com.erminesoft.my_account.myacount.ui.fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.erminesoft.my_account.myacount.core.bridge.ActivityBridge;

/**
 * Created by Aleks on 18.04.2016.
 */
public abstract class GenericFragment extends android.support.v4.app.Fragment {

    protected ActivityBridge mActivityBridge;
    private ProgressDialog progressDialog;

    public static final String COSTS_CATEGORY = "costs";
    public static final String INCOMES_CATEGORY = "incomes";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBridge = (ActivityBridge) getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    protected void showShortToast(int resId) {
        showShortToast(getString(resId));
    }

    protected void showShortToast(String contentString) {
        Toast.makeText(getActivity(), contentString, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(String contentString) {
        Toast.makeText(getActivity(), contentString, Toast.LENGTH_LONG).show();
    }

    protected void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Loading....");
        }

        progressDialog.show();
    }


    protected void hideProgressDialog() {

        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }


}


