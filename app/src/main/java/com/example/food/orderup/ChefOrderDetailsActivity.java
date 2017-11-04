package com.example.food.orderup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class ChefOrderDetailsActivity extends AppCompatActivity {

    final_order_model order;
    TextView name, phone;
    ListView list;
    HashMap<String, item_model_class> orderItem;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_order_detail);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Orders");

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phoneNo);
        list = findViewById(R.id.list);

        Intent intent = getIntent();
        order = (final_order_model) intent.getSerializableExtra("order");

        orderItem = order.getOrder();

        name.setText(order.getUserName().toString());
        phone.setText(order.getPhoneNo().toString());

        ChefOrderDetailCustomAdapter adapter = new ChefOrderDetailCustomAdapter(this, orderItem);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}