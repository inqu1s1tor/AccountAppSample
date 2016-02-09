package com.erminesoft.my_account.myacount.ui.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.erminesoft.my_account.myacount.R;

public class ContentForIncomeActivity extends GenericActivity {

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, ContentForIncomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_for_income_layout);
    }
}
