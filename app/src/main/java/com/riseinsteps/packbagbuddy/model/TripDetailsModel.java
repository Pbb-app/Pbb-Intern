package com.riseinsteps.packbagbuddy.model;

public class TripDetailsModel {
    private int id;
    private String name;
    private String desc;
    private String Duration;
    private String Image;
    private float trip_default_price;
    private float trip_special_price;
    private String nameOfState;
    private String Availability;
    private String To;
    private String From;
    private int MinAge;
    private int totalSeats;
    private String quickFacts;
    private String placesToVisit;
    private String Accommodation;
    private String meal;
    private String transportation;
    private String Itinerary;
    private String TourDetails;
    private String Rules;
    private String cancellationAndRefund;
    private float rating;
    private String Cost;

    TripDetailsModel(){

    }

    public TripDetailsModel(int id, String name, String desc, String duration, String image, float trip_default_price, float trip_special_price, String nameOfState, String availability, String to, String from, int minAge, int totalSeats, String quickFacts, String placesToVisit, String accommodation, String meal, String transportation, String itinerary, String tourDetails, String rules, String cancellationAndRefund, float rating, String cost) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        Duration = duration;
        Image = image;
        this.trip_default_price = trip_default_price;
        this.trip_special_price = trip_special_price;
        this.nameOfState = nameOfState;
        Availability = availability;
        To = to;
        From = from;
        MinAge = minAge;
        this.totalSeats = totalSeats;
        this.quickFacts = quickFacts;
        this.placesToVisit = placesToVisit;
        Accommodation = accommodation;
        this.meal = meal;
        this.transportation = transportation;
        Itinerary = itinerary;
        TourDetails = tourDetails;
        Rules = rules;
        this.cancellationAndRefund = cancellationAndRefund;
        this.rating = rating;
        Cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public float getTrip_default_price() {
        return trip_default_price;
    }

    public void setTrip_default_price(float trip_default_price) {
        this.trip_default_price = trip_default_price;
    }

    public float getTrip_special_price() {
        return trip_special_price;
    }

    public void setTrip_special_price(float trip_special_price) {
        this.trip_special_price = trip_special_price;
    }

    public String getNameOfState() {
        return nameOfState;
    }

    public void setNameOfState(String nameOfState) {
        this.nameOfState = nameOfState;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public int getMinAge() {
        return MinAge;
    }

    public void setMinAge(int minAge) {
        MinAge = minAge;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getQuickFacts() {
        return quickFacts;
    }

    public void setQuickFacts(String quickFacts) {
        this.quickFacts = quickFacts;
    }

    public String getPlacesToVisit() {
        return placesToVisit;
    }

    public void setPlacesToVisit(String placesToVisit) {
        this.placesToVisit = placesToVisit;
    }

    public String getAccommodation() {
        return Accommodation;
    }

    public void setAccommodation(String accommodation) {
        Accommodation = accommodation;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getItinerary() {
        return Itinerary;
    }

    public void setItinerary(String itinerary) {
        Itinerary = itinerary;
    }

    public String getTourDetails() {
        return TourDetails;
    }

    public void setTourDetails(String tourDetails) {
        TourDetails = tourDetails;
    }

    public String getRules() {
        return Rules;
    }

    public void setRules(String rules) {
        Rules = rules;
    }

    public String getCancellationAndRefund() {
        return cancellationAndRefund;
    }

    public void setCancellationAndRefund(String cancellationAndRefund) {
        this.cancellationAndRefund = cancellationAndRefund;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }
}
