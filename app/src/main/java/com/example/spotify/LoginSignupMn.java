package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LoginSignupMn extends AppCompatActivity {

    ImageView imgbackbtn;
    Button logbtn,regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup_mn);

        getSupportActionBar().hide();

        imgbackbtn = findViewById(R.id.imgbackbtn);
        logbtn = findViewById(R.id.logbtn);
        regbtn = findViewById(R.id.regbtn);

        imgbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSignupMn.this,LoginSignupSt.class));
            }
        });
        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSignupMn.this,LogInpg.class));
            }
        });
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSignupMn.this,NewRegister.class));
            }
        });
    }
}