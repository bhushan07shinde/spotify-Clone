package com.example.spotify.Model;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.ModelClass;
import com.example.spotify.R;
import com.example.spotify.Songs_List;
import com.example.spotify.playSongs;

import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    MediaPlayer mediaPlayer;
    private List<ModelClass> userList;
    Context context;
    String playToSong;
      boolean flag = true;
       static boolean stopFlag = true;
       static int p=0;


    public void pause(View view)
    {
//        mediaPlayer = MediaPlayer.create(context, R.raw.one_bottle_down);
        mediaPlayer.pause();
    }


    public void play(View v , String x)
    {

        if(x.equals("One Bottle Down")) {
            mediaPlayer = MediaPlayer.create(context, R.raw.one_bottle_down);
            mediaPlayer.start();
        }
       else if(x.equals("Blue Eyes"))
        {
            mediaPlayer = MediaPlayer.create(context, R.raw.blue_eyes);
            mediaPlayer.start();
        }
        else if(x.equals("Habibi"))
        {
            mediaPlayer = MediaPlayer.create(context, R.raw.habibi_remix);
            mediaPlayer.start();
        }
//        if(x.equals("Brown Rangs"))
//        {
//
//        }
//        if(x.equals("Dheere Dheere"))
//        {
//
//        }
//        if(x.equals("Sunny Sunny"))
//        {
//
//        }
//        if(x.equals("Ankho Ankho"))
//        {
//
//        }
//        if(x.equals("Tere Sang Yara"))
//        {
//
//        }
//        if(x.equals("Jeena Jeena"))
//        {
//
//        }
//        if(x.equals("Dil Diya Gallan"))
//        {
//
//        }
//        if(x.equals("Paniyonsa"))
//    {
//
//    }
//        if(x.equals("Dil Meri Na Sune"))
//        {
//
//        }
//        if(x.equals("Dekhte Dekhte"))
//        {
//
//        }
//        if(x.equals("Nayan"))
//        {
//
//        }
//        if(x.equals("Vaste"))
//        {
//
//        }
//        if(x.equals("Mehndi"))
//        {
//
//        }
//        if(x.equals("Leja"))
//        {
//
//        }
//        if(x.equals("Dilbar"))
//        {
//
//        }
//        if(x.equals("Mukhada Vekh Ke"))
//        {
//
//        }
//        if(x.equals("Ve Mahi"))
//        {
//
//        }
//        if(x.equals("Khairiyat"))
//        {
//
//        }
//        if(x.equals("First Class"))
//        {
//
//        }
//        if(x.equals("Shayad"))
//        {
//
//        }
//        if(x.equals("Woh Din"))
//        {
//
//        }
//        if(x.equals("Ghungroo"))
//        {
//
//        }
//        if(x.equals("Suit Suit"))
//        {
//
//        }
//        if(x.equals("Patola"))
//        {
//
//        }
//        if(x.equals("Banja Tu Meri Rani"))
//        {
//
//        }
//        if(x.equals("Morani Banke"))
//        {
//
//        }
//        if(x.equals("Slowly Slowly"))
//        {
//
//        }
//        if(x.equals("Nain Bengali"))
//        {
//
//        }
//        if(x.equals("Mehrama"))
//        {
//
//        } if(x.equals("Hawa Banke"))
//    {
//
//    }
//        if(x.equals("Judayina"))
//        {
//
//        }
//        if(x.equals("Chogada"))
//        {
//
//        }
//        if(x.equals("See You Again"))
//        {
//
//        }
//        if(x.equals("Attention"))
//        {
//
//        }
//        if(x.equals("We Don't Talk"))
//        {
//
//        }
//        if(x.equals("One Dance"))
//        {
//
//        }
//        if(x.equals("Smiley Over The Top"))
//        {
//
//        }
//        if(x.equals("Give It Up"))
//        {
//
//        }
//        if(x.equals("Levitating"))
//        {
//
//        }
//        if(x.equals("No Lie"))
//        {
//
//        } if(x.equals("Shape Of You"))
//    {
//
//    }
//        if(x.equals("Summer Nights"))
//        {
//
//        }
//        if(x.equals("Stay"))
//        {
//
//        }
//        if(x.equals("Let Me Love You"))
//        {
//
//        }
//        if(x.equals("Sorry"))
//        {
//
//        }
//
//
//

    }
//

    public SongsAdapter(Context context,List<ModelClass> userList) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public SongsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_songs_row,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsAdapter.ViewHolder holder, int position) {
           String resourec = userList.get(position).getTvsongName();
           holder.setData(resourec);
           playToSong = userList.get(position).getTvsongName();


           holder.songnm.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {


                   Intent intent = new Intent(context, playSongs.class);
                   intent.putExtra("songName",resourec);
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intent);


//                   if(flag) {
//                       if(p==0) {
////                           mediaPlayer.reset();
//                           play(v, resourec);
//                           p++;
//                           flag = false;
//
//                       }
//                       else if(p>0)
//                       {
//                           mediaPlayer.stop();
//                           mediaPlayer.reset();
//                           play(v, resourec);
//                           flag=false;
//                           p=0;
//
//                       }
//                   }
//                   else if (!flag)
//                   {
//                       mediaPlayer.stop();
//                       mediaPlayer.reset();
//                       play(v,resourec);
//                       pause(v);
//                       flag=true;
//                   }
//                   p=0;


               }
           });



    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView songnm;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songnm = itemView.findViewById(R.id.tvsongName);





        }

        public void setData(String resourec) {
            songnm.setText(resourec);
        }
    }

    public String songName(String nameOfsong)
    {
        return nameOfsong;
    }


}
