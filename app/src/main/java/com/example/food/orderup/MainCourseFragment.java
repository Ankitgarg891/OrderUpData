package com.example.food.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class MainCourseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ListView listView;
        Button check_out = (Button) view.findViewById(R.id.check_outButton);
        String[] names = {"Cheela", "Paneer Sauted Chilli", "Chilli Sauted Spehgati", "Pav Bhaji", "Dal Shorba", "Soya Soft Covered Chap"};
        int images[] = {R.drawable.cheela, R.drawable.chilipaneer, R.drawable.noodles, R.drawable.pav, R.drawable.shorba, R.drawable.soya};
        String price[] = {"180","150","210","200","220"," 260"};
        int quantity[] = {0,0,0,0,0,0};

        listView = (ListView) view.findViewById(R.id.menu_listview);
        listView.setAdapter(new MenuCustomAdapter(getContext(), images, names, price,quantity,check_out));

        super.onViewCreated(view, savedInstanceState);
    }
}
