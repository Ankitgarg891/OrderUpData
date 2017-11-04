package com.example.food.orderup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ChefOrderDetailCustomAdapter extends ArrayAdapter {

    Context context;
    HashMap<String, item_model_class> order;
    ArrayList<String> key;
    LayoutInflater inflater;

    public ChefOrderDetailCustomAdapter(@NonNull Context context, HashMap<String, item_model_class> order) {
        super(context, R.layout.chef_order_detail_adapter);

        this.context = context;
        this.order = order;
        key = new ArrayList<>(order.keySet());

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return order.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = inflater.inflate(R.layout.chef_order_detail_adapter, parent, false);

        TextView name = view.findViewById(R.id.name);
        TextView quantity = view.findViewById(R.id.quantity);
        ImageView image = view.findViewById(R.id.image);

        item_model_class item = order.get(key.get(position));
        Log.e("object received", key + "  " + order.get(key.get(position)).getName());

        float int_price = Float.parseFloat(item.getPrice());
        name.setText(item.getName());
        quantity.setText("Quantity : " + item.getQuantity() + "");

        return view;
    }
}