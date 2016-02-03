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
public class MainActivity extends GenericActivity {

    private Button incomeButton;
    private Button costsButton;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

         View.OnClickListener listener = new Clicker();

        findViewById(R.id.buttonIncome).setOnClickListener(listener);
        findViewById(R.id.buttonCosts).setOnClickListener(listener);

        Bundle bundle = getIntent().getExtras();
    }

    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonIncome:
                   IncomeActivity.start(MainActivity.this);
                    break;
                case R.id.buttonCosts:
                    CostsActivity.start(MainActivity.this);
                    break;
            }

        }

    }

    /*@Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonIncome:
                Intent intentIncome = new Intent(this, IncomeActivity.class);
                startActivity(intentIncome);
                break;
            case R.id.buttonCosts:
                Intent intentCosts = new Intent(this, CostsActivity.class);
                startActivity(intentCosts);
                break;
        }

    }*/

}