package com.example.food.orderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuCustomAdapter extends BaseAdapter {

    int[] images;
    String[] prices;
    String[] names;

    Context context;
    LayoutInflater layoutInflater;

    MenuCustomAdapter(Context context, int image[], String[] name, String[] price) {
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
    public View getView(int i, View menuview, ViewGroup viewGroup) {

        int orderlist[];

        menuview = layoutInflater.inflate(R.layout.menu_custom_listview, viewGroup, false);

        ImageView item_ImageView = (ImageView) menuview.findViewById(R.id.menu_ImageView);
        TextView name_TextView = (TextView) menuview.findViewById(R.id.menu_nameTextView);
        TextView price_Textview = (TextView) menuview.findViewById(R.id.menu_item_priceTextView);

        ImageButton add_quantity = (ImageButton) menuview.findViewById(R.id.add_quantityImageButton);
        ImageButton delete_quantity = (ImageButton) menuview.findViewById(R.id.delete_quantityImageButton);

        final TextView quantity_number = (TextView) menuview.findViewById(R.id.quantity_numberTextView);

        item_ImageView.setImageResource(images[i]);
        name_TextView.setText(names[i]);
        price_Textview.setText(prices[i]);

        add_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity_number.setText("1");
            }
        });
        delete_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity_number.setText("9");
            }
        });
        return menuview;
    }
}