package com.riseinsteps.packbagbuddy.model;

 public class AllAdventureTripModel
{
    String image;
    String title;
    float rating;
    String cost;

    public AllAdventureTripModel()
    {}

    public AllAdventureTripModel(String image,String title,float rating,String cost)
    {
        this.image=image;
        this.title=title;
        this.rating=rating;
        this.cost=cost;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public float getRating() {
        return rating;
    }

    public String getCost() {
        return cost;
    }
}
