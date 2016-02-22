package com.erminesoft.my_account.myacount.ui.activity.incomes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;
import com.erminesoft.my_account.myacount.ui.adapters.IncomeAdapter;

public class IncomeActivity extends GenericActivity {


    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, IncomeActivity.class));
    }

    private ListView incomeList;
    private IncomeAdapter adapterIncome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income_layout);

        incomeList = (ListView)findViewById(R.id.listViewIncome);
        incomeList.setEmptyView(findViewById(R.id.empty_list_item_income));

        View.OnClickListener listener  = new Clicker();
        findViewById(R.id.fab).setOnClickListener(listener);

        adapterIncome = new IncomeAdapter(this, application.getdBbridge().loadIncome(), true);
        incomeList.setAdapter(adapterIncome);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadStartData();
    }

    private void loadStartData(){
        adapterIncome.swapCursor(application.getdBbridge().loadIncome());
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fab:
                    ContentForIncomeActivity.start(IncomeActivity.this);
                    break;
            }
        }
    }


}

