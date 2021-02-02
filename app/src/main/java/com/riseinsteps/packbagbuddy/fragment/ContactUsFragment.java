package com.riseinsteps.packbagbuddy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.riseinsteps.packbagbuddy.LeaveYourInfo;
import com.riseinsteps.packbagbuddy.R;

public class ContactUsFragment extends Fragment {

    //Button btnInfo;
    EditText your_name;
    EditText your_email;
    EditText your_phone_number;
    EditText your_message;
    Button send_message;
    String name;
    String email;
    String phone_number;
    String message;
    View itemview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

//        btnInfo = view.findViewById(R.id.btnInfo);
//
//        btnInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(container.getContext(), LeaveYourInfo.class);
//                startActivity(i);
//            }
//        });

        // Setting the view
        itemview=view;

        // Initializing the varriaous views
        initComponents();

        // Setting
        // the OnClickListner on send Message Button

        send_message.setOnClickListener(view1 -> {
            // Function for checking the input from user
            if(checking_input_from_user()){
                // Function for Sending Email to the company
                sendEmail();
            }
        });



        return view;
    }




    private void sendEmail() {


        Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);




        /* Fill it with Data */


        sendEmail.setType("plain/text");


        sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"vishalchaudhary1975@gmail.com"});





        sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,


                "name:"+name+'\n'+"Email ID:"+email+'\n'+"Message:"+'\n'+message);




        /* Send it off to the Activity-Chooser */


        startActivity(Intent.createChooser(sendEmail, "Send mail..."));


    }

    private boolean checking_input_from_user() {


        name      = your_name.getText().toString();


        email     = your_email.getText().toString();


        phone_number   = your_phone_number.getText().toString();

        message   = your_message.getText().toString();


        if (TextUtils.isEmpty(name)){


            your_name.setError("Enter Your Name");


            your_name.requestFocus();


            return false;


        }

        if (!isValidMail(email)) {





            your_email.setError("Invalid Email");


            return false;


        }

        if(!isValidMobile(phone_number)){
            your_phone_number.setError("Invalid Phone Number");
            return false;
        }
        if (TextUtils.isEmpty(message)){


            your_message.setError("Enter Your Message");


            your_message.requestFocus();


            return false;


        }
        return true;

    }

    private void initComponents() {
        your_name=itemview.findViewById(R.id.name);
        your_email=itemview.findViewById(R.id.email);
        your_phone_number=itemview.findViewById(R.id.phoneNumber);
        your_message=itemview.findViewById(R.id.message);
        send_message=itemview.findViewById(R.id.send_message);
    }

    private boolean isValidMail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }



}
