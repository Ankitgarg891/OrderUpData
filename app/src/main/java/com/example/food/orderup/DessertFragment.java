package com.example.food.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class DessertFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ListView listView;
        String[] names = {"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10"};
        int images = R.mipmap.ic_launcher;

        listView = (ListView) view.findViewById(R.id.menu_listview);
        listView.setAdapter(new CustomAdapter(getContext(), images, names));

        super.onViewCreated(view, savedInstanceState);
    }
}
