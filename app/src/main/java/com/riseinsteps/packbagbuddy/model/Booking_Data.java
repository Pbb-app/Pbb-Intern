package com.riseinsteps.packbagbuddy.model;


public class Booking_Data {


    private String image_url;
    private String title;
    private String duration;
    private String amount;
    public Booking_Data(){

    }

    public Booking_Data(String discount, String image_id, String title, String time, String amount) {

        this.image_url = image_id;
        this.title = title;
        this.duration = time;
        this.amount = amount;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getAmount() {
        return amount;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
