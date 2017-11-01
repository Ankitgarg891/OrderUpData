package com.example.food.orderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class FinalOrderCustomAdapter extends ArrayAdapter {

    Context context;

    LayoutInflater layoutInflater;
    HashMap<String,Integer> order;

    ArrayList<String> itemName;

    FinalOrderCustomAdapter(Context context, HashMap<String,Integer> order) {

        super(context,R.layout.final_order_custom_listview);
        this.order = order;
        this.context = context;
        itemName = new ArrayList<>();

        Set<String> nameSet = this.order.keySet();
        itemName = new ArrayList<>(nameSet);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
       return order.size();
    }

    @Override
    public View getView(int i, View finalorderview, ViewGroup viewGroup) {

        finalorderview = layoutInflater.inflate(R.layout.final_order_custom_listview, viewGroup, false);


        TextView final_order_name = (TextView) finalorderview.findViewById(R.id.final_order_nameTextView);
        TextView final_order_quantity = (TextView) finalorderview.findViewById(R.id.final_order_quantityTextView);

        final_order_name.setText("" + itemName.get(i));
        final_order_quantity.setText("Quantity : " +order.get(itemName.get(i)));

        return finalorderview;
    }
}