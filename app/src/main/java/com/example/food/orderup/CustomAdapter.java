package com.example.food.orderup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int images;
    String[] names;

    Context context;
    LayoutInflater layoutInflater;

    CustomAdapter(Context context, int image, String[] name) {
        this.context = context;
        this.images = image;
        this.names = name;

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

        ImageView imageView = (ImageView) view.findViewById(R.id.menu_ImageView);
        TextView textView = (TextView) view.findViewById(R.id.menu_nameTextView);

        imageView.setImageResource(images);
        textView.setText(names[i]);

        return view;
    }
}
