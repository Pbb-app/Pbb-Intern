package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.riseinsteps.packbagbuddy.fragment.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {
    private EditText userEmail;
    private EditText userPassword;
    private FloatingActionButton userSignIn;
    private TextView userSignUp, userForgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText) findViewById(R.id.et_emailAddress);
        userPassword = (EditText) findViewById(R.id.et_password);
        userSignIn = (FloatingActionButton) findViewById(R.id.fab_signIn);
        userSignUp = (TextView) findViewById(R.id.tv_SignUp);
        userForgotPassword = (TextView) findViewById(R.id.tv_ForgotPassword);


        // handle the user signIn
        userSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEmail.getText().toString().trim();
                String pwd = userPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    userEmail.setError("Email Required for SignIn");
                    return;
                } else if (TextUtils.isEmpty(pwd)) {
                    userPassword.setError("Password Required for SignIn");
                    return;
                } else {
                    signIn(email, pwd);
                }
            }
        });


        // setting up the user sign up
        userSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userSignUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(userSignUpIntent);
                finish();
            }
        });


        // setting up the user forgot password
        userForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotPasswordIntent = new Intent(LoginActivity.this, UserForgotPassword.class);
                startActivity(forgotPasswordIntent);
                finish();
            }
        });


    }

    private void signIn(String email, String password) {

    }


}