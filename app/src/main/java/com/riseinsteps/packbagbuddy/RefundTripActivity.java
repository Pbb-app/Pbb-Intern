package com.riseinsteps.packbagbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class RefundTripActivity extends AppCompatActivity {


    DatabaseReference  databaseReference;
    TextView tv_cancellation_refund;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund_trip);
        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tour Refund and Cancellations");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initComponent();

        fetchDetails();
    }
    private void fetchDetails() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Common data");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String refund=(String)snapshot.child("Cancellation & Refunds").getValue();
                tv_cancellation_refund.setText(refund);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v(error.getMessage(), "Adventure Trip Details of " + "Kedarnath");
            }

        });
    }
    public void initComponent() {
        tv_cancellation_refund =(TextView) findViewById(R.id.tv_cancellation_refund);

    }
}
