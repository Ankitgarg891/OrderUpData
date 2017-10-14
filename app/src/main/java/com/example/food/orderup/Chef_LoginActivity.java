package com.example.food.orderup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chef_LoginActivity extends AppCompatActivity {
    Button view_orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_login);

        view_orders = (Button) findViewById(R.id.view_orders);


        view_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Chef_LoginActivity.this,order_list_chef.class);
                startActivity(intent);
            }
        });

    }
}
