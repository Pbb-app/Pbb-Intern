package com.riseinsteps.packbagbuddy.model;

public class TourDetailsModel {
    private String ImageUrl;
    private String desc;

    public TourDetailsModel(String imageUrl, String desc) {
        ImageUrl = imageUrl;
        this.desc = desc;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
