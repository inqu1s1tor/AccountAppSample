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


public class CostsSpinnerAdapter extends CursorAdapter {

    private LayoutInflater mInflater;

    public CostsSpinnerAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.spinner_costs_adapter_layout, parent, false);

        SpinnerCostsHolder spinnerCostsHolder = new SpinnerCostsHolder();
        spinnerCostsHolder.spinnerItem = (TextView)view.findViewById(R.id.spinnerCostsItem);
        view.setTag(spinnerCostsHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        SpinnerCostsHolder spinnerCostsHolder = (SpinnerCostsHolder)view.getTag();

        int spinnerCategoriesIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORIES_NAME);
        spinnerCostsHolder.spinnerItem.setText(cursor.getString(spinnerCategoriesIndex));

    }

    private static final class SpinnerCostsHolder {
        TextView spinnerItem;
    }
}
