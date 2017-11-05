package com.example.food.orderup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ChefOrderDetailsActivity extends AppCompatActivity {

    final_order_model order;
    TextView name, phone;
    ListView list;
    Button compelete;
    String key;
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
        compelete = findViewById(R.id.complete);
        Intent intent = getIntent();
        order = (final_order_model) intent.getSerializableExtra("order");
        key = intent.getStringExtra("key");
        orderItem = order.getOrder();

        name.setText(order.getUserName().toString());
        phone.setText(order.getPhoneNo().toString());

        ChefOrderDetailCustomAdapter adapter = new ChefOrderDetailCustomAdapter(this, orderItem);
        list.setAdapter(adapter);

        setUpListenerForCompelete();

    }

    private void setUpListenerForCompelete() {
        compelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OrderListChefActivity.fullOrder.remove(key);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference reference = db.getReference();


                reference.child("order").child(ChefLoginActivity.hotel_name).setValue(OrderListChefActivity.fullOrder);
                Toast.makeText(ChefOrderDetailsActivity.this,"Order is Completed",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}