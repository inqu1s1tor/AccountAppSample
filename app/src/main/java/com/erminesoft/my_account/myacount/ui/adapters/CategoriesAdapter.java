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

public final class CategoriesAdapter extends CursorAdapter {

    private final LayoutInflater mInflater;

    public CategoriesAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.list_item_categories_details_layout, parent, false);
        CategoriesHolder categoriesHolder = new CategoriesHolder();
        categoriesHolder.categoriesGeneral = (TextView) view.findViewById(R.id.categoryGeneralTextView);
        view.setTag(categoriesHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CategoriesHolder categoriesHolder = (CategoriesHolder) view.getTag();

        int categoriesIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_NAME);
        categoriesHolder.categoriesGeneral.setText(cursor.getString(categoriesIndex));
    }

    private static final class CategoriesHolder {
        TextView categoriesGeneral;
    }
}
