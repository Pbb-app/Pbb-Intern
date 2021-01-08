package com.riseinsteps.packbagbuddy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter;
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;

import java.util.ArrayList;
import java.util.List;

public class AdventureTripActivity extends AppCompatActivity {
    private RecyclerView adventureTripRecycleView;
    private List<AdventureTripModel> modelList;
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

    private void setAllAdventureTripAdapter() {
        adventureTripRecycleView = findViewById(R.id.rv_all_adventure_trips);
        adventureTripRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        modelList = new ArrayList<>();

        modelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000, "OCt-NOV", 4.7f));
        modelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000, "OCt-NOV", 4.7f));
        modelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000, "OCt-NOV", 4.7f));
        modelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000, "OCt-NOV", 4.7f));
        modelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000, "OCt-NOV", 4.7f));
        modelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000, "OCt-NOV", 4.7f));
        modelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000, "OCt-NOV", 4.7f));
        modelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000, "OCt-NOV", 4.7f));
        modelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000, "OCt-NOV", 4.7f));


        tripAdapter = new AllAdventureTripAdapter(modelList);
        adventureTripRecycleView.setAdapter(tripAdapter);

    }
}