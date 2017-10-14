package com.example.food.orderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FinalOrderCustomAdapter extends BaseAdapter {

    int[] images;
    String[] names, prices, quantities;

    Context context;
    LayoutInflater layoutInflater;

    FinalOrderCustomAdapter(Context context, int[] image, String[] name, String[] quantity, String[] price) {
        this.images = image;
        this.quantities = quantity;
        this.names = name;
        this.prices = price;
        this.context = context;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View finalorderview, ViewGroup viewGroup) {

        finalorderview = layoutInflater.inflate(R.layout.final_order_custom_listview, viewGroup, false);
        ImageView final_order_image = (ImageView) finalorderview.findViewById(R.id.final_orderImageView);
        TextView final_order_name = (TextView) finalorderview.findViewById(R.id.final_order_nameTextView);
        TextView final_order_quantity = (TextView) finalorderview.findViewById(R.id.final_order_quantityTextView);
        TextView final_order_price = (TextView) finalorderview.findViewById(R.id.final_order_priceTextView);

        final_order_image.setImageResource(images[i]);
        final_order_name.setText(names[i]);
        final_order_quantity.setText(quantities[i]);
        final_order_price.setText(prices[i]);

        return finalorderview;
    }
}