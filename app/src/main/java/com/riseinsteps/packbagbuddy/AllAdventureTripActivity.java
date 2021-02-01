package com.riseinsteps.packbagbuddy;

import android.os.Bundle;
import android.view.View;

import com.riseinsteps.packbagbuddy.adapter.AdventureTripAdapter;
import com.riseinsteps.packbagbuddy.adapter.PopularSportAdapter;
import com.riseinsteps.packbagbuddy.model.TripModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//home fragment
public class AllAdventureTripActivity extends AppCompatActivity
{
    private RecyclerView adventureTripRecyclerView;
    private List<TripModel> adventureTripList;
    private AdventureTripAdapter adventureTripAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_adventure_trip);
        setAdventureTripRecyclerview();
    }
    private void setAdventureTripRecyclerview() {
        adventureTripRecyclerView = findViewById(R.id.recyclerViewAdventrousTrips);
        adventureTripRecyclerView.setHasFixedSize(true);
        adventureTripRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adventureTripList = new ArrayList<>();
        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        adventureTripAdapter = new AdventureTripAdapter(adventureTripList);
        adventureTripRecyclerView.setAdapter(adventureTripAdapter);


    }

}