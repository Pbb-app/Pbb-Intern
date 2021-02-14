package com.riseinsteps.packbagbuddy;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.riseinsteps.packbagbuddy.fragment.AboutUsFragment;
import com.riseinsteps.packbagbuddy.fragment.CancelBookingFragment;
import com.riseinsteps.packbagbuddy.fragment.ContactUsFragment;
import com.riseinsteps.packbagbuddy.fragment.HomeFragment;
import com.riseinsteps.packbagbuddy.fragment.LegalPolicyFragment;
import com.riseinsteps.packbagbuddy.fragment.MyAccountFragment;
import com.riseinsteps.packbagbuddy.fragment.RegisterAsPartnerFragment;
import com.riseinsteps.packbagbuddy.fragment.ReportProlemFragmet;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    FirebaseUser CurrentUser;
    ImageView nav_userImage;
    TextView nav_username;
    private StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.include_toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setting_user_information();

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

    public void setting_user_information(){
        View headerView = navigationView.getHeaderView(0);
         nav_username=headerView.findViewById(R.id.tv_userName);
         nav_userImage=headerView.findViewById(R.id.user_profile_image);

         CurrentUser=FirebaseAuth.getInstance().getCurrentUser();
        uploadImage();
        get_username();
    }
    private void uploadImage()
    {    storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference image_ref = storageReference.child("users/" + CurrentUser.getUid() + "/profile_image");
        image_ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into( nav_userImage);
            }
        });
    }
private void get_username(){
     DatabaseReference databaseReference;
    databaseReference = FirebaseDatabase.getInstance().getReference("user/" + CurrentUser.getUid());
    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
        String name= (String) snapshot.child("name").getValue();
        nav_username.setText(name);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
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

          case R.id.nav_report_problem:
                getSupportActionBar().setTitle("Report Problem");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ReportProlemFragmet()).commit();
                break;

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