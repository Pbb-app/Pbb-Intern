package com.riseinsteps.packbagbuddy;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.riseinsteps.packbagbuddy.fragment.AboutUsFragment;
import com.riseinsteps.packbagbuddy.fragment.CancelBookingFragment;
import com.riseinsteps.packbagbuddy.fragment.ContactUsFragment;
import com.riseinsteps.packbagbuddy.fragment.HomeFragment;
import com.riseinsteps.packbagbuddy.fragment.LegalPolicyFragment;
import com.riseinsteps.packbagbuddy.fragment.MyAccountFragment;
import com.riseinsteps.packbagbuddy.fragment.RegisterAsPartnerFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//      ActionBarDrawerToggle is used to create the hamburger icon to switch the fragments
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportActionBar().setTitle("Home");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }


    //   Overriding the default behaviour of back button
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportActionBar().setTitle("Home");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;

//            case R.id.nav_bookings:
//                getSupportActionBar().setTitle("Your Bookings");
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BookingFragment()).commit();
//                break;
//
            case R.id.nav_cancel_booking:
                getSupportActionBar().setTitle("Cancel Booking");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CancelBookingFragment()).commit();
                break;

            case R.id.nav_myAccount:
                getSupportActionBar().setTitle("My Account");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyAccountFragment()).commit();
                break;

//            case R.id.nav_report_problem:
//                getSupportActionBar().setTitle("Report Problem");
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ReportProblemFragment()).commit();
//                break;

            case R.id.nav_register_as_partner:
                getSupportActionBar().setTitle("Register as Partner");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegisterAsPartnerFragment()).commit();
                break;

            case R.id.nav_legal_policy:
                getSupportActionBar().setTitle("Legal Policies");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LegalPolicyFragment()).commit();
                break;

            case R.id.nav_contact_us:
                getSupportActionBar().setTitle("Contact Us");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ContactUsFragment()).commit();
                break;

            case R.id.nav_about_us:
                getSupportActionBar().setTitle("About Us");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutUsFragment()).commit();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



}