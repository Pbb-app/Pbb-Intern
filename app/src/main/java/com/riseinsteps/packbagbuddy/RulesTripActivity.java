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

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RulesTripActivity extends AppCompatActivity {


    DatabaseReference databaseReference1,databaseReference2;
    StorageReference storageReference;
    Uri photoUrl;

    TextView tv_rulesNReg,tv_price_excludes,tv_price_includes,tv_things_to_carry;
    View view;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_trip);
        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tour Rules");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initComponent();

        fetchDetails();
    }
    private void fetchDetails() {
        databaseReference1 = FirebaseDatabase.getInstance().getReference("Common data/Rules & Regulations");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Rule1=(String)snapshot.child("1").getValue();
                String Rule2=(String)snapshot.child("2").getValue();
                String Rule3=(String)snapshot.child("3").getValue();
                String Rule4=(String)snapshot.child("4").getValue();
                String Rule5=(String)snapshot.child("5").getValue();
                String Rule6=(String)snapshot.child("6").getValue();
                String Rule7=(String)snapshot.child("7").getValue();
                tv_rulesNReg.setText("Rule 1: "+Rule1+ "\n\nRule 2: "+Rule2+"\n\nRule 3: "
                        +Rule3+"\n\nRule 4: "+Rule4+"\n\nRule 5: "+Rule5 +"\n\nRule 6:  "+Rule6+"\n\nRule 7: "+Rule7);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v(error.getMessage(), "Adventure Trip Details of " + "Kedarnath");
            }

        });

        databaseReference2 = FirebaseDatabase.getInstance().getReference("Common data/Tour details");
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String PE1=(String)snapshot.child("Price Excludes/1").getValue();
                String PE2=(String)snapshot.child("Price Excludes/2").getValue();
                String PE3=(String)snapshot.child("Price Excludes/3").getValue();
                String PE4=(String)snapshot.child("Price Excludes/4").getValue();
                String PE5=(String)snapshot.child("Price Excludes/5").getValue();
                tv_price_excludes.setText(PE1+ "\n\n"+PE2+"\n\n" +PE3+"\n\n"+PE4+"\n\n "+PE5);
                String PI1=(String)snapshot.child("Price Includes/1").getValue();
                String PI2=(String)snapshot.child("Price Includes/2").getValue();
                String PI3=(String)snapshot.child("Price Includes/3").getValue();
                String PI4=(String)snapshot.child("Price Includes/4").getValue();
                String PI5=(String)snapshot.child("Price Includes/5").getValue();
                tv_price_includes.setText(PI1+ "\n\n"+PI2+"\n\n" +PI3+"\n\n"+PI4+"\n\n "+PI5);
                String TOC1=(String)snapshot.child("Things To Carry/1").getValue();
                String TOC2=(String)snapshot.child("Things To Carry/2").getValue();
                String TOC3=(String)snapshot.child("Things To Carry/3").getValue();
                String TOC4=(String)snapshot.child("Things To Carry/4").getValue();
                String TOC5=(String)snapshot.child("Things To Carry/5").getValue();
                String TOC6=(String)snapshot.child("Things To Carry/6").getValue();
                String TOC7=(String)snapshot.child("Things To Carry/7").getValue();
                String TOC8=(String)snapshot.child("Things To Carry/8").getValue();
                String TOC9=(String)snapshot.child("Things To Carry/9").getValue();
                String TOC10=(String)snapshot.child("Things To Carry/10").getValue();
                String TOC11=(String)snapshot.child("Things To Carry/11").getValue();
                tv_things_to_carry.setText(TOC1+ "\n\n"+TOC2+"\n\n" +TOC3+"\n\n"+TOC4+"\n\n "+TOC5+"\n\n"+
                        TOC6+ "\n\n"+TOC7+"\n\n" +TOC8+"\n\n"+TOC9+"\n\n "+TOC10+"\n\n "+TOC11);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v(error.getMessage(), "Adventure Trip Details of " + "Kedarnath");
            }

        });
    }
    public void initComponent() {
        tv_rulesNReg=(TextView)findViewById(R.id.tv_rulesNReg);
        tv_price_excludes=(TextView)findViewById(R.id.tv_price_excludes);
        tv_price_includes=(TextView)findViewById(R.id.tv_price_includes);
        tv_things_to_carry=(TextView)findViewById(R.id.tv_things_to_carry);
    }

}