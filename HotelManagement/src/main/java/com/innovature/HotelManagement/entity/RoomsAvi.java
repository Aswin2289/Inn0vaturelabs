package com.innovature.HotelManagement.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.innovature.HotelManagement.form.RoomAviForm;

@Entity
public class RoomsAvi {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomAviId;

    private Integer noOfRooms;
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name =  "hotel_id", referencedColumnName = "hotel_id")
    private Hotel hotelId;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name =  "type_id", referencedColumnName = "type_id")
    private HotelRoom typeId;

    private Integer bookedRoom=0;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;


    public RoomsAvi(){

    }

    public RoomsAvi(Integer roomAviId){
        this.roomAviId=roomAviId;
    }



    public RoomsAvi(RoomAviForm form){
        this.noOfRooms=form.getNoOfRooms();
        this.hotelId= new Hotel(form.getHotelId());
        this.typeId=new HotelRoom(form.getTypeId());
        Date dt = new Date();
        this.createDate = dt;
    }

    
    public Integer getRoomAviId() {
        return roomAviId;
    }

    public void setRoomAviId(Integer roomAviId) {
        this.roomAviId = roomAviId;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    public HotelRoom getTypeId() {
        return typeId;
    }

    public void setTypeId(HotelRoom typeId) {
        this.typeId = typeId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(Integer bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public RoomsAvi edit(RoomAviForm form) {
        this.hotelId=new Hotel(form.getHotelId());
        this.typeId=new HotelRoom(form.getTypeId());
        this.noOfRooms=form.getNoOfRooms();
        return this;
    }





    
    
}
