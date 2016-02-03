package com.erminesoft.my_account.myacount.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.erminesoft.my_account.myacount.R;

public class CostsActivity extends GenericActivity {

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, CostsActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costs_layout);
    }
}
