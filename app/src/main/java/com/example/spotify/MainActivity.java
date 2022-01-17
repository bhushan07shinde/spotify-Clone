package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.spotify.Model.AllCategory;
import com.example.spotify.Model.CategoryItems;
import com.example.spotify.adapter.MainRecyclerview;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    MainRecyclerview mainRecyclerview;


    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        // some dummy data for recyler view

        // Data For Category item model




        List<CategoryItems> categoryItemsList = new ArrayList<>();
        categoryItemsList.add(new CategoryItems(11, R.drawable.honey_sing));
        categoryItemsList.add(new CategoryItems(12,R.drawable.atif_aslam));
        categoryItemsList.add(new CategoryItems(13,R.drawable.dhawni_bhanushali));
        categoryItemsList.add(new CategoryItems(14,R.drawable.arijit_sing));
        categoryItemsList.add(new CategoryItems(15,R.drawable.guru_randhawa));
        categoryItemsList.add(new CategoryItems(16,R.drawable.darshan_rawal));

        // Singers Nam

        List<CategoryItems> categoryItemsList11 = new ArrayList<>();
        categoryItemsList11.add(new CategoryItems("Honey Sing"));
        categoryItemsList11.add(new CategoryItems("Atif Aslam"));
        categoryItemsList11.add(new CategoryItems("Dhavni Bhanushali"));
        categoryItemsList11.add(new CategoryItems("Arijit Sing"));
        categoryItemsList11.add(new CategoryItems("Guru Randhawa"));
        categoryItemsList11.add(new CategoryItems("Darshan Raval"));

        List<CategoryItems> categoryItemsList2 = new ArrayList<>();
        categoryItemsList2.add(new CategoryItems(21,R.drawable.charlie_putth));
        categoryItemsList2.add(new CategoryItems(22,R.drawable.drake));
        categoryItemsList2.add(new CategoryItems(23,R.drawable.dua_lipa));
        categoryItemsList2.add(new CategoryItems(24,R.drawable.daddy_yanke));
        categoryItemsList2.add(new CategoryItems(25,R.drawable.ed_shreen));
        categoryItemsList2.add(new CategoryItems(26,R.drawable.justin));

        // Singers nm

        List<CategoryItems> categoryItemsList12 = new ArrayList<>();
        categoryItemsList12.add(new CategoryItems("Charlie Puth"));
        categoryItemsList12.add(new CategoryItems("Drake"));
        categoryItemsList12.add(new CategoryItems("Dua Lipa"));
        categoryItemsList12.add(new CategoryItems("Daddy Yankee"));
        categoryItemsList12.add(new CategoryItems("Ed Sheeran"));
        categoryItemsList12.add(new CategoryItems("Justin Bieber"));

        List<CategoryItems> categoryItemsList3 = new ArrayList<>();
        categoryItemsList3.add(new CategoryItems(31,R.drawable.jeh_jawani_hain_dewami));
        categoryItemsList3.add(new CategoryItems(32,R.drawable.befikre));
        categoryItemsList3.add(new CategoryItems(33,R.drawable.aashiqu2));
        categoryItemsList3.add(new CategoryItems(34,R.drawable.ra_one));
        categoryItemsList3.add(new CategoryItems(35,R.drawable.khiladi_786));
        categoryItemsList3.add(new CategoryItems(36,R.drawable.war));


        // singers nm


        List<CategoryItems> categoryItemsList13 = new ArrayList<>();
        categoryItemsList13.add(new CategoryItems("Yeh Jawaani Hai Deewani"));
        categoryItemsList13.add(new CategoryItems("Befikre"));
        categoryItemsList13.add(new CategoryItems("Aashiqui 2"));
        categoryItemsList13.add(new CategoryItems("Ra-One"));
        categoryItemsList13.add(new CategoryItems("Khiladi 786"));
        categoryItemsList13.add(new CategoryItems("War"));


        List<CategoryItems> categoryItemsList4 = new ArrayList<>();
        categoryItemsList4.add(new CategoryItems(41,R.drawable.own_playlist));
        categoryItemsList4.add(new CategoryItems(42,R.drawable.insta_reels));
        categoryItemsList4.add(new CategoryItems(43,R.drawable.remix));
        //singers nm

        List<CategoryItems> categoryItemsList14 = new ArrayList<>();
        categoryItemsList14.add(new CategoryItems("My Own Playlist"));
        categoryItemsList14.add(new CategoryItems("Insta Reels Songs"));
        categoryItemsList14.add(new CategoryItems("Remixes"));


        List<CategoryItems> categoryItemsList5 = new ArrayList<>();
        categoryItemsList5.add(new CategoryItems(51,R.drawable.jeh_jawani_hain_dewami));
        categoryItemsList5.add(new CategoryItems(52,R.drawable.befikre));
        categoryItemsList5.add(new CategoryItems(53,R.drawable.aashiqu2));
        categoryItemsList5.add(new CategoryItems(54,R.drawable.ra_one));
        categoryItemsList5.add(new CategoryItems(55,R.drawable.khiladi_786));
        categoryItemsList5.add(new CategoryItems(56,R.drawable.war));

        //singers nm


//        List<CategoryItems> categoryItemsList15 = new ArrayList<>();
//        categoryItemsList15.add(new CategoryItems("Yeh Jawaani Hai Deewani"));
//        categoryItemsList15.add(new CategoryItems("Befikre"));
//        categoryItemsList15.add(new CategoryItems("Aashiqui 2"));
//        categoryItemsList15.add(new CategoryItems("Ra-One"));
//        categoryItemsList15.add(new CategoryItems("Khiladi 786"));
//        categoryItemsList15.add(new CategoryItems("War"));
//
        List<AllCategory>allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Top Artist",categoryItemsList,categoryItemsList11));
        allCategoryList.add(new AllCategory("International Hits",categoryItemsList2,categoryItemsList12));
        allCategoryList.add(new AllCategory("Bollywood Blast",categoryItemsList3,categoryItemsList13));
        allCategoryList.add(new AllCategory("CHILL-PILL",categoryItemsList4,categoryItemsList14));
//        allCategoryList.add(new AllCategory("Testing",categoryItemsList5,categoryItemsList15));



        setMainCategoryRecycler(allCategoryList);


    }


    //Back Button

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        int pid = android.os.Process.myPid();
        moveTaskToBack(true);
        android.os.Process.killProcess(pid);
        System.exit(1);
//        finish();
    }

    private void setMainCategoryRecycler(List<AllCategory>allCategoryList)
    {
        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerview = new MainRecyclerview(this,allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerview);

        System.out.println("ROM :- "+allCategoryList);
    }



}