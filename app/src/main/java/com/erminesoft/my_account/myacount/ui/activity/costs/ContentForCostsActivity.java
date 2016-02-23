package com.erminesoft.my_account.myacount.ui.activity.costs;

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



public final class ContentForCostsActivity extends GenericActivity {

    private Spinner spinnerCosts;
    private EditText editTextName;
    private EditText sumCost;
    private CategorySpinnerAdapter categorySpinnerAdapter;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, ContentForCostsActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_for_costs_layout);

        editTextName = (EditText) findViewById(R.id.EditTextNameCosts);
        sumCost = (EditText) findViewById(R.id.EditTextSumCosts);

        spinnerCosts = (Spinner) findViewById(R.id.spinner);
        categorySpinnerAdapter = new CategorySpinnerAdapter(this, application.getdBbridge().loadCostsCategories(), true);
        spinnerCosts.setAdapter(categorySpinnerAdapter);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.ButtonConfirmChoice).setOnClickListener(listener);
        findViewById(R.id.transferToCategory).setOnClickListener(listener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        categorySpinnerAdapter.swapCursor(application.getdBbridge().loadCostsCategories());
    }

    private void extractCategory(Cursor cursor) {
        String nameCostsEntered = editTextName.getText().toString();
        int sumCostsEntered = Integer.parseInt(sumCost.getText().toString());

        int categoryIdIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_ID);
        int categoryId = cursor.getInt(categoryIdIndex);

        application.getdBbridge().saveCostsToDb(categoryId, nameCostsEntered, sumCostsEntered);
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ButtonConfirmChoice:
                    extractCategory((Cursor) spinnerCosts.getSelectedItem());
                    finish();
                    break;

                case R.id.transferToCategory:
                    CategoriesActivity.start(ContentForCostsActivity.this);
                    break;
            }
        }
    }

}
