package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class LogoSt extends AppCompatActivity {

    private static int Time_Out = 4000;
    TextView tvanimated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_st);
        tvanimated=findViewById(R.id.tvanimated);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoSt.this,LoginSignupSt.class);
                startActivity(intent);
                finish();
            }
        },Time_Out);

        YoYo.with(Techniques.FlipInY).duration(3000).playOn(tvanimated);


    }
}