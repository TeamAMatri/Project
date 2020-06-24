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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText upwd, umail;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        umail = findViewById(R.id.loginmail);
        upwd = findViewById(R.id.loginpwd);
        auth = FirebaseAuth.getInstance();

    }

    public void login(View view) {
        String pwd = upwd.getText().toString();
        String mail = umail.getText().toString();
        String emailPattern =  "[a-zA-Z0-9._#$&*]+@[a-z]+\\.+[a-z]+";
        String passwordPattern = "[a-zA-z0-9._#$&*]{6,10}";
        if(mail.matches(emailPattern))
        {

        }
        else
        {
            umail.setError("Eg: hello@gmail.com");
            umail.requestFocus();
        }

        if(pwd.matches(passwordPattern))
        {

        }
        else
        {
            upwd.setError("Should contain 6-10 characters");
            upwd.requestFocus();
        }

        if(mail.matches(emailPattern) && pwd.matches(passwordPattern))
        {
                auth.signInWithEmailAndPassword(mail,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Logged in Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Invalid user", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }

    }

    public void register(View view) {
        startActivity(new Intent(this, Registration.class));
    }

    public void forgotpassword(View view) {
        startActivity(new Intent(LoginActivity.this, PasswordActivity.class));
    }
}
