package com.example.food.orderup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = "Welcome_activity";
    Toolbar toolbar;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String flag, id, name[] = {"Town Hall Restaurant", "The Big Chill Café", "Yellow Brick Road Restaurant", "Wok in the Clouds", "The Coffee Bean & Tea Leaf", "Café Turtle", "Omazoni"},
            address[] = {"61 Khan Market, Rabindra Nagar, New Delhi", "36 Khan Market, New Delhi", "Taj Vivanta Hotel, Cornwallis Road, Sujan Singh Park, Khan Market, New Delhi", "52 Khan Market, New Delhi",
                    "62 Middle Lane, Khan Market, Rabindra Nagar, New Delhi", "23 Middle Lane, 2nd Floor, Khan Market, New Delhi", "Prithviraj Market, Khan Market, Delhi"};
    Integer images[] = {R.drawable.town_hall, R.drawable.the_big_chill, R.drawable.yellow_brick, R.drawable.wok_in_the_clouds, R.drawable.the_coffee_bean, R.drawable.cafe_turtle, R.drawable.omazoni};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Welcome,");

        ListView outlet_listview = (ListView) findViewById(R.id.outletListView);

        CustomAdapter customAdapter = new CustomAdapter();
        outlet_listview.setAdapter(customAdapter);

        outlet_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(WelcomeActivity.this, MenuActivity.class));
                        break;
                }
            }
        });

        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");
        id = intent.getStringExtra("id");

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("User-details").child(id);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again whenever data at this location is updated.
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    toolbar.setSubtitle(dataSnapshot.child("Name").getValue().toString());

                    Log.d("WelcomeActivity", "Name = " + d.child("Name"));
                    Log.d("WelcomeActivity", "Phone No = " + d.child("Phone no"));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return name.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.outlet_custom_listview, null);

            ImageView outlet_image = (ImageView) view.findViewById(R.id.outletImageView);
            TextView outlet_name = (TextView) view.findViewById(R.id.outlet_nameTextView);
            TextView outlet_address = (TextView) view.findViewById(R.id.outlet_addressTextView);

            outlet_image.setImageResource(images[i]);
            outlet_name.setText(name[i]);
            outlet_address.setText(address[i]);

            return view;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}