package com.riseinsteps.packbagbuddy.model;

import android.os.Bundle;

import com.riseinsteps.packbagbuddy.Caritem;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.adapter.CARAdapter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CancellationAndRefunds extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancellation_and_refunds);

        ArrayList<Caritem> exampleList = new ArrayList<>();
        exampleList.add(new Caritem(""));
        exampleList.add(new Caritem(""));
        exampleList.add(new Caritem(""));
        exampleList.add(new Caritem(""));
        exampleList.add(new Caritem(""));
        exampleList.add(new Caritem(""));
        exampleList.add(new Caritem(""));

        mRecyclerView = findViewById(R.id.MRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new CARAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}