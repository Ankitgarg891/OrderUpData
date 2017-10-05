package com.example.food.orderup;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class
SplashActivity extends AppCompatActivity {

    TextView t1;
    Handler handler;
    Animation animation;
    Typeface tf;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tf = Typeface.createFromAsset(getAssets(),"fonts/round.ttf");


        animation= AnimationUtils.loadAnimation(this,R.anim.fade_in);

        t1=(TextView)findViewById(R.id.orderup_text);
        t1.startAnimation(animation);

        t1.setTypeface(tf);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 4000);
    }
}