package com.riseinsteps.packbagbuddy;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.riseinsteps.packbagbuddy.adapter.OtherTourDetailsAdapter;
import com.riseinsteps.packbagbuddy.adapter.TourDetailsAdapter;
import com.riseinsteps.packbagbuddy.adapter.TripDetailsAdapter;
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;
import com.riseinsteps.packbagbuddy.model.OtherTourDetailsModel;
import com.riseinsteps.packbagbuddy.model.TourDetailsModel;

import java.util.ArrayList;
import java.util.List;

import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPNAME;

public class AdventureTripDetailActivity extends AppCompatActivity {

    private ViewPager TripViewPager;
    private List<AdventureTripModel> modelList;
    private TripDetailsAdapter tripDetailsAdapter;

    private RecyclerView tourDetailsRecyclerView;
    private List<TourDetailsModel> tourDetailsModelList;
    private TourDetailsAdapter tourDetailsAdapter;

    private RecyclerView otherTourDetailsRecyclerView;
    private List<OtherTourDetailsModel> otherTourDetailsModelList;
    private OtherTourDetailsAdapter otherTourDetailsAdapter;

    private TextView tripName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_trip_detail);

        setTripViewPager();

        tripName.setText(getIntent().getStringExtra(TRIPNAME));


        setTourDetailsRecyclerVie();

        setOtherTourDetailsRecyclerView();

    }

    private void setOtherTourDetailsRecyclerView() {
        otherTourDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        otherTourDetailsModelList = new ArrayList<>();
        otherTourDetailsModelList.add(new OtherTourDetailsModel("Tour Duration", "5 Days, 4 Nights"));
        otherTourDetailsModelList.add(new OtherTourDetailsModel("Places to Visit", "1. GuptKashi\n2. Vishwanath Temple\n" +
                "3. Manikarnik Kund\n4. Kedarnath Temple"));
        otherTourDetailsModelList.add(new OtherTourDetailsModel("Accommodation", "1. Accommodation in room as given at hotel in Guptkashi and Rishikesh and all taxes on Double and triple sharing basis\n" +
                "2. Accommodation in Kedarnath 5 Pax in Single Room"));
        otherTourDetailsModelList.add(new OtherTourDetailsModel("Meal", "Breakfast will be Provided\n" +
                "P.S. : Food will not be provided while traveling."));
        otherTourDetailsModelList.add(new OtherTourDetailsModel("Transportation", "Private Car"));

        otherTourDetailsAdapter = new OtherTourDetailsAdapter(otherTourDetailsModelList);
        otherTourDetailsRecyclerView.setAdapter(otherTourDetailsAdapter);
    }

    private void setTourDetailsRecyclerVie() {
        tourDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        tourDetailsModelList = new ArrayList<>();
        tourDetailsModelList.add(new TourDetailsModel("https://www.flaticon.com/svg/vstatic/svg/1124/1124602.svg?token=exp=1610480404~hmac=dfeca12bbc243fec5246c0379355b7d9"
                , "5 Days, 4 Nights"));
        tourDetailsModelList.add(new TourDetailsModel("https://www.flaticon.com/svg/vstatic/svg/1077/1077114.svg?token=exp=1610480476~hmac=f9e7144a9ffb1146a7905145e35bd9bc"
                , "Min Age: 7+"));
        tourDetailsModelList.add(new TourDetailsModel("https://www.flaticon.com/svg/vstatic/svg/747/747310.svg?token=exp=1610480528~hmac=ac54bcdb93945cc3b8daca95dc111288",
                "Availability: OCT-NOV"));

        tourDetailsAdapter = new TourDetailsAdapter(tourDetailsModelList);
        tourDetailsRecyclerView.setAdapter(tourDetailsAdapter);
    }

    private void setTripViewPager() {
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