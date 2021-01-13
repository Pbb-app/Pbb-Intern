package com.riseinsteps.packbagbuddy.model;

public class ExploreIndia {
    private String videourl;
    private String title;
    private String description;
    private float rating;

    public ExploreIndia(String videourl, String title, String description, float rating) {
        this.videourl = videourl;
        this.title = title;
        this.description = description;
        this.rating = rating;

    }

    public float getRating() {
        return rating;
    }

    public String getVideourl() {
        return videourl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
