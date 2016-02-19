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
import com.erminesoft.my_account.myacount.ui.adapters.CategoriesAdapter;

public class CategoriesActivity extends GenericActivity {

    private EditText eddingCategory;
    private ListView listViewCategories;
    private CategoriesAdapter categoriesAdapter;
    private RadioGroup radioGroup;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, CategoriesActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);

        eddingCategory = (EditText) findViewById(R.id.editTextCategoryAdding);
        listViewCategories = (ListView) findViewById(R.id.listViewCategories);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.buttonAddingCategory).setOnClickListener(listener);

        radioGroup = (RadioGroup) findViewById(R.id.CategoryRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioListener());

        categoriesAdapter = new CategoriesAdapter(this, application.getdBbridge().loadCostsCategories(), true);
        listViewCategories.setAdapter(categoriesAdapter);

        radioGroup.check(R.id.CostsCategoryRadioButton);
    }

    private void fillCategoryAdapterForCosts() {
        categoriesAdapter.swapCursor(application.getdBbridge().loadCostsCategories());
    }

    private void fillCategoryAdapterForIncome() {
        categoriesAdapter.swapCursor(application.getdBbridge().loadIncomeCategories());
    }

    private void saveCategoryCost() {
        String categoryEntered = eddingCategory.getText().toString();
        application.getdBbridge().saveCategoriesCostsToDb(categoryEntered);
        eddingCategory.setText("");
        fillCategoryAdapterForCosts();
    }

    private void saveCategoryIncome() {
        String categoryIncomeEntered = eddingCategory.getText().toString();
        application.getdBbridge().saveCategoriesIncomeToDb(categoryIncomeEntered);
        eddingCategory.setText("");
        fillCategoryAdapterForIncome();
    }

    private void saveNewCategory() {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.CostsCategoryRadioButton:
                saveCategoryCost();
                break;

            case R.id.IncomeCategoryRadioButton:
                saveCategoryIncome();
                break;
        }
    }

    private final class RadioListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.CostsCategoryRadioButton:
                    fillCategoryAdapterForCosts();
                    break;

                case R.id.IncomeCategoryRadioButton:
                    fillCategoryAdapterForIncome();
                    break;
            }
        }
    }

    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAddingCategory:
                    saveNewCategory();
                    break;

            }

        }
    }
}