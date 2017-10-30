package com.example.food.orderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FinalOrderCustomAdapter extends BaseAdapter {

    ArrayList names, quantities;
    Context context;

    LayoutInflater layoutInflater;

    FinalOrderCustomAdapter(Context context, ArrayList name, ArrayList quantity) {
        this.quantities = quantity;
        this.names = name;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View finalorderview, ViewGroup viewGroup) {

        finalorderview = layoutInflater.inflate(R.layout.final_order_custom_listview, viewGroup, false);

        TextView final_order_name = (TextView) finalorderview.findViewById(R.id.final_order_nameTextView);
        TextView final_order_quantity = (TextView) finalorderview.findViewById(R.id.final_order_quantityTextView);

        final_order_name.setText("" + names.get(i));
        final_order_quantity.setText("Quantity : " + quantities.get(i));

        return finalorderview;
    }
}