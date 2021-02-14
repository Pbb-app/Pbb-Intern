package com.riseinsteps.packbagbuddy;

import android.os.Bundle;
import android.view.View;

import com.riseinsteps.packbagbuddy.adapter.AdventureTripAdapter;
import com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter;
import com.riseinsteps.packbagbuddy.adapter.PopularSportAdapter;
import com.riseinsteps.packbagbuddy.model.TripModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//home fragment
public class AllAdventureTripActivity extends AppCompatActivity
{
    private RecyclerView adventureTripRecyclerView1;
    private List<TripModel> adventureTripList;
    private AllAdventureTripAdapter  AllAdventureTripAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_adventure_trip);
        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Adventrous Trips");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setAdventureTripRecyclerview();
    }
    private void setAdventureTripRecyclerview() {
        adventureTripRecyclerView1 = findViewById(R.id.recyclerViewAdventrousTrips);
        adventureTripRecyclerView1.setHasFixedSize(true);
        adventureTripRecyclerView1.setLayoutManager(new LinearLayoutManager(this));

        adventureTripList = new ArrayList<>();
        adventureTripList.add(new TripModel("Kedarnath Tour", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath Tour", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath Tour", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath Tour", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath Tour", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath Tour", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        AllAdventureTripAdapter = new AllAdventureTripAdapter(adventureTripList);
        adventureTripRecyclerView1.setAdapter(AllAdventureTripAdapter);


    }

}