package com.innovature.HotelManagement.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import javax.validation.constraints.NotBlank;

public class RoomAviForm {
 
    
    //@NotBlank
    @NotNull
    private Integer noOfRooms;

    private Integer hotelId;
    private Integer typeId;



    
    public Integer getNoOfRooms() {
        return noOfRooms;
    }
    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
    public Integer getHotelId() {
        return hotelId;
    }
    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
    public Integer getTypeId() {
        return typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    
}
