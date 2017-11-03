package com.example.food.orderup;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderListChefActivity extends AppCompatActivity {

    Toolbar toolbar;
    ProgressDialog dialog;

    HashMap<String,item_model_class> fullOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list_chef);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        getSupportActionBar().setTitle("Orders");

        fetchData();

    }

    private void fetchData() {

        dialog = new ProgressDialog(this);
        dialog.setMessage("Fetching Data");
        dialog.setCancelable(false);
        dialog.show();


        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference().child("order").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              for(DataSnapshot s : dataSnapshot.getChildren()){

                  fullOrder.put(s.getKey(), (item_model_class) s.getValue());

              }

              plotRecord();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void plotRecord() {


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}