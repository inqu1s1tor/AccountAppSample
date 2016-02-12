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



public class CostsAdapter extends CursorAdapter {

    private final LayoutInflater mInflater;

    public CostsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup pViewGroup) {
        View view = mInflater.inflate(R.layout.list_item_cost_details_layout, pViewGroup, false);
        CostsHolder costHolder = new CostsHolder();
        costHolder.categoryCosts = (TextView)view.findViewById(R.id.costCategoryTextView);
        costHolder.nameCosts = (TextView)view.findViewById(R.id.costNameTextView);
        view.setTag(costHolder);
        return view ;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CostsHolder costHolder =  (CostsHolder)view.getTag();

        int categoriesCostIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_CATEGORIES);
        int nameCostIndex = cursor.getColumnIndex(DataBaseHelper.COSTS_NAME);

        costHolder.categoryCosts.setText(cursor.getString(categoriesCostIndex));
        costHolder.nameCosts.setText(cursor.getString(nameCostIndex));
    }


    private static final class CostsHolder {
        TextView categoryCosts;
        TextView nameCosts;
    }
}
