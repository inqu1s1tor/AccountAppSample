package com.erminesoft.my_account.myacount.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.erminesoft.my_account.myacount.R;

public class ListAdapter extends ArrayAdapter<String> {
    TextView textView;
    String[] list;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.list_layout, parent, false);

        textView = (TextView) customView.findViewById(R.id.listText);
        textView.setText(list[position]);
        return customView;

    }

    public ListAdapter(Context context, String[] list) {
        super(context, R.layout.list_layout, list);
        this.list = list;
    }
}
