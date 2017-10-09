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
        String[] names = {"m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8", "m9", "m10"};
        int images = R.mipmap.ic_launcher;

        listView = (ListView) view.findViewById(R.id.menu_listview);
        listView.setAdapter(new CustomAdapter(getContext(), images, names));

        super.onViewCreated(view, savedInstanceState);
    }
}
