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


public class MainActivity extends GenericActivity {

    private TextView generalCostScore;
    private TextView generalIncomeScore;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        generalCostScore = (TextView)findViewById(R.id.generalSumCostTextView);
        generalIncomeScore = (TextView)findViewById(R.id.genralSumIncomeTextView);

         View.OnClickListener listener = new Clicker();
        findViewById(R.id.buttonIncome).setOnClickListener(listener);
        findViewById(R.id.buttonCosts).setOnClickListener(listener);
        findViewById(R.id.buttonCategories).setOnClickListener(listener);

        Cursor cursor = application.getdBbridge().calculateSumCosts();
        cursor.moveToFirst();
        int b = cursor.getInt(1);
        String general = String.valueOf(b);
        generalCostScore.setText(general);

        if(cursor.moveToFirst()) {
             cursor.getInt(0);
        }
/*
        int ss = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COSTS_SUM));

        String general = String.valueOf(ss);
        generalCostScore.setText(general);
    */
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