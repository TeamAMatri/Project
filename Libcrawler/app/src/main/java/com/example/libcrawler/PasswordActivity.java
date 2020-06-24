package com.example.libcrawler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordActivity extends AppCompatActivity {
    EditText mail;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        mail = findViewById(R.id.mail);
        auth = FirebaseAuth.getInstance();
    }

    public void reset(View view) {
        String email = mail.getText().toString().trim();
        if(email.isEmpty())
            Toast.makeText(this, "Please enter your registered email ID", Toast.LENGTH_SHORT).show();
        else{
            auth.sendPasswordResetEmail(email).addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(PasswordActivity.this, "Password reset email sent!", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(PasswordActivity.this, LoginActivity.class));
                    }
                    else
                        Toast.makeText(PasswordActivity.this, "Enter valid email ID", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}