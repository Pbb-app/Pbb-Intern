package com.riseinsteps.packbagbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.riseinsteps.packbagbuddy.adapter.TripDetailsAdapter;
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;

import java.util.ArrayList;
import java.util.List;

import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.AVAILABILITYMONTH;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.DAYS;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPNAME;

public class AdventureTripDetailActivity extends AppCompatActivity {

    private ViewPager TripViewPager;
    private List<AdventureTripModel> modelList;
    private TripDetailsAdapter tripDetailsAdapter;

    private TextView tripName, days, availabilityMonth, startingLocation, destination, minimumAge, totalSeats, quickFacts,
            placesToVisit, accommodation, meals, transportation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_trip_detail);

        setTripViewPager();

        tripName = findViewById(R.id.tv_rip_detail_name);
        days = findViewById(R.id.tv_trip_detail_num_of_days);
        availabilityMonth = findViewById(R.id.tv_trip_detail_availability);
        startingLocation = findViewById(R.id.tv_trip_detail_starting_location);
        destination = findViewById(R.id.tv_trip_detail_destination);
        minimumAge = findViewById(R.id.tv_trip_detail_min_age);
        totalSeats = findViewById(R.id.tv_trip_detail_total_seats);
        quickFacts = findViewById(R.id.tv_trip_detail_quick_facts);
        placesToVisit = findViewById(R.id.tv_trip_detail_places_to_visit);
        accommodation = findViewById(R.id.tv_trip_detail_accommodation);
        meals = findViewById(R.id.tv_trip_detail_meals);
        transportation = findViewById(R.id.tv_trip_detail_transportation);


        tripName.setText(getIntent().getStringExtra(TRIPNAME));
        days.setText(getIntent().getStringExtra(DAYS));
        days.setText(getIntent().getStringExtra(DAYS));
        availabilityMonth.setText(getIntent().getStringExtra(AVAILABILITYMONTH));
        startingLocation.setText(getIntent().getStringExtra(DAYS));
        destination.setText(getIntent().getStringExtra(DAYS));
        minimumAge.setText(getIntent().getStringExtra(DAYS));
        totalSeats.setText(getIntent().getStringExtra(DAYS));
        quickFacts.setText(getIntent().getStringExtra(DAYS));
        placesToVisit.setText(getIntent().getStringExtra(DAYS));
        accommodation.setText(getIntent().getStringExtra(DAYS));
        meals.setText(getIntent().getStringExtra(DAYS));
        transportation.setText(getIntent().getStringExtra(DAYS));

    }

    private void setTripViewPager() {
        TripViewPager = findViewById(R.id.vp_trip_gallery);
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

        tripDetailsAdapter = new TripDetailsAdapter(modelList);
        TripViewPager.setAdapter(tripDetailsAdapter);
    }
}