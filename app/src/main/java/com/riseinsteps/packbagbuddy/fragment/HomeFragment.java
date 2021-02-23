package com.riseinsteps.packbagbuddy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.riseinsteps.packbagbuddy.AllAdventureTripActivity;
import com.riseinsteps.packbagbuddy.AllPopularSportActivity;
import com.riseinsteps.packbagbuddy.BookingsActivity;
import com.riseinsteps.packbagbuddy.ChatBot;
import com.riseinsteps.packbagbuddy.MyListAdapter;
import com.riseinsteps.packbagbuddy.MyListData;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.SliderAdapter;
import com.riseinsteps.packbagbuddy.SliderData;
import com.riseinsteps.packbagbuddy.adapter.AdventureTripAdapter;
import com.riseinsteps.packbagbuddy.adapter.PopularSportAdapter;
import com.riseinsteps.packbagbuddy.model.TripModel;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View view;

    private FloatingActionButton exploreIndia, bookings;
    private RelativeLayout AllAdventureTrips, AllPopularSports;

    private RecyclerView adventureTripRecyclerView, popularSportRecyclerView,trecyclerview;
    private List<TripModel> adventureTripList, popularSportList;
    private AdventureTripAdapter adventureTripAdapter;
    private PopularSportAdapter popularSportAdapter;
    private DatabaseReference databaseReference;
    String url1 = "https://cdn.pixabay.com/photo/2019/07/25/17/09/camp-4363073_960_720.png";
    String url2 = "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg";
    String url3 = "https://cdn.hipwallpaper.com/i/40/41/yB7N0g.jpg";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);

        exploreIndia = view.findViewById(R.id.exploreIndia);
        bookings = view.findViewById(R.id.bookings);

        trecyclerview = (RecyclerView) view.findViewById(R.id.TrustedPartners_r);


        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = view.findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter sadapter = new SliderAdapter(getActivity().getApplicationContext(), sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(sadapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();


        MyListData[] myListData = new MyListData[] {
                new MyListData("Email",R.drawable.paytm),
                new MyListData("Info", R.drawable.razorpay),
                new MyListData("Delete",R.drawable.godutch),
                new MyListData("Dialer", R.drawable.cred),

        };


        MyListAdapter adapter = new MyListAdapter(myListData);
        trecyclerview.setHasFixedSize(true);
        trecyclerview.setLayoutManager(new LinearLayoutManager(view.getContext()));
        trecyclerview.setAdapter(adapter);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
        trecyclerview.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView

        exploreIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exploreIndia = new Intent(view.getContext(), AllAdventureTripActivity.class);    //change here
                view.getContext().startActivity(exploreIndia);
            }
        });

        bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createTour = new Intent(view.getContext(), BookingsActivity.class);
                view.getContext().startActivity(createTour);
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

    private void setPopularSportRecyclerview(View view) {
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

    }



//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.home_screen_menu, menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.nav_chatbot:
//                Intent intent = new Intent(view.getContext(), ChatBot.class);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.home_screen_menu, menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.nav_chatbot:
//                Intent intent = new Intent(view.getContext(), ChatBot.class);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}