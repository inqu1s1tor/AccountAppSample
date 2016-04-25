package com.erminesoft.my_account.myacount.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.adapters.CategoriesAdapter;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Aleks on 18.04.2016.
 */
public class CategoryCostsFragment extends GenericFragment {
    private EditText addingCategoryCosts;
    private ListView categoryCostsLv;
    private CategoriesAdapter costsCategoriesAdapter;
    private Observer observer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.category_costs_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.buttonAddingCategoryCosts).setOnClickListener(new Clicker());
        addingCategoryCosts = (EditText)view.findViewById(R.id.editTextCategoryAddingCosts);

        categoryCostsLv = (ListView) view.findViewById(R.id.costs_category_list_view);
        costsCategoriesAdapter = new CategoriesAdapter(getActivity(), mActivityBridge.getUApplication().getdBbridge().loadCostsCategories(), true);
        categoryCostsLv.setAdapter(costsCategoriesAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        observer = new DbObserver();
        mActivityBridge.getUApplication().getdBbridge().addNewObserver(observer);
    }

    @Override
    public void onStop() {
        super.onStop();

        mActivityBridge.getUApplication().getdBbridge().removeObserver(observer);
        observer = null;
    }

    private void saveCategoryCost() {
        String categoryEntered = addingCategoryCosts.getText().toString();
        mActivityBridge.getUApplication().getdBbridge().saveCategoriesCostsToDb(categoryEntered);
        addingCategoryCosts.setText("");
        fillCategoryAdapterForCosts();
    }

    private void fillCategoryAdapterForCosts() {
        costsCategoriesAdapter.swapCursor(mActivityBridge.getUApplication().getdBbridge().loadCostsCategories());
    }

    private final class DbObserver implements Observer {

        @Override
        public void update(Observable observable, Object data) {

        }
    }

    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAddingCategoryCosts:
                    saveCategoryCost();
            }
        }
    }
}
