package com.example.bookfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //This acitivity is visible only for 3 seconds and you have to add image and title in the layout file
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                finish();//If you dont give it here,if you click back you will be navigated to this screen again
            }
        },3000);//3000 millis is equal to 3 secs
    }
}
