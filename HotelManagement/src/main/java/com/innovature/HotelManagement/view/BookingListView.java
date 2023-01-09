package com.innovature.HotelManagement.view;

import java.util.Date;

import com.innovature.HotelManagement.entity.Hotel;
import com.innovature.HotelManagement.entity.HotelRoom;






public class BookingListView {


    private final Integer bookId;
    private final String BookName;
    private final Hotel hotelId;
    private final HotelRoom typeId;
    private final byte status;
    @Json.DateFormat
    private final Date startDate;
    @Json.DateFormat
    private final Date endDate;
    
    @Json.DateTimeFormat
    private final Date createDate;



    public BookingListView(Integer bookId,String BookName,Hotel hotelId,HotelRoom typeId,byte status,Date startDate,Date endDate,Date createDate){

        this.bookId=bookId;
        this.BookName=BookName;
        this.hotelId=hotelId;
        this.typeId=typeId;
        this.status=status;
        this.startDate=startDate;
        this.endDate=endDate;
        this.createDate=createDate;

    }
    // public BookingListView(Integer bookId,String BookName,Hotel hotelId,HotelRoom typeId,byte status,Date startDate,Date endDate,Date createDate){

    //     this.bookId=bookId;
    //     this.BookName=BookName;
    //     this.hotelId=hotelId;
    //     this.typeId=typeId;
    //     this.status=status;
    //     this.startDate=startDate;
    //     this.endDate=endDate;
    //     this.createDate=createDate;

    // }


    
    


 



    public Integer getBookId() {
        return bookId;
    }
    // public Integer getHotelId() {
    //     return hotelId;
    // }

    // public Integer getTypeId() {
    //     return typeId;
    // }

    public Hotel getHotelId() {
        return hotelId;
    }

    public HotelRoom getTypeId() {
        return typeId;
    }

    public String getBookName() {
        return BookName;
    }
   
    public byte getStatus() {
        return status;
    }
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }


    public Date getCreateDate() {
        return createDate;
    }


    
    
    
}
