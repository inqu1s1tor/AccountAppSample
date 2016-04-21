package com.erminesoft.my_account.myacount.util;

import android.database.Cursor;

import com.erminesoft.my_account.myacount.db.DataBaseHelper;
import com.erminesoft.my_account.myacount.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static List<Category> cursorToCategories(Cursor cursor) {
        List<Category> categories = new ArrayList<>(cursor.getCount());

        if (!cursor.moveToFirst()) {
            return categories;
        }

        while (cursor.moveToNext()) {
            categories.add(cursorToCategory(cursor));
        }

        return categories;
    }

    public static Category cursorToCategory(Cursor cursor) {

        int nameIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_NAME);
        int typeIndex = cursor.getColumnIndex(DataBaseHelper.CATEGORY_TYPE);

        Category category = new Category();
        category.setCategoryName(cursor.getString(nameIndex));
        category.setCategoryType(cursor.getInt(typeIndex));

        return category;
    }
}
