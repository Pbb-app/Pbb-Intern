package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class CreateTourActivity extends AppCompatActivity {

    private Spinner spLengthofStay, spAccommodation;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tour);

        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Your Tour");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spLengthofStay = findViewById(R.id.spLengthofStay);
        spAccommodation = findViewById(R.id.spAccommodation);

        final ArrayList<String> s1 = new ArrayList<>();
        s1.add("1 Day");
        s1.add("2-5 Days");
        s1.add("6-10 Days");
        s1.add("11-20 Days");
        s1.add("21-30 Days");
        s1.add("30+ Days");

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, s1);

        spLengthofStay.setAdapter(arrayAdapter1);

        final ArrayList<String> s2 = new ArrayList<>();
        s2.add("According to Budget");
        s2.add("Comfort");
        s2.add("Luxury");
        s2.add("Self");
        s2.add("Other-Please specify under details");

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, s2);

        spAccommodation.setAdapter(arrayAdapter2);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(CreateTourActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
        return true;
    }
}