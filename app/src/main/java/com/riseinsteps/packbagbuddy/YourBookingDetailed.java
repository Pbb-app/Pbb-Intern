package com.riseinsteps.packbagbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class YourBookingDetailed extends AppCompatActivity {

    private Toolbar toolbar;

    String location ="notset";
    String title ="notset";
    String duration ="notset";
    String cost ="notset";
    String subtitle ="notset";
    String date ="notset";
    String fromlocation;
    String todestination;
    String status;
    String count;

    ImageView locationiv;
    TextView titletv;
    TextView durationtv;
    TextView costtv;
    TextView subtitletv;
    TextView datetv;
    TextView fromlocationtv;
    TextView todestinationtv;
    TextView statustv;
    TextView counttv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_booking_detailed);

        toolbar = findViewById(R.id.include_toolbar);

        locationiv=findViewById(R.id.locationiv);
        titletv=findViewById(R.id.titletv);
        durationtv=findViewById(R.id.durationtv);
        costtv=findViewById(R.id.costtv);
        subtitletv=findViewById(R.id.subtitletv);
        datetv=findViewById(R.id.datetv);
        fromlocationtv=findViewById(R.id.fromdestinationtv);
        todestinationtv=findViewById(R.id.todestinationtv);
        statustv=findViewById(R.id.statustv);
        counttv=findViewById(R.id.counttv);







        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Booking Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Bundle extras=getIntent().getExtras();
        if (extras!=null)
        {
            title=extras.getString("title");
            duration=extras.getString("duration");
            cost=extras.getString("cost");
            subtitle=extras.getString("subtitle");
            location=extras.getString("image");
            date=extras.getString("date");
            fromlocation=extras.getString("fromdestination");
            todestination=extras.getString("todestination");
            status=extras.getString("status");
            count=extras.getString("count");

        }


        titletv.setText(title);
        durationtv.setText(duration);
        costtv.setText(cost);
        subtitletv.setText(subtitle);
        datetv.setText(date);
        fromlocationtv.setText(fromlocation);
        todestinationtv.setText(todestination);
        statustv.setText(status);
        counttv.setText(count);





    }
}