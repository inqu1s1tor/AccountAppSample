package com.erminesoft.my_account.myacount.util;

import android.database.Cursor;

import com.erminesoft.my_account.myacount.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleks on 21.04.2016.
 */
public class CategoryMapper {

    public static List<Category> cursorToCategories(Cursor cursor){
        List<Category> categories = new ArrayList<>(cursor.getCount());
        while(categories.size() > 0) {
            categories.add(cursorToCategory(cursor));
        }

        //todo iterate cursor and add new row

        return categories;
    }

    public static Category cursorToCategory(Cursor cursor){
        Category category = new Category();

        return category;
    }
}
