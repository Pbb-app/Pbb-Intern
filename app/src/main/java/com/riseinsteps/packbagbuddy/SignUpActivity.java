package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.riseinsteps.packbagbuddy.model.User;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout name, email, phoneNumber, password, confirmPassword;

    private FirebaseAuth mAuth;

    FirebaseDatabase database;
    String tempName;
    String tempPhn;
    String tempEmail;
    String tempPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

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
                tempName = name.getEditText().getText().toString().trim();
                tempPhn = phoneNumber.getEditText().getText().toString().trim();
                tempEmail = email.getEditText().getText().toString().trim();
                tempPwd = password.getEditText().getText().toString().trim();
            create_user();
                //getting the firebase instance




            }
        });

    }

    public void create_user() {
        mAuth.createUserWithEmailAndPassword(tempEmail, tempPwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, "Log in successefully", Toast.LENGTH_SHORT).show();
                    // Signing the current user
                    signIn_Current_User();
                } else {
                    Toast.makeText(SignUpActivity.this, "Log in Unsuccessefully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }





    public void signIn_Current_User() {
        mAuth.signInWithEmailAndPassword(tempEmail, tempPwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){



                    database = FirebaseDatabase.getInstance();
                    User user = new User(tempName, tempEmail, tempPhn);
                    String user_id = mAuth.getCurrentUser().getUid();

                    Toast.makeText(SignUpActivity.this, "Sign in successefully"+user_id, Toast.LENGTH_SHORT).show();


                    database.getReference().child("user").child(user_id).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "User data is added successefully", Toast.LENGTH_SHORT).show();

                                // To Display new Activity

                                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();

                            } else {
                                Log.v(" "+task.getException().getMessage(),"hello");
                                Toast.makeText(SignUpActivity.this, "user data is not added", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }
                else{
                    Toast.makeText(SignUpActivity.this, "Sign in Unsuccessefully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}