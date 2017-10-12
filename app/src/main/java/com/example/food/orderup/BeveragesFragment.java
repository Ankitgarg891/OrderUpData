package com.example.food.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class BeveragesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ListView listView;
        String[] names = {"Vegetarian Spring Rolls", "Vegetable Fried Wonton", "Crispy Chilli Potatoes", "Chilli Paneer", "Crispy Tangy Mushrooms", "Corn Pepper Salt"};
        int images[] = {R.drawable.roll, R.drawable.wonton, R.drawable.chilli, R.drawable.paneer, R.drawable.mushroom, R.drawable.corn};
        String price[] = {"225"," 225"," 245"," 275"," 245"," 260"};

        listView = (ListView) view.findViewById(R.id.menu_listview);
        listView.setAdapter(new CustomAdapter(getContext(), images, names, price));

        super.onViewCreated(view, savedInstanceState);
    }
}
