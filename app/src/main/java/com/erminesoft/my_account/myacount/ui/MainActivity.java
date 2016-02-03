package com.erminesoft.my_account.myacount.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.erminesoft.my_account.myacount.R;

/**
 * The class for choice functionality.
 */
public class MainActivity extends GenericActivity implements View.OnClickListener {

    private Button incomeButton;
    private Button costsButton;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        incomeButton = (Button) findViewById(R.id.button2);
        costsButton = (Button) findViewById(R.id.button5);
        incomeButton.setOnClickListener(this);
        costsButton.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button2:
                Intent intentIncome = new Intent(this, IncomeActivity.class);
                startActivity(intentIncome);
                break;
            case R.id.button5:
                Intent intentCosts = new Intent(this, CostsActivity.class);
                startActivity(intentCosts);
                break;
        }

    }

}