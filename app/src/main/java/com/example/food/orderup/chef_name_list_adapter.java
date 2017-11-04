package com.example.food.orderup;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class chef_name_list_adapter extends ArrayAdapter {

    ArrayList<String> key;
    HashMap<String,final_order_model> fullOrder;
    LayoutInflater inflater;
    Context context;

    public chef_name_list_adapter(@NonNull Context context, ArrayList<String> key, HashMap<String,final_order_model> fullorder) {
        super(context, R.layout.chef_order_name_list);

        this.context = context;
        this.key = key;
        this.fullOrder = fullorder;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return key.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = inflater.inflate(R.layout.chef_order_name_list,parent,false);


        TextView name = view.findViewById(R.id.name);
        TextView phone = view.findViewById(R.id.phoneno);

        Log.e("before error",fullOrder.toString());
        Log.e("key",key.get(position));
        final_order_model item = fullOrder.get(key.get(position));

        String n =  item.getUserName();
        String p = item.getPhoneNo();

        name.setText(n);
        phone.setText(p);

        return view;
    }
}
