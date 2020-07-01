package com.example.libcrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class Search_book extends AppCompatActivity {
    EditText book_required;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
        book_required = findViewById(R.id.search);
    }

    public void searchbook(View view) {
        String book = book_required.getText().toString();

    }

}