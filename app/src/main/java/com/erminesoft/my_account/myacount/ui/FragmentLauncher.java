package com.erminesoft.my_account.myacount.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.fragments.CategoryCostsFragment;
import com.erminesoft.my_account.myacount.ui.fragments.CategoryIncomesFragment;
import com.erminesoft.my_account.myacount.ui.fragments.GenericFragment;

/**
 * Created by Aleks on 18.04.2016.
 */
public final class FragmentLauncher {

    private final FragmentManager manager;

    public FragmentLauncher(FragmentManager manager) {
        this.manager = manager;
    }


    private void launch(GenericFragment fragment, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commitAllowingStateLoss();

    }

    public void launchCategoryCostsFragment() {
        GenericFragment categoryCostsFragment = new CategoryCostsFragment();
        launch(categoryCostsFragment, GenericFragment.COSTS_CATEGORY);
    }

    public void launchCategoryIncomesFragment() {
        GenericFragment categoryIncomesFragment = new CategoryIncomesFragment();
        launch(categoryIncomesFragment, GenericFragment.INCOMES_CATEGORY);
    }

}
