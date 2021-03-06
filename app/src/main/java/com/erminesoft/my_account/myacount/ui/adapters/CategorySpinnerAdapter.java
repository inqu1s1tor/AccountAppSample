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


public final class CategorySpinnerAdapter extends CursorAdapter {

    private final LayoutInflater mInflater;

    public CategorySpinnerAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.spinner_costs_adapter_layout, parent, false);

        SpinnerCostsHolder spinnerCostsHolder = new SpinnerCostsHolder();
        spinnerCostsHolder.spinnerItem = (TextView) view.findViewById(R.id.spinnerCostsItem);
        view.setTag(spinnerCostsHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        SpinnerCostsHolder spinnerCostsHolder = (SpinnerCostsHolder) view.getTag();

        int spinnerCategoryIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_NAME);
        spinnerCostsHolder.spinnerItem.setText(cursor.getString(spinnerCategoryIndex));
    }


    private final static class SpinnerCostsHolder {
        TextView spinnerItem;
    }
}
