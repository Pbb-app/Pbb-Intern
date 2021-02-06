package com.riseinsteps.packbagbuddy.model;

public class TripModel {
    private int id;
    private String name;
    private String desc;
    private String days;
    private String imageUrl;
    private float trip_default_price;
    private float trip_special_price;
    private String nameOfState;
    private String availability;
    private String startingPoint;
    private String destinationPoint;
    private int minAgeRequire;
    private int totalSeats;
    private String quickFacts;
    private String placesToVisit;
    private String accommodation;
    private String meal;
    private String transportation;
    private String itinerary;
    private String tourDetails;
    private String rulesAndRegulation;
    private String cancellationAndRefund;
    private float rating;
    private String cost;

    public TripModel(String name,String imageUrl){
        this.name=name;
        this.imageUrl=imageUrl;
    }

    public TripModel(String name, String desc, String days, String imageUrl, float trip_default_price, float trip_special_price,
                     String nameOfState, String availability, String startingPoint, String destinationPoint, int minAgeRequire,
                     int totalSeats, String quickFacts, String placesToVisit, String accommodation, String meal, String transportation,
                     String itinerary, String tourDetails, String rulesAndRegulation, String cancellationAndRefund, float rating, String cost) {
        this.name = name;
        this.desc = desc;
        this.days = days;
        this.imageUrl = imageUrl;
        this.trip_default_price = trip_default_price;
        this.trip_special_price = trip_special_price;
        this.nameOfState = nameOfState;
        this.availability = availability;
        this.startingPoint = startingPoint;
        this.destinationPoint = destinationPoint;
        this.minAgeRequire = minAgeRequire;
        this.totalSeats = totalSeats;
        this.quickFacts = quickFacts;
        this.placesToVisit = placesToVisit;
        this.accommodation = accommodation;
        this.meal = meal;
        this.transportation = transportation;
        this.itinerary = itinerary;
        this.tourDetails = tourDetails;
        this.rulesAndRegulation = rulesAndRegulation;
        this.cancellationAndRefund = cancellationAndRefund;
        this.rating = rating;
        this.cost=cost;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCost() {
        return cost;
    }

    public float getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getDays() {
        return days;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public float getTrip_default_price() {
        return trip_default_price;
    }

    public float getTrip_special_price() {
        return trip_special_price;
    }

    public String getNameOfState() {
        return nameOfState;
    }

    public String getAvailability() {
        return availability;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public int getMinAgeRequire() {
        return minAgeRequire;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getQuickFacts() {
        return quickFacts;
    }

    public String getPlacesToVisit() {
        return placesToVisit;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public String getMeal() {
        return meal;
    }

    public String getTransportation() {
        return transportation;
    }

    public String getItinerary() {
        return itinerary;
    }

    public String getTourDetails() {
        return tourDetails;
    }

    public String getRulesAndRegulation() {
        return rulesAndRegulation;
    }

    public String getCancellationAndRefund() {
        return cancellationAndRefund;
    }
}
