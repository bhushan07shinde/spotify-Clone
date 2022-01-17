package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginSignupSt extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseDatabase database;

    Button LstBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup_st);

        getSupportActionBar().hide();

        LstBtn = findViewById(R.id.LstBtn);


        //Auth Firebase

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();



        if(auth.getCurrentUser()!=null)
        {
            startActivity(new Intent(LoginSignupSt.this,MainActivity.class));
            finish();

        }

        LstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSignupSt.this,LoginSignupMn.class));
            }
        });
    }
}