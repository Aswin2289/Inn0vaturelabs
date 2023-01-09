package com.innovature.HotelManagement.view;

import java.util.Date;

import com.innovature.HotelManagement.entity.Hotel;
import com.innovature.HotelManagement.entity.HotelRoom;

public class RoomAviListView {


    private final Integer roomAviId;
    private final Integer noOfRooms;
    private final Hotel hotelId;
    private final HotelRoom typeId;
    private final Integer bookedRoom;

    @Json.DateTimeFormat
    private final Date createDate;

    public RoomAviListView(Integer roomAviId,Integer noOfRooms,Hotel hotelId,HotelRoom typeId,Integer bookedRoom,Date createDate){

        this.roomAviId=roomAviId;
        this.noOfRooms=noOfRooms;
        this.hotelId=hotelId;
        this.typeId=typeId;
        this.bookedRoom=bookedRoom;
        this.createDate=createDate;

    }

    public Integer getRoomAviId() {
        return roomAviId;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    
    public Hotel getHotelId() {
        return hotelId;
    }

    public HotelRoom getTypeId() {
        return typeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Integer getBookedRoom() {
        return bookedRoom;
    }

    
    
}
