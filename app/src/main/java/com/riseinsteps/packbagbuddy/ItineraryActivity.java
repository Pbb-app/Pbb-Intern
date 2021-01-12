package com.riseinsteps.packbagbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.riseinsteps.packbagbuddy.adapter.ItineraryAdapter;
import com.riseinsteps.packbagbuddy.model.ItineraryModel;

import java.util.ArrayList;

public class ItineraryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);

        ArrayList<ItineraryModel> exampleList = new ArrayList<>();
        exampleList.add(new ItineraryModel("Line 1"));
        exampleList.add(new ItineraryModel("Line 2"));
        exampleList.add(new ItineraryModel("Line 3"));
        exampleList.add(new ItineraryModel("Line 4"));
        exampleList.add(new ItineraryModel("Line 5"));
        exampleList.add(new ItineraryModel("Line 6"));
        exampleList.add(new ItineraryModel("Line 7"));
        exampleList.add(new ItineraryModel("Line 8"));
        exampleList.add(new ItineraryModel("Line 9"));
        exampleList.add(new ItineraryModel("Line 10"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItineraryAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}