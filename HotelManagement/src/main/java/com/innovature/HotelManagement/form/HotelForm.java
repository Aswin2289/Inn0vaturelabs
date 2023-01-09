package com.innovature.HotelManagement.form;

import java.sql.Blob;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class HotelForm {
    

    @Size(max=255)
    @NotBlank
    private String name;

    @Size(max=255)
    @NotBlank
    private String description;

    //@NotBlank
    //private String image;

    @Size(max = 255)
    @NotBlank
    private String address;

    @Size(max = 255)
    @NotBlank
    private String latitude;

    @Size(max = 255)
    @NotBlank
    private String longitude;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // public Blob getImage() {
    //     return image;
    // }

    // public void setImage(Blob image) {
    //     this.image = image;
    // }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    
}
