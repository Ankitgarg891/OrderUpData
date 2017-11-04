package com.example.food.orderup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderListChefActivity extends AppCompatActivity {

    Toolbar toolbar;
    ProgressDialog dialog;

    HashMap<String, final_order_model> fullOrder;

    ArrayList<String> key = new ArrayList<>();
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list_chef);

        list = findViewById(R.id.chef_ordersListView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Orders List");

        fetchData();
        setuplistClickListener();

    }

    private void setuplistClickListener() {

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String k = key.get(i);
                final_order_model order = fullOrder.get(k);

                Intent intent = new Intent(OrderListChefActivity.this, ChefOrderDetailsActivity.class);
                intent.putExtra("order", order);
                startActivity(intent);
                Log.e("order is ", order.toString());
            }
        });
    }

    private void fetchData() {

        dialog = new ProgressDialog(this);
        dialog.setMessage("Fetching Data");
        dialog.setCancelable(false);
        dialog.show();


        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference().child("order").child(ChefLoginActivity.hotel_name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                fullOrder = new HashMap<>();
                for (DataSnapshot s : dataSnapshot.getChildren()) {

                    fullOrder.put(s.getKey(), s.getValue(final_order_model.class));

                }
                dialog.dismiss();
                parseRecord();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void parseRecord() {

        key = new ArrayList<>(fullOrder.keySet());

        chef_name_list_adapter adapter = new chef_name_list_adapter(this, key, fullOrder);
        list.setAdapter(adapter);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}