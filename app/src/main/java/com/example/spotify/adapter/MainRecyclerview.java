package com.example.spotify.adapter;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotify.Model.AllCategory;
import com.example.spotify.Model.CategoryItems;
import com.example.spotify.R;

import java.util.List;

public class MainRecyclerview extends RecyclerView.Adapter<MainRecyclerview.MainViewHolder> {

    private Context context;
    private List<AllCategory> allCategoryList;
    private List<CategoryItems>categoryItemsListnmSingers;



    public MainRecyclerview(Context context, List<AllCategory> allCategoryList ) {
        this.context = context;
        this.allCategoryList = allCategoryList;

    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder,  int position) {

        holder.tvCat_title.setText(allCategoryList.get(position).getCategoryTitle());

        seCatItemsRecycler(holder.item_recycler,allCategoryList.get(position).getCategoryItemsList(),allCategoryList.get(position).getCategoryItemsListnmSingers());


    }




    @Override
    public int getItemCount() {
        return  allCategoryList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvCat_title;
        RecyclerView item_recycler;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCat_title  = itemView.findViewById(R.id.tvCat_title);
            item_recycler = itemView.findViewById(R.id.item_recycler);


        }


    }
    private void seCatItemsRecycler(RecyclerView recyclerView, List<CategoryItems> categoryItemsList , List<CategoryItems> categoryItemsListnmSingers)
    {
        CategoryItemRecyclerAdapter itemRecyclerAdapter = new CategoryItemRecyclerAdapter(context,categoryItemsList , categoryItemsListnmSingers);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter((itemRecyclerAdapter));
    }
}
