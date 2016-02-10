package com.erminesoft.my_account.myacount.ui.activity.costs;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.activity.CategoriesActivity;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;
import com.erminesoft.my_account.myacount.ui.adapters.CostsSpinnerAdapter;

public class ContentForCostsActivity extends GenericActivity {

    private Spinner spinnerCosts;

    public static void start(Activity activity) {
        activity.startActivity(new Intent (activity, ContentForCostsActivity.class));
    }

    private EditText editTextCategory;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_for_costs_layout);

        editTextCategory = (EditText)findViewById(R.id.EditTextCategory);
        editTextName = (EditText)findViewById(R.id.EditTextNameCosts);


        spinnerCosts = (Spinner)findViewById(R.id.spinner);

        CostsSpinnerAdapter costsSpinnerAdapter = new CostsSpinnerAdapter(this, application.getdBbridge().loadCategories(), true);
        spinnerCosts.setAdapter(costsSpinnerAdapter);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.ButtonConfirmChoice).setOnClickListener(listener);
        findViewById(R.id.transferToCategory).setOnClickListener(listener);
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ButtonConfirmChoice:
                    String categoryCostsEntered = editTextCategory.getText().toString();
                    String nameCostsEntered = editTextName.getText().toString();
                    application.getdBbridge().saveCostsToDb(categoryCostsEntered, nameCostsEntered);
                    finish();
                    break;
                case R.id.transferToCategory:
                    CategoriesActivity.start(ContentForCostsActivity.this);
                    break;
            }
        }
    }

}
