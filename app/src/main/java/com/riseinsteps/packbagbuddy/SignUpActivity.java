package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.riseinsteps.packbagbuddy.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private EditText name, email, username, phoneNumber, password, confirmPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.et_username);
        email = findViewById(R.id.et_emailAddress);
        username = findViewById(R.id.et_userID);
        phoneNumber = findViewById(R.id.et_phone_number);
        password = findViewById(R.id.et_password);
        confirmPassword = findViewById(R.id.et_confirmPassword);
        FloatingActionButton userSignUp = findViewById(R.id.fab_signUp);

        userSignUp.setOnClickListener(v -> {
            if (TextUtils.isEmpty(name.getText().toString().trim())) {
                name.setError("Please fill the name");
            } else if (TextUtils.isEmpty(email.getText().toString().trim())) {
                email.setError("Email Required for SignUp");
            } else if (TextUtils.isEmpty(username.getText().toString().trim())) {
                username.setError("Username Required for SignUp");
            } else if (TextUtils.isEmpty(phoneNumber.getText().toString().trim())) {
                phoneNumber.setError("Phone Number Required for SignUp");
            } else if (TextUtils.isEmpty(password.getText().toString())) {
                password.setError("Password Required for SignUp");
            } else if (TextUtils.isEmpty(confirmPassword.getText().toString())) {
                confirmPassword.setError("Please Enter confirm password");
            } else if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                confirmPassword.setError("Password not match");
            } else {
                String tempName = name.getText().toString().trim();
                String tempUserName = username.getText().toString().trim();
                String tempPhn = phoneNumber.getText().toString().trim();
                String tempEmail = email.getText().toString().trim().toLowerCase();
                String tempPwd = password.getText().toString();

                //getting the firebase instance
                mAuth = FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(tempEmail, tempPwd).addOnCompleteListener(SignUpActivity.this, task -> {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        String error = Objects.requireNonNull(task.getException()).toString();
                        Toast.makeText(SignUpActivity.this, "SignUp failed:" + error, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}