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
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

    FloatingActionButton exploreIndia, createTour, latestOffers;
    private RelativeLayout AllAdventureTrips, AllPopularSports;

    private RecyclerView adventureTripRecyclerView, popularSportRecyclerView;
    private List<TripModel> adventureTripList, popularSportList;
    private AdventureTripAdapter adventureTripAdapter;
    private PopularSportAdapter popularSportAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);

        exploreIndia= view.findViewById(R.id.exploreIndia);
        createTour= view.findViewById(R.id.bookings);
        latestOffers = view.findViewById(R.id.latestOffers);


        exploreIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exploreIndia = new Intent(view.getContext(), ExploreIndiaActivity.class);
                view.getContext().startActivity(exploreIndia);
            }
        });

        createTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createTour = new Intent(view.getContext(), CreateTourActivity.class);
                view.getContext().startActivity(createTour);
            }
        });


        latestOffers.setOnClickListener(new View.OnClickListener() {
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
        adventureTripRecyclerView = view.findViewById(R.id.adventrous_recycler_home);
        adventureTripRecyclerView.setHasFixedSize(true);
        adventureTripRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));

        adventureTripList = new ArrayList<>();
        adventureTripAdapter = new AdventureTripAdapter(adventureTripList);
        adventureTripRecyclerView.setAdapter(adventureTripAdapter);

        // Fetching the data from firebase for adventure trip list

        databaseReference= FirebaseDatabase.getInstance().getReference("Adventrous Trips");
         databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                     String name= (String) dataSnapshot.child("name").getValue();
                     String image_url=(String) dataSnapshot.child("Image").getValue();
                     Log.v(name+" "+image_url,"checking database");
                     adventureTripList.add(new TripModel(name,image_url));
                 }
                adventureTripAdapter.notifyDataSetChanged();
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {
                 Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });

    }

    private void setPopularSportRecyclerview(View view)
    {
        popularSportRecyclerView = view.findViewById(R.id.popular_recycler_home);
        popularSportRecyclerView.setHasFixedSize(true);
        popularSportRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));

        popularSportList = new ArrayList<>();
        popularSportAdapter = new PopularSportAdapter(popularSportList);
        popularSportRecyclerView.setAdapter(popularSportAdapter);


        // fetching the data for popular sports from firebase

        databaseReference= FirebaseDatabase.getInstance().getReference("Popular Sports");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String name= (String) dataSnapshot.child("name").getValue();
                    String image_url=(String) dataSnapshot.child("Image").getValue();
                    Log.v(name+" "+image_url,"checking database");
                    popularSportList.add(new TripModel(name,image_url));
                }
                popularSportAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        // fetching end

        /*
        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));
        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));
        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));
        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        popularSportAdapter = new PopularSportAdapter(popularSportList);
        popularSportRecyclerView.setAdapter(popularSportAdapter);
        */
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
