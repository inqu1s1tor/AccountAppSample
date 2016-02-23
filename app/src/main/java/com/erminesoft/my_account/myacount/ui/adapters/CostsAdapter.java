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

public final class CostsAdapter extends CursorAdapter {

    private final LayoutInflater mInflater;

    public CostsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup pViewGroup) {
        View view = mInflater.inflate(R.layout.list_item_cost_details_layout, pViewGroup, false);
        CostsHolder costHolder = new CostsHolder();

        costHolder.categoryCosts = (TextView) view.findViewById(R.id.costCategoryTextView);
        costHolder.nameCosts = (TextView) view.findViewById(R.id.costNameTextView);
        costHolder.sumCost = (TextView) view.findViewById(R.id.costSumTextView);
        view.setTag(costHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CostsHolder costHolder = (CostsHolder) view.getTag();

        int categoriesCostIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_NAME);
        int nameCostIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_NAME);
        int sumCostIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_SUM);

        costHolder.categoryCosts.setText(cursor.getString(categoriesCostIndex));
        costHolder.nameCosts.setText(cursor.getString(nameCostIndex));
        costHolder.sumCost.setText(String.valueOf(cursor.getInt(sumCostIndex)));
    }

    private static final class CostsHolder {
        TextView categoryCosts;
        TextView nameCosts;
        TextView sumCost;
    }
}
