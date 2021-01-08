package com.riseinsteps.packbagbuddy.model;

public class AdventureTripModel {
    private int id;
    private String tripName;
    private String description;
    private String days;
    private int tripDefaultPrice;
    private int tripSpecialPrice;
    private String tripImageURL;
    private String nameOfState;
    private int tripDiscountPercentage;
    private String availabilityMonth;
    private float rating;

    public AdventureTripModel(int id, String tripName, String description, String days, int tripDefaultPrice,
                              int tripSpecialPrice, String tripImageURL,
                              String nameOfState, int tripDiscountPercentage, String availabilityMonth, float rating) {
        this.id = id;
        this.tripName = tripName;
        this.description = description;
        this.days = days;
        this.tripDefaultPrice = tripDefaultPrice;
        this.tripSpecialPrice = tripSpecialPrice;
        this.tripImageURL = tripImageURL;
        this.nameOfState = nameOfState;
        this.tripDiscountPercentage = tripDiscountPercentage;
        this.availabilityMonth = availabilityMonth;
        this.rating = rating;
    }

    public int getTripDiscountPercentage() {
        return tripDiscountPercentage;
    }

    public void setTripDiscountPercentage(int tripDiscountPercentage) {
        this.tripDiscountPercentage = tripDiscountPercentage;
    }


    public String getTripImageURL() {
        return tripImageURL;
    }

    public void setTripImageURL(String tripImageURL) {
        this.tripImageURL = tripImageURL;
    }

    public String getNameOfState() {
        return nameOfState;
    }

    public void setNameOfState(String nameOfState) {
        this.nameOfState = nameOfState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getTripDefaultPrice() {
        return tripDefaultPrice;
    }

    public void setTripDefaultPrice(int tripDefaultPrice) {
        this.tripDefaultPrice = tripDefaultPrice;
    }

    public int getTripSpecialPrice() {
        return tripSpecialPrice;
    }

    public void setTripSpecialPrice(int tripSpecialPrice) {
        this.tripSpecialPrice = tripSpecialPrice;
    }

    public String getAvailabilityMonth() {
        return availabilityMonth;
    }

    public void setAvailabilityMonth(String availabilityMonth) {
        this.availabilityMonth = availabilityMonth;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
