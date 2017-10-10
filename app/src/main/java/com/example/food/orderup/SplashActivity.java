package com.example.food.orderup;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView tray;
    Animation animation;
    TextView text;
    Handler handler1;
    Boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        text = (TextView) findViewById(R.id.order);
        tray = (ImageView) findViewById(R.id.splashtray);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim);

        tray.startAnimation(animation);

        handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (check == false) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }

        }, 2000);
    }

    @Override
    public void onBackPressed() {
        check = true;
        super.onBackPressed();
    }
}


