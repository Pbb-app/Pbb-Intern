package com.riseinsteps.packbagbuddy.model;

import com.google.android.material.textfield.TextInputLayout;

public class User {
    private String name;
    private String email;
    private String userName;
    private String phoneNumber;


    public User(){

    }

    public User(String name, String email, String userName, String phoneNumber) {

        this.name = name;
        this.email = email;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
