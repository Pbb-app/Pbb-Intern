package com.riseinsteps.packbagbuddy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.packbagbuddy.AllAdventureTripActivity;
import com.riseinsteps.packbagbuddy.AllPopularSportActivity;
import com.riseinsteps.packbagbuddy.ChatBot;
import com.riseinsteps.packbagbuddy.CreateTourActivity;
import com.riseinsteps.packbagbuddy.ExploreIndiaActivity;
import com.riseinsteps.packbagbuddy.LatestOffersActivity;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.adapter.AdventureTripAdapter;
import com.riseinsteps.packbagbuddy.adapter.PopularSportAdapter;
import com.riseinsteps.packbagbuddy.model.TripModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View view;

    private LinearLayout ExploreIndia, CreateTour, LatestOffers;
    private LinearLayout AllAdventureTrips, AllPopularSports;

    private RecyclerView adventureTripRecyclerView, popularSportRecyclerView;
    private List<TripModel> adventureTripList, popularSportList;
    private AdventureTripAdapter adventureTripAdapter;
    private PopularSportAdapter popularSportAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);

        ExploreIndia = view.findViewById(R.id.layoutExploreIndia);
        CreateTour = view.findViewById(R.id.layoutCreateTour);
        LatestOffers = view.findViewById(R.id.layoutOffers);


        ExploreIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exploreIndia = new Intent(view.getContext(), ExploreIndiaActivity.class);
                view.getContext().startActivity(exploreIndia);
            }
        });

        CreateTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createTour = new Intent(view.getContext(), CreateTourActivity.class);
                view.getContext().startActivity(createTour);
            }
        });


        LatestOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent latestOffers = new Intent(view.getContext(), LatestOffersActivity.class);
            }
        });


        AllAdventureTrips = view.findViewById(R.id.ll_adventure_trip);

        AllAdventureTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allAdventureTrip = new Intent(view.getContext(), AllAdventureTripActivity.class);
                view.getContext().startActivity(allAdventureTrip);
            }
        });

        setAdventureTripRecyclerview(view);

        AllPopularSports = view.findViewById(R.id.ll_popular_sports);

        AllPopularSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allPopularSport = new Intent(view.getContext(), AllPopularSportActivity.class);
                view.getContext().startActivity(allPopularSport);
            }
        });

        setPopularSportRecyclerview(view);

        return view;
    }


    private void setAdventureTripRecyclerview(View view) {
        adventureTripRecyclerView = view.findViewById(R.id.rv_adventure_trips);
        adventureTripRecyclerView.setHasFixedSize(true);
        adventureTripRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));

        adventureTripList = new ArrayList<>();
        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        adventureTripList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        adventureTripAdapter = new AdventureTripAdapter(adventureTripList);
        adventureTripRecyclerView.setAdapter(adventureTripAdapter);


    }

    private void setPopularSportRecyclerview(View view) {
        popularSportRecyclerView = view.findViewById(R.id.rv_popular_sports);
        popularSportRecyclerView.setHasFixedSize(true);
        popularSportRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));

        popularSportList = new ArrayList<>();
        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund"));

        popularSportAdapter = new PopularSportAdapter(popularSportList);
        popularSportRecyclerView.setAdapter(popularSportAdapter);
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.home_screen_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_chatbot:
                Intent intent = new Intent(view.getContext(), ChatBot.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
