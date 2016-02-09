package com.erminesoft.my_account.myacount.ui.activity.incomes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;
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

        View.OnClickListener listener  = new Clicker();
        findViewById(R.id.fab).setOnClickListener(listener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadStartData();
    }

    private void loadStartData(){
        Cursor cursor = application.getdBbridge().loadIncome();
        IncomeAdapter adapterIncome = new IncomeAdapter(this, cursor, true);
        incomeList.setAdapter(adapterIncome);
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

