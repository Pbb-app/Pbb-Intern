package com.riseinsteps.packbagbuddy.model;

import android.os.Bundle;

import com.riseinsteps.packbagbuddy.ExampleItem;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.adapter.RARAdapter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RulesAndRegulations extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_and_regulations);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem("1. You have to follow the instructions given by the instructors/leaders for your and other participants’ safety."
        ));
        exampleList.add(new ExampleItem("2. Do not misbehave with other participants. This will not be entertained and you will be banned from the current as well as from future trips plus a penalty will be charged."));
        exampleList.add(new ExampleItem("3. Accommodation is based on sharing based. As per the situation, accommodation may vary and participants need to cooperate with instructors and other participants."));
        exampleList.add(new ExampleItem("4. Keep the Camp site, rooms/tents neat and clean."));
        exampleList.add(new ExampleItem("5. Do not leave the Camp site/hotel without permission from instructor/leader."));
        exampleList.add(new ExampleItem("6. Take care of your valuable things. For any kind of missing items or valuables, PackBagBuddy shall not be responsible."));
        exampleList.add(new ExampleItem("7. If participant is found having any type of narcotic drugs, alcoholic items, tobacco items and smoking items during the trip, inside or outside the campsite, that will directly lead to cancellation of the participant and fees will not be refunded."));

        mRecyclerView = findViewById(R.id.tvRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RARAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}