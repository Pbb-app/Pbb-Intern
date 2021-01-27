package com.riseinsteps.packbagbuddy;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class CreateTourActivity extends AppCompatActivity {

    Spinner spLengthofStay, spAccommodation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tour);

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

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, s2);

        spAccommodation.setAdapter(arrayAdapter2);

    }
}