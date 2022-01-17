package com.example.spotify.adapter;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.MainActivity;
import com.example.spotify.Model.CategoryItems;
import com.example.spotify.R;
import com.example.spotify.Songs_List;

import java.io.ObjectInputStream;
import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemHolder> {


    public  Context  context;
    private List<CategoryItems> categoryItemsList;
    List<CategoryItems>categoryItemsListnmSingers;
    public static int x=0;





    public CategoryItemRecyclerAdapter(Context context, List<CategoryItems> categoryItemsList, List<CategoryItems>categoryItemsListnmSingers)  {
        this.context = context;
        this.categoryItemsList = categoryItemsList;
        this.categoryItemsListnmSingers = categoryItemsListnmSingers;
    }

    @NonNull
    @Override
    public CategoryItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemHolder(LayoutInflater.from(context).inflate(R.layout.category_row_itms,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemHolder holder, @SuppressLint("RecyclerView") int position)  {

        holder.img_album.setImageResource(categoryItemsList.get(position).getImageUrl());
        holder.tvSingersNM.setText(categoryItemsListnmSingers.get(position).getSingersName());



        int name= categoryItemsList.get(position).getImageUrl();
        String singerNm = categoryItemsListnmSingers.get(position).getSingersName().toString();

        x=categoryItemsList.get(position).getItemId();
        System.out.println("Value of X :- :"+x);
        System.out.println("Path of Img name :- "+name);
        System.out.println("position of img :- "+position);

        holder.img_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(categoryItemsList.get(position).getItemId()==56)
//                {
                    Intent intent = new Intent(context,Songs_List.class);
                    intent.putExtra("imgname",name);
                    intent.putExtra("albname",singerNm);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

//                }
//                Toast.makeText(context, "heloo "+categoryItemsList.get(position).getItemId(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return categoryItemsList.size();
    }



    public static final class CategoryItemHolder extends RecyclerView.ViewHolder
    {

        ImageView img_album;
        TextView tvSingersNM;
//implements View.OnClickListener


        public CategoryItemHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this);
            img_album = itemView.findViewById(R.id.img_album);
            tvSingersNM = itemView.findViewById(R.id.tvSingersNM);
//            img_album.setOnClickListener(this);

        }

//        @Override
//        public void onClick(View v) {
//
//            int position=this.getPosition();
////            long x = this.getItemId();
//            img_album.getId();
////            int pos=categoryItemsList.get(position).getItemId();
//
//
//
////            int resId = this.getResources().getIdentifier("imageNameHere", "drawable", this.getPackageName());
//            Toast.makeText(v.getContext(), "item Clicked"+String.valueOf(position)+" "+x, Toast.LENGTH_SHORT).show();
////            x=0;
//        }
    }
}
