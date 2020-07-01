package com.example.libcrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void admin(View view) {
        startActivity(new Intent(select.this,AdminLogin.class));
    }

    public void user(View view) {
        startActivity(new Intent(select.this,LoginActivity.class));
    }
}