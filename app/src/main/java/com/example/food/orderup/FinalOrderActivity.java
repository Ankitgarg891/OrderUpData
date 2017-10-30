package com.example.food.orderup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class FinalOrderActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView final_order;

    ArrayList name,quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);

        Intent intent = getIntent();
        name = intent.getStringArrayListExtra("order_item_name");
        quantity = intent.getIntegerArrayListExtra("order_item_quantity");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("OrderUp");

        final_order = (ListView) findViewById(R.id.final_orderListView);
        final_order.setAdapter(new FinalOrderCustomAdapter(FinalOrderActivity.this, name, quantity));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}