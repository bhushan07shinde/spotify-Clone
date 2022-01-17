package com.example.spotify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.spotify.Model.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class NewRegister extends AppCompatActivity {

    private FirebaseAuth auth;
    FirebaseDatabase database;

    //Loading Progress Dialog
    ProgressDialog progressDialog;

    EditText etfirstn,etlastn,etemailsign,etpasssign;
    Button btnsignup;
      ImageView btnbacksign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        getSupportActionBar().hide();

        btnbacksign = findViewById(R.id.btnbacksign);
        btnsignup = findViewById(R.id.btnsignup);
        etfirstn = findViewById(R.id.etfirstn);
        etlastn = findViewById(R.id.etlastn);
        etemailsign = findViewById(R.id.etemailsign);
        etpasssign = findViewById(R.id.etpasssign);

        //Auth instance
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        //Progress Dialog

        progressDialog = new ProgressDialog(NewRegister.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");

        //Back Button

        btnbacksign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewRegister.this,LoginSignupMn.class));
            }
        });

        etemailsign.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!TextUtils.isEmpty(etpasssign.getText())|| !TextUtils.isEmpty(s))
                {
                    btnsignup.setEnabled(true);
                    btnsignup.setClickable(true);
                    btnsignup.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.glowlogbtn));
                }
                else
                {

                    btnsignup.setEnabled(false);
                    btnsignup.setClickable(false);
                    btnsignup.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.logbutton));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etpasssign.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!TextUtils.isEmpty(etemailsign.getText())|| !TextUtils.isEmpty(s))
                {
                    btnsignup.setEnabled(true);
                    btnsignup.setClickable(true);
                    btnsignup.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.glowlogbtn));
                }
                else
                {

                    btnsignup.setEnabled(false);
                    btnsignup.setClickable(false);
                    btnsignup.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.logbutton));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


       //Sign_Up Firebase Data Collection

       btnsignup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               progressDialog.show();

               auth.createUserWithEmailAndPassword(etemailsign.getText().toString().trim(),etpasssign.getText().toString().trim()
               ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful())
                       {
                           progressDialog.dismiss();
                           String userName = etfirstn.getText().toString().trim()+" "+etlastn.getText().toString().trim();


                           Users user = new Users(etemailsign.getText().toString().trim(),etpasssign.getText().toString().trim(),userName);
                           String id = task.getResult().getUser().getUid();
                           database.getReference().child("Users").child(id).setValue(user);

                           Toast.makeText(NewRegister.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(NewRegister.this,MainActivity.class));
                           finish();
                       }
                       else
                       {
                           progressDialog.dismiss();
                           Toast.makeText(NewRegister.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });
           }
       });

    }
}