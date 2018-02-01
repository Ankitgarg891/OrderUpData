package com.example.food.orderup;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private static final String TAG = "SignUpActivity";
    EditText new_username, new_phone, new_email, new_password, new_re_password;
    Button create_account;
    TextView error_details;

    FirebaseDatabase database;
    DatabaseReference myRef;
    private FirebaseAuth mAuth;                              //for authentication
    private FirebaseAuth.AuthStateListener mAuthListener;    //for authentication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        new_username = (EditText) findViewById(R.id.new_user);
        new_phone = (EditText) findViewById(R.id.new_phone);
        new_email = (EditText) findViewById(R.id.new_email);
        new_password = (EditText) findViewById(R.id.new_password);
        new_re_password = (EditText) findViewById(R.id.new_re_password);
        error_details = (TextView) findViewById(R.id.error_details);

        create_account = (Button) findViewById(R.id.create_account);

        database = FirebaseDatabase.getInstance();

        mAuth = FirebaseAuth.getInstance(); //for authentication

        myRef = database.getReference("User-details");

        new_username.setOnFocusChangeListener(this);
        new_phone.setOnFocusChangeListener(this);
        new_email.setOnFocusChangeListener(this);
        new_password.setOnFocusChangeListener(this);
        new_re_password.setOnFocusChangeListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null)
                //user is signed in
                {
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (true == validate()) {
                    error_details.setTextColor(Color.parseColor("#ff0099cc"));
                    error_details.setText("Creating user account...");
                    Toast.makeText(SignUpActivity.this, "Please Wait", Toast.LENGTH_LONG).show();

                    String email = new_email.getText().toString();
                    String password = new_password.getText().toString();

                    final FirebaseUser user = mAuth.getCurrentUser();

                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, R.string.auth_failed, Toast.LENGTH_SHORT).show();
                            } else {
                                final String id;
                                if (user != null) {
                                    id = user.getUid();

                                    myRef.child(id).child("Name").setValue(new_username.getText().toString());
                                    myRef.child(id).child("Phone no").setValue(new_phone.getText().toString());

                                    Toast.makeText(SignUpActivity.this, "Account Created", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(SignUpActivity.this, WelcomeActivity.class);
                                    intent.putExtra("id", id);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }
                    });
                }
            }
        });

    }

    private boolean validate() {
        error_details.setTextColor(Color.RED);

        String MobilePattern = "[0-9]{10}";
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (new_username.length() == 0 || new_phone.length() == 0 || new_email.length() == 0 || new_password.length() == 0 || new_re_password.length() == 0) {

            error_details.setText("Please fill the empty fields");

            Toast.makeText(getApplicationContext(), "Please fill the empty fields", Toast.LENGTH_SHORT).show();
            return false;
        } else if (new_username.length() > 25 || new_username.length() < 5) {
            Toast.makeText(getApplicationContext(), "Please enter valid user name", Toast.LENGTH_SHORT).show();

            error_details.setText("Please enter valid user name");
            return false;
        } else if (!new_phone.getText().toString().matches(MobilePattern)) {

            Toast.makeText(getApplicationContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();

            error_details.setText("Please enter valid 10 digit phone number");
            return false;
        } else if (!new_email.getText().toString().matches(emailPattern)) {

            Toast.makeText(getApplicationContext(), "Please enter valid email address", Toast.LENGTH_SHORT).show();

            error_details.setText("Please enter valid email address");
            return false;
        } else if (new_password.length() < 6) {

            Toast.makeText(getApplicationContext(), "Please enter minimum 6 character password", Toast.LENGTH_SHORT).show();

            error_details.setText("Please enter minimum 6 character password");
            return false;
        } else if (!new_password.getText().toString().equals(new_re_password.getText().toString())) {

            Toast.makeText(getApplicationContext(), "Please enter same password", Toast.LENGTH_SHORT).show();

            error_details.setText("Please enter same password");
            return false;

        } else {
            return true;
        }

    }

    @Override
    public void onFocusChange(View view, boolean b) {

        error_details.setTextColor(Color.parseColor("#ff0099cc"));
        switch (view.getId()) {
            case (R.id.new_user):
                error_details.setText("Enter 5-25 characters");
                break;
            case (R.id.new_phone):
                error_details.setText("Enter 10 digits");
                break;
            case (R.id.new_email):
                error_details.setText("Enter  Email Address");
                break;
            case (R.id.new_password):
                error_details.setText("Enter Minimum 6 characters");
                break;
            case (R.id.new_re_password):
                error_details.setText("Enter same password again");
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}