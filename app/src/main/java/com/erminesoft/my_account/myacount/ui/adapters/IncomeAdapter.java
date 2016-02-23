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

public final class IncomeAdapter extends CursorAdapter {

    private final LayoutInflater nLayoutInflater;

    public IncomeAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        nLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup pViewGroup) {
        View view = nLayoutInflater.inflate(R.layout.list_item_income_details_layout, pViewGroup, false);
        IncomeHolder incomeHolder = new IncomeHolder();
        incomeHolder.nameIncome = (TextView) view.findViewById(R.id.incomeNameTextView);
        incomeHolder.categoryIncome = (TextView) view.findViewById(R.id.incomeCategoryTextView);
        incomeHolder.sumIncome = (TextView) view.findViewById(R.id.incomeSumTextView);
        view.setTag(incomeHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        IncomeHolder incomeHolder = (IncomeHolder) view.getTag();

        int categoriesIncomeIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_NAME);
        int nameIncomeIndex = cursor.getColumnIndex(DataBaseHelper.INCOME_NAME);
        int sumCostIndex = cursor.getColumnIndex(DataBaseHelper.INCOME_SUM);

        incomeHolder.categoryIncome.setText(cursor.getString(categoriesIncomeIndex));
        incomeHolder.nameIncome.setText(cursor.getString(nameIncomeIndex));
        incomeHolder.sumIncome.setText(String.valueOf(cursor.getInt(sumCostIndex)));
    }

    private static final class IncomeHolder {
        TextView categoryIncome;
        TextView nameIncome;
        TextView sumIncome;
    }
}



