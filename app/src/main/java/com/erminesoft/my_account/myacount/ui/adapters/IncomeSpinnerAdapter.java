package com.erminesoft.my_account.myacount.ui.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.db.DataBaseHelper;


public class IncomeSpinnerAdapter extends CursorAdapter {

    private final LayoutInflater mLayoutInflater;

    public IncomeSpinnerAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.spinner_income_adapter_layout, parent, false);

        SpinnerIncomeHolder spinnerIncomeHolder = new SpinnerIncomeHolder();
        spinnerIncomeHolder.spinnerItemIncome = (TextView)view.findViewById(R.id.spinnerIncomeItem);

        view.setTag(spinnerIncomeHolder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        SpinnerIncomeHolder spinnerIncomeHolder = (SpinnerIncomeHolder)view.getTag();

        int spinnerNameIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORIES_NAME);
        spinnerIncomeHolder.spinnerItemIncome.setText(cursor.getString(spinnerNameIndex));

    }

    private  static final class SpinnerIncomeHolder {
        TextView spinnerItemIncome;


    }
}
