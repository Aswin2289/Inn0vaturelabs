package com.innovature.HotelManagement.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.innovature.HotelManagement.entity.RoomsAvi;

public interface RoomAviRepository extends Repository<RoomsAvi,Integer>{

    RoomsAvi save(RoomsAvi roomsAvi);
    Collection <RoomsAvi> findAll();
    RoomsAvi findById(Integer roomAviId);
    @Query(value = "select * from rooms_avi where hotel_id=?1",nativeQuery = true)
    Collection<RoomsAvi>selroom(Integer hotelId);

    

    @Modifying
    @Transactional
    @Query(value="update rooms_avi set booked_room=booked_room+1 where hotel_id=?1 and type_id=?2 and booked_room<no_of_rooms", nativeQuery = true)
    int bookedroom(Integer hotelId, Integer typeId);
    

    @Modifying
    @Transactional
    @Query(value="update rooms_avi set booked_room=booked_room-1 where hotel_id=?1 and type_id=?2 and booked_room>0", nativeQuery = true)
    int bookedroomdec(Integer hotelId, Integer typeId);

    @Query(value = "select type_id, no_of_rooms-booked_room as total from rooms_avi where hotel_id=?1 and type_id=?2",nativeQuery = true)
    Collection<Object[]>Noroom(Integer hotelId ,Integer typeId);

    @Query(value = "select no_of_rooms-booked_room as total from rooms_avi where hotel_id=?1 and type_id=?2",nativeQuery = true)
    Integer roomdata(Integer hotelId ,Integer typeId);

    



    
}
