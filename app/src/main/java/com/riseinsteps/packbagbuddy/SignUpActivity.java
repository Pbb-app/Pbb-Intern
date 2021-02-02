package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.riseinsteps.packbagbuddy.model.User;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout name, email, phoneNumber, password, confirmPassword;

    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");
        mAuth=FirebaseAuth.getInstance();

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
            }

            else
                {
                String tempName = name.getEditText().getText().toString().trim();
                String tempPhn = phoneNumber.getEditText().getText().toString().trim();
                String tempEmail = email.getEditText().getText().toString().trim();
                String tempPwd = password.getEditText().getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(tempEmail, tempPwd).addOnCompleteListener(SignUpActivity.this, task -> {
                    if (task.isSuccessful())
                    {
                        User information = new User(tempName,tempPhn);

                        FirebaseDatabase.getInstance()
                                .getReference("User")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task)
                            {
                                Toast.makeText(SignUpActivity.this, "SignUp Done:" , Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });


                    } else {
                        String error = Objects.requireNonNull(task.getException()).toString();
                        Toast.makeText(SignUpActivity.this, "SignUp failed:" + error, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}