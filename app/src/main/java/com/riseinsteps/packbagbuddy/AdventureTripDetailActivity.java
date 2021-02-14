package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.EventListener;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.riseinsteps.packbagbuddy.model.TripDetailsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdventureTripDetailActivity extends AppCompatActivity {

    DatabaseReference mCurrentSport, databaseReference;
    StorageReference storageReference;
    Uri photoUrl;
    ImageView activity_image;
    TextView tv_trip_detail_name, tv_quick_facts_desc, startingDestination, endDestination, stateofDestination,
            tour_details_desc,  minAge, numofSeats, actual_Cost;
    View view;
    private Toolbar toolbar;

    //String sports=getIntent().getStringExtra("name");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_trip_detail);

       final String sports;
        Intent intent=getIntent();
        sports = intent.getStringExtra("name").trim();
        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tour Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initComponent();

        databaseReference = FirebaseDatabase.getInstance().getReference("Adventrous Trips/"+sports+"/Image");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String image_url= (String) snapshot.getValue();
                Glide.with(AdventureTripDetailActivity.this).load(image_url).placeholder(R.drawable.save).dontAnimate().into(activity_image);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        storageReference = FirebaseStorage.getInstance().getReference();
//        StorageReference image_ref = storageReference.child("Adventrous Trips/"+sports+"/Image");
//        image_ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                final String stringUri;
//                stringUri = uri.toString();
//                //Glide.with(AdventureTripDetailActivity.this).load(uri).placeholder(R.drawable.save).dontAnimate().into(activity_image);
//                Picasso.get().load(uri).into(activity_image);
//            }
//        });
        fetchDetails();
        TextView rules=(TextView) findViewById(R.id.tv_rules_and_regulation);
        TextView refund=(TextView) findViewById(R.id.tv_cancellation_and_Refund);

        ImageView rulesIV=(ImageView)findViewById(R.id.iv_rules_and_regulation);
        ImageView refundIV=(ImageView)findViewById(R.id.iv_cancellation_and_Refund);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdventureTripDetailActivity.this, RulesTripActivity.class);
                startActivity(intent);
            }
        });
        rulesIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdventureTripDetailActivity.this, RulesTripActivity.class);
                startActivity(intent);
            }
        });
        refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdventureTripDetailActivity.this, RefundTripActivity.class);
                startActivity(intent);
            }
        });
        refundIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdventureTripDetailActivity.this, RefundTripActivity.class);
                startActivity(intent);
            }
        });
    }


    private void fetchDetails() {
        final String sports;
        Intent intent=getIntent();
        sports = intent.getStringExtra("name").trim();
        databaseReference = FirebaseDatabase.getInstance().getReference("Adventrous Trips/"+sports);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                    tv_trip_detail_name.setText(sports);

                    String Accommodation=(String)snapshot.child("Quick Facts/Accommodation").getValue();
                    String Camp_dur=(String)snapshot.child("Quick Facts/Camp Duration").getValue();
                    String Camp_reg=(String)snapshot.child("Quick Facts/Camp Region").getValue();
                    String meal=(String)snapshot.child("Quick Facts/Meal").getValue();
                    String visit1=(String)snapshot.child("Quick Facts/Places to Visit/1").getValue();
                    String visit2=(String)snapshot.child("Quick Facts/Places to Visit/2").getValue();
                    String visit3=(String)snapshot.child("Quick Facts/Places to Visit/3").getValue();
                    tv_quick_facts_desc.setText(" 1. Accommodation: "+Accommodation+ "\n\n 2. Camp Duration: "+Camp_dur+"\n\n 3. Camp Region: "
                            +Camp_reg+"\n\n 4. Meal: "+meal+"\n\n 5. Places to Visit: \n i. "+visit1 +"\n ii. "+visit2+"\n iii. "+visit3);

                        String from = snapshot.child("from").getValue().toString();
                        startingDestination.setText("From: " + from);

                        String to = snapshot.child("to").getValue().toString();
                        endDestination.setText("To:  " + to);

                        String tourdetails1 = (String) snapshot.child("Tour Details/Departure & Return Location").getValue();
                        String tourdetails2 = (String) snapshot.child("Tour Details/Reporting Time").getValue();
                        tour_details_desc.setText(" 1.Departure & Return Location: " + tourdetails1 + "\n 2.Reporting Time: " + tourdetails2 + "\n");

                        String MinAge = (String) snapshot.child("Min Age").getValue();
                        minAge.setText("Minimum Age:  " + MinAge);

                        String numSeats = (String) snapshot.child("Total Seats").getValue();
                        numofSeats.setText("Total Seats: " + numSeats + "\n");

                        String cost = snapshot.child("Cost").getValue().toString();
                        actual_Cost.setText("Cost:  " + cost);
                    }
                //}


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v(error.getMessage(), "Adventure Trip Details of " + "Kedarnath");
            }

        });
    }
            public void initComponent() {
                tv_trip_detail_name = (TextView) findViewById(R.id.tv_trip_detail_name);
                activity_image = (ImageView) findViewById(R.id.activity_image);
                tv_quick_facts_desc = (TextView) findViewById(R.id.tv_quick_facts_desc);
                startingDestination = (TextView) findViewById(R.id.startingDestination);
                endDestination = (TextView) findViewById(R.id.endDestination);
                tour_details_desc = (TextView) findViewById(R.id.tour_details_desc);
                minAge = (TextView) findViewById(R.id.minAge);
                numofSeats = (TextView) findViewById(R.id.numofSeats);
                actual_Cost = (TextView) findViewById(R.id.actual_Cost);
            }
        }