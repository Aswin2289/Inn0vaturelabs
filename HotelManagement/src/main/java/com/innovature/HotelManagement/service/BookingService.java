package com.innovature.HotelManagement.service;

import java.util.Collection;
import java.util.Optional;

import com.innovature.HotelManagement.entity.Booking;
import com.innovature.HotelManagement.entity.Hotel;
import com.innovature.HotelManagement.form.BookingForm;
import com.innovature.HotelManagement.view.BookingDetailView;
import com.innovature.HotelManagement.view.BookingListView;

public interface BookingService {

    BookingDetailView add(BookingForm form);
    Collection<Booking>list();
    
    Collection<BookingListView>list1();
    Collection<Hotel>available(String checkIn,String checkOut);
    Collection<Hotel>availabilityId(Integer hotelId ,Integer typeId,String checkIn,String checkOut);
    void Bookstatusup(Integer bookId);
    boolean sendBookEmail(Integer bookId,String sentto);
    Collection<Object[]>datediff();
    boolean sendCancelBookEmail(Integer bookId,String sentto);
    
}
