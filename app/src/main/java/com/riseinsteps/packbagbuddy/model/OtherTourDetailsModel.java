package com.riseinsteps.packbagbuddy.model;

public class OtherTourDetailsModel {
    private String tourDetailsHeading;
    private String tourDetailsDesc;

    public OtherTourDetailsModel(String tourDetailsHeading, String tourDetailsDesc) {
        this.tourDetailsHeading = tourDetailsHeading;
        this.tourDetailsDesc = tourDetailsDesc;
    }

    public String getTourDetailsHeading() {
        return tourDetailsHeading;
    }

    public void setTourDetailsHeading(String tourDetailsHeading) {
        this.tourDetailsHeading = tourDetailsHeading;
    }

    public String getTourDetailsDesc() {
        return tourDetailsDesc;
    }

    public void setTourDetailsDesc(String tourDetailsDesc) {
        this.tourDetailsDesc = tourDetailsDesc;
    }
}
