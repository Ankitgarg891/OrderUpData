package com.example.food.orderup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChefLoginActivity extends AppCompatActivity {

    Button view_orders;
    private static final String TAG = "chef_LoginActivity";
    EditText password_chef;

    Spinner s1;
    ArrayAdapter a1;

    String place, res, pass_user, pass_real;
    String res_name[] = {"Town Hall Restaurant", "The Big Chill Café", "Yellow Brick Road Restaurant", "Wok in the Clouds", "The Coffee Bean & Tea Leaf", "Café Turtle", "Omazoni"};
    String no[] = {"0", "1", "2", "3", "4", "5", "6"};
    String passwords[]={"THR05","TBCC05","YBRR05","WITC05","TCBTL05","CATU05","OMA05"};
    FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference myRef;

    public static String chef_id;
    public static String hotel_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_login);


        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        myRef = database.getReference("Chef");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    chef_id = user.getUid();
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };


        final TextView status_c = (TextView) findViewById(R.id.status_chef);
        password_chef = (EditText) findViewById(R.id.password_chef);

        s1 = (Spinner) findViewById(R.id.spinner);

        a1 = new ArrayAdapter(this, R.layout.spinner_layout, res_name);

        s1.setAdapter(a1);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                res = res_name[i];
                place = no[i];
                hotel_name = res;
                pass_real=passwords[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                res = res_name[0];
                hotel_name = res;
                place = no[0];

                pass_real=passwords[0];
            }
        });


        view_orders = (Button) findViewById(R.id.view_orders);

        view_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChefLoginActivity.this, "Please Wait", Toast.LENGTH_SHORT).show();
                status_c.setText("Checking Details..");
                pass_user = password_chef.getText().toString();

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again whenever data at this location is updated.

                        for (DataSnapshot d : dataSnapshot.getChildren()) {
                            //pass_real = dataSnapshot.child(place).getValue().toString();

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

                //   pass_real

                Intent intent = new Intent(ChefLoginActivity.this, OrderListChefActivity.class);


                //intent.putExtra("res", pass_user + "yu" + pass_real);

                //Toast.makeText(ChefLoginActivity.this, pass_real+"="+pass_user, Toast.LENGTH_SHORT).show();

                if (pass_real.equals(pass_user))
                {

                    startActivity(intent);
                    finish();



                }
                else
                {
                    status_c.setText("Please enter correct password");
                    Toast.makeText(ChefLoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}