package com.example.libcrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText uroll,umail;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uroll = findViewById(R.id.loginroll);
        auth = FirebaseAuth.getInstance();
    }

    public void login(View view) {
        String roll = uroll.getText().toString();
        String mail = umail.getText().toString();
        if(mail.isEmpty() || roll.isEmpty()){
            Toast.makeText(LoginActivity.this, "Fields sholudn't be empty", Toast.LENGTH_SHORT).show();
        }
        else{

        }

    }

    public void register(View view) {
        startActivity(new Intent(this, Registration.class));
    }
}
