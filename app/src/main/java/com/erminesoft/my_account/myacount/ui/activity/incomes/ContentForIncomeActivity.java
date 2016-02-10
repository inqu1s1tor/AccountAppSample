package com.erminesoft.my_account.myacount.ui.activity.incomes;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;

public class ContentForIncomeActivity extends GenericActivity {

    private EditText editTextCategoryIncome;
    private EditText editTextNameIncome;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, ContentForIncomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_for_income_layout);

        View.OnClickListener listener = new Clicker();

        findViewById(R.id.ButtonConfirmChoiceIncome).setOnClickListener(listener);
        editTextCategoryIncome = (EditText)findViewById(R.id.EditTextCategoryIncome);
        editTextNameIncome = (EditText)findViewById(R.id.EditTextNameIncome);
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ButtonConfirmChoiceIncome:
                    String categoryIncomeEntered = editTextCategoryIncome.getText().toString();
                    String nameIncomeEntered = editTextNameIncome.getText().toString();
                    application.getdBbridge().saveIncomeToDb(categoryIncomeEntered, nameIncomeEntered);
                    finish();
                    break;
            }
        }
    }


}
