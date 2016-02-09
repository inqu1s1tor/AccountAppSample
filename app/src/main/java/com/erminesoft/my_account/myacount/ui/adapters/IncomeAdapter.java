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



public class IncomeAdapter extends CursorAdapter {

    private final LayoutInflater mLayoutInflater ;

    public IncomeAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup pViewGroup) {
        View view = mLayoutInflater.inflate(R.layout.list_item_income_details_layout, pViewGroup, false);
        IncomeHolder incomeHolder = new IncomeHolder();
        incomeHolder.nameIncome = (TextView) view.findViewById(R.id.incomeNameTextView);
        incomeHolder.categoryIncome = (TextView)view.findViewById(R.id.incomeCategoryTextView);
        view.setTag(incomeHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        IncomeHolder incomeHolder = (IncomeHolder)view.getTag();
        incomeHolder.categoryIncome.setText(cursor.getColumnIndex(DataBaseHelper.INCOME_CATEGORIES));
        incomeHolder.nameIncome.setText(cursor.getColumnIndex(DataBaseHelper.INCOME_NAME));

    }

    private static class IncomeHolder {
        TextView categoryIncome;
        TextView nameIncome;

    }


}



