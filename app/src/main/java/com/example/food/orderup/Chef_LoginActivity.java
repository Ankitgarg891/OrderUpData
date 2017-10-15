package com.example.food.orderup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Chef_LoginActivity extends AppCompatActivity {

    Button view_orders;

    Spinner s1;
    ArrayAdapter a1;

    String res;
    String res_name[]={"Town Hall Restaurant", "The Big Chill Café", "Yellow Brick Road Restaurant", "Wok in the Clouds", "The Coffee Bean & Tea Leaf", "Café Turtle", "Omazoni"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_login);

        Spinner s1=(Spinner)findViewById(R.id.spinner);

        a1=new ArrayAdapter(this,R.layout.spinner_layout,res_name);

        s1.setAdapter(a1);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                res=res_name[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                res=res_name[0];

            }
        });








        view_orders = (Button) findViewById(R.id.view_orders);

        view_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chef_LoginActivity.this, OrderListChefActivity.class);
                intent.putExtra("res",res);
                startActivity(intent);
            }
        });

    }
}