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
import com.riseinsteps.packbagbuddy.model.OtherTourDetailsModel;
import com.riseinsteps.packbagbuddy.model.TourDetailsModel;
import com.riseinsteps.packbagbuddy.model.TripModel;

import java.util.ArrayList;
import java.util.List;


public class AdventureTripDetailActivity extends AppCompatActivity {

    private ViewPager TripViewPager;
    private List<TripModel> modelList;
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


    }



}