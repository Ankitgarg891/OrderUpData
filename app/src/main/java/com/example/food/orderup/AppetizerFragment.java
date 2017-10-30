package com.example.food.orderup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class AppetizerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView;
        String[] names = {"Vegetarian Spring Rolls", "Vegetable Fried Wonton", "Crispy Chilli Potatoes", "Chilli Paneer", "Crispy Tangy Mushrooms", "Corn Pepper Salt"};
        int images[] = {R.drawable.roll, R.drawable.wonton, R.drawable.chilli, R.drawable.paneer, R.drawable.mushroom, R.drawable.corn};
        String price[] = {"225", " 225", " 245", " 275", " 245", " 260"};
        int quantity[] = {0,0,0,0,0,0};

        Button check_out = (Button) view.findViewById(R.id.check_outButton);

        listView = (ListView) view.findViewById(R.id.menu_listview);
        listView.setAdapter(new MenuCustomAdapter(getContext(), images, names, price,quantity));

        check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FinalOrderActivity.class);
                intent.putExtra("order_item_name",MenuCustomAdapter.order_list);
                intent.putExtra("order_item_quantity",MenuCustomAdapter.order_quantity);
                startActivity(intent);
            }
        });
    }
}