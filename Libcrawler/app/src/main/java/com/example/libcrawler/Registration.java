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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registration extends AppCompatActivity {
    EditText umail, upwd;
    EditText uname, uroll, uphno;
    FirebaseAuth auth;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        umail = findViewById(R.id.email);
        upwd = findViewById(R.id.pwd);
        uname = findViewById(R.id.name);
        uroll = findViewById(R.id.roll);
        uphno = findViewById(R.id.phno);
        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference("user");
    }

    public void register(View view) {
        String mail = umail.getText().toString();
        String pwd = upwd.getText().toString();
        final String name = uname.getText().toString();
        final String roll = uroll.getText().toString();
        final String phno = uphno.getText().toString();
        if(mail.isEmpty() || pwd.isEmpty()|| name.isEmpty()||roll.isEmpty()||phno.isEmpty()){
            Toast.makeText(Registration.this, "Fields shouln't be empty", Toast.LENGTH_SHORT).show();}
        else{

            auth.createUserWithEmailAndPassword(mail,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Registration.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        HashMap<String,String> maps = new HashMap<>();
                        maps.put("name",name);
                        maps.put("roll",roll);
                        maps.put("contact",phno);
                        reference.setValue(maps).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    startActivity(new Intent(Registration.this,LoginActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(Registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }

                }
            });
        }

    }

    public void login(View view) {
        Intent i = new Intent(Registration.this, LoginActivity.class);
        startActivity(i);
    }
}
