package com.riseinsteps.packbagbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

public class SignUpActivity extends AppCompatActivity {
    public static final int RC_SIGN_IN = 100;

    private EditText firstName, lastName, username, password, confirmPassword, emailID, phoneNumber;
    private Button btnSignUp;
    private LinearLayout btnLogin;
    private FirebaseAuth mAuth;
    private TextView skipForNow;

    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstName = findViewById(R.id.et_firstName);
        lastName = findViewById(R.id.et_lastName);
        emailID = findViewById(R.id.et_emailAddress);
        username = findViewById(R.id.et_userName);
        password = findViewById(R.id.et_password);
        confirmPassword = findViewById(R.id.et_confirmPassword);
        phoneNumber = findViewById(R.id.et_PhoneNumber);
        btnSignUp = findViewById(R.id.btn_SignUp);
        btnLogin = findViewById(R.id.layout_login);
        skipForNow = findViewById(R.id.tv_skip);

        // setting up the sign up button
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
                    //getting a firebase instance
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                String error = task.getException().toString();
                                Toast.makeText(SignUpActivity.this, "SignIn Failed" + error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);


        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.google_sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        // setting up to login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // setting up the skip button
        skipForNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            GoogleSignInAccount acc = GoogleSignIn.getLastSignedInAccount(this);
            if (acc != null) {
                String DisplayName = acc.getDisplayName();
                Toast.makeText(this, "Welcome " + DisplayName, Toast.LENGTH_SHORT).show();
            }
            startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
            finish();


        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.e("Message", "signInResult:failed code=" + e.toString());

        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
}