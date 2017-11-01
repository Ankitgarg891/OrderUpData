package com.example.food.orderup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import java.util.HashMap;

public class FinalOrderActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView final_order;

    HashMap<String,Integer> order = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);

        Intent intent = getIntent();

        order = (HashMap<String, Integer>) intent.getSerializableExtra("order");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("OrderUp");

        final_order = (ListView) findViewById(R.id.final_orderListView);
        final_order.setAdapter(new FinalOrderCustomAdapter(FinalOrderActivity.this,order));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}