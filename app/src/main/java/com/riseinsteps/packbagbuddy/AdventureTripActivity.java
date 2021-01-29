package com.riseinsteps.packbagbuddy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter;
import com.riseinsteps.packbagbuddy.model.TripModel;

import java.util.ArrayList;
import java.util.List;

public class AdventureTripActivity extends AppCompatActivity {
    private RecyclerView adventureTripRecycleView;
    private List<TripModel> modelList;
    private AllAdventureTripAdapter tripAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_trip);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setAllAdventureTripAdapter();
    }

    private void setAllAdventureTripAdapter()
    {


    }
}