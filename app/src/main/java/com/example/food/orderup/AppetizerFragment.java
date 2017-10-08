package com.example.food.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class AppetizerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        String[] names = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10"};
        int images = R.mipmap.ic_launcher, total_size = names.length, i;



        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.newlayout);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        for (i=0;i<total_size;i++) {
            View view1  = inflater.inflate(R.layout.menu_custom_listview, linearLayout, false);

            ImageView imageView = (ImageView)view1.findViewById(R.id.menu_ImageView);
            TextView textView = (TextView)view1.findViewById(R.id.menu_nameTextView);

            imageView.setImageResource(images);
            textView.setText(names[i]);

            linearLayout.addView(view1);
        }
        super.onViewCreated(view, savedInstanceState);
    }
}