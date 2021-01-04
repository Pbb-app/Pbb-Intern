package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private EditText firstName, lastName, username, password, confirmPassword, emailID, phoneNumber;
    private Button btnLogin, btnSignUp;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        username = findViewById(R.id.etUserName);
        password = findViewById(R.id.etPassword);
        confirmPassword = findViewById(R.id.etConfirmPassword);
        emailID = findViewById(R.id.etEmailid);
        phoneNumber = findViewById(R.id.et_PhoneNumber);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        // setting  up a login button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = firstName.getText().toString().trim();
                String lName = lastName.getText().toString().trim();
                String User = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                String confPwd = confirmPassword.getText().toString().trim();
                String email = emailID.getText().toString().trim();
                String phnNumber = phoneNumber.getText().toString().trim();


                if (TextUtils.isEmpty(fName)) {
                    firstName.setError("First Name Required");
                    return;
                } else if (TextUtils.isEmpty(lName)) {
                    lastName.setError("Last Name Required");
                    return;
                } else if (TextUtils.isEmpty(User)) {
                    username.setError("Username Required");
                    return;
                } else if (TextUtils.isEmpty(pwd)) {
                    password.setError("Password Required");
                    return;
                } else if (TextUtils.isEmpty(confPwd)) {
                    confirmPassword.setError("Confirm Password Required");
                    return;
                } else if (TextUtils.isEmpty(email)) {
                    emailID.setError("Email Required");
                    return;
                } else if (TextUtils.isEmpty(phnNumber)) {
                    phoneNumber.setError("Phone Number Required");
                    return;
                } else {
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                String error = task.getException().toString();
                                Toast.makeText(SignInActivity.this, "SignIn Failed" + error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}