package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class PopularSportDetailActivity extends AppCompatActivity {

    DatabaseReference mCurrentSport, databaseReference;
    StorageReference storageReference;
    Uri photoUrl;
    ImageView activity_image;
    TextView CampRegion,Availability,tv_adventure_sports,Cost,Days,Nights,accomodation,meal,Places_to_visit,tv_sport_detail_name;
   View view;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_sport_detail);
         toolbar= findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tour Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//        final String sports;
//        Intent intent=getIntent();
//        sports = intent.getStringExtra("name_sport").trim();
        initComponent();
//
//       storageReference = FirebaseStorage.getInstance().getReference();
//        StorageReference image_ref = storageReference.child("Popular Sports/"+sports+"/Image");
//        image_ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                final String stringUri;
//                stringUri = uri.toString();
//                Glide.with(PopularSportDetailActivity.this).load(stringUri).placeholder(R.drawable.save).dontAnimate().into(activity_image);
//                //Picasso.get().load(uri).into(activity_image);
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
                Intent intent = new Intent(PopularSportDetailActivity.this, RulesTripActivity.class);
                startActivity(intent);
            }
        });
        rulesIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopularSportDetailActivity.this, RulesTripActivity.class);
                startActivity(intent);
            }
        });

        refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopularSportDetailActivity.this, RefundTripActivity.class);
                startActivity(intent);
            }
        });
        refundIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopularSportDetailActivity.this, RefundTripActivity.class);
                startActivity(intent);
            }
        });

    }

    private void fetchDetails() {
        final String sports;
        Intent intent=getIntent();
        sports = intent.getStringExtra("name_sport").trim();

       databaseReference = FirebaseDatabase.getInstance().getReference("Popular Sports/ CHADAR FROZEN RIVER TREK");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               tv_sport_detail_name.setText(sports);
                  String Accommodation=(String)snapshot.child("Accommodation").getValue();
                String cost=snapshot.child("Cost").getValue().toString();
                String Camp_reg=(String)snapshot.child("Camp Region").getValue();
                String Meal=(String)snapshot.child("Meal").getValue();
                String days=snapshot.child("Days").getValue().toString();
                String night=snapshot.child("Nights").getValue().toString();
                String availability=(String)snapshot.child("Availability").getValue();
                CampRegion.setText("Camp Region: "+Camp_reg);
                Availability.setText("Availability: "+availability);
                Cost.setText("Cost: "+cost);
                accomodation.setText("Accommodation: "+Accommodation);
                meal.setText("Meal: "+Meal);
                Days.setText("Days: "+days);
                Nights.setText("Nights: "+night);

                String place1=(String)snapshot.child("Places To Visit/1").getValue();
                String place2=(String)snapshot.child("Places To Visit/2").getValue();
                String place3=(String)snapshot.child("Places To Visit/3").getValue();
                Places_to_visit.setText(" 1. "+place1+"\n  2."+place2+"\n  3."+place3);

                String sport1=(String)snapshot.child("Activities/1").getValue();
                String sport2=(String)snapshot.child("Activities/2").getValue();
                tv_adventure_sports.setText("  1."+sport1+"\n  2."+sport2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v(error.getMessage(), "Adventure Trip Details of " + "Kedarnath");
            }

        });
  }
    public void initComponent() {
        CampRegion = (TextView) findViewById(R.id.CampRegion);
        activity_image = (ImageView) findViewById(R.id.activity_image_sport);
        Availability = (TextView) findViewById(R.id.Availability);
        tv_adventure_sports = (TextView) findViewById(R.id.tv_adventure_sports);
        Cost = (TextView) findViewById(R.id.Cost);
        Days = (TextView) findViewById(R.id.Days);
        Nights= (TextView) findViewById(R.id.Nights);
        accomodation= (TextView) findViewById(R.id.accomodation);
        meal = (TextView) findViewById(R.id.meal);
        Places_to_visit=(TextView)findViewById(R.id.Places_to_visit);
        tv_sport_detail_name=(TextView)findViewById(R.id.tv_sport_detail_name);
    }
}