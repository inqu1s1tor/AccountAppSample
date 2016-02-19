package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.adapters.CategoriesAdapterForCosts;
import com.erminesoft.my_account.myacount.ui.adapters.CategoriesAdapterForIncome;

public class CategoriesActivity extends GenericActivity {

    private EditText eddingCategory;
    private ListView listViewCategories;
    private CategoriesAdapterForCosts categoriesAdapter;
    private CategoriesAdapterForIncome categoriesAdapterForIncome;
    private RadioButton CostsCategoryRadioButton;
    private RadioGroup radioGroup;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, CategoriesActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);

        eddingCategory = (EditText)findViewById(R.id.editTextCategoryAdding);
        listViewCategories = (ListView)findViewById(R.id.listViewCategories);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.buttonAddingCategory).setOnClickListener(listener);

        CostsCategoryRadioButton = (RadioButton)findViewById(R.id.CostsCategoryRadioButton);
        CostsCategoryRadioButton.setOnClickListener(listener);
        radioGroup =(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.check(R.id.CostsCategoryRadioButton);

        findViewById(R.id.IncomeCategoryRadioButton).setOnClickListener(listener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        categoriesAdapter = new CategoriesAdapterForCosts(this, application.getdBbridge().loadCategories(), true);
        categoriesAdapterForIncome = new CategoriesAdapterForIncome(this, application.getdBbridge().loadCategories(),true);

        loadStartData();
    }

    private void startCategoryAdapterForCosts() {
        listViewCategories.setAdapter(categoriesAdapter);
    }

    private void startCategoryAdapterForIncome() {
        listViewCategories.setAdapter(categoriesAdapterForIncome);
    }

    private void loadStartData() {
            categoriesAdapter.swapCursor(application.getdBbridge().loadCategories());
    }

    private void saveCategoryCost(){
        String categoryEntered = eddingCategory.getText().toString();
        application.getdBbridge().saveCategoriesCostsToDb(categoryEntered);
        eddingCategory.setText("");

        loadStartData();
    }

    private void saveCategoryIncome() {
        String categoryIncomeEntered = eddingCategory.getText().toString();
        application.getdBbridge().saveCategoriesIncomeToDb(categoryIncomeEntered);
        eddingCategory.setText("");

        loadStartData();
    }

    private void switchRadioButtonCondition() {
        if (CostsCategoryRadioButton.isChecked()) {
            saveCategoryCost();
        }else {
            saveCategoryIncome();
        }
    }

    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAddingCategory:
                    switchRadioButtonCondition();
                    break;

                case R.id.CostsCategoryRadioButton:
                     startCategoryAdapterForCosts();
                    break;

                case R.id.IncomeCategoryRadioButton:
                    startCategoryAdapterForIncome();
                    break;
            }

        }
    }
}
