package com.riseinsteps.packbagbuddy;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class PopularSportDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_sport_detail);
         toolbar= findViewById(R.id.include_toolbar);
         getSupportActionBar();
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tour Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}