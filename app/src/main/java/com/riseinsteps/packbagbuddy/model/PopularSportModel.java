package com.riseinsteps.packbagbuddy.model;

public class PopularSportModel {
    private int id;
    private String imageURL;
    private String sportName;
    private int numberOfTours;

    public PopularSportModel(int id, String imageURL, String sportName, int numberOfTours) {
        this.id = id;
        this.imageURL = imageURL;
        this.sportName = sportName;
        this.numberOfTours = numberOfTours;
    }

    public int getNumberOfTours() {
        return numberOfTours;
    }

    public void setNumberOfTours(int numberOfTours) {
        this.numberOfTours = numberOfTours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
