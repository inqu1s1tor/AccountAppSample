package com.erminesoft.my_account.myacount.ui.activity.incomes;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.db.DataBaseHelper;
import com.erminesoft.my_account.myacount.ui.activity.CategoriesActivity;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;
import com.erminesoft.my_account.myacount.ui.adapters.CategorySpinnerAdapter;

public class ContentForIncomeActivity extends GenericActivity {



    private EditText editTextNameIncome;
    private Spinner spinnerIncome;
    private CategorySpinnerAdapter incomeSpinnerAdapter;


    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, ContentForIncomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_for_income_layout);

        editTextNameIncome = (EditText)findViewById(R.id.EditTextNameIncome);
        spinnerIncome = (Spinner)findViewById(R.id.spinnerIncome);

        incomeSpinnerAdapter = new CategorySpinnerAdapter(this, application.getdBbridge().loadIncomeCategories(), true);
        spinnerIncome.setAdapter(incomeSpinnerAdapter);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.ButtonConfirmChoiceIncome).setOnClickListener(listener);
        findViewById(R.id.transferToCategoryFromIncome).setOnClickListener(listener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        incomeSpinnerAdapter.swapCursor(application.getdBbridge().loadIncomeCategories());

    }

    private void extractCategory (Cursor cursor) {
        String categoryEnteredIncome = editTextNameIncome.getText().toString();

        int categoryIdIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_ID);
        int categoryId = cursor.getInt(categoryIdIndex);

        application.getdBbridge().saveIncomeToDb(categoryId, categoryEnteredIncome);
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ButtonConfirmChoiceIncome:
                    extractCategory((Cursor)spinnerIncome.getSelectedItem());
                    finish();
                    break;
                case R.id.transferToCategoryFromIncome:
                    CategoriesActivity.start(ContentForIncomeActivity.this);
                    break;
            }
        }
    }
}
