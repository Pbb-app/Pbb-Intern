package com.riseinsteps.packbagbuddy;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.riseinsteps.packbagbuddy.model.TripDetailsModel;
import com.squareup.picasso.Picasso;

public class AdventureTripDetailActivity extends AppCompatActivity {

    DatabaseReference mCurrentSport, databaseReference;
    StorageReference storageReference;
    Uri photoUrl;
    ImageView activity_image;
    TextView tv_trip_detail_name, tv_quick_facts_desc, startingDestination, endDestination, stateofDestination,
            tour_details_desc, duration, minAge, availability, numofSeats, actual_Cost;
    View view;
    private Toolbar toolbar;
//    String sports=getIntent().getStringExtra("name");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_sport_detail);
        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tour Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
    }
}