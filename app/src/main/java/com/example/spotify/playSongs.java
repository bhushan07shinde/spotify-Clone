package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class playSongs extends AppCompatActivity {

    TextView songnm;
    ImageView playsong,prevsong,nextsong;
    SeekBar SeekBar;
    MediaPlayer mediaPlayer;
    int currentIndex=0;
    int songID;
    String nameOfsong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_songs);
        songnm = findViewById(R.id.tvsongnm);
        playsong = findViewById(R.id.imgplay);
        prevsong = findViewById(R.id.imgprev);
        nextsong = findViewById(R.id.imgnext);
        SeekBar = findViewById(R.id.seekBar);

        getSupportActionBar().hide();

//        songnm.setText(getIntent().getStringExtra("songName"));
        nameOfsong = getIntent().getStringExtra("songName");
//    songnm.getText().toString();
        ArrayList<Integer> songs = new ArrayList<>();
        if (nameOfsong.equals("One Bottle Down") || nameOfsong.equals("Blue Eyes") || nameOfsong.equals("Brown Rangs") || nameOfsong.equals("Dheere Dheere") || nameOfsong.equals("Sunny Sunny") || nameOfsong.equals("Ankho Ankho")) {

            songs.add(0, R.raw.one_bottle_down);
            songs.add(1, R.raw.blue_eyes);
            songs.add(2, R.raw.brown_rang);
            songs.add(3, R.raw.dheere_dheere);
            songs.add(4, R.raw.sunny_sunny);
            songs.add(5, R.raw.ankho_ankho);

        }
     else   if (nameOfsong.equals("Tere Sang Yara") || nameOfsong.equals("Jeena Jeena") || nameOfsong.equals("Dil Diya Gallan") || nameOfsong.equals("Paniyonsa") || nameOfsong.equals("Dil Meri Na Sune") || nameOfsong.equals("Dekhte Dekhte")) {
        songs.add(0,R.raw.tere_sang_yara);
        songs.add(1,R.raw.jeena_jeena);
        songs.add(2,R.raw.dil_diya_galan);
        songs.add(3,R.raw.paniyon_sa);
        songs.add(4,R.raw.dil_meri_na_sune);
        songs.add(5,R.raw.dekhte_dekhte);
//
        } else if (nameOfsong.equals("Mukhada Vekh Ke") || nameOfsong.equals("Dilbar") || nameOfsong.equals("Leja") || nameOfsong.equals("Mehndi") || nameOfsong.equals("Vaste") || nameOfsong.equals("Nayan")) { songs.add(0,R.raw.nayan);
        songs.add(1,R.raw.vaste);
        songs.add(2,R.raw.mehandi);
        songs.add(3,R.raw.leja_re);
        songs.add(4,R.raw.dilbar);
        songs.add(5,R.raw.mukhada);
        } else if (nameOfsong.equals("Ve Mahi") || nameOfsong.equals("Khairiyat") || nameOfsong.equals("First Class") || nameOfsong.equals("Shayad") || nameOfsong.equals("Woh Din") || nameOfsong.equals("Ghungroo"))
        {
        songs.add(0,R.raw.ve_mahi);
        songs.add(1,R.raw.khairiyat);
        songs.add(2,R.raw.first_class);
        songs.add(3,R.raw.shayad);
        songs.add(4,R.raw.woh_din);
        songs.add(5,R.raw.ghungroo);
//
    }
    else if (nameOfsong.equals("Suit Suit") || nameOfsong.equals("Patola") || nameOfsong.equals("Banja Tu Meri Rani") || nameOfsong.equals("Morani Banke") || nameOfsong.equals("Slowly Slowly") || nameOfsong.equals("Nain Bengali")) {
        songs.add(0,R.raw.suit_suit);
        songs.add(1,R.raw.patola);
        songs.add(2,R.raw.ban_ja_tu_meri_rani);
        songs.add(3,R.raw.morni_banke);
        songs.add(4,R.raw.slowly_slowly);
        songs.add(5,R.raw.nain_bengali);
//
        }
        else if (nameOfsong.equals("Mehrama") || nameOfsong.equals("Hawa Banke") || nameOfsong.equals("Judayina") || nameOfsong.equals("Chogada") ) {
//
        songs.add(0,R.raw.mehrma);
        songs.add(1,R.raw.hawa_banke);
        songs.add(2,R.raw.judayiyaan);
        songs.add(3,R.raw.chogada);
//
        }
        else if ( nameOfsong.equals("We Don't Talk") || nameOfsong.equals("Attention") || nameOfsong.equals("See You Again") ) {
//
        songs.add(0,R.raw.see_you_again);
        songs.add(1,R.raw.attention);
        songs.add(2,R.raw.we_dont_talk_anymore);
//
        }
        else if ( nameOfsong.equals("Give It Up") || nameOfsong.equals("Smiley Over The Top") || nameOfsong.equals("One Dance") ) {
//
        songs.add(0,R.raw.one_dance);
        songs.add(1,R.raw.smiley);
        songs.add(2,R.raw.give_it_up);
//
        }

        else if (nameOfsong.equals("No Lie") || nameOfsong.equals("Levitating") ) {
        songs.add(0,R.raw.levitating);
        songs.add(1,R.raw.no_lie);
//
        }

        else if (nameOfsong.equals("Despacito") || nameOfsong.equals("Con Calma") || nameOfsong.equals("Dura")  ) {
        songs.add(0,R.raw.despacito);
        songs.add(1,R.raw.con_calma);
        songs.add(2,R.raw.dura);
        }
        else if (nameOfsong.equals("Shape Of You") || nameOfsong.equals("Summer Nights") ) {
        songs.add(0,R.raw.shape_of_you);
        songs.add(1,R.raw.summer_nights);
//
        }
        else if ( nameOfsong.equals("Sorry") || nameOfsong.equals("Let Me Love You") || nameOfsong.equals("Stay") ) {
        songs.add(0,R.raw.stay);
        songs.add(1,R.raw.let_me_love_you);
        songs.add(2,R.raw.sorry);
        songs.add(3,R.raw.baby);
        }
        else if(nameOfsong.equals("SubhanAllah") || nameOfsong.equals("Kabira") || nameOfsong.equals("Ilahi") || nameOfsong.equals("Diliwali Girlfriend") || nameOfsong.equals("Balam Pichcari") || nameOfsong.equals("Badtamiz Dil")) {
//
        songs.add(0,R.raw.badtamiz_dil);
        songs.add(1,R.raw.balam_pichkari);
        songs.add(2,R.raw.dilliwali_gf);
        songs.add(3,R.raw.ilahi);
        songs.add(4,R.raw.kabira);
        songs.add(5,R.raw.subhanallah);
//
        }
        else if (nameOfsong.equals("Nashe Si Chadgayi") || nameOfsong.equals("Ude Dil") || nameOfsong.equals("You And Me")  ) {
//
        songs.add(0,R.raw.nashe_si_chad_gayi);
        songs.add(1,R.raw.ude_dil);
        songs.add(2,R.raw.you_and_me);

        }
