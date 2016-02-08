package com.erminesoft.my_account.myacount.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.adapters.CostsAdapter;

public class CostsActivity extends GenericActivity implements View.OnClickListener {

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, CostsActivity.class));
    }

    private ListView listViewCosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costs_layout);

        listViewCosts = (ListView) findViewById(R.id.listViewCosts);

        loadStartData();

        findViewById(R.id.fab).setOnClickListener(this);

    }
    private void loadStartData(){
        Cursor cursor = application.getdBbridge().loadCosts();
        CostsAdapter costsAdapter = new CostsAdapter(this, cursor, true);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, ChoiceContentActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
    }
}
