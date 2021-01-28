package com.riseinsteps.packbagbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.riseinsteps.packbagbuddy.adapter.BookingAdapter;
import com.riseinsteps.packbagbuddy.model.Booking_Data;

import java.util.ArrayList;
import java.util.List;

public class BookingActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BookingAdapter mAdapter;

    List<Booking_Data> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        initComponent();
    }
    private void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

         items =new ArrayList<>();

        //set data and list adapter
        mAdapter = new BookingAdapter(items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked


    }
}