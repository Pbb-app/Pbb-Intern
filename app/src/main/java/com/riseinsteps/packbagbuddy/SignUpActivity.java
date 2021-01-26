package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.riseinsteps.packbagbuddy.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout name, email,  phoneNumber, password, confirmPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.et_username);
        email = findViewById(R.id.et_emailAddress);
        phoneNumber = findViewById(R.id.et_phone_number);
        password = findViewById(R.id.et_password);
        confirmPassword = findViewById(R.id.et_confirmPassword);
        FloatingActionButton userSignUp = findViewById(R.id.fab_signUp);

        userSignUp.setOnClickListener(v -> {
            if (TextUtils.isEmpty(name.getEditText().getText().toString().trim())) {
                name.setError("Please fill the name");
            } else if (TextUtils.isEmpty(email.getEditText().getText().toString().trim())) {
                email.setError("Email Required for SignUp");
            } else if (TextUtils.isEmpty(phoneNumber.getEditText().getText().toString().trim())) {
                phoneNumber.setError("Phone Number Required for SignUp");
            } else if (TextUtils.isEmpty(password.getEditText().getText().toString().trim())) {
                password.setError("Password Required for SignUp");
            } else if (TextUtils.isEmpty(confirmPassword.getEditText().getText().toString().trim())) {
                confirmPassword.setError("Please Enter confirm password");
            } else if (!password.getEditText().getText().toString().trim().equals(confirmPassword.getEditText().getText().toString().trim())) {
                confirmPassword.setError("Password not match");
            } else {
                String tempName = name.getEditText().getText().toString().trim();
                String tempPhn = phoneNumber.getEditText().getText().toString().trim();
                String tempEmail = email.getEditText().getText().toString().trim();
                String tempPwd = password.getEditText().getText().toString().trim();

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