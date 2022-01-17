package com.example.spotify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LogInpg extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseDatabase database;

    //Loading Progress Dialog
    ProgressDialog progressDialog;

    ImageView imgbackbtn,eyehideornot;
    EditText etlogemail,etlogpass;
    Button loginbtnglow;
    boolean show = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_inpg);
        getSupportActionBar().hide();

        imgbackbtn = findViewById(R.id.imgbackbtn);
        etlogemail = findViewById(R.id.etlogemail);
        etlogpass = findViewById(R.id.etlogpass);
        loginbtnglow = findViewById(R.id.loginbtnglow);
        eyehideornot = findViewById(R.id.eyehideornot);
        getSupportActionBar().hide();

        //Auth Firebase

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        //Progress Dialog

        progressDialog = new ProgressDialog(LogInpg.this);
        progressDialog.setTitle("Log In");
        progressDialog.setMessage("Login to your account");


        eyehideornot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(show) {
                    eyehideornot.setImageResource(R.drawable.ic_baseline_visibility_24);
                    etlogpass.setTransformationMethod(null);
                    show = false;
                }

                else
                {
                    eyehideornot.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    etlogpass.setTransformationMethod(new PasswordTransformationMethod());
                    show = true;
                }

            }
        });


        imgbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LogInpg.this,LoginSignupMn.class);
                startActivity(intent);
            }
        });

        etlogemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!TextUtils.isEmpty(etlogpass.getText())|| !TextUtils.isEmpty(s))
                {
                    loginbtnglow.setEnabled(true);
                    loginbtnglow.setClickable(true);
                    loginbtnglow.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.glowlogbtn));
                }
                else
                {

                    loginbtnglow.setEnabled(false);
                    loginbtnglow.setClickable(false);
                    loginbtnglow.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.logbutton));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etlogpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!TextUtils.isEmpty(etlogemail.getText())|| !TextUtils.isEmpty(s))
                {
                    loginbtnglow.setEnabled(true);
                    loginbtnglow.setClickable(true);
                    loginbtnglow.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.glowlogbtn));
                }
                else
                {

                    loginbtnglow.setEnabled(false);
                    loginbtnglow.setClickable(false);
                    loginbtnglow.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.logbutton));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loginbtnglow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogInpg.this,"Loged In..",Toast.LENGTH_SHORT).show();
            }
        });



        //Log_In Firebase Data Collection

        loginbtnglow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();

                auth.signInWithEmailAndPassword(etlogemail.getText().toString().trim(),etlogpass.getText().toString().trim()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                              progressDialog.dismiss();
                              if(task.isSuccessful())
                              {
                                   startActivity(new Intent(LogInpg.this,MainActivity.class));
                              }
                              else
                              {
                                  Toast.makeText(LogInpg.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                              }
                            }
                        });

            }
        });

        if(auth.getCurrentUser()!=null)
        {
            startActivity(new Intent(LogInpg.this,MainActivity.class));
            finish();
        }
    }




}