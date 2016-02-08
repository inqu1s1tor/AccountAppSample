package com.erminesoft.my_account.myacount.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.erminesoft.my_account.myacount.R;

public class ChoiceContentActivity extends GenericActivity implements View.OnClickListener {

    private EditText editTextCategory;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_content);

        editTextCategory = (EditText)findViewById(R.id.EditTextCategory);
        editTextName = (EditText)findViewById(R.id.EditTextName);

        findViewById(R.id.ButtonConfirmChoice).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }



}
