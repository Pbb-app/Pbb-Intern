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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    public static final int RC_SIGN_IN = 101;

    private EditText email, password;
    private Button btnLogin;
    private LinearLayout btnSignUp;
    private TextView skipForNow, forgotPwd;

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.et_emailAddress);
        password = findViewById(R.id.et_password);
        forgotPwd= findViewById(R.id.tv_ForgotPassword);


        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            this.finish();
        }
        //forgot password activity
        forgotPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,passwordreset.class));
            }
        });
        //setting up the login button
        btnLogin = findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting data from the user.
                String tempEmail = email.getText().toString().trim();
                String tempPwd = password.getText().toString().trim();

                if (TextUtils.isEmpty(tempEmail)) {
                    email.setError("Email Required for Login");
                    return;
                } else if (TextUtils.isEmpty(tempPwd)) {
                    password.setError("Password Required for Login");
                    return;
                } else {

                    //getting a firebase instance.
                    mAuth = FirebaseAuth.getInstance();

                    //signin with the user credentials
                    mAuth.signInWithEmailAndPassword(tempEmail, tempPwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                String error = task.getException().toString();
                                Toast.makeText(LoginActivity.this, "Login Failed" + error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        //setting up the forgot Password
        

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

        //setting up the signup button
        btnSignUp = findViewById(R.id.layout_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //setting up the skip option
        skipForNow = findViewById(R.id.tv_skip);
        skipForNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
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
            String DisplayName = "";
            if (acc != null) {
                DisplayName = acc.getDisplayName();
            }
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            Toast.makeText(this, "Welcome " + DisplayName, Toast.LENGTH_LONG).show();
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