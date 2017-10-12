package com.example.food.orderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] images;
    String[] prices;
    String[] names;

    Context context;
    LayoutInflater layoutInflater;

    CustomAdapter(Context context, int image[], String[] name, String[] price) {
        this.context = context;
        this.images = image;
        this.names = name;
        this.prices = price;

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
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = layoutInflater.inflate(R.layout.menu_custom_listview, viewGroup, false);

        ImageView item_ImageView = (ImageView) view.findViewById(R.id.menu_ImageView);
        TextView name_TextView = (TextView) view.findViewById(R.id.menu_nameTextView);
        TextView price_Textview = (TextView) view.findViewById(R.id.menu_item_priceTextView);

        item_ImageView.setImageResource(images[i]);
        name_TextView.setText(names[i]);
        price_Textview.setText(prices[i]);

        return view;
    }
}
