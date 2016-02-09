package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
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

        Clicker listener  = new Clicker();
        findViewById(R.id.fab).setOnClickListener(listener);
    }

    private void loadStartData(){
        Cursor cursor = application.getdBbridge().loadIncome();
        IncomeAdapter adapter = new IncomeAdapter(this, cursor, true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String name = data.getStringExtra("name");
        String category  = data.getStringExtra("category");
        application.getdBbridge().saveIncomeToDb(name, category);
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fab:
                    Intent intent = new Intent(IncomeActivity.this, ChoiceContentActivity.class);
                    startActivityForResult(intent, 2);
            }
        }
    }


}