//
//
        else if (nameOfsong.equals("Sun Raha Hain Na") || nameOfsong.equals("Meri Aashiqui") || nameOfsong.equals("Tum Hi Ho")  ) {
        songs.add(0,R.raw.dildaara);
        songs.add(1,R.raw.chammak_challo);
        songs.add(2,R.raw.criminal);
        songs.add(3,R.raw.raftarein);
        }
//

//
        else if (nameOfsong.equals("Lonely") || nameOfsong.equals("Hookah Bar") || nameOfsong.equals("Long Drive")  ) {
        songs.add(0,R.raw.hookabar);
        songs.add(1,R.raw.long_drive);
        songs.add(2,R.raw.khiladi_title_track);
//
        }
//
//
        else if (nameOfsong.equals("Ghungrooo") || nameOfsong.equals("Jai Jai Shiv shankar") ) {
        songs.add(0,R.raw.ghungroo);
        songs.add(1,R.raw.jai_jai_shivshankar);
//
        }
//
        else if (nameOfsong.equals("Ola La") || nameOfsong.equals("She Move It Like [Slowed]") || nameOfsong.equals("Chokra Jawan") || nameOfsong.equals("Often Remix") || nameOfsong.equals("Sterio X Zalima") || nameOfsong.equals("I Like Me")) {
        songs.add(0,R.raw.i_like_me_better);
        songs.add(1,R.raw.sterio_x_zalima);
        songs.add(2,R.raw.often_remix);
        songs.add(3,R.raw.chokra_jawn);
        songs.add(4,R.raw.she_move_it_like_slowed);
        songs.add(5,R.raw.ola_la);
//
        }
