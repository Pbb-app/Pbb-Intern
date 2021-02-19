package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {


    private LinearLayout layout;
    private Animation animation;
    FirebaseAuth mauth;
    ImageView logo, logoname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mauth=FirebaseAuth.getInstance();

        // for hiding the status bar from the top
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        layout = findViewById(R.id.layout);
        logo = findViewById(R.id.logo);
        logoname = findViewById(R.id.logoname);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_bottom);
        logoname.startAnimation(animation);
        logo.startAnimation(animation);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if(mauth.getCurrentUser()!=null) {
                    Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                }
                else {

                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        }).start();

    }
}