package com.erminesoft.my_account.myacount.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.adapters.ListAdapter;

public class IncomeActivity extends GenericActivity {
    private ListView incomeList;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, IncomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income_layout);
        incomeList = (ListView)findViewById(R.id.listView);
        getListView();
    }

    public void getListView(){
        String [] strings = new String[]{"Hello","World",
                "A","B","C"};
        ListAdapter listAdapter = new ListAdapter(this, strings);
        incomeList.setAdapter(listAdapter);
    }
    }

