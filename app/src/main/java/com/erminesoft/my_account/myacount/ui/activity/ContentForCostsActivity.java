package com.erminesoft.my_account.myacount.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.erminesoft.my_account.myacount.R;

public class ContentForCostsActivity extends GenericActivity {

    private EditText editTextCategory;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_for_costs_layout);

        editTextCategory = (EditText)findViewById(R.id.EditTextCategory);
        editTextName = (EditText)findViewById(R.id.EditTextName);

        Clicker listener = new Clicker();
        findViewById(R.id.ButtonConfirmChoice).setOnClickListener(listener);
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ButtonConfirmChoice:
                    Intent intent = new Intent();
                    intent.putExtra("name", editTextName.getText().toString());
                    intent.putExtra("category", editTextCategory.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
            }
        }
    }

}
