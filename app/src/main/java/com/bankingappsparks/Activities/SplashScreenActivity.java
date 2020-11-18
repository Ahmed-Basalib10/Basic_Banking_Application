package com.bankingappsparks.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bankingappsparks.R;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView logo;
    TextView app_name , developed,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo=(ImageView) findViewById(R.id.logo);
        app_name=(TextView) findViewById(R.id.appName);
        name=(TextView) findViewById(R.id.name);
        developed=(TextView) findViewById(R.id.developed);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animation();
            }
        },2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
               finish();
            }
        },5500);
    }

    private void animation() {
     app_name.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.nameanim));
     logo.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logoanim));
     app_name.setVisibility(View.VISIBLE);
     logo.setVisibility(View.VISIBLE);
     developed.setVisibility(View.VISIBLE);
     name.setVisibility(View.VISIBLE);
    }
}