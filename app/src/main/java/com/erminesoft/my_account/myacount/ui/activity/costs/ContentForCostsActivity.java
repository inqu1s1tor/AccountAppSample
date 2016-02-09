package com.erminesoft.my_account.myacount.ui.activity.costs;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;

public class ContentForCostsActivity extends GenericActivity {

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
        editTextName = (EditText)findViewById(R.id.EditTextName);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.ButtonConfirmChoice).setOnClickListener(listener);
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
            }
        }
    }

}
