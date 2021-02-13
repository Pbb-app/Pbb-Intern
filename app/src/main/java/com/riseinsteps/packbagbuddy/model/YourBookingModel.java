package com.riseinsteps.packbagbuddy.model;

public class YourBookingModel {

    String location; //image of location
    String title;  //place name
    String duration;  //duration of trip
    String cost;  //cost
    String substitle;  //category of sports
    String date;  //date of trip
    String fromlocation;
    String todestination;
    String status;
    String count;


    public YourBookingModel()
    {}

    public YourBookingModel(String image,String title,String duration,String cost,String substitle,String date,String fromlocation,String todestination,String status,String count)
    {
        this.location=image;
        this.title=title;
        this.duration=duration;
        this.cost=cost;
        this.substitle=substitle;
        this.date=date;
        this.fromlocation=fromlocation;
        this.todestination=todestination;
        this.status=status;
        this.count=count;


    }

    public String getFromlocation() {
        return fromlocation;
    }

    public void setFromlocation(String fromlocation) {
        this.fromlocation = fromlocation;
    }

    public String getTodestination() {
        return todestination;
    }

    public void setTodestination(String todestination) {
        this.todestination = todestination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setSubstitle(String substitle) {
        this.substitle = substitle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }




    public String getLocation() {
        return location;
    }


    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getCost() {
        return cost;
    }

    public String getSubstitle() {
        return substitle;
    }

    public String getDate() {
        return date;
    }

}

