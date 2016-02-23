package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.db.DataBaseHelper;
import com.erminesoft.my_account.myacount.ui.activity.costs.CostsActivity;
import com.erminesoft.my_account.myacount.ui.activity.incomes.IncomeActivity;


public  final class MainActivity extends GenericActivity {

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
        fillStartData();
    }

    private void fillStartData() {
        fillCost();
        fillIncome();
    }

    private void fillCost() {
        Cursor cursor = application.getdBbridge().calculateSumCosts();
        int sumCost = 0;
        if (cursor.moveToFirst()) {
            int sumIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_SUM);
            sumCost = cursor.getInt(sumIndex);
        }
        generalCostScore.setText(String.valueOf(sumCost));
    }

    private void fillIncome() {
        Cursor cursorIncome = application.getdBbridge().calulateSumIncome();
        int sumInc = 0;
        if (cursorIncome.moveToFirst()) {
            int sumIndex = cursorIncome.getColumnIndex(DataBaseHelper.INCOME_SUM);
            sumInc = cursorIncome.getInt(sumIndex);
        }
        generalIncomeScore.setText(String.valueOf(sumInc));
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