package com.erminesoft.my_account.myacount.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.adapters.ListAdapter;

public class Income extends AppCompatActivity {
    ListView incomeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income);
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

