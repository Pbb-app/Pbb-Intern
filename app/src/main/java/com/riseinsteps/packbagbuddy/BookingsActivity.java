package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter;
import com.riseinsteps.packbagbuddy.adapter.YourBookingAdapter;
import com.riseinsteps.packbagbuddy.fragment.HomeFragment;
import com.riseinsteps.packbagbuddy.model.TripModel;
import com.riseinsteps.packbagbuddy.model.YourBookingModel;

import java.util.ArrayList;
import java.util.List;

public class BookingsActivity extends AppCompatActivity {


    private List<YourBookingModel> yourBookingList;
    private YourBookingAdapter yourBookingAdapter;
    private YourBookingAdapter.RecyclerviewClickListener listener;
    private LinearLayout linearLayout;
    private Button bookatripbtn;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);



        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Your Bookings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setOnClickListener();

        linearLayout=findViewById(R.id.nobooking);
        bookatripbtn=findViewById(R.id.bookatripbtn);

        RecyclerView yourbookings =(RecyclerView) findViewById(R.id.yourbookings);
        yourbookings.setHasFixedSize(true);
        yourbookings.setLayoutManager(new LinearLayoutManager(this));


        if(yourBookingList==null){
            View view = linearLayout;
            linearLayout.setVisibility(view.VISIBLE);

        }


        else{
            View view=yourbookings;
            yourbookings.setVisibility(view.VISIBLE);
        }



        yourBookingList = new ArrayList<>();
        bookatripbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

//        yourBookingList.add(new YourBookingModel("https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg","Kedarnath","9 days-8nights","8000","Adventure Trip","09/02/2021","Pune","delhi","Completed","2") );
//        yourBookingList.add(new YourBookingModel("https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg","Kedarnath","9 days-8nights","8000","Adventure Trip","09/02/2021","Pune","delhi","Completed","2") );
//        yourBookingList.add(new YourBookingModel("https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg","Kedarnath","9 days-8nights","8000","Adventure Trip","09/02/2021","Pune","delhi","Completed","2") );
//        yourBookingList.add(new YourBookingModel("https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg","Kedarnath","9 days-8nights","8000","Adventure Trip","09/02/2021","Pune","delhi","Completed","2") );
//        yourBookingList.add(new YourBookingModel("https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg","Kedarnath","9 days-8nights","8000","Adventure Trip","09/02/2021","Pune","delhi","Completed","2") );
//        yourBookingList.add(new YourBookingModel("https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg","Kedarnath","9 days-8nights","8000","Adventure Trip","09/02/2021","Pune","delhi","Completed","2") );
//        yourBookingList.add(new YourBookingModel("https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg","Kedarnath","9 days-8nights","8000","Adventure Trip","09/02/2021","Pune","delhi","Completed","2") );




        yourBookingAdapter = new YourBookingAdapter(yourBookingList,listener);
        yourbookings.setAdapter(yourBookingAdapter);



    }

    private void setOnClickListener() {
        listener= new YourBookingAdapter.RecyclerviewClickListener() {
            @Override
            public void onClick(View v, int position) {

                Intent intent=new Intent(getApplicationContext(),YourBookingDetailed.class);
                intent.putExtra("image",yourBookingList.get(position).getLocation());
                intent.putExtra("title",yourBookingList.get(position).getTitle());
                intent.putExtra("duration",yourBookingList.get(position).getDuration());
                intent.putExtra("cost",yourBookingList.get(position).getCost());
                intent.putExtra("subtitle",yourBookingList.get(position).getSubstitle());
                intent.putExtra("date",yourBookingList.get(position).getDate());
                intent.putExtra("fromdestination",yourBookingList.get(position).getFromlocation());
                intent.putExtra("todestination",yourBookingList.get(position).getTodestination());
                intent.putExtra("status",yourBookingList.get(position).getStatus());
                intent.putExtra("count",yourBookingList.get(position).getCount());


                startActivity(intent);



            }
        };
    }
}