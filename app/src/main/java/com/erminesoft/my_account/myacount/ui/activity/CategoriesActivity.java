package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.adapters.CategoriesAdapter;

public class CategoriesActivity extends GenericActivity {

    private EditText eddingCategory;
    private ListView listViewCategories;
    private CategoriesAdapter categoriesAdapter;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, CategoriesActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);

        eddingCategory = (EditText)findViewById(R.id.editTextCategoryAdding);
        listViewCategories = (ListView)findViewById(R.id.listViewCategories);

        View.OnClickListener listener = new Clicker();
        findViewById(R.id.buttonAddingCategory).setOnClickListener(listener);

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadStartdata();
    }

    private void loadStartdata() {
        Cursor cursor = application.getdBbridge().loadCategories();
        categoriesAdapter = new CategoriesAdapter(this, cursor, true) ;
        listViewCategories.setAdapter(categoriesAdapter);
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAddingCategory:
                    String categoryEntered = eddingCategory.getText().toString();
                    application.getdBbridge().saveCategoriesToDb(categoryEntered);
            }

        }
    }
}
