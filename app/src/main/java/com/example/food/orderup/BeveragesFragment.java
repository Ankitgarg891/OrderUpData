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
        String[] names = {"Soft Drinks  ", "Mohito", "Oreo Shake", "Kitkat Shake", "Ferrero Rocher"};
        int images[] = {R.drawable.soft, R.drawable.mohito, R.drawable.oreo, R.drawable.kitkat, R.drawable.ferrero};
        String price[] = {"50","120","150","150","150","250"};

        listView = (ListView) view.findViewById(R.id.menu_listview);
        listView.setAdapter(new MenuCustomAdapter(getContext(), images, names, price));

        super.onViewCreated(view, savedInstanceState);
    }
}
