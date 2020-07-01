package com.example.libcrawler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    String[] branches = {"CSE","ECE","EEE","CIVIL","MECHANICAL","IT","METALLURGY","CHEMICAL","BSH"};
    int[] images = {R.drawable.cse,R.drawable.ece,R.drawable.eee,R.drawable.civil,R.drawable.mechanical,R.drawable.it,
            R.drawable.metallurgical, R.drawable.chemical,R.drawable.bsh};
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        myAdapter = new MyAdapter(this,branches,images);
       rv.setAdapter(myAdapter);
        rv.setLayoutManager(new GridLayoutManager(this,2));
    }
}