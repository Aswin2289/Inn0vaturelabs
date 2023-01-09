package com.innovature.HotelManagement.view;

import com.innovature.HotelManagement.entity.Booking;
import java.util.Date;

public class BookingDetailView extends BookingListView{
    public BookingDetailView(Booking book){
        super(
            book.getBookId(),
            book.getBookName(),
            book.getHotelId(), 
            book.getTypeId(), 
            book.getStatus(),
            book.getStartDate(),
            book.getEndDate(),
            book.getCreateDate()
        );

    }
    
}
