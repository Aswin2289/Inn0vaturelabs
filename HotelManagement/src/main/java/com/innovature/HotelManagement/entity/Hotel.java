package com.innovature.HotelManagement.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Transient;

import com.innovature.HotelManagement.form.HotelForm;

@Entity
public class Hotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;
    private String name;
    private String description;
    @Column(nullable = true, length = 64)
    private String image;
    //private Blob image;
    private String address;
    private String latitude;
    private String longitude;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public Hotel(){

    }

    public Hotel(Integer hotelId){
        this.hotelId=hotelId;
    }

    public Hotel(HotelForm form){
        this.name=form.getName();
        this.description=form.getDescription();
        //this.image=form.getImage();
        this.address=form.getAddress();
        this.latitude=form.getLatitude();
        this.longitude=form.getLongitude();
        Date dt = new Date();
        this.createDate = dt;
        
    }
    public Hotel edit(String name,String description,String address,String latitude,String longitude){
        this.name=name;
        this.description=description;
        this.address=address;
        this.latitude=latitude;
        this.longitude=longitude;
        return this;

    }

 

    @Transient
    public String getPhotosImagePath() {
        if (image == null || hotelId == null)
            return null;
        return "/items - photos/" + hotelId + image;
    }



    public Integer getHotelId() {
        return hotelId;
    }
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    
    
}
