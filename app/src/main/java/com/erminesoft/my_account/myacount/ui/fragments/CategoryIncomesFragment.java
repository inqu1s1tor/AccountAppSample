package com.erminesoft.my_account.myacount.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.adapters.CategoriesAdapter;

/**
 * Created by Aleks on 18.04.2016.
 */
public class CategoryIncomesFragment extends GenericFragment {
    private EditText addingCategoryIncome;
    private ListView categoryIncomeLv;
    private CategoriesAdapter incomeCategoriesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.category_incomes_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categoryIncomeLv = (ListView) view.findViewById(R.id.incomes_category_list_view);
        view.findViewById(R.id.buttonAddingCategoryIncome).setOnClickListener(new Clicker());

        addingCategoryIncome = (EditText)view.findViewById(R.id.editTextCategoryAddingIncome);
        incomeCategoriesAdapter = new CategoriesAdapter(getActivity(), mActivityBridge.getUApplication().getdBbridge().loadIncomeCategories(), true);
        categoryIncomeLv.setAdapter(incomeCategoriesAdapter);
    }

    private void saveCategoryIncome() {
        String categoryIncomeEntered = addingCategoryIncome.getText().toString();
        mActivityBridge.getUApplication().getdBbridge().saveCategoriesIncomeToDb(categoryIncomeEntered);
        addingCategoryIncome.setText("");
        fillCategoryAdapterForIncome();
    }

    private void fillCategoryAdapterForIncome() {
        incomeCategoriesAdapter.swapCursor(mActivityBridge.getUApplication().getdBbridge().loadIncomeCategories());
    }

    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAddingCategoryIncome:
                    saveCategoryIncome();
            }
        }
    }
}
