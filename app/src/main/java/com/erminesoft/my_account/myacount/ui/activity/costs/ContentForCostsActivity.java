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
import com.erminesoft.my_account.myacount.ui.adapters.CostsSpinnerAdapter;



public class ContentForCostsActivity extends GenericActivity {

    private Spinner spinnerCosts;
    private EditText editTextName;
    private CostsSpinnerAdapter costsSpinnerAdapter;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, ContentForCostsActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_for_costs_layout);

        editTextName = (EditText) findViewById(R.id.EditTextNameCosts);
        spinnerCosts = (Spinner) findViewById(R.id.spinner);

        costsSpinnerAdapter = new CostsSpinnerAdapter(this, application.getdBbridge().loadCategories(), true);
        spinnerCosts.setAdapter(costsSpinnerAdapter);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.ButtonConfirmChoice).setOnClickListener(listener);
        findViewById(R.id.transferToCategory).setOnClickListener(listener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        costsSpinnerAdapter.swapCursor(application.getdBbridge().loadCategories());
    }

    private void extractCategory(Cursor cursor) {
        String nameCostsEntered = editTextName.getText().toString();

        int categoryIdIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORIES_ID);
        int categoryId = cursor.getInt(categoryIdIndex);

        application.getdBbridge().saveCostsToDb(categoryId, nameCostsEntered);
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
