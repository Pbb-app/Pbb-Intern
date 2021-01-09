package com.riseinsteps.packbagbuddy.model;

public class ExploreIndia
{
    private int image_id;
    private String title;
    private String days;
    private int tripDefaultPrice;
    private int tripSpecialPrice;
    private String availabilityMonth;


    public ExploreIndia(int image_id, String title, String days, int tripDefaultPrice, int tripSpecialPrice , String availabilityMonth )
    {
        this.image_id=image_id;
        this.title=title;
        this.days=days;
        this.tripDefaultPrice=tripDefaultPrice;
        this.tripSpecialPrice=tripSpecialPrice;
        this.availabilityMonth=availabilityMonth;
    }
    public  int getImage_id() {
        return image_id;
    }


    public String getTitle() {
        return title;
    }

    public String getDays() {
        return days;
    }

    public int getTripDefaultPrice() {
        return tripDefaultPrice;
    }

    public int getTripSpecialPrice() {
        return tripSpecialPrice;
    }

    public String getAvailabilityMonth() {
        return availabilityMonth;
    }
}
