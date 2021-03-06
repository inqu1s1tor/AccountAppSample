package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.core.callback.SimpleMainCallback;
import com.erminesoft.my_account.myacount.db.DataBaseHelper;
import com.erminesoft.my_account.myacount.net.SyncService;
import com.erminesoft.my_account.myacount.ui.activity.authorization.AuthActivity;
import com.erminesoft.my_account.myacount.ui.activity.costs.CostsActivity;
import com.erminesoft.my_account.myacount.ui.activity.incomes.IncomeActivity;

import java.util.List;


public  final class MainActivity extends GenericActivity {

    private TextView generalCostScore;
    private TextView generalIncomeScore;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        generalCostScore = (TextView) findViewById(R.id.generalSumCostTextView);
        generalIncomeScore = (TextView) findViewById(R.id.genralSumIncomeTextView);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.buttonIncome).setOnClickListener(listener);
        findViewById(R.id.buttonCosts).setOnClickListener(listener);
        findViewById(R.id.buttonCategories).setOnClickListener(listener);

        application.getNetBridge().autoLogin(new NetCallback());

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

    private void logOut(){
        application.getSharedHelper().sharedHelperClear();
        application.getdBbridge().clearAllData();
        application.getNetBridge().userLogout();
        AuthActivity.start(MainActivity.this);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_settings_menu, menu);
        return true;
    }

    private final class NetCallback extends SimpleMainCallback {
        @Override
        public void onSuccess() {
            Log.d("MyLog", "autoLogin success");
            super.onSuccess();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sync:
                application.getNetBridge().getAllCosts(new NetListener());
                application.getNetBridge().getAllIncomes(new NetListener());
                application.getNetBridge().getAllCategories(new NetListener());
                SyncService.start(MainActivity.this);
                break;

            case R.id.action_log_out:
                logOut();
                break;

        }
        return super.onOptionsItemSelected(item);
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

    private final class NetListener extends SimpleMainCallback {
        @Override
        public void onSuccess() {
            Log.d("", "" );
        }
    }
}