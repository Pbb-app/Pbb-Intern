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
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;
import com.riseinsteps.packbagbuddy.model.PopularSportModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View view;

    private LinearLayout ExploreIndia, CreateTour, LatestOffers;
    private LinearLayout AllAdventureTrips, AllPopularSports;

    private List<AdventureTripModel> adventureTripModelList;
    private RecyclerView adventureTripRecyclerView;
    private AdventureTripAdapter adventureTripAdapter;

    private List<PopularSportModel> popularSportModelList;
    private RecyclerView popularSportRecyclerView;
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

        adventureTripModelList = new ArrayList<>();

        adventureTripModelList.add(new AdventureTripModel(1, "Kedarnath", "as", "43", 2000, 1000,
                "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Odhisa", 15, "OCT", 3.2f));
        adventureTripModelList.add(new AdventureTripModel(1, "Kedarnath", "as", "43", 2000, 1000,
                "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Odhisa", 15, "OCT", 3.2f));
        adventureTripModelList.add(new AdventureTripModel(1, "Kedarnath", "as", "43", 2000, 1000,
                "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Odhisa", 15, "OCT", 3.2f));
        adventureTripModelList.add(new AdventureTripModel(1, "Kedarnath", "as", "43", 2000, 1000,
                "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Odhisa", 15, "OCT", 3.2f));
        adventureTripModelList.add(new AdventureTripModel(1, "Kedarnath", "as", "43", 2000, 1000,
                "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Odhisa", 15, "OCT", 3.2f));

        adventureTripAdapter = new AdventureTripAdapter(adventureTripModelList);
        adventureTripRecyclerView.setAdapter(adventureTripAdapter);

    }


    private void setPopularSportRecyclerview(View view) {
        popularSportRecyclerView = view.findViewById(R.id.rv_popular_sports);
        popularSportRecyclerView.setHasFixedSize(true);
        popularSportRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));

        popularSportModelList = new ArrayList<>();
        popularSportModelList.add(new PopularSportModel(1, "https://images.pexels.com/photos/1365425/pexels-photo-1365425.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Trekking", 5));
        popularSportModelList.add(new PopularSportModel(1, "https://images.pexels.com/photos/1365425/pexels-photo-1365425.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Trekking", 5));
        popularSportModelList.add(new PopularSportModel(1, "https://images.pexels.com/photos/1365425/pexels-photo-1365425.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Trekking", 5));
        popularSportModelList.add(new PopularSportModel(1, "https://images.pexels.com/photos/1365425/pexels-photo-1365425.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Trekking", 5));
        popularSportModelList.add(new PopularSportModel(1, "https://images.pexels.com/photos/1365425/pexels-photo-1365425.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Trekking", 5));
        popularSportModelList.add(new PopularSportModel(1, "https://images.pexels.com/photos/1365425/pexels-photo-1365425.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Trekking", 5));
        popularSportModelList.add(new PopularSportModel(1, "https://images.pexels.com/photos/1365425/pexels-photo-1365425.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
                "Trekking", 5));

        popularSportAdapter = new PopularSportAdapter(popularSportModelList);
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
