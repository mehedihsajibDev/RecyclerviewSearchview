package com.tolet.sajib.retrofitgetparttwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasySplashScreen config = new EasySplashScreen(MainActivity.this)
                .withFullScreen()
                .withTargetActivity(Home.class) //This is target activity
                .withSplashTimeOut(2000)
                .withBackgroundResource(android.R.color.white)
                .withLogo(R.drawable.logo);
        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }
}
