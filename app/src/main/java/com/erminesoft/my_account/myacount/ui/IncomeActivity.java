package com.erminesoft.my_account.myacount.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.adapters.IncomeAdapter;

public class IncomeActivity extends GenericActivity {
    private ListView incomeList;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, IncomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income_layout);
        incomeList = (ListView)findViewById(R.id.listViewIncome);




        loadStartData();
            }

    private void loadStartData(){
        Cursor cursor = application.getdBbridge().loadIncome();
        IncomeAdapter adapter = new IncomeAdapter(this, cursor, true);
    }


    }

