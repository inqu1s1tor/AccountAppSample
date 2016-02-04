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

/**
 * Created by Sane4ek on 04.02.2016.
 */
public class CostAdapter extends CursorAdapter {

    private final LayoutInflater mInflater;

    public CostAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup pViewGroup) {

        View view = mInflater.inflate(R.layout.list_item_cost_detail, pViewGroup, false);
        CostHolder holder = new CostHolder();
        holder.categoryCost = (TextView)view.findViewById(R.id.categoryCost);
        holder.nameCost = (TextView)view.findViewById(R.id.nameCost);
        view.setTag(holder);
        return view ;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CostHolder holder =  (CostHolder)view.getTag();
        holder.categoryCost.setText(cursor.getColumnIndex(DataBaseHelper.COSTS_CATEGORIES));
        holder.nameCost.setText(cursor.getColumnIndex(DataBaseHelper.COSTS_NAME));

    }

    private static class CostHolder {
        TextView categoryCost;
        TextView nameCost;

    }
}
