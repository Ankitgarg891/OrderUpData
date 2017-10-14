package com.example.food.orderup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

public class FinalOrderActivity extends AppCompatActivity {

    Toolbar toolbar;
    String[] names = {"Vegetarian Spring Rolls", "Vegetable Fried Wonton", "Crispy Chilli Potatoes"};
    int images[] = {R.drawable.roll, R.drawable.wonton, R.drawable.chilli};
    String price[] = {"450", "450", "735"};
    String quantity[] = {"2", "2", "3"};
    ListView final_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("OrderUp");

        final_order = (ListView) findViewById(R.id.final_orderListView);
        final_order.setAdapter(new FinalOrderCustomAdapter(FinalOrderActivity.this, images, names, quantity, price));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}