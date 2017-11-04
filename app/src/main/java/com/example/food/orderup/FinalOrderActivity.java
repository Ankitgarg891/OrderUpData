package com.example.food.orderup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FinalOrderActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button submit;
    ListView final_order;

    public static String order_string = "order";

    HashMap<String, item_model_class> order = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);

        Intent intent = getIntent();

        order = (HashMap<String, item_model_class>) intent.getSerializableExtra("order");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("OrderUp");

        final_order = (ListView) findViewById(R.id.final_orderListView);
        final_order.setAdapter(new FinalOrderCustomAdapter(FinalOrderActivity.this, order));

        submit = (Button) findViewById(R.id.order_nowButton);

        if (order.isEmpty() || order.size() == 0) {
            submit.setClickable(false);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference ref = db.getReference();

                final_order_model final_order = new final_order_model(order, WelcomeActivity.userName, WelcomeActivity.userPhone);

                ref.child(order_string).child(MenuActivity.hotel_name).child(LoginActivity.userId).setValue(final_order);
                MenuCustomAdapter.order.clear();
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