//
        else if (nameOfsong.equals("Habibi") || nameOfsong.equals("One Dance_") || nameOfsong.equals("IndustriBaby") || nameOfsong.equals("Kolaveri D x Industri Baby") || nameOfsong.equals("Sickick")  ) {
        songs.add(0,R.raw.habibi_remix);
        songs.add(1,R.raw.one_dance);
            songs.add(2, R.raw.industry_beaby);
        songs.add(3,R.raw.kolaveri_x_industri_beaby);
        songs.add(4,R.raw.sickick);
        }
//
        else if (nameOfsong.equals("Best Of 2021 Mashup") || nameOfsong.equals("Love Mashup") ) {
        songs.add(0,R.raw.best_2021_mashup);
        songs.add(1,R.raw.bollywood_love_mashup);
//
        }

        mediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));


        playsong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SeekBar.setMax(mediaPlayer.getDuration());
                if(mediaPlayer!=null&&mediaPlayer.isPlaying())
                {

                    mediaPlayer.pause();
                    playsong.setImageResource(R.drawable.play_song_24);
            }
                else
                {
                    mediaPlayer.start();
                    playsong.setImageResource(R.drawable.paus_song_24);
                }
            }
        });

        nextsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currentIndex==songs.size()-1)
                {
                    currentIndex=0;
                    System.out.println("Array Index====>"+currentIndex);
                }
                if(mediaPlayer!=null)
                {
                    playsong.setImageResource(R.drawable.paus_song_24);
                }
                if(currentIndex<=songs.size())
                {
                    currentIndex++;
                    System.out.println("Array Index====>"+songs.size());

                }
                else
                {
                    currentIndex=0;
                    System.out.println("Array Index====>"+currentIndex);
                }
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                mediaPlayer=MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
                mediaPlayer.start();
            }
        });

        prevsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null)
                {
                    playsong.setImageResource(R.drawable.paus_song_24);
                }
                if(currentIndex>0)
                {
                    currentIndex--;
                }
                else
                {
                    currentIndex = songs.size()-1;
                }
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                mediaPlayer=MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
                mediaPlayer.start();
            }
        });

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                SeekBar.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
            }
        });

        SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                {
                    mediaPlayer.seekTo(progress);
                    SeekBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer!=null)
                {
                    try {
                        if(mediaPlayer.isPlaying())
                        {
                            Message message = new Message();

                            message.what=mediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

@SuppressLint("Handler leak")
    Handler handler=new Handler(){
    public void handleMessage(Message msg)
    {
        SeekBar.setProgress(msg.what);
    }

    };

    int count=0;
    @Override
    public void onBackPressed() {
//        super.onBackPressed();


        count++;
        if(!mediaPlayer.isPlaying())
        {
            super.onBackPressed();
        }
        else
        {
            Toast.makeText(this, "Note:-  Please Stop The Song Before Going Back.......!", Toast.LENGTH_SHORT).show();
        }
    }
}