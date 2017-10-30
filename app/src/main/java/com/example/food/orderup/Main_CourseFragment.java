package com.example.food.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Main_CourseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ListView listView;
        String[] names = {"Cheela", "Paneer Sauted Chilli", "Chilli Sauted Spehgati", "Pav Bhaji", "Dal Shorba", "Soya Soft Covered Chap"};
        int images[] = {R.drawable.cheela, R.drawable.chilipaneer, R.drawable.noodles, R.drawable.pav, R.drawable.shorba, R.drawable.soya};
        String price[] = {"225"," 225"," 245"," 275"," 245"," 260"};

        listView = (ListView) view.findViewById(R.id.menu_listview);
        listView.setAdapter(new MenuCustomAdapter(getContext(), images, names, price));

        super.onViewCreated(view, savedInstanceState);
    }
}
