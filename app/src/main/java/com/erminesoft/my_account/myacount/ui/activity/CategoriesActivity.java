package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.core.AAplication;
import com.erminesoft.my_account.myacount.core.bridge.ActivityBridge;
import com.erminesoft.my_account.myacount.ui.FragmentLauncher;
import com.erminesoft.my_account.myacount.ui.adapters.CategoriesAdapter;
import com.erminesoft.my_account.myacount.ui.fragments.CategoryCostsFragment;
import com.erminesoft.my_account.myacount.ui.fragments.CategoryIncomesFragment;
import com.erminesoft.my_account.myacount.ui.fragments.GenericFragment;

public class CategoriesActivity extends GenericActivity implements ActivityBridge  {
    private TabLayout mTabLayout;
    private FragmentLauncher fragmentLauncher;
    private AAplication application;

    public static final String COSTS_CATEGORY = "Costs";
    public static final String INCOMES_CATEGORY = "Incomes";


    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, CategoriesActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);

        fragmentLauncher = new FragmentLauncher(getSupportFragmentManager());

        application = (AAplication)getApplication();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabLayout = (TabLayout) findViewById(R.id.tab_container);
        initTabs();

        mTabLayout.setOnTabSelectedListener(new OnTabSelectedListener());

    }


    private void initTabs() {
        String[] tab_names = getResources().getStringArray(R.array.tabs_name);

        TabLayout.Tab tab;
        for (String name : tab_names) {
            tab = mTabLayout.newTab();

            tab.setText(name);
            boolean setSelected = false;

            if (name.equals("Costs")) {
                setSelected = true;
                fragmentLauncher.launchCategoryCostsFragment();
            }

            mTabLayout.addTab(tab, setSelected);
        }
    }

    @Override
    public AAplication getUApplication() {
        return application;
    }

    @Override
    public FragmentLauncher getFragmentLauncher() {
        return fragmentLauncher;
    }


    private final class OnTabSelectedListener implements TabLayout.OnTabSelectedListener {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Log.d("Mylog", "position " + tab.getText());

            switch (tab.getText().toString()) {
                case COSTS_CATEGORY:
                    fragmentLauncher.launchCategoryCostsFragment();
                    break;

                case INCOMES_CATEGORY:
                    fragmentLauncher.launchCategoryIncomesFragment();
                    break;

            }

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }


    }

}

