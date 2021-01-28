package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LegalPolicyActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private TextView termsAndCondition, CopyrightPolicy, PrivacyPolicy, CancellationAndRefund;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_policy);

        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Legal Policies");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        termsAndCondition = findViewById(R.id.tv_terms_and_conditions);
        CopyrightPolicy = findViewById(R.id.tv_copyright_policy);
        PrivacyPolicy = findViewById(R.id.tv_privacy_policy);
        CancellationAndRefund = findViewById(R.id.tv_cancellation_and_refund);

        termsAndCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LegalPolicyActivity.this, TermsAndConditionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        CopyrightPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LegalPolicyActivity.this, CopyRightPolicyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        PrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LegalPolicyActivity.this, PrivacyPolicyActivity.class);
                startActivity(intent);
                finish();
            }
        });

        CancellationAndRefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LegalPolicyActivity.this, CancellationAndRefundPolicyActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(LegalPolicyActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
        return true;
    }
}