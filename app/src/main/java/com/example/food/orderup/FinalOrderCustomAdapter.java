package com.example.food.orderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class FinalOrderCustomAdapter extends ArrayAdapter {

    Context context;

    LayoutInflater layoutInflater;
    HashMap<String,item_model_class> order;
    ArrayList<String> itemName;

    FinalOrderCustomAdapter(Context context, HashMap<String,item_model_class> order) {

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

        String key = itemName.get(i);
        item_model_class item = order.get(key);

        TextView final_order_name = (TextView) finalorderview.findViewById(R.id.name);
        TextView final_order_quantity = (TextView) finalorderview.findViewById(R.id.quantity);
        TextView price = finalorderview.findViewById(R.id.price);
        TextView total = finalorderview.findViewById(R.id.total);
        ImageView imageView = finalorderview.findViewById(R.id.image);

        int intquan = item.getQuantity();
        float floatprice  = Float.parseFloat(item.getPrice());
        float totalPrce = intquan*floatprice;


        final_order_name.setText("" + item.getName());
        final_order_quantity.setText("Quantity : " +item.getQuantity());
        price.setText(item.getPrice()+"/per unit");
        total.setText("Total Price : ₹"+totalPrce+"");
        imageView.setImageDrawable(context.getDrawable(item.getImage()));
        return finalorderview;
    }
}