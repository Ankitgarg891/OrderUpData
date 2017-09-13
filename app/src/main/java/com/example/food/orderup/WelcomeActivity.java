package com.example.food.orderup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG ="Welcome_activity" ;
    TextView display;
    FirebaseDatabase database;
    int ctr=0;
    DatabaseReference myRef;
    String flag;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        display=(TextView)findViewById(R.id.display);


        Intent intent=getIntent();
        flag=intent.getStringExtra("flag");

        id=intent.getStringExtra("id");








        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("User-details").child(id);







        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                String display_name="";

                for(DataSnapshot d:dataSnapshot.getChildren())

                {

                    display.setText("Welcome Mr. "+dataSnapshot.child("Name").getValue().toString());
                 //   Toast.makeText(WelcomeActivity.this,dataSnapshot.child("Name").toString(), Toast.LENGTH_LONG).show();

                    Log.d("WelcomeActivity","Name = " + d.child("Name"));
                    Log.d("WelcomeActivity","Phone No = " + d.child("Phone no"));








                }





                Log.d(TAG, "Value is: " + display_name);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
























    }
}
