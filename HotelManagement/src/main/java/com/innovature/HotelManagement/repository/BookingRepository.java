package com.innovature.HotelManagement.repository;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.innovature.HotelManagement.entity.Booking;
import com.innovature.HotelManagement.entity.Hotel;
import com.innovature.HotelManagement.view.BookingListView;

public interface BookingRepository extends Repository<Booking, Integer>{
    

    Booking save(Booking booking);
    Collection<Booking> findAll();
    Booking findById(Integer bookId);

    
    Collection<BookingListView> findAllByUserUserId(Integer userId);
    
    @Query(value="select * from hotel where hotel_id NOT IN(select hotel_id from booking where end_date BETWEEN ?1 and ?2 OR start_date BETWEEN ?1 and ?2)",nativeQuery = true)
    Collection<Integer>availability(String checkIn,String checkOut);

    @Query(value="select * from booking where hotel_id=?1 and type_id=?2 and ?3 not between start_date and end_date and ?4 not between start_date and end_date",nativeQuery = true)
    Collection<Integer>availabilityId(Integer hotelId ,Integer typeId,String checkIn,String checkOut);



    @Query(value="select b.book_id,(b.end_date-b.start_date)*h.type_price as total from booking b inner join hotel_room h on b.type_id=h.type_id",nativeQuery = true)
    Collection<Object[]>datediff();

  

    
}
