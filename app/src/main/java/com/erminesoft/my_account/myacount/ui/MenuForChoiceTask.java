package com.erminesoft.my_account.myacount.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.adapters.ListAdapter;

/**
 * The class for choice functionality.
 */
public class MenuForChoiceTask extends Activity implements View.OnClickListener {

    private Button incomeButton;
    private Button costsButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_for_choice_task);

        incomeButton = (Button)findViewById(R.id.button2);
        costsButton = (Button) findViewById(R.id.button5);
        incomeButton.setOnClickListener(this);
        costsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.button2:
                Intent intentIncome = new Intent(this, Income.class);
                startActivity(intentIncome);
                break;
            case R.id.button5:
                Intent intentCosts = new Intent(this, Costs.class);
                startActivity(intentCosts);
                break;
        }

    }

}