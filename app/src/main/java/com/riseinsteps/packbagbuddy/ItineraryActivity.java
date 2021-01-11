package com.riseinsteps.packbagbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.riseinsteps.packbagbuddy.adapter.ExampleAdapter;

import java.util.ArrayList;

public class ItineraryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem("Line 1"));
        exampleList.add(new ExampleItem("Line 2"));
        exampleList.add(new ExampleItem("Line 3"));
        exampleList.add(new ExampleItem("Line 4"));
        exampleList.add(new ExampleItem("Line 5"));
        exampleList.add(new ExampleItem("Line 6"));
        exampleList.add(new ExampleItem("Line 7"));
        exampleList.add(new ExampleItem("Line 8"));
        exampleList.add(new ExampleItem("Line 9"));
        exampleList.add(new ExampleItem("Line 10"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}