package com.innovature.HotelManagement.view;

import java.sql.Blob;

public class HotelListView {
    private final int hotelId;
    private final String name;
    private final String description;
    private final String image;
    private final String address;
    private final String latitude;
    private final String longitude;


    public HotelListView(int hotelId,String name,String description,String image,String address,String latitude,String longitude){
        this.hotelId=hotelId;
        this.name=name;
        this.description=description;
        this.image=image;
        this.address=address;
        this.latitude=latitude;
        this.longitude=longitude;

    }
    public int getHotelId() {
        return hotelId;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    public String getAddress() {
        return address;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    

}
