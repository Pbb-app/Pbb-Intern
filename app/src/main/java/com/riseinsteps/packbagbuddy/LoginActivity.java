package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout userEmail;
    private TextInputLayout userPassword;
    private FloatingActionButton userSignIn;
    private TextView userSignUp, userForgotPassword;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar=findViewById(R.id.progress_circular);
        userEmail = findViewById(R.id.et_emailAddress);
        userPassword = findViewById(R.id.et_password);
        userSignIn = findViewById(R.id.fab_signIn);
        userSignUp = findViewById(R.id.tv_SignUp);
        userForgotPassword = findViewById(R.id.tv_ForgotPassword);


        // handle the user signIn
        userSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = String.valueOf(userEmail.getEditText().getText());
                String pwd = String.valueOf(userPassword.getEditText().getText());

                if (TextUtils.isEmpty(email)) {
                    userEmail.setError("Email Required for SignIn");
                    return;
                } else if (TextUtils.isEmpty(pwd)) {
                    userPassword.setError("Password Required for SignIn");
                    return;
                } else {
                    progressBar.setVisibility(View.VISIBLE);
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
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.INVISIBLE);
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            FirebaseUser user = mAuth.getCurrentUser();
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });

    }


}