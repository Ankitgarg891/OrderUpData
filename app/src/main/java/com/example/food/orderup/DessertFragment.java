package com.example.food.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        Button check_out = (Button) view.findViewById(R.id.check_outButton);

        String[] names = {"Chocolate Sandwich", "Ferrero Cake", "Ice Cream Cake", "Chocolate Truffle", "Waffle"};
        int images[] = {R.drawable.choco, R.drawable.ferrer, R.drawable.ice, R.drawable.truffle, R.drawable.waffle};
        String price[] = {"150", " 180", " 200", " 275", " 245", " 260"};
        int quantity[] = {0, 0, 0, 0, 0, 0};
        listView = (ListView) view.findViewById(R.id.menu_listview);
        listView.setAdapter(new MenuCustomAdapter(getContext(), images, names, price, quantity,check_out));

        super.onViewCreated(view, savedInstanceState);
    }
}
