package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.db.DataBaseHelper;
import com.erminesoft.my_account.myacount.ui.activity.costs.CostsActivity;
import com.erminesoft.my_account.myacount.ui.activity.incomes.IncomeActivity;


public class MainActivity extends GenericActivity {

    private TextView generalCostScore;
    private TextView generalIncomeScore;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        generalCostScore = (TextView) findViewById(R.id.generalSumCostTextView);
        generalIncomeScore = (TextView) findViewById(R.id.genralSumIncomeTextView);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.buttonIncome).setOnClickListener(listener);
        findViewById(R.id.buttonCosts).setOnClickListener(listener);
        findViewById(R.id.buttonCategories).setOnClickListener(listener);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Cursor cursor = application.getdBbridge().calculateSumCosts();
        int sum = 0;
        if (cursor.moveToFirst()) {
            int sumIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_SUM);
            sum = cursor.getInt(sumIndex);
        }
        generalCostScore.setText(String.valueOf(sum));
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
                case R.id.buttonCategories:
                    CategoriesActivity.start(MainActivity.this);
                    break;
            }
        }
    }

}