package com.erminesoft.my_account.myacount.ui;

import android.app.Activity;
import android.os.Bundle;

import com.erminesoft.my_account.myacount.core.AAplication;

public abstract class GenericActivity extends Activity {

    protected AAplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = (AAplication) getApplication();
    }
}
