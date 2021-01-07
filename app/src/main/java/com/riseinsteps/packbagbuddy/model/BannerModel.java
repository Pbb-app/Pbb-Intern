package com.riseinsteps.packbagbuddy.model;

public class BannerModel {
    private int id;
    private String bannerImageUrl;

    public BannerModel(int id, String bannerImageUrl) {
        this.id = id;
        this.bannerImageUrl = bannerImageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBannerImageUrl() {
        return bannerImageUrl;
    }

    public void setBannerImageUrl(String bannerImageUrl) {
        this.bannerImageUrl = bannerImageUrl;
    }
}
