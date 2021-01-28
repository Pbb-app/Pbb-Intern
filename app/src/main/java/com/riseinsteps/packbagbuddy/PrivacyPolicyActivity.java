package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.riseinsteps.packbagbuddy.fragment.LegalPolicyFragment;

public class PrivacyPolicyActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Privacy Policy");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(PrivacyPolicyActivity.this, LegalPolicyFragment.class);
        startActivity(intent);
        finish();
        return true;
    }
}