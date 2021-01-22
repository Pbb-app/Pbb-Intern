package com.riseinsteps.packbagbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class UserForgotPassword extends AppCompatActivity
{
    EditText enteredEmail;
    Button send;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordreset);
        enteredEmail= findViewById(R.id.emailverify);
        send=findViewById(R.id.sendbutton);
        firebaseAuth = FirebaseAuth.getInstance();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String userEmail= enteredEmail.getText().toString().trim();
                if(userEmail.equals(""))
                {
                    Toast.makeText(UserForgotPassword.this,"Enter Your Registered E-mail Id",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(UserForgotPassword.this,"Password reset E-mail sent",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(UserForgotPassword.this, LoginActivity.class));
                            }
                            else {
                                Toast.makeText(UserForgotPassword.this,"Enter the registered E-mail",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}