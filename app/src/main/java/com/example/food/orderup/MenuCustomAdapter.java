package com.example.food.orderup;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuCustomAdapter extends ArrayAdapter {

    int[] images;
    String[] prices;
    String[] names;
    int[] quantity;

    Context context;
    LayoutInflater layoutInflater;

    ArrayList order_list = new ArrayList();
    ArrayList order_quantity = new ArrayList();

    static HashMap<String, Integer> order = new HashMap<>();

    Button submit;

    MenuCustomAdapter(Context context, int image[], String[] name, String[] price, int[] quantity, Button submit) {
        super(context, R.layout.menu_custom_listview);
        this.context = context;
        this.images = image;
        this.names = name;
        this.prices = price;
        this.quantity = quantity;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.submit = submit;

        setuplistenerforsubmit();
    }

    private void setuplistenerforsubmit() {

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, FinalOrderActivity.class);
                Log.e("order", order.toString());

                intent.putExtra("order", order);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public View getView(final int i, View menuview, ViewGroup viewGroup) {

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

        if (order.containsKey(names[i])) {

            quantity[i] = order.get(names[i]);
        }
        quantity_number.setText("" + quantity[i]);


        add_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity[i]++;
                quantity_number.setText("" + quantity[i]);

                order.put(names[i], quantity[i]);
                Log.e("changed", order_list.toString() + " " + order_quantity.toString());

            }
        });
        delete_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity[i] > 0) {
                    quantity[i]--;
                    quantity_number.setText("" + quantity[i]);


                    order.put(names[i], quantity[i]);

                    if (quantity[i] == 0) {

                        order.remove(names[i]);
                    }


                } else {
                    Toast.makeText(context, "Please select a correct quantity", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return menuview;
    }
}