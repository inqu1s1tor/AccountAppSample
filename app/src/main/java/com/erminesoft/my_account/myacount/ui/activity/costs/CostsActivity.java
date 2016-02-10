package com.erminesoft.my_account.myacount.ui.activity.costs;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.erminesoft.my_account.myacount.R;
import com.erminesoft.my_account.myacount.ui.activity.GenericActivity;
import com.erminesoft.my_account.myacount.ui.adapters.CostsAdapter;

public class CostsActivity extends GenericActivity {
    @Override
    protected void onStart() {
        super.onStart();
        loadStartData();
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, CostsActivity.class));
    }

    private ListView listViewCosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costs_layout);

        listViewCosts = (ListView) findViewById(R.id.listViewCosts);

        View.OnClickListener listener  = new Clicker();
        findViewById(R.id.fab).setOnClickListener(listener);

    }

    private void loadStartData(){
        Cursor cursor = application.getdBbridge().loadCosts();
        CostsAdapter costsAdapter = new CostsAdapter(this, cursor, true);
        listViewCosts.setAdapter(costsAdapter);
    }


    private final class Clicker implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fab:
                    ContentForCostsActivity.start(CostsActivity.this);
                    break;
            }
        }
    }

}

