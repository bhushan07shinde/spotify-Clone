package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.spotify.Model.SongsAdapter;

import java.util.ArrayList;
import java.util.List;


public class Songs_List extends AppCompatActivity {

    MediaPlayer mediaPlayer;


    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SongsAdapter songs;

    List<ModelClass>userList;

    SongsAdapter adapter;

    ImageView singPic,backText;
    TextView singNm,tvsongName;
    String songtitle;
   String SongToPlay;


    public void play(View view)
    {
        mediaPlayer.start();
    }
    public void pause(View view)
    {
        mediaPlayer.pause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
        singPic=findViewById(R.id.imgPicsing);
        singNm=findViewById(R.id.tvsingnm);
        backText = findViewById(R.id.backtext);
        tvsongName = findViewById(R.id.tvsongName);

        getSupportActionBar().hide();
//        mediaPlayer = MediaPlayer.create(this, R.raw.one_bottle_down);

        singPic.setImageResource(getIntent().getIntExtra("imgname",0));
        singNm.setText(getIntent().getStringExtra("albname"));

        singNm.setText(getIntent().getStringExtra("albname"));

        songtitle=singNm.getText().toString();

//        SongToPlay = getIntent().getStringExtra("playtoSong").toString();



        initData();

        initRecyclerView();

        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Songs_List.this,MainActivity.class));

            }
        });




    }

    private void initData() {




        userList = new ArrayList<>();






        if(songtitle.equals("Honey Sing")) {

            userList.add(new ModelClass("One Bottle Down"));
            userList.add(new ModelClass("Blue Eyes"));
            userList.add(new ModelClass("Brown Rangs"));
            userList.add(new ModelClass("Dheere Dheere"));
            userList.add(new ModelClass("Sunny Sunny"));
            userList.add(new ModelClass("Ankho Ankho"));
        }
      else  if(songtitle.equals("Atif Aslam")) {
            //Atif

            userList.add(new ModelClass("Tere Sang Yara"));
            userList.add(new ModelClass("Jeena Jeena"));
            userList.add(new ModelClass("Dil Diya Gallan"));
            userList.add(new ModelClass("Paniyonsa"));
            userList.add(new ModelClass("Dil Meri Na Sune"));
            userList.add(new ModelClass("Dekhte Dekhte"));
        }
        //Dhawni
      else  if(songtitle.equals("Dhavni Bhanushali")) {
            userList.add(new ModelClass("Nayan"));
            userList.add(new ModelClass("Vaste"));
            userList.add(new ModelClass("Mehndi"));
            userList.add(new ModelClass("Leja"));
            userList.add(new ModelClass("Dilbar"));
            userList.add(new ModelClass("Mukhada Vekh Ke"));
        }
      else  if(songtitle.equals("Arijit Sing")) {
            // Arijit

            userList.add(new ModelClass("Ve Mahi"));
            userList.add(new ModelClass("Khairiyat"));
            userList.add(new ModelClass("First Class"));
            userList.add(new ModelClass("Shayad"));
            userList.add(new ModelClass("Woh Din"));
            userList.add(new ModelClass("Ghungroo"));
        }

       else if(songtitle.equals("Guru Randhawa")) {
            //Guru

            userList.add(new ModelClass("Suit Suit"));
            userList.add(new ModelClass("Patola"));
            userList.add(new ModelClass("Banja Tu Meri Rani"));
            userList.add(new ModelClass("Morani Banke"));
            userList.add(new ModelClass("Slowly Slowly"));
            userList.add(new ModelClass("Nain Bengali"));
        }
       else if(songtitle.equals("Darshan Raval")) {
            //Darshan

            userList.add(new ModelClass("Mehrama"));
            userList.add(new ModelClass("Hawa Banke"));
            userList.add(new ModelClass("Judayina"));
            userList.add(new ModelClass("Chogada"));
        }
      else  if(songtitle.equals("Charlie Puth")) {
            //charli
            userList.add(new ModelClass("See You Again"));
            userList.add(new ModelClass("Attention"));
            userList.add(new ModelClass("We Don't Talk"));
        }
      else  if(songtitle.equals("Drake")) {
            // drake
            userList.add(new ModelClass("One Dance"));
            userList.add(new ModelClass("Smiley Over The Top"));
            userList.add(new ModelClass("Give It Up"));
        }
      else  if(songtitle.equals("Dua Lipa")) {
            //Dua

            userList.add(new ModelClass("Levitating"));
            userList.add(new ModelClass("No Lie"));
        }
     else   if(songtitle.equals("Ed Sheeran")) {
            //ed shree

            userList.add(new ModelClass("Shape Of You"));
            userList.add(new ModelClass("Summer Nights"));
        }
      else  if(songtitle.equals("Justin Bieber")) {
            //justin

            userList.add(new ModelClass("Stay"));
            userList.add(new ModelClass("Let Me Love You"));
            userList.add(new ModelClass("Sorry"));
            userList.add(new ModelClass("Baby"));
        }
      else  if(songtitle.equals("Daddy Yankee")) {
            //yanke


            userList.add(new ModelClass("Despacito"));
            userList.add(new ModelClass("Con Calma"));
            userList.add(new ModelClass("Dura"));
        }
      else  if(songtitle.equals("Yeh Jawaani Hai Deewani")) {
            //yeh jawani
            userList.add(new ModelClass("Badtamiz Dil"));
            userList.add(new ModelClass("Balam Pichcari"));
            userList.add(new ModelClass("Diliwali Girlfriend"));
            userList.add(new ModelClass("Ilahi"));
            userList.add(new ModelClass("Kabira"));
            userList.add(new ModelClass("SubhanAllah"));
        }
       else if(songtitle.equals("Befikre")) {
            //befikre
            userList.add(new ModelClass("Nashe Si Chadgayi"));
            userList.add(new ModelClass("Ude Dil"));
            userList.add(new ModelClass("You And Me"));
        }
      else  if(songtitle.equals("Aashiqui 2")) {
            //aashiqui

            userList.add(new ModelClass("Sun Raha Hain Na"));
            userList.add(new ModelClass("Meri Aashiqui"));
            userList.add(new ModelClass("Tum Hi Ho"));
        }
       else if(songtitle.equals("Ra-One")) {
            //raone

            userList.add(new ModelClass("Dildara"));
            userList.add(new ModelClass("Chamak Challo"));
            userList.add(new ModelClass("Criminal"));
            userList.add(new ModelClass("Raftarein"));
        }
       else if(songtitle.equals("War"))
        {
            userList.add(new ModelClass("Ghungrooo"));
            userList.add(new ModelClass("Jai Jai Shiv shankar"));
        }
       else if(songtitle.equals("My Own Playlist")) {
            //own
            userList.add(new ModelClass("I Like Me"));
            userList.add(new ModelClass("Sterio X Zalima"));
            userList.add(new ModelClass("Often Remix"));
            userList.add(new ModelClass("Chokra Jawan"));
            userList.add(new ModelClass("She Move It Like [Slowed]"));
            userList.add(new ModelClass("Ola La"));
        }
       else if(songtitle.equals("Insta Reels Songs")) {
            //Insta reels

            userList.add(new ModelClass("Habibi"));
            userList.add(new ModelClass("One Dance_"));

            userList.add(new ModelClass("IndustriBaby"));
            userList.add(new ModelClass("Kolaveri D x Industri Baby"));
            userList.add(new ModelClass("Sickick"));

        }
        else if(songtitle.equals("Remixes")) {
            //remix
            userList.add(new ModelClass("Best Of 2021 Mashup"));
            userList.add(new ModelClass("Love Mashup"));
        }
        else
        {

            userList.add(new ModelClass("Hookah Bar"));
            userList.add(new ModelClass("Long Drive"));
            userList.add(new ModelClass("Lonely"));
        }
    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.songsNM_recycler);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SongsAdapter(this,userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    public void onBackPressed() {
////        super.onBackPressed();
////        int pid = android.os.Process.myPid();
////        moveTaskToBack(true);
////        android.os.Process.killProcess(pid);
////        System.exit(1);
//////        finish();
        startActivity(new Intent(Songs_List.this,MainActivity.class));
//        stopService(new Intent());
//        finishAffinity();

//        onDestroy();
//        startActivity(new Intent(Songs_List.this,MainActivity.class));
    }


}